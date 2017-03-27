package ch28.synchronizers;

import java.util.concurrent.Exchanger;

public class MyExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new StringConsumer(exchanger);
        new StringManufacturer(exchanger);
    }

}
class StringConsumer{
    public StringConsumer(Exchanger<String> exc) {
        new Thread(()->{
            try {
                System.out.println(exc.exchange(new String()));
                System.out.println(exc.exchange(new String()));
                System.out.println(exc.exchange(new String()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class StringManufacturer{
    public StringManufacturer(Exchanger<String> exc) {
        new Thread(()->{
            char q = 'A';
            String txt = "";
            for(int i = 0; i <3;i++){
                for(int j = 0; j<5;j++){
                    txt+=q;
                    q++;
                }
                try {
                    exc.exchange(txt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                txt = "";
            }
        }).start();
    }
}