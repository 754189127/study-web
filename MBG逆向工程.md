# study-web
使用MyBatis Generator（MBG）代码生成器使用

官方使用指导：http://www.mybatis.org/generator/

常见的使用方式如下：

一、用JAVA代码生成

1、在pom.xml中添加引用
````
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.5</version>
</dependency>

````
2、在项目根目录创建mbg.xml配置文件
````<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
  <context id="DB2Tables" targetRuntime="MyBatis3">
  <commentGenerator>
    <property name="suppressAllComments" value="true" />
</commentGenerator>
  <!-- 数据库连接 -->
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
        connectionURL="jdbc:mysql://192.168.18.203:3306/db_study?useSSL=false"
        userId="root"
        password="123456">
    </jdbcConnection>

    <javaTypeResolver >
      <property name="forceBigDecimals" value="false" />
    </javaTypeResolver>

<!-- 指定javaBean的生成位置 -->
    <javaModelGenerator targetPackage="com.study.entity"  targetProject=".\src\main\java">
      <property name="enableSubPackages" value="true" />
      <property name="trimStrings" value="true" />
    </javaModelGenerator>
    
    
<!-- 指定sql映射文件的生成位置-->
    <sqlMapGenerator targetPackage="mapper"  targetProject=".\src\main\resources">
      <property name="enableSubPackages" value="true" />
    </sqlMapGenerator>
    
    
<!-- 指定dao接口的生成位置 ，mapper接口-->
    <javaClientGenerator type="XMLMAPPER" targetPackage="com.study.dao"  targetProject=".\src\main\java">
      <property name="enableSubPackages" value="true" />
    </javaClientGenerator>
    
    
<!-- table指定每个表生成策略 -->
    <table tableName="s_user" domainObjectName="User"></table>
    <table tableName="s_user_info" domainObjectName="UserInfo"></table>


    <table schema="DB2ADMIN" tableName="ALLTYPES" domainObjectName="Customer" >
      <property name="useActualColumnNames" value="true"/>
      <generatedKey column="ID" sqlStatement="DB2" identity="true" />
      <columnOverride column="DATE_FIELD" property="startDate" />
      <ignoreColumn column="FRED" />
      <columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />
    </table>

  </context>
</generatorConfiguration>
````
3、创建一个测试类MBGTest.java
````
public class MBGTest {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
````



二、使用Maven运行生成 

http://www.mybatis.org/generator/running/runningWithMaven.html

1、在pom.xml文件中配置dependency
````
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.5</version>
</dependency>
````

2、配置plugin插件
````
<build>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.2</version>
    <executions>
        <execution>
        <id>Generate MyBatis Files</id>
           <goals>
               <goal>generate</goal>
           </goals>
           <phase>generate</phase>
                <configuration>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
           </execution>
    </executions>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.5</version>
        </dependency>
       <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.2</version>
        </dependency>
    </dependencies>
</build>
````

3、创建generatorConfig.xml

在resource目录下创建generatorConfig.xml配置文件
````
<?xmlversion="1.0"encoding="UTF-8"?>
<!DOCTYPEgeneratorConfiguration
  PUBLIC"-//mybatis.org//DTDMyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
   <properties resource="schemeone/properties/mysql/mysql.properties"/>
   <context id="mysqlTables" targetRuntime="MyBatis3">
      <jdbcConnection driverClass="com.mysql.jdbc.Driver"
         connectionURL="${jdbc.url}" userId="${jdbc.username}"  password="${jdbc.password}"/>
      <!--指定生成的类型为java类型，避免数据库中number等类型字段 -->
      <javaTypeResolver>
        <propertyname="forceBigDecimals" value="false"/>
      </javaTypeResolver>
      <!--自动生成的实体的存放包路径 -->
      <javaModelGenerator targetPackage="org.cj.entity.auto"
         targetProject="src/main/java">
        <property name="enableSubPackages" value="true"/>
          <property name="trimStrings" value="true"/>
      </javaModelGenerator>
      <!--自动生成的*Mapper.xml文件存放路径 -->
      <sqlMapGenerator targetPackage="org.cj.dao.auto.mysql"
          targetProject="src/main/java">
        <property name="enableSubPackages" value="true"/>
      </sqlMapGenerator>
      <!--自动生成的*Mapper.java存放路径 -->
      <javaClientGenerator type="XMLMAPPER"
         targetPackage="org.cj.dao.auto" targetProject="src/main/java">
        <property name="enableSubPackages" value="true"/>
      </javaClientGenerator>
        <table tableName="test" domainObjectName="Test" 
            enableCountByExample="false"  enableUpdateByExample="false" 
            enableDeleteByExample="false" enableSelectByExample="false" 
            selectByExampleQueryId="false">
          <generatedKey column="ID" sqlStatement="selectuuid_short()"
              identity="false"/>
        </table>
      <table tableName="teacher" domainObjectName="Tercher">
         <generatedKey column="ID" sqlStatement="select uuid_short()"   identity="false"/>
      </table>
   </context>
</generatorConfiguration>
````
