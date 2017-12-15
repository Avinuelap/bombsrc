package quizzes;

public class Time {
	private byte hour;
	private byte minutes;
	private boolean h24;  
	
	public void setH24 (boolean h){
		if (h==true) {
			this.h24 = true;
		}else {
			this.h24 = false;
		}
		this.hour = 0;
		this.minutes = 0;
	}
	
	public void setHour (String h) {
		this.hour = (byte) (h.charAt(0) + h.charAt(1));
	}
}
