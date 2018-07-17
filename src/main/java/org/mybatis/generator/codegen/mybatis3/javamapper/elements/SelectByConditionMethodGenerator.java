package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.dom.java.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * mapper.java文件中添加selectByCondition方法
 * </pre>
 *
 * @author hailiang.xu
 * @version 1.0
 * @since 2018/7/17 11:22
 */
public class SelectByConditionMethodGenerator extends
        AbstractJavaMapperMethodGenerator {

    private boolean isSimple;

    public SelectByConditionMethodGenerator(boolean isSimple) {
        super();
        this.isSimple = isSimple;
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);

        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("java.util.List");
        returnType.addTypeArgument(introspectedTable.getRules()
                .calculateAllFieldsClass());
        method.setReturnType(returnType);
        importedTypes.add(returnType);

        method.setName(introspectedTable.getSelectByConditionStatementId());

        FullyQualifiedJavaType paramType = new FullyQualifiedJavaType("java.util.Map");
        paramType.addTypeArgument(new FullyQualifiedJavaType("java.lang.String"));
        paramType.addTypeArgument(new FullyQualifiedJavaType("java.lang.Object"));
        importedTypes.add(paramType);
        Parameter parameter = new Parameter(paramType, "params");
        method.addParameter(parameter);

        addMapperAnnotations(interfaze, method);

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(
                method, interfaze, introspectedTable)) {
            addExtraImports(interfaze);
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
    }

    public void addExtraImports(Interface interfaze) {
    }
}
