package Bai1;

abstract class Expression {
    @Override
    abstract public String toString();
    abstract public int evaluate();
}

class Numeral extends Expression{
    int value;

    public Numeral() {
    }

    public Numeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
class Square extends Expression{
    protected Expression expression;

    public Square(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(){
        return expression.evaluate()*expression.evaluate();
    }

    @Override
    public String toString() {
        return "Square:" + "expression=" + expression;
    }
}

abstract class BinaryExpression extends Expression{

    @Override
    abstract public int evaluate();
    abstract public Expression left();
    abstract public Expression right();
}


class Addition extends BinaryExpression{

    protected Expression left, right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() + right.evaluate());
    }

    @Override
    public Expression left() {
        return left;
    }

    @Override
    public Expression right() {
        return right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
}
class Multiplication extends BinaryExpression{
    Expression left, right;

    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() * right.evaluate());
    }

    @Override
    public Expression left() {
        return left;
    }

    @Override
    public Expression right() {
        return right;
    }
    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}

class Division extends BinaryExpression{
    Expression left, right;

    public Division(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() throws ArithmeticException{
        if(right.evaluate() == 0)
            throw new ArithmeticException("Lỗi chia cho 0");
        return (left.evaluate() / right.evaluate());
    }

    @Override
    public Expression left() {
        return left;
    }

    @Override
    public Expression right() {
        return right;
    }
    @Override
    public String toString() {
        return left.toString() + " : " + right.toString();
    }
}
class Subtraction extends BinaryExpression{
    Expression left, right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() - right.evaluate());
    }

    @Override
    public Expression left() {
        return left;
    }

    @Override
    public Expression right() {
        return right;
    }
    @Override
    public String toString() {
        return left.toString() + " - " + right.toString();
    }
}
public class ExpressionTest {
    public static void main(String[] args){

        Numeral num1 = new Numeral(10);
        Numeral num2 = new Numeral(1);
        Numeral num3 = new Numeral(2);
        Numeral num4 = new Numeral(3);
        //biểu thức 1
        Square sq2 = new Square(num1);                          //bình phương của 10
        Multiplication mul = new Multiplication(num3,num4);     //tích của 2 và 3
        Subtraction sub =new Subtraction(sq2,num2);             //hiệu của (10^2) và 1
        Addition add = new Addition(sub,mul);                   //tổng cua (10^2-1) va (2*3)
        Square sq1 = new Square(add);                           //binh phuong bieu thuc
        System.out.println("(10*10 - 1 + 2*3)^2 = " + (10*10 - 1 + 2*3)*(10*10 - 1 + 2*3));
        System.out.println("(10*10 - 1 + 2*3)^2 = " + sq1.evaluate());

        Numeral num5 = new Numeral(5);
        Numeral num6 = new Numeral(0);
        //biểu thức 2
        Division dic = new Division(num5,num6);                 //tích của 5 và 0

        try {
            System.out.println(dic.toString() + " = " + dic.evaluate());
        } catch (ArithmeticException e) {       //
            System.out.println(e.getMessage());
        }
    }
}
