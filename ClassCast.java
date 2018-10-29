package Bai2;

public class ClassCast {
    public int Number(Object s) throws ClassCastException{
        return (int)s;
    }
    public static void main(String[] args){
        try {
            System.out.println(new ClassCast().Number("String"));
        } catch (ClassCastException e) {        //không thể chuyển kiểu object này sang kiểu object khác
            System.out.println(e);
        }
    }
}
