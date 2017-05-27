package ws;

import protobuf.ws.LoginChatProto.AgainConnectS;
import protobuf.ws.LoginChatProto.ChatUserOfflineS;
import protobuf.ws.LoginChatProto.ChatUserOnlineS;
import protobuf.ws.LoginChatProto.GetChatListC;
import protobuf.ws.LoginChatProto.GetChatListS;
import protobuf.ws.LoginChatProto.GroupMessageReceiveC;
import protobuf.ws.LoginChatProto.GroupMessageS;
import protobuf.ws.LoginChatProto.LoginChatServerC;
import protobuf.ws.LoginChatProto.LoginChatServerS;
import protobuf.ws.LoginChatProto.SendMessageC;
import protobuf.ws.LoginChatProto.ToUserMessageS;
import protobuf.ws.LoginChatProto.UserKickS;
import protobuf.ws.LoginChatProto.UserMessageReceiveC;
import protobuf.ws.LoginChatProto.UserMessageS;

public class WsOpCodeChat extends WsOpCode {
	// 登录请求
	public static int LOGIN_CHAT_SERVER_C = 1;
	// 登录成功后返回数据
	public static int LOGIN_CHAT_SERVER_S = 2;
	// 用户上线
	public static int USER_ONLINE_S = 3;
	// 用户下线
	public static int USER_OFFLINE_S = 4;
	// 发送消息给个人或组织
	public static int SEND_MESSAGE_C = 5;
	// 接到的个人消息
	public static int USER_MESSAGE_S = 6;
	// 接到的组织消息
	public static int GROUP_MESSAGE_S = 7;
	// 用户收到个人消息的回复
	public static int USER_MESSAGE_RECEIVE_C = 8;
	// 用户收到组织消息的回复
	public static int GROUP_MESSAGE_RECEIVE_C = 9;
	// 用户被踢下线
	public static int USER_KICK_S = 10;
	public static int AGAIN_CONNECT_S = 11;

	public static int GET_CHAT_LIST_C = 12;
	public static int GET_CHAT_LIST_S = 13;

	// 接到的自己发送给别人的消息
	public static int TO_USER_MESSAGE_S = 14;

	public static void init() {
		wsOpCodeMap.put(LOGIN_CHAT_SERVER_C, LoginChatServerC.class);
		wsOpCodeType.put(LOGIN_CHAT_SERVER_C, new int[] { 1, 1 });

		wsOpCodeMap.put(LOGIN_CHAT_SERVER_S, LoginChatServerS.class);

		wsOpCodeMap.put(USER_ONLINE_S, ChatUserOnlineS.class);

		wsOpCodeMap.put(USER_OFFLINE_S, ChatUserOfflineS.class);

		wsOpCodeMap.put(SEND_MESSAGE_C, SendMessageC.class);
		wsOpCodeMap.put(USER_MESSAGE_S, UserMessageS.class);
		wsOpCodeMap.put(GROUP_MESSAGE_S, GroupMessageS.class);
		wsOpCodeMap.put(USER_MESSAGE_RECEIVE_C, UserMessageReceiveC.class);
		wsOpCodeMap.put(GROUP_MESSAGE_RECEIVE_C, GroupMessageReceiveC.class);
		wsOpCodeMap.put(USER_KICK_S, UserKickS.class);
		wsOpCodeMap.put(AGAIN_CONNECT_S, AgainConnectS.class);
		wsOpCodeMap.put(GET_CHAT_LIST_C, GetChatListC.class);
		wsOpCodeMap.put(GET_CHAT_LIST_S, GetChatListS.class);
		wsOpCodeMap.put(TO_USER_MESSAGE_S, ToUserMessageS.class);

	}
}
