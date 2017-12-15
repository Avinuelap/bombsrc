package week10;

public class Student2 {

		private String name;
		private String surname;
		private float[] marks = new float [5]; //Programming, calculus, algebra, information, writing
		
		//Set methods for every field
		public void setName(String n) {
			this.name = n;
		}
		
		public void setSurname(String sN) {
			this.surname = sN; 
		}
		
		public void setPMark(float pM) {
			if (pM>=0 && pM<=10) {
			this.marks[0] = pM; 
			}
			else {
				this.marks[0] = 0;
			}
		}
		
		public void setAMark(float aM) {
			if (aM>=0 && aM<=10) {
			this.marks[1] = aM;
			}
			else {
				this.marks[1] = 0;
			}
		}
		
		public void setCMark(float cM) {
			if (cM>=0 && cM<=10) {
			this.marks[2] = cM;
			}
			else {
				this.marks[2] = 0;
			}
		}
		
		public void setIMark(float iM) {
			if (iM>=0 && iM<=10) {
			this.marks[3] = iM;
			}
			else {
				this.marks[3] = 0;
			}
		}
		
		public void setWMark(float wM) {
			if (wM>=0 && wM<=10) {
			this.marks[4] = wM;
			}
			else {
				this.marks[4] = 0;
			}
		}
		
		//Get methods for every field
		public String getName() {
			return this.name;
		}
		
		public String getSurname() {
			return this.surname;
		}
		
		public float getPMark() {
			return this.marks[0];	
		}
		
		public float getAMark() {
			return this.marks[1];
		}
		
		public float getCMark() {
			return this.marks[2];
		}
		
		public float getIMark() {
			return this.marks[3];
		}
		
		public float getWMark() {
			return this.marks[4];
		}
		
		
		//Full constructor:
		public Student2 (String n, String sN, float pM, float cM, float aM, float iM, float wM) {
			setName(n);
			setSurname(sN);
			setPMark(pM);
			setCMark(cM);
			setAMark(aM);
			setIMark(iM);
			setWMark(wM);
			
			
		}
	}

