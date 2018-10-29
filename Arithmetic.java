package Bai2;

public class Arithmetic {
    public int Div(int a, int b) throws ArithmeticException{
        return a/b;
    }
    public static void main(String[] args){

        try {
            System.out.println(new Arithmetic().Div(5, 0));
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
