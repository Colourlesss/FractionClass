public class FractionDriver
{
    public static void main(String[] args){
        Fraction a = new Fraction(1,9);
        Fraction b = new Fraction(1,3);
        Fraction c = Fraction.multiply(a,b);
        System.out.println(c.getNum() + "/" + c.getDenom());
    }
}
