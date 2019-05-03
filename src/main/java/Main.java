import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX_SIZE = 30000000;
    private static final int MAX_THREADS = 24;
    public static List<Integer> llista = new ArrayList<Integer>();
    private final static double MAX_NUM  = 3809128309d;

    public static Integer index = 0;

    public static synchronized Integer getIndex(){
        int indice = index;
        index++;
        return indice;
    }

    private static void init(){

        for (int i=0; i < MAX_SIZE; i++){
            //
            llista.add(2);
        }

    }



    public static void main(String[] args) throws InterruptedException {

        init();


        long time = System.currentTimeMillis();


       List<Thread> threads = new ArrayList<Thread>();

       for (int i = 0; i < MAX_THREADS; i++){
           Thread thread = new Thread(new Operation());
           thread.start();
           threads.add(thread);
       }

        for (int i = 0; i < MAX_THREADS; i++){
            threads.get(i).join();
        }


        for (Integer value : llista){
            if (value!=4){
                System.out.println(value);
            }
        }

        System.out.println("Temps total: " + (System.currentTimeMillis() - time) );



    }

}
