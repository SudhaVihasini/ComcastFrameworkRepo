package pratice.test;

import java.util.Date;

public class CaptureTimeStamp {
	public static void main(String[]args) {
		String time=new Date().toString().replace(" "," ").replace(":"," ");
		System.out.println(time);
	}

}
