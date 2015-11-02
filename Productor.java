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
            colaCircular.insertar(name ,(int)(Math.random()*10));
        }
    }
}
