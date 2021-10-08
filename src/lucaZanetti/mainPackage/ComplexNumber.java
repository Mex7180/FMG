package lucaZanetti.mainPackage;

public class ComplexNumber {
	/* Complex Number object
	 * Defines a new object to calculate with complex numbers
	 * Functions for addition, subtraction and squares of complex numbers
	 * are defined.
	 */
	private double realPart;
	private double imaginaryPart;
	
	private double angle;
	private double r;
	
	//Constructor for a complex number
	public ComplexNumber(double re, double im) {
		this.imaginaryPart = im;
		this.realPart = re;
		
	}

	/* Add a second complex number to the first, returns 
	 * the new complex number with keeping the old value for the one,
	 * by which the function was called.
	 */
	public ComplexNumber addInC(ComplexNumber number2){
		double realRes= this.getRealPart()+number2.getRealPart();
		double imaginaerRes= this.getImaginaryPart()+number2.getImaginaryPart();
		
		ComplexNumber result = new ComplexNumber(realRes, imaginaerRes);
		return result;
	}
	/* Subtract a second complex number from the first one,
	 * returns the new complex number with keeping the old value for the one,
	 * by which the function was called.
	 */
	public ComplexNumber subtractInC(ComplexNumber number2) {
		double realRes= this.getRealPart()-number2.getRealPart();
		double imaginaerRes= this.getImaginaryPart()-number2.getImaginaryPart();
		
		ComplexNumber res = new ComplexNumber(realRes, imaginaerRes);
		return res;
	}
	
	/* Returns the square of the complex number, by which the function was called.
	 * Calculated with the normal form and not the polar one.
	 */
	public ComplexNumber cSquare() {
		double real = this.getRealPart();
		double imaginaer = this.getImaginaryPart();
		double realRes = (real*real)-(imaginaer*imaginaer);
		double imaginaerRes = (real*imaginaer)*2;
		ComplexNumber quadrat = new ComplexNumber(realRes, imaginaerRes);
		
		return quadrat;
	}
	/*
	 * Getters and setters 
	 */
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart(){
		return imaginaryPart;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public double getR() {
		r =  Math.sqrt((imaginaryPart*imaginaryPart)+(realPart*realPart));
		return r;
	}

}
