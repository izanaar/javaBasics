package ch17;

public class execMetod {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String programName = "gedit";
        try{
            p = r.exec(programName);
        }catch (Exception e){
            System.out.println("Executing "+ programName + " failed because of exception:\n" + e);
        }

        try {
            p.waitFor();
        } catch (InterruptedException e) {
            System.out.println("Waiting for process to end failed. Exception:\n" + e );
        }
        System.out.println(programName + "has been terminated.");
    }
}
