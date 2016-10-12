package ch20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Formatter;

public class MyFile {
    public static void main(String[] args) {
        File coreFile = new File("/home/work/java/IOTest");
        if(!coreFile.exists()){
            System.out.println("File does not exists.");
            return;
        }
        System.out.println(coreFile.isDirectory() ? "directory" : "not a directory");
        System.out.println("Date modified: " + new Date(coreFile.lastModified()));

        viewDirContainment(coreFile);

        for(int i = 0; i<3; i++){
            String path,cont;
            path = coreFile.getAbsolutePath()+"/test txt fl#"+String.valueOf(i);
            cont = "test file #" + String.valueOf(i) + "\nin dir: " + path;
            createTextFile(path, cont);
        }

        viewDirContainment(coreFile);
        //createTrashFiles(2,3,coreFile.getAbsoluteFile());
    }

    public static void createTrashFiles(int sublevels, int num, File coreFile){
        for(int i = 0; i < num;i++){
            File newFile = new File(coreFile.getAbsolutePath()
                    + "/trashSubDir#"+String.valueOf(i));
            System.out.println("New file's abs path: " + newFile.getAbsolutePath());
            System.out.println(newFile.mkdirs());
        }
    }

    public static void createTextFile(String path, String containment){
        try(FileWriter fw = new FileWriter(path)){
            fw.write(containment);
        } catch (IOException e) {
            System.out.println("Could not create file by adress: \n" + path);
        }
    }

    public static void viewDirContainment(File file){
        System.out.println("Dir's " + file.getAbsolutePath() + " containment:");
        int maxLngth = 0;
        File[] fileList = file.listFiles();
        for(String entry : file.list())
            if(entry.length() > maxLngth)
                maxLngth = entry.length();
        maxLngth+=2;
        System.out.println("Max dir's name lngth: " + maxLngth);
        try(Formatter fmt = new Formatter(System.out)){
            int currLngth;
            String name,prop;
            for(File entry : fileList){
                currLngth = maxLngth - entry.getName().length();
                name = entry.getName();
                prop = entry.isDirectory() ? "dir" : "file";
                fmt.format("%s %"+currLngth+"s%n", name, prop);
                currLngth = fmt.toString().length();
                fmt.flush();
            }
            System.out.println();
        }
    }
}
