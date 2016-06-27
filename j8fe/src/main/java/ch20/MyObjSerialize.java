package ch20;

import auxillary.Dosieu;

import java.io.*;

public class MyObjSerialize {
    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/work/java/IOTest/ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/work/java/IOTest/ser"))){

            Dosieu wWhite = new Dosieu("Walter White","He's always goddamn right");
            System.out.println("Source object: " + wWhite);

            String address = "308 Negra Arroyo Lane, Albuquerque, New Mexico, 87104";
            byte[] adressBytes = address.getBytes();

            oos.write(adressBytes);
            oos.writeObject(wWhite);

            wWhite = null;
            adressBytes = new byte[adressBytes.length];
            System.out.println("Object variable contains: " + wWhite);
            
            ois.read(adressBytes);
            System.out.println("Deserialized address: " + new String(adressBytes));

            wWhite = (Dosieu) ois.readObject();
            System.out.println("Deserialized object: " + wWhite);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
