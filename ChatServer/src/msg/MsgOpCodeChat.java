package msg;

import org.grain.threadmsg.ThreadMsgManager;

public class MsgOpCodeChat {
	public static String USER_OFFLINE = "USER_OFFLINE";

	public static void init() {
		ThreadMsgManager.addMapping(USER_OFFLINE, new int[] { 1, 1 });
	}
}
