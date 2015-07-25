package ch20;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MyBufferedInputStream {
    public static void main(String[] args) {
        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream("/home/work/java/IOTest/respond"))){
//            viewAvailableBytes(is);
            byte[] bytes = new byte[is.available()];
            is.mark(is.available()+1);
            is.read(bytes);
//            p("File contains: ");
//            viewArray(bytes, ByteArrayViewType.AS_TEXT);
//            viewAvailableBytes(is);
//            p("Performing reset...");
//            is.reset();
//            viewAvailableBytes(is);
//            p("Reading stream by sentences:");
            readStreamBySentences(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readStreamBySentences(BufferedInputStream is) throws IOException {
        int count = 1, letters = 1, val;
        byte[] bytes;
        is.mark(is.available()+1);
        while ((val = is.read()) != -1){
            if((char)val == '.'){
                is.reset();
                bytes = new byte[letters];
                is.read(bytes);
//                p("Sentence " + count + ": ");
//                viewArray(bytes, ByteArrayViewType.AS_TEXT_IGNORE_N);
                count++; letters = 1;
                is.mark(is.available()+1);
            }else
                if(val != -1){
                    letters++;
                }else
                    return;

        }

    }
}
