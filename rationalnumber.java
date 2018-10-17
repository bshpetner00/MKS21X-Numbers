public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else {
      numerator = nume;
      denominator = deno;
    }
	reduce();
  }

  public double getValue(){
    return numerator / denominator;
  }

  /**
  *return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
	RationalNumber reciprocal = new RationalNumber(denominator, numerator);
    return reciprocal;
  }
  /**
  *return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
  }


  /**
  *return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return ""+numerator+"/"+denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    while (a > 0 && b > 0) {
		int previous = a;
		a = b;
		b = (previous % b);
	}
	if (a == 0) {
		return b;
	}
	else if (b == 0){
		return a;
	}
	else {
		return 1;
	}
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
	int gcd = gcd(numerator, denominator);
	numerator = numerator / gcd;
	denominator = denominator / gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(this.getNumerator() * other.getNumerator(), this.getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(this.getNumerator() * other.getDenominator(), this.getDenominator()*other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int numerator = this.getNumerator()*other.getDenominator()+other.getNumerator()*other.getDenominator();
	int denominator = this.getDenominator()*other.getDenominator()+this.getDenominator()*other.getDenominator();
	RationalNumber q = new RationalNumber(numerator,denominator);
	return q;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int numerator = this.getNumerator()*other.getDenominator()-other.getNumerator()*other.getDenominator();
	int denominator = this.getDenominator()*other.getDenominator()-other.getDenominator()*this.getDenominator();
	RationalNumber q = new RationalNumber(numerator,denominator);
	return q;
  }
} 