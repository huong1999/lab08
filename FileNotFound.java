package Bai2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFound {
    public void readFile(String link) throws FileNotFoundException{
        File file = new File(link);
        Scanner sc = new Scanner(file);
        while(sc.hasNext())     //dừng khi đã đọc hết dữ liệu từ file
            System.out.println(sc.nextLine());
        sc.close();             //ngừng nhập
    }
    public static void main(String[] args){
        try {
            FileNotFound file = new FileNotFound();
            file.readFile("abc.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
