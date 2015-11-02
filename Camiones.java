public class Camiones extends Thread {

    /*Los camiones son los que van a borrar los datos de la pila*/

    ColaCircular colaCircular;
    String nombre;

    public Camiones(String nombre, ColaCircular colaCircular) {
        this.colaCircular = colaCircular;
        this.nombre = nombre;
    }




    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            colaCircular.borrar(nombre);
        }
    }

}
