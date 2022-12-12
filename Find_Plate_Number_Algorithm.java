


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This is where you implement your algorithm to find the correct Plate to return
 * You will need to use the database 
 * @author armen
 *
 */

public class Find_Plate_Number_Algorithm {

	

	public static String getPlateNumber (ArrayList<String[]> ArrayOfPlateResults, Camera_System Cameras) {

		if (ArrayOfPlateResults.size() > 0) {

			/**
			 * Returns the 1st element in the 1st array in ArrayOfPlateResults
			 * This so you can see your program working
			 */
			String chi = ("京渝沪津皖闽甘粤贵琼冀黑豫鄂湘苏赣吉辽青陕鲁晋川云浙桂蒙宁藏新0123456789");
			String eng = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			String[] PlateArray = ArrayOfPlateResults.get(0);
//			StringBuilder chinese = new StringBuilder(PlateArray[3]);
//			StringBuilder english = new StringBuilder(PlateArray[2]);
//			StringBuilder english1 = new StringBuilder(checkValid(english));
//			int p1 = 0;
//			int p2 = 0;
//			while(p1 < chi.length()){
//				if(chinese.charAt(p1) != english1.charAt(p2) && chi.contains(chinese.substring(p1,p1+1))) {
//					english1.replace(p2, p2 + 1, chinese.substring(p1, p1 + 1));
//					p1++;
//					p2++;
//				}
//			}
		}

		return null;

	}

	public static StringBuilder checkValid(StringBuilder str){
		if(str.length() > 8){
			str = new StringBuilder(str.substring(0, 8));
		}
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' ' && i != 2){
				if(i > 2){
					str = new StringBuilder(str.substring(i - 2));
				}else{
					str = new StringBuilder("0" + str.substring(i-2));
				}
			}
		}
		return str;
	}
	

	
	
	
	
	

}
