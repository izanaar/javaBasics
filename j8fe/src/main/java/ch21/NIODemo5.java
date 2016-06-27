package ch21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//using ByteBuffer to write file via NIO
public class NIODemo5 {
    public static void main(String[] args) {
        try(SeekableByteChannel sbc =
                    Files.newByteChannel(Paths.get("/home/work/java/IOTest/nio5"),
                            StandardOpenOption.CREATE,StandardOpenOption.WRITE)){
            ByteBuffer wBuf = ByteBuffer.allocate(128);

            String str = "The Tempest Keep was merely a setback.";

            for( char c : str.toCharArray())
                wBuf.put((byte) c);
            wBuf.rewind();
            sbc.write(wBuf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
