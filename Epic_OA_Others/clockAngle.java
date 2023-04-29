/*
 * We are given a specific time(like 02:23), we need to get the angle 
 * between hour and minute(less than 180)
 */

public class clockAngle{
	public static void main(String[] args){
		angle("02:33");
	}

	public static void angle(String time){
		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);
		double angle = (Math.abs(30*hour+minute*0.5-minute*6)>180)?(360-(Math.abs(30*hour+minute*0.5-minute*6))):(Math.abs(30*hour+minute*0.5-minute*6));
		System.out.println(angle);
	}
}