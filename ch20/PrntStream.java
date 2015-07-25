package ch20;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrntStream {
    public static void main(String[] args) {
        try(FileOutputStream ps = new FileOutputStream("/home/work/java/IOTest/is1")){
            String str = "The Tempest Keep was merely a setback.";

            ps.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
