package ch21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIODemo6 {
    public static void main(String[] args) {
        try(FileChannel fc = (FileChannel) Files.newByteChannel(Paths.get("/home/work/java/IOTest/nio6"),
                StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.READ)){

            String str = "The Tempest Keep was merely a setback.";



            MappedByteBuffer mBuf = fc.map(FileChannel.MapMode.READ_WRITE,0,str.length());

            for(char c : str.toCharArray())
                mBuf.put((byte)c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
