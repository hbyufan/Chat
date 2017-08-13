# threecss-embed-chat

threecss-embed-chat是基于ThreeCSS分布式框架开发的一款嵌入聊天项目。

该项目由ThreeCSSEmbedChat(服务器)与ThreeCSSEmbedChatClient(客户端)两个子项目组成。


体验地址：
http://embedchat.threecss.com


依赖身份系统：
threecss-identity


打版本：在项目根目录下，配置好build-custom.properties每个项目的路径及发布路径，执行

	ant


配置：

	dist/ThreeCSSEmbedChatClient/js/app/Url.js-----访问聊天服务器与身份系统服务器

	dist/ThreeCSSEmbedChatConfigData/configext.json----访问身份系统及是否使用MongoDB存储聊天记录的配置

	dist/ThreeCSSEmbedChatConfigData/mybatis-config.xml---访问聊天数据库

	dist/ThreeCSSEmbedChat.properties----ThreeCSSEmbedChatConfigData在服务器路径


推荐环境：

	jdk-8u121

	apache-tomcat-8.5.12

	MariaDB-10.1.22

	CentOS-7-1611
	
	mongodb-3.4.3（可选）

	支持Html5浏览器


发布项目：

1、该项目依赖threecss-identity，需要先部署身份系统，具体详见：

https://github.com/dianbaer/threecss-identity

2、安装数据库
	
	create database threecssembedchat
	
	source ****/threecssembedchat.sql
	
3、安装MongoDB数据库（通过配置可选）

	mongo --host 0.0.0.0 --eval 'db = db.getSiblingDB("threecssembedchat");db.createUser({user: "threecssembedchat",pwd: "123456",roles: [ "readWrite", "dbAdmin" ]})'

4、将ThreeCSSEmbedChatConfigData放入服务器某个路径，例如
	
	/home/ThreeCSSEmbedChatConfigData

5、将ThreeCSSEmbedChat.properties放入tomcat根目录下，例如
	
	/home/tomcat/ThreeCSSEmbedChat.properties
	
	并修改config_dir对应的ThreeCSSEmbedChatConfigData路径

6、将ThreeCSSEmbedChatClient与ThreeCSSEmbedChat.war放入tomcat/webapps，例如
	
	/home/tomcat/webapps/ThreeCSSEmbedChat.war
	
	/home/tomcat/webapps/ThreeCSSEmbedChatClient

	
如何嵌入threecss-embed-chat：
	
	1、基于threecss-identity身份系统开发的项目直接调用

		<iframe frameborder="0" allowtransparency="true" width="770px" height="480px" id="talk_box" src="http://embedchat.threecss.com/talk.html?token=5ffdefd0e1104ebdbc49cc6de538b669"></iframe>
		
	2、基于其他身份系统，需对threecss-embed-chat进行二次开发对接相应的身份系统


threecss-embed-chat功能：

	群组聊天，个人对个人聊天。
	支持发送表情。
	查看聊天记录及按时间段查询。
	相同用户登录踢下线功能。
	

threecss-embed-chat特色：	

1、嵌入式：
	
	支持嵌入方式。
	
2、推送聊天动态控制
	
	服务器支持对聊天记录的推送进行有效控制，可在高负荷的情况下依据服务器IO状况进行可选择性推送。
	
3、聊天记录非关系型存储

	支持将聊天记录存入MongoDB，有效的减少服务器查询聊天记录的数据库负荷。
	
4、基于ThreeCSS统一线程模型，优秀的多线程推送机制
	
	线程1：
	
		用户登录并放入2~(n-1)的随机线程。
		用户离线、用户断线。
		
	线程2~(n-1)：
	
		轮训本线程的每个用户要推送的聊天记录队列进行推送。
		加入、离开本线程要做的事情。
		发送消息给组或个人的处理。
		收到消息、收到组消息的处理。
		获取聊天记录的处理。
	
	
	
	
	
	
	