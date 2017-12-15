package week9;

/**
 * 
 * @author Antonio Viñuela
 * @author Ignacio Velasco 
 *
 */

public class TimeInterval {
	public byte initialMin;
	public byte initialHour;
	public byte finalMin;
	public byte finalHour;
	
	public String tInterval;
	/** Time intervals belong to:
	 * morning: 06:00-12:00
	 * afternoon: 12:00-18:00
	 * evening: 18:00-00:00
	 * night: 00:00-06:00
	 */
	
	public TimeInterval(byte iH, byte iM, byte fH, byte fM) {
		// 1. Checking if hours are correct.
		// If the starting hour is not correct, it will copy the value for the ending hour and viceversa.
		// If none is correct, 0 will be set for both.
		if (iH<0 || iH>24 ) {
			if (fH<0 || fH>24 ) {
				iH=fH=0;				
			}
			else {
				iH=fH;
			}
		}
		
		if (fH<0 || fH>24 ) {
			fH=iH;
		}
		
		finalHour = fH;
		initialHour = iH;
		
		// 2. Checking if minutes are correct
		// If the starting or ending minutes are not correct they will be set to 0.
		if (iM<0 || iM>60) {
			iM=0;
		}
		if (fM<0 || fM>60) {
			fM=0;
		}
		finalMin = fM;
		initialMin = iM;
		
		// 3. The starting time point must be previous to the ending time point. If not, both will be interchanged
		if ((fH<iH) || (fH==iH && fM < iM)) {
			byte a = iH;
			iH = fH;
			fH = a;
			
			byte b = iM;
			iM = fM;
			fM = b;
			
			finalHour = fH;
			initialHour = iH;
			finalMin = fM;
			initialMin = iM;			
		}	
		
		// 4. The constructor must automatically set the values for morning/afternoon/evening/night:
			
			// First if: starting in night:
		if (initialHour>=0 && initialHour<6) {
			if (finalHour>=0 && finalHour<6) {
				tInterval = "night";
			}
			if (finalHour>=6 && finalHour<12) {
				tInterval = "night morning";
			}
			if (finalHour>=12 && finalHour<18) {
				tInterval = "night morning afternoon";
			}
			if (finalHour>=18 && finalHour<24) {
				tInterval = "night morning afternoon evening";
			}
		}


			// Second if: starting in morning:
		if (initialHour>=6 && initialHour<12) {
			if (finalHour>=6 && finalHour<12) {
				tInterval = "morning";
			}
			if (finalHour>=12 && finalHour<18) {
				tInterval = "morning afternoon";
			}
			if (finalHour>=18 && finalHour<24) {
				tInterval = "morning afternoon evening";
			}
		}

			//Third if: starting in afternoon:			
		if (initialHour>=12 && initialHour<18) {
			if (finalHour>=12 && finalHour<18) {
				tInterval = "afternoon";
			}
			if (finalHour>=18 && finalHour<24) {
				tInterval  = "afternoon evening";
			}
		}

			//Third if: starting in evening:
		if (initialHour>=18 && initialHour<24 && finalHour>=18 && finalHour<24) {
			tInterval = "evening";
			}
		}
	}

