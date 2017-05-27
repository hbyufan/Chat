package action;

import config.CommonConfigChat;
import http.AllowParam;
import http.HOpCodeUCenter;
import http.HttpPacket;
import http.HttpUtil;
import protobuf.http.UCErrorProto.UCError;
import protobuf.http.UserGroupProto.GetUserGroupC;
import protobuf.http.UserGroupProto.GetUserGroupS;
import protobuf.http.UserGroupProto.UserGroupData;

public class UserGroupAction {
	public static UserGroupData getUserGroup(String userGroupId, String token) {
		GetUserGroupC.Builder builder = GetUserGroupC.newBuilder();
		builder.setHOpCode(HOpCodeUCenter.GET_USER_GROUP);
		builder.setUserGroupId(userGroupId);
		HttpPacket httpPacket = new HttpPacket(HOpCodeUCenter.GET_USER_GROUP, builder.build());
		HttpPacket returnHttpPacket = HttpUtil.send(httpPacket, CommonConfigChat.UCENTER_URL, AllowParam.SEND_TYPE_PROTOBUF, AllowParam.RECEIVE_TYPE_PROTOBUF, token);
		if (returnHttpPacket != null) {
			if ((returnHttpPacket.getData()) instanceof UCError) {
				return null;
			}
			GetUserGroupS message = (GetUserGroupS) returnHttpPacket.getData();
			return message.getUserGroup();
		}
		return null;
	}
}
