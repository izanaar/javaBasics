package ch20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static auxillary.CollectionsViewer.viewArray;

/**
 * Created by ierus on 7/19/15.
 */
public class FilePrintStream {
    public static void main(String[] args) {
        try(PrintStream fps = new PrintStream(System.out, false);
            FileReader fileReader = new FileReader("/home/work/java/IOTest/printstream")){

            fps.print("First line");
            char[] chars = new char[50];
            fileReader.read(chars);
            viewArray(chars);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
