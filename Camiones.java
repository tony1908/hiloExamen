public class Camiones extends Thread {

    /*Los camiones son los que van a borrar los datos de la pila*/

    ColaCircular colaCircular, colaCircular2;
    String nombre;

    public Camiones(String nombre, ColaCircular colaCircular, ColaCircular colaCircular2 ) {
        this.colaCircular = colaCircular;
        this.colaCircular2 = colaCircular2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        super.run();
        int a;
        while (true) {
            // if (colaCircular.validaVacio() != true) {
                a = colaCircular.borrar(nombre);
                colaCircular2.insertar(nombre, a);
            // }
        }
    }

}
