package ch20;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class PropertiesViewer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file;
        System.out.print("Type file/dir absolute path: ");
        while (sc.hasNext()){
            String command = sc.nextLine();
            if(command.equals("exit")) {
                System.out.println("Bye!");
                return;
            }else
                file = new File(command);
                if(!file.exists()){
                    System.out.println("File does not exists.");
                    continue;
                }else
                    viewFileProperties(file);
            System.out.print("Type file/dir absolute path: ");
        }
    }

    private static void viewFileProperties(File file) {
        System.out.println(file.isDirectory() ? "Directory's" : "File's" + " properties:");
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Date modified: " + new Date(file.lastModified()));
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println();
    }
}
