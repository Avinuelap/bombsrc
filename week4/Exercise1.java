package week4;

public class Exercise1 {

	public static void main(String[] args) {
		byte a=28;
		short  b=30000;
		int  c=1000000;
		long d=5000000;
		float e=2.8E10F;
		double f=4.5E34;
		char g= 'a';
		boolean h=false;
		String i="stringin";
		
		
	//////////////////////////// B Y T E ///////////////////////////////////
		short b1= a;	//ok
		int c1= a;		//ok
		long d1= a;		//ok
		float e1= a;	//ok
		double f1= a;	//ok
		char g1= a;		//error
		boolean h1= a;	//error
		String i1= a;	//error
		
	//////////////////////////// S H O R T //////////////////////////////////
		byte a2= b;		//error
		int c2= b;		//ok
		long d2= b;		//ok
		float e2= b;	//ok
		double f2= b;	//ok
		char g2= b;		//error
		boolean h2= b;	//error
		String i2= b;	//error
		
	//////////////////////////// I N T //////////////////////////////////////
		byte a3= c;		//error
		short b3= c;	//error
		long d3= c;		//ok
		float e3= c;	//ok
		double f3= c;	//ok
		char g3= c;		//error
		boolean h3= c;	//error
		String i3= c;	//error
		
	//////////////////////////// L O N G ////////////////////////////////////
		byte a4= d;		//error
		short b4= d;	//error
		int c4= d;		//error
		float e4= d;	//ok
		double f4= d;	//ok
		char g4= d;		//error
		boolean h4= d;	//error
		String i4= d;	//error
	
	//////////////////////////// F L O A T ///////////////////////////////////
		byte a5= e;		//error
		short b5= e;	//error
		int c5= e;		//error
		long d5= e;		//error
		double f5= e;	//ok
		char g5= e;		//error
		boolean h5= e;	//error
		String i5= e;	//error
		
	//////////////////////////// D O U B L E //////////////////////////////////
		byte a6= f;		//error
		short b6= f;	//error
		int c6= f;		//error
		long d6= f;		//error
		float e6= f;	//error
		char g6= f;		//error
		boolean h6= f;	//error
		String i6= f;	//error
		
	//////////////////////////// C H A R /////////////////////////////////////
		byte a7= g;		//error
		short b7= g;	//error
		int c7= g;		//ok
		long d7= g;		//ok
		float e7= g;	//ok
		double f7= g;	//ok
		boolean h7= g;	//error
		String i7= g;	//error
	
	//////////////////////////// B O O L E A N ////////////////////////////////
		byte a8= h;		//error
		short b8= h;	//error
		int c8= h;		//error
		long d8= h;		//error
		float e8= h;	//error
		double f8= h;	//error
		char g8= h;		//error
		String i8= g;	//error
		
	//////////////////////////// S T R I N G /////////////////////////////////
		byte a9= i;		//error
		short b9= i;	//error
		int c9= i;		//error
		long d9= i;		//error
		float e9= i;	//error
		double f9= i;	//error
		boolean h9= i;	//error
		char g9= i;		//error
		
		
//		Type	byte	short	int	 long	float	double	char   boolean  string
//      byte    YES	     YES    YES	  YES	 YES	 YES	 NO	     NO       NO
//		short	NO		 YES 	YES	  YES	 YES	 YES	 NO	     NO       NO
//		int		NO		 NO 	YES	  YES	 YES	 YES	 NO	     NO       NO
//		long	NO		 NO 	NO	  YES	 YES	 YES	 NO	     NO       NO
//		float	NO		 NO 	NO	  NO	 YES	 YES	 NO	     NO       NO
//		double	NO		 NO 	NO	  NO	 NO		 YES	 NO	     NO       NO
//		char	NO		 NO 	YES	  YES	 YES	 YES	 YES	 NO       NO
//		boolean NO		 NO 	NO	  NO	 NO		 NO		 NO 	 YES      NO
//		string	NO		 NO 	NO	  NO	 NO		 NO		 NO		 NO       YES
		
		
		
		
		
	}

}
