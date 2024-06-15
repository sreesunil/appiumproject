package constants;

import utils.CommonUtils;

public class FileConstant {
	
	public static final String REPORT_PATH = System.getProperty("user.dir")+"/src/main/resources/reports/"+ CommonUtils.getStringDateAndTimestamp()+ "_APIDEMOS.html";
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir")+"/src/main/resources/reports/" + CommonUtils.getStringDateAndTimestamp()+"_APIDEMOS.PNG";

}
