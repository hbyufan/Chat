package config;

import config.ConfigManager.JsonConfigType;
import log.LogManager;
import net.sf.json.JSONObject;

public class CommonConfigChat extends CommonConfig {

	public static String UCENTER_URL;
	public static String MONGODB_URL;
	public static int MONGODB_PORT;
	public static String MONGODB_USERNAME;
	public static String MONGODB_PASSWORD;
	public static String MONGODB_DBNAME;
	public static boolean IS_USE_MONGODB;

	public static void init() {
		LogManager.initLog.info("初始化CommonConfigChat");
		JSONObject configExt = ConfigManager.getJsonData(JsonConfigType.CONFIGEXT.getTypeValue());
		UCENTER_URL = configExt.getJSONArray("uCenterUrl").getString(0);

		MONGODB_URL = configExt.getJSONArray("mongodbUrl").getString(0);
		MONGODB_PORT = configExt.getJSONArray("mongodbPort").getInt(0);
		MONGODB_USERNAME = configExt.getJSONArray("mongodbUsername").getString(0);
		MONGODB_PASSWORD = configExt.getJSONArray("mongodbPassword").getString(0);
		MONGODB_DBNAME = configExt.getJSONArray("mongodbDBName").getString(0);

		IS_USE_MONGODB = configExt.getJSONArray("isUseMongodb").getBoolean(0);
		LogManager.initLog.info("初始化CommonConfigChat完成");
	}
}
