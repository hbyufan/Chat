package server;

import config.CommonConfigChat;
import http.HOpCodeUCenter;
import init.IExpand;
import init.Init;
import mongo.MongodbManager;
import msg.MsgOpCodeChat;
import service.LoginChatService;
import service.LoginChatServiceMongodb;
import service.MessageService;
import service.MessageServiceMongodb;
import ws.WsOpCodeChat;

public class Expand implements IExpand {

	@Override
	public void init() throws Exception {
		WsOpCodeChat.init();
		HOpCodeUCenter.init();
		CommonConfigChat.init();
		MsgOpCodeChat.init();
		if (CommonConfigChat.IS_USE_MONGODB) {
			MongodbManager.init(CommonConfigChat.MONGODB_URL, CommonConfigChat.MONGODB_PORT, CommonConfigChat.MONGODB_USERNAME, CommonConfigChat.MONGODB_PASSWORD, CommonConfigChat.MONGODB_DBNAME);
			Init.registerService(LoginChatServiceMongodb.class);
			Init.registerService(MessageServiceMongodb.class);
		} else {
			Init.registerService(LoginChatService.class);
			Init.registerService(MessageService.class);
		}
	}

	@Override
	public void threadInit() throws Exception {

	}

}
