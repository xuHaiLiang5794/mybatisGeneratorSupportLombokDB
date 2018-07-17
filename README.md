# mybatis-generator-core-1.3.7-sources[lombok/swagger]
## 项目介绍
生成entity时没有找到带中文方法注释的配置方法，而我恰巧又需要一个集成了lombok和swagger的entity，
因此下载了mybatis-generator-core-1.3.7-sources源码，并在此基础上，做些调整集成了lombok和swagger。


## 新增功能
* 生成支持中文注释的entity
* 生成支持Lombok的entity
* 生成支持Swagger的entity
* 去掉生成带类型参数的方法的返回值前缀
* Mapper增加selectByCondition查询方法


## 修改记录
```
org.mybatis.generator.internal.DefaultCommentGenerator
属性上的文档注释取数据库中的备注信息
get/set方法不要注释
```

```
org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator
去掉主键字段的get/set方法
```

```
org.mybatis.generator.codegen.mybatis3.model.BaseRecordGenerator
去掉普通字段的get/set方法
```

```
org.mybatis.generator.api.MybatisGenerator
生成java文件和xml文件的代码都在这里面
```

```
org.mybatis.generator.api.dom.java.TopLevelClass
添加lombok注解
```

```
org.mybatis.generator.api.dom.java.InnerClass
添加lombok注解
```

```
org.mybatis.generator.internal.util.JavaBeansUtil
org.mybatis.generator.api.dom.java.TopLevelClass
添加日期/时间格式化注解
```

```
org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator
org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByConditionElementGenerator
增加mapper xml中select(id=selectByCondition)标签
```

```
org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator
org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByConditionMethodGenerator
增加mapper java中selectByCondition方法
```



## 环境准备
* 下载并安装[JAVA 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* 下载并安装[GIT](https://git-scm.com/download)
* 下载并安装[Maven](http://maven.apache.org/download.cgi)
* 下载[idea](https://www.jetbrains.com/idea/) 开发工具
* 下载并安装[lombok](https://projectlombok.org/)