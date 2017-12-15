package week8;

/**
 * 
 * @author Antonio Viñuela
 * @author Ignacio Velasco
 */
public class RightTriangle {
	public float height; 
	public float base; 
	
	public RightTriangle(float height, float base) {
		if (height<=0) {
			this.height = 1.0F;
		}
		else {
			this.height = height;
		}
		
		if (base<=0) {
			this.base = 1.0F;
		}
		else {
			this.base = base;
		}
	}
}
