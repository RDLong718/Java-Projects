/*
 * 12/9/2020
   Sample Final Question 1
 */
package rectangleapp;

/**
 *
 * @author Sokol
 */
public class Rational {
    // fields
    private int num;
    private int den;
    /**
     * 
     * @param num
     * @param den
     * @throws Exception 
     */
    public Rational(int num, int den) throws Exception {
        if (den==0) throw new Exception("div by 0");
        this.num=num;
        this.den=den;
    }
    /**
     * 
     * @param num 
     */
    public Rational(int num) throws Exception {
        this(num, 1);
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        if (den==1) return "" + num;
        return num + "/" + den;
    }
    /**
     * 
     * @param obj
     * @return
     * @throws Exception 
     */
   public Rational multiply(Rational obj) throws Exception {
       return new Rational(this.num*obj.num, this.den*obj.den);
   } 
   /**
    * 
    * @return
    * @throws Exception 
    */
    public Rational inverse() throws Exception {
       return new Rational(this.den, this.num);
   } 
    /**
     * 
     * @param obj
     * @return 
     */
    public boolean equals(Rational obj) {
        return this.num==obj.num && this.den==obj.den;
    }
    public static void main(String[] args) {
        try {
            Rational r1 = new Rational(5);
            Rational r2 = new Rational(6, 19);
            Rational r3 = r1.multiply(r2);
            r3 = r1.inverse();
            if (r1.equals(r3))
                System.out.println("r1 and r3 are the same.");
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
