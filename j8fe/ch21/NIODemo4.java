package ch21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIODemo4 {
    public static void main(String[] args) {
        try(FileChannel fch =
                    (FileChannel) Files.newByteChannel(Paths.get("/home/work/java/IOTest/nio5"))){
            MappedByteBuffer mBuf = fch.map(FileChannel.MapMode.READ_ONLY,0,fch.size());

            for(int i = 0; i < fch.size(); i++)
                System.out.print((char) mBuf.get());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
