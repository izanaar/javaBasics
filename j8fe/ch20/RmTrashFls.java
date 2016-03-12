package ch20;

import java.io.File;
import java.io.IOException;

public class RmTrashFls {
    public static void main(String[] args) {
        String path = "/home/work/java/IOTest";
        System.out.print("Accept clearing this directory '" + path + " ? ");
        byte[] command = new byte[2];
        try {
            System.in.read(command);
            if (!((command[0] == 111 && command[1] == 107) || (command[0] == 79 && command[1] == 75)))
                throw new IOException("Invalid command;");
        } catch (IOException e) {
            System.out.println("Operation aborted.");
            return;
        }
        System.out.println(eraseDirectory(new File(path),false));
    }


    private static boolean eraseDirectory(File file, boolean removeCurrent) {
        if(!file.isDirectory())
            return file.delete();
        File[] files = file.listFiles();
        if (file.isDirectory() || files.length != 0) {
            for (File innerFile : files)
                if (!eraseDirectory(innerFile, true))
                   return false;
        }
        if (removeCurrent)
            return file.delete();
        else return true;
    }
}
