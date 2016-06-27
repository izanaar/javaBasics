package ch20;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class MyPushbackInputStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3,4,5};
        int c;
        try(PushbackInputStream f = new PushbackInputStream(new ByteArrayInputStream(bytes))){
            while ((c = f.read()) != -1){
                if(c == 2){
                    //System.out.println(c);
                    f.unread(3);
                }
                else
                    System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
