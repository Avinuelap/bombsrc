package week4;

public class Exercise2 {

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
	short b1= a;		//ok
	int c1= a;			//ok
	long d1= a;			//ok
	float e1= a;		//ok
	double f1= a;		//ok
	char g1= (char) a;			//ok
	boolean h1= (boolean) a;	//error
	String i1= (String) a;		//error
	
//////////////////////////// S H O R T //////////////////////////////////
	byte a2= (byte) b;			//ok
	int c2= b;			//ok
	long d2= b;			//ok
	float e2= b;		//ok
	double f2= b;		//ok
	char g2= (char) b;			//ok
	boolean h2= (boolean) b;	//error
	String i2= (String) b;		//error
	
//////////////////////////// I N T //////////////////////////////////////
	byte a3= (byte) c;			//ok
	short b3= (short) c;		//ok
	long d3= c;			//ok
	float e3= c;		//ok
	double f3= c;		//ok
	char g3= (char) c;			//ok
	boolean h3= (boolean) c;	//error
	String i3= (String) c;		//error
	
//////////////////////////// L O N G ////////////////////////////////////
	byte a4= (byte) d;			//ok
	short b4= (short) d;		//ok
	int c4= (int) d;			//ok
	float e4= d;		//ok
	double f4= d;		//ok
	char g4= (char) d;			//ok
	boolean h4= (boolean)d;		//error
	String i4= (String) d;		//error

//////////////////////////// F L O A T ///////////////////////////////////
	byte a5= (byte) e;			//ok
	short b5= (short) e;		//ok
	int c5= (int) e;			//ok
	long d5= (long) e;			//ok
	double f5= e;			//ok
	char g5= (char) e;			//ok
	boolean h5= (boolean) e;	//error
	String i5= (String) e;		//error
	
//////////////////////////// D O U B L E //////////////////////////////////
	byte a6= (byte) f;			//ok
	short b6= (short) f;		//ok
	int c6= (int) f;			//ok
	long d6= (long) f;			//ok
	float e6= (float) f;		//ok
	char g6= (char) f;			//ok
	boolean h6= (boolean) f;	//error
	String i6= (String) f;		//error
	
//////////////////////////// C H A R /////////////////////////////////////
	byte a7= (byte) g;			//ok
	short b7= (short) g;		//ok
	int c7= g;			//ok
	long d7= g;			//ok
	float e7= g;		//ok
	double f7= g;		//ok
	boolean h7= (boolean) g;	//error
	String i7= (String) g;		//error

//////////////////////////// B O O L E A N ////////////////////////////////
	byte a8= (byte) h;			//error
	short b8= (short) h;		//error
	int c8= (int) h;			//error
	long d8= (long) h;			//error
	float e8= (float) h;		//error
	double f8= (double) h;		//error
	char g8= (char) h;			//error
	String i8= (String) g;		//error
	
//////////////////////////// S T R I N G /////////////////////////////////
	byte a9= (byte) i;			//error
	short b9= (short)i;			//error
	int c9= (int) i;			//error
	long d9= (long) i;			//error
	float e9= (float) i;		//error
	double f9= (double) i;		//error
	boolean h9= (boolean) i;	//error
	char g9= (char) i;			//error
	
//	Type	byte	short	int	 long	float	double	char   boolean  string
//  byte    YES	     YES    YES	  YES	 YES	 YES	 YES     NO       NO
//	short	YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	int		YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	long	YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	float	YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	double	YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	char	YES		 YES 	YES	  YES	 YES	 YES	 YES	 NO       NO
//	boolean NO		 NO 	NO	  NO	 NO		 NO		 NO 	 YES      NO
//	string	NO		 NO 	NO	  NO	 NO		 NO		 NO		 NO       YES
	
	
//Non-numerical data types can't be casted to numerical types, and vice versa
}	
