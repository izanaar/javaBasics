package classes;

public class A{
    public static void main(String[] args) {
        //X.Y val = new X.Y();
    }
}


class X {
    public int pbXVal;
    private int prXVal;


    Y inner;

    void meth(){
        inner = new Y();

    }

    class Y{
        private int prYVal;
        public int pbYVal;

        void meth(){

        }

    }
}
