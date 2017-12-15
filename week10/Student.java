package week10;

public class Student {
	private String name;
	private String surname;
	private float pMark, aMark, cMark, iMark, wMark;
	
	//Set methods for every field
	public void setName(String n) {
		this.name = n;
	}
	
	public void setSurname(String sN) {
		this.surname = sN;
	}
	
	public void setPMark(float pM) {
		if (pM>=0 && pM<=10) {
		this.pMark = pM;
		}
		else {
			this.pMark = 0;
		}
	}
	
	public void setAMark(float aM) {
		if (aM>=0 && aM<=10) {
		this.aMark = aM;
		}
		else {
			this.aMark = 0;
		}
	}
	
	public void setCMark(float cM) {
		if (cM>=0 && cM<=10) {
		this.cMark = cM;
		}
		else {
			this.cMark = 0;
		}
	}
	
	public void setIMark(float iM) {
		if (iM>=0 && iM<=10) {
		this.iMark = iM;
		}
		else {
			this.iMark = 0;
		}
	}
	
	public void setWMark(float wM) {
		if (wM>=0 && wM<=10) {
		this.wMark = wM;
		}
		else {
			this.wMark = 0;
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
		return this.pMark;	
	}
	
	public float getAMark() {
		return this.aMark;
	}
	
	public float getCMark() {
		return this.cMark;
	}
	
	public float getIMark() {
		return this.iMark;
	}
	
	public float getWMark() {
		return this.wMark;
	}
	
	
	//Full constructor:
	public Student (String n, String sN, float pM, float cM, float aM, float iM, float wM) {
		setName(n);
		setSurname(sN);
		setPMark(pM);
		setCMark(cM);
		setAMark(aM);
		setIMark(iM);
		setWMark(wM);
		
		
	}
}
