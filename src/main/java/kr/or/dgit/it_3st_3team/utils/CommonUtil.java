package kr.or.dgit.it_3st_3team.utils;


public class CommonUtil {
	public static final String PATTERN_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+$";
	public static final String PATTERN_PHONE = "^[0-9-]{8,14}$";
	public static final String IMG_PATH = System.getProperty("user.dir") + "\\DataImg\\";
	public static final String DEFAULT_USER_IMG = "nobody.png";

	public static String phoneNumberHyphenAdd(String num, boolean mask) {

	    String formatNum = "";
	    num = num.replaceAll("-","");

	    if (num.length() == 11) {
	        if (mask) {
	            formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-****-$3");
	        }else{
	            formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
	        }
	    }else if(num.length()==8){
	        formatNum = num.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
	    }else{
	        if(num.indexOf("02")==0){
	            if(mask){
	                formatNum = num.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-****-$3");
	            }else{
	                formatNum = num.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3");
	            }
	        }else{
	            if(mask){
	                formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-****-$3");
	            }else{
	                formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
	            }
	        }
	    }
	    return formatNum;
	}
}
