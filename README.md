# find-house项目文档

## 1.项目背景
> 最近工作中涉及到全文搜索，个人学习完成elasticsearch之后动手实践一下，所以有了这个小demo

## 2.项目说明
-  该项目主要分为两部分：数据抓取、数据搜索
    - 数据抓取，使用jsoup从贝壳找房上获取房源数据
    - 数据搜索，利用es实现分词匹配搜索
- 组件版本
    - es 7.6.1
    - jsoup 1.10.2
    - springboot 2.3.7.RELEASE  
- 项目使用说明
    1. 从github获取源码之后，使用idea构建项目
    2. 启动安装好的es，并相应修改 application.yml 文件中的配置信息
    3. 启动项目，访问 http://127.0.0.1:8081/doc.html（swagger文档地址）
    4. 先使用数据导入接口将数据插入es中（完成后可先自行判断是否插入成功，涉及到es的基础使用，请自行学习）
    5. 使用数据搜索接口进行关键字匹配查询
