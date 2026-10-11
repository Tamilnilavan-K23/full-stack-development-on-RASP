class SUM{
    private int a;
    private int b;

    public SUM(int b, int a) {
        this.b = b;
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

   @Override
    public String toString() {
        return "SUM{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    int sum(){
        return a+b;
    }

}


public class Sample {
    public static void main(String[] args) {
        SUM sum=new SUM(34,56);
        System.out.println(sum);
        System.out.println(sum.toString());
        System.out.println(sum.toString()+" is "+sum.sum());

    }
}
