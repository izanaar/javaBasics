package j8se.ch2.auxiliary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.stream.Stream;

public class Recoder {
    public static void tryRecode(Path file) throws IOException {

        if (!Files.isRegularFile(file)) {
            throw new IOException("File " + file.toString() + " is not regular file.");
        } else {
            File tmpFile = recode(file);
            cleanup(file, tmpFile);
        }

    }

    private static File recode(Path file) throws IOException {

        File tempFile = File.createTempFile(file.toString(), ".tmp");

        try (Stream<String> lines = Files.lines(file, Charset.forName("CP1251"));
             PrintWriter out = new PrintWriter(tempFile)) {
            lines.forEach(out::println);
        }
        return tempFile;
    }

    private static void cleanup(Path file, File tmpFile) throws IOException {
        Files.delete(file);
        Files.move(tmpFile.toPath(), file, StandardCopyOption.ATOMIC_MOVE);
    }

}
