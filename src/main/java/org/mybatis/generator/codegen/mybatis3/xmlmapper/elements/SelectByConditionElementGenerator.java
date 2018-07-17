package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * <pre>
 * mapper.xml文件中添加selectByCondition select标签
 * </pre>
 *
 * @author hailiang.xu
 * @version 1.0
 * @since 2018/7/17 10:35
 */
public class SelectByConditionElementGenerator extends AbstractXmlElementGenerator {

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute(
                "id", introspectedTable.getSelectByConditionStatementId())); //$NON-NLS-1$
        if (introspectedTable.getRules().generateResultMapWithBLOBs()) {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getResultMapWithBLOBsId()));
        } else {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getBaseResultMapId()));
        }

        String parameterType;
        if (introspectedTable.getAllColumns().size() > 1) {
            parameterType = "map"; //$NON-NLS-1$
        } else {
            parameterType = introspectedTable.getAllColumns().get(0)
                    .getFullyQualifiedJavaType().toString();
        }

        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
                parameterType));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

        if (stringHasValue(introspectedTable
                .getSelectByPrimaryKeyQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByPrimaryKeyQueryId());
            sb.append("' as QUERYID,"); //$NON-NLS-1$
        }
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
        if (introspectedTable.hasBLOBColumns()) {
            answer.addElement(new TextElement(",")); //$NON-NLS-1$
            answer.addElement(getBlobColumnListElement());
        }

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));

        XmlElement whereElement = new XmlElement("where");
        answer.addElement(whereElement);
        boolean f = false;
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getAllColumns()) {
            sb.setLength(0);
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" != null");
            XmlElement isNotNullElement = new XmlElement("if");
            isNotNullElement.addAttribute(new Attribute("test", sb.toString()));

            sb.setLength(0);
            /**
             * 加个if降低包的大小
             */
            if (f) {
                sb.append("AND ");
            }
            f = true;
            sb.append(MyBatis3FormattingUtilities
                    .getAliasedEscapedColumnName(introspectedColumn));
            sb.append(" = ");
            sb.append(MyBatis3FormattingUtilities
                    .getParameterClause(introspectedColumn));
            isNotNullElement.addElement(new TextElement(sb.toString()));

            whereElement.addElement(isNotNullElement);
        }

        if (context.getPlugins()
                .sqlMapSelectByPrimaryKeyElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
