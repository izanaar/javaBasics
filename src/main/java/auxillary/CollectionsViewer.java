package auxillary;

public class CollectionsViewer {
    public static String testDirPath = "/home/work/java/IOTest";
    public static void viewArray(String[] array){
        for(String val : array)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void viewArray(char[] chars) {
        for(char ch : chars)
            System.out.print(ch + " ");
        System.out.println();
    }
}
