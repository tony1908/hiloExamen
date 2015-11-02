import java.util.Random;

public class Productor extends Thread {

    /*Los productores ponen los datos que quitaran los camioes*/

    ColaCircular colaCircular;
    String name;
    Random rnd = new Random();

    public Productor(String name, ColaCircular colaCircular) {
        this.colaCircular = colaCircular;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                int tiempoDormido = (int)(Math.random()*(2000-5000) + 5000);
                sleep(tiempoDormido);
                System.out.println("La linea " + name + " durmio: " + tiempoDormido + " ms");
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            colaCircular.insertar(name ,(int)(Math.random()*10));
        }
    }
}
