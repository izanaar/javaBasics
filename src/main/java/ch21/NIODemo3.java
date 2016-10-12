package ch21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIODemo3 {
    public static void main(String[] args) {
        try(SeekableByteChannel fch = Files.newByteChannel(Paths.get("/home/work/java/IOTest/nio5"))){
            System.out.println("File channel's size: " + fch.size());
            byte[] buffArr = new byte[16];
            ByteBuffer buff = ByteBuffer.wrap(buffArr);
            int count, readIt = 0;
            do{
                count = fch.read(buff);
                readIt++;
                if(count != -1){
                    buff.rewind();
                    System.out.print(new String(buffArr));
                }
            }while (count != -1);
            System.out.println("Reading iterations amount: " + readIt);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
