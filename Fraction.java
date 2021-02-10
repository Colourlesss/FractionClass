public class Fraction{
    private int numerator, denominator;
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }
    public Fraction(int num,int denom){
        this.numerator = num;
        if(denom!=0){
            this.denominator = denom;
        }else{
            this.denominator = 1;
        }
    }
    public Fraction(String frac){
        String[] a = frac.split("/");
        this.numerator = Integer.parseInt(a[0]);
        if(!a[1].equals("0")){
            this.denominator = 1;
        }else{
        this.denominator = Integer.parseInt(a[1]);
        }
    }
    public Fraction(Fraction frac){
        this.numerator = frac.numerator;
        this.denominator = frac.denominator;
    }
    public int getNum(){
        return this.numerator;
    }
    public int getDenom(){
        return this.denominator;
    }
    public double toDouble(){
        return this.numerator / this.denominator;
    }
    private int GCF(int a,int b){
        if(a==0 || b==0){
            return 1;
        }
        if(a<0){
            return GCF(-a,b);
        }
        if(b<0){
            return GCF(a,-b);
        }
        while(a!=b){
            if(a>b){
                a = a-b;
            }else if(b>a){
                b = b-a;
            }
        }
        return a;
    }
    public void reduce(){
        int gcf = GCF(this.numerator,this.denominator);
        this.numerator = this.numerator / gcf;
        this.denominator = this.denominator / gcf;
    }
    public void setNum(int num){
        this.numerator = num;
    }
    public void setDenom(int denom){
        if(denom==0){
            System.out.println("Invalid Value");
        }else{
            this.denominator = denom;
        }
    }
    public static Fraction multiply(Fraction a, Fraction b){
        Fraction res = new Fraction(a.getNum() * b.getNum(),a.getDenom() * b.getDenom());
        return res;
    }
    public static Fraction divide(Fraction dividend, Fraction divisor){
        if(divisor.getNum()==0){
            System.out.println("Invalid Divisor, returned dividend");
            return dividend;
        }else{
            Fraction res = new Fraction(dividend.getNum() * divisor.getDenom(),dividend.getDenom() * divisor.getNum());
            res.reduce();
            return res;
        }
    }
    public static Fraction add(Fraction a, Fraction b){
        int n = a.getNum() * b.getDenom() + b.getNum() * a.getDenom();
        int d = a.getDenom() * b.getDenom();
        Fraction res = new Fraction(n,d);
        res.reduce();
        return res;
    }
    public static Fraction substract(Fraction minuend, Fraction minus){
        int n = minuend.getNum() * minus.getDenom() - minus.getNum() * minuend.getDenom();
        int d = minuend.getDenom() * minus.getDenom();
        Fraction res = new Fraction(n,d);
        res.reduce();
        return res;
    }
}
