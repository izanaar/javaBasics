package ch20;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class CrtTrashFls {
    public static void main(String[] args) throws IOException {
        File coreFile = new File("/home/work/java/IOTest");
        if(!createTrashDirs(2,3, coreFile))
            System.out.println("Directories weren't created.");
    }

    private static boolean createTrashDirs(int subLvls, int num, File coreFile) throws IOException {
        for(int i = 0; i < num;i++){
            if(subLvls == 0){
                Path newFile = Paths.get(coreFile.getAbsolutePath() + "/trashFile" + String.valueOf(i));
                Files.createFile(newFile);
                PrintStream ps = new PrintStream(Files.newOutputStream(newFile, StandardOpenOption.CREATE));
                ps.println("Trash file " + newFile.getFileName());
                ps.print(new Date());
                if(i == num-1){
                    Path unv = Paths.get(coreFile.getAbsolutePath()+"/unviewable trash dir"),
                            view = Paths.get(coreFile.getAbsolutePath() + "/viewable trash dir");
                    Files.createDirectories(unv);
                    Files.createDirectory(view);
                }
                continue;
            }else {
                File newFile = new File(coreFile.getAbsolutePath() + "/subDir" + (i + 1) + "l" + subLvls);
                boolean isCreated = newFile.mkdirs();
                if (!isCreated) return false;
                else if (subLvls > 2)
                    System.out.println(newFile.getName() + " created.");
                createTrashDirs(subLvls - 1, num, newFile);
            }
        }
        return true;
    }
}
