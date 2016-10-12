package ch20;

import auxillary.Dosieu;

import java.io.*;

public class MySerializeToArray {
    public static void main(String[] args) {
        byte[] array;
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream ous = new ObjectOutputStream(bos)){
            Dosieu wWhite = new Dosieu("Walter White","He's always goddamn right");
            System.out.println("Source object: " + wWhite);

            ous.writeObject(wWhite);
            array = bos.toByteArray();

            deserializeFromByteArray(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deserializeFromByteArray(byte[] array){
        try(ObjectInputStream ois  = new ObjectInputStream(new ByteArrayInputStream(array))){
            System.out.println("Deserialized object: " + (Dosieu)ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

