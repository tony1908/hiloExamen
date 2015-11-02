public class Productor extends Thread {

    /*Los productores ponen los datos que quitaran los camioes*/

    ColaCircular colaCircular;
    String name;

    public Productor(String name, ColaCircular colaCircular) {
        this.colaCircular = colaCircular;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                sleep((int)(Math.random()*5000));
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            colaCircular.insertar(name ,(int)(Math.random()*10));
        }
    }
}
