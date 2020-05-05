# 知识点总结
## MySQL
## MyBatis
mybatis 全局配置：
```xml
<settings>
        <!-- 使用jdbc的useGeneratedKeys获取自增主键值 -->
        <setting name="useGeneratedKeys" value="true"/>
        
        <!--
        使用列别名替换列名 默认值为true
        select name as title(实体中的属性名是title) form table;
        开启后mybatis会自动帮我们把表中name的值赋到对应实体的title属性中
        -->
        <setting name="useColumnLabel" value="true"/>
        
        <!-- 开启驼峰命名转换 create_time 到 Entity(createTime) -->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
```

## Java
## Redis
## 前端