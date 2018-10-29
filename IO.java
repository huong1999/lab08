package Bai2;

import java.io.FileWriter;
import java.io.IOException;

public class IO {
    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter("data.txt");
        fw.write("Xu ly ngoai le trong java");
        fw.close();
    }

    public static void main(String args[]) {
        try {
            IO io = new IO();
            io.writeFile();
        } catch (IOException ioe) {
            System.out.println("Co loi ghi file: "+ ioe);
        }
    }
}