import java.util.List;

public class Operation implements Runnable {


    public void run() {


        int index;

        while ((index = Main.getIndex()) < Main.llista.size()) {
            operationToList(index);
        }


    }

    private void operationToList(int index) {
      /*  try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        Integer item = Main.llista.get(index);
        System.out.println(Thread.currentThread().getName() + " -Valor inicial:" + item);

        item = item * item;

        System.out.println(Thread.currentThread().getName() + "-Valor final:" + item);
        Main.llista.set(index, item);


    }

}
