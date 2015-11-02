public class Camiones extends Thread {

    /*Los camiones son los que van a borrar los datos de la pila*/

    ColaCircular colaCircular;
    String nombre;

    public Camiones(String nombre, ColaCircular colaCircular ) {
        this.colaCircular = colaCircular;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        super.run();
        int a;
        while (true) {
            // if (colaCircular.validaVacio() != true) {
                a = colaCircular.borrar(nombre);
            // }
        }
    }

}
