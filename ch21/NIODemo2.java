package ch21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIODemo2 {
    public static void main(String[] args) {
        try(SeekableByteChannel channel = Files.newByteChannel(Paths.get("/home/work/java/IOTest/nio1"))){
            byte[] inArr = new byte[64];
            ByteBuffer buffer = ByteBuffer.wrap(inArr);

            int q = channel.read(buffer);

            for(int i = 0; i < q; i++){
                System.out.print((char) inArr[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
