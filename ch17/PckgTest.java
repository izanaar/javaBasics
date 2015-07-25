package ch17;

public class PckgTest {
    public static void main(String[] args) {
        Package pckgs[];
        pckgs = Package.getPackages();
        for (Package pckg : pckgs) {
            System.out.println(
                    pckg.getName() + " " +
                            pckg.getImplementationTitle() + " " +
                            pckg.getImplementationVendor() + " " +
                            pckg.getImplementationVersion()
            );
        }
    }
}
