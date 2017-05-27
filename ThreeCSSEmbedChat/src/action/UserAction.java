package action;

import java.util.List;

import config.CommonConfigChat;
import http.AllowParam;
import http.HOpCodeUCenter;
import http.HttpPacket;
import http.HttpUtil;
import protobuf.http.UCErrorProto.UCError;
import protobuf.http.UserGroupProto.GetUserC;
import protobuf.http.UserGroupProto.GetUserListC;
import protobuf.http.UserGroupProto.GetUserListS;
import protobuf.http.UserGroupProto.GetUserS;
import protobuf.http.UserGroupProto.UserData;
import protobuf.ws.LoginChatProto.ChatUserData;

public class UserAction {
	public static UserData getUser(String token) {
		GetUserC.Builder builder = GetUserC.newBuilder();
		builder.setHOpCode(HOpCodeUCenter.GET_USER);
		HttpPacket httpPacket = new HttpPacket(HOpCodeUCenter.GET_USER, builder.build());
		HttpPacket returnHttpPacket = HttpUtil.send(httpPacket, CommonConfigChat.UCENTER_URL, AllowParam.SEND_TYPE_PROTOBUF, AllowParam.RECEIVE_TYPE_PROTOBUF, token);
		if (returnHttpPacket != null) {
			// 如果返回的是错误类型,说明用户中心拦截器没通过
			if ((returnHttpPacket.getData()) instanceof UCError) {
				return null;
			}
			GetUserS message = (GetUserS) returnHttpPacket.getData();
			return message.getUser();
		}
		return null;
	}

	public static List<UserData> getFriendList(String userGroupTopId, String token) {
		GetUserListC.Builder builder = GetUserListC.newBuilder();
		builder.setUserGroupTopId(userGroupTopId);
		builder.setHOpCode(HOpCodeUCenter.GET_USER_LIST);
		HttpPacket httpPacket = new HttpPacket(HOpCodeUCenter.GET_USER_LIST, builder.build());
		HttpPacket returnHttpPacket = HttpUtil.send(httpPacket, CommonConfigChat.UCENTER_URL, AllowParam.SEND_TYPE_PROTOBUF, AllowParam.RECEIVE_TYPE_PROTOBUF, token);
		if (returnHttpPacket != null) {
			// 如果返回的是错误类型,说明用户中心拦截器没通过
			if ((returnHttpPacket.getData()) instanceof UCError) {
				return null;
			}
			GetUserListS message = (GetUserListS) returnHttpPacket.getData();
			return message.getUserList();
		}
		return null;
	}

	public static ChatUserData.Builder getChatUserDataBuilder(UserData userData, boolean isOnline) {
		ChatUserData.Builder builder = ChatUserData.newBuilder();
		builder.setUserId(userData.getUserId());
		builder.setUserImg(userData.getUserImg());
		builder.setUserRealName(userData.getUserRealName());
		builder.setUserRole(userData.getUserRole());
		builder.setIsOnline(isOnline);
		return builder;
	}
}
