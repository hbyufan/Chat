# Chat

[![Build Status](https://travis-ci.org/dianbaer/Chat.svg?branch=master)](https://travis-ci.org/dianbaer/Chat)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d004d40521bf4dccb61e19c73730649e)](https://www.codacy.com/app/232365732/Chat?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dianbaer/Chat&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

# Chat是一个Html5的聊天项目，基于websocket。

Chat由ChatServer(服务器)与ChatClient(客户端)两个项目组成。


基于grain RPC框架

https://github.com/dianbaer/grain

	grain-threadwebsocket
	grain-mongodb
	grain-mariadb
	grain-httpclient


## 依赖身份系统：

Identity

https://github.com/dianbaer/Identity


## 打版本：在项目根目录下，执行

	ant


## 配置：

	dist/ChatClient/js/app/Url.js-----访问聊天服务器与身份系统服务器
	
	
	function Url() {
		//身份系统的地址
		this.url = "http://localhost:8080/IdentityServer/s";
		//聊天服务器的地址
		this.chat = "ws://localhost:8081/ChatServer/ws";
	}
	$T.url = new Url();
	

	dist/ChatConfig/mybatis-config.xml---访问聊天数据库

	dist/ChatServer.properties----ChatConfig在服务器路径以及一些配置
	
	#mybatis-config.xml在服务器的地址
	config_dir = C:/Users/admin/Desktop/github/Chat/trunk/ChatConfig
	#身份系统的地址
	uCenterUrl = http://localhost:8080/IdentityServer/s
	#mongodb的配置
	mongodbUrl = 172.27.108.72
	mongodbPort = 27017
	mongodbUsername = chat
	mongodbPassword = 123456
	mongodbDBName = chat
	#是否使用mongodb，如果填false聊天记录存储在mysql，如果填true聊天记录存储在mongodb
	isUseMongodb = false




## 推荐环境：

>快捷部署 https://github.com/dianbaer/deployment-server

	jdk-8u121

	apache-tomcat-8.5.12

	MariaDB-10.1.22

	CentOS-7-1611
	
	mongodb-3.4.3（可选）

	支持Html5浏览器


## 发布项目：

>1、该项目依赖Identity，需要先部署身份系统，具体详见：

	https://github.com/dianbaer/Identity

>2、安装数据库
	
	create database chat
	
	source ****/chat.sql
	
>3、安装MongoDB数据库（通过配置可选）

	mongo --host 0.0.0.0 --eval 'db = db.getSiblingDB("chat");db.createUser({user: "chat",pwd: "123456",roles: [ "readWrite", "dbAdmin" ]})'

>4、将ChatConfig放入服务器某个路径，例如
	
	/home/ChatConfig

>5、将ChatServer.properties放入tomcat根目录下，例如
	
	/home/tomcat/ChatServer.properties
	
	并修改config_dir对应的ChatConfig路径

>6、将ChatClient与ChatServer.war放入tomcat/webapps，例如
	
	/home/tomcat/webapps/ChatServer.war
	
	/home/tomcat/webapps/ChatClient

	
## 如何嵌入Chat：
	
	1、基于Identity身份系统开发的项目直接调用

		<iframe frameborder="0" allowtransparency="true" width="770px" height="480px" id="talk_box" src="https://xxx/talk.html?token=5ffdefd0e1104ebdbc49cc6de538b669"></iframe>
		
	2、基于其他身份系统，需对Chat进行二次开发对接相应的身份系统


## Chat功能：

	群组聊天，个人对个人聊天。
	支持发送表情。
	查看聊天记录及按时间段查询。
	相同用户登录踢下线功能。
	

## Chat特色：	

>1、嵌入式：
	
	支持嵌入方式。
	
>2、推送聊天动态控制
	
	服务器支持对聊天记录的推送进行有效控制，可在高负荷的情况下依据服务器IO状况进行可选择性推送。
	
>3、聊天记录非关系型存储

	支持将聊天记录存入MongoDB，有效的减少服务器查询聊天记录的数据库负荷。
	
>4、基于统一线程模型，优秀的多线程推送机制，高效的、线程安全的登录、登出队列。
	
	线程1：
	
		用户登录并放入2~n的随机线程。
		用户离线、用户断线。
		
	线程2~n：
	
		轮训本线程的每个用户要接受的聊天记录队列进行推送。
		加入、离开本线程要做的事情。
		发送消息给组或个人的随机线程处理。
		已阅读消息、已阅读组消息的随机线程处理。
		获取聊天记录的随机线程处理。
	
	
	
	
	
	
	