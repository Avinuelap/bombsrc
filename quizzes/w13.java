package quizzes;

public class w13 {

	public static int myMethod3(int a, double [] b){
        for (int ii=0; ii<b.length; ii++){
        if (b[ii]<2)
            a++;
    }
    return a;
}

public static void main (String [] args){
    int v1 = 4;
    double v2 [] = new double []{1.2,1.3,2.5,6.3,2.8,3};
    v1=myMethod3(v1,v2);
    System.out.println(v1);

}}


	


