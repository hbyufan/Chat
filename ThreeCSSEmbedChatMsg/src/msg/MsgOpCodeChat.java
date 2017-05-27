package msg;

import protobuf.msg.UserOfflineMsg.UserOffline;

public class MsgOpCodeChat extends MsgOpCode {
	public static String USER_OFFLINE = "USER_OFFLINE";

	public static void init() {
		msgOpCodeMap.put(USER_OFFLINE, UserOffline.class);
		msgOpcodeType.put(USER_OFFLINE, new int[] { 1, 1 });
	}
}
