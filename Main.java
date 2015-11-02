public class Main {
    public static void main(String[] args) {

        int capCamiones;
        int productosDia;
        int tamanoCola;
        capCamiones = (Teclado.entero("Capacidad de cada camion: ") * 2);

        do {
            productosDia = Teclado.entero("Productos por dia: ");
        }while (!(productosDia >= capCamiones));

        tamanoCola = Teclado.entero("Tamanio de la cola: ");


        ColaCircular colaCircular = new ColaCircular(tamanoCola, productosDia, capCamiones);


        Productor productorUno = new Productor("A", colaCircular);
        Productor productorDos = new Productor("B", colaCircular);
        Productor productorTres = new Productor("C", colaCircular);
        Productor productorCuatro = new Productor("D", colaCircular);


        Camiones camionUno = new Camiones("C1", colaCircular);
        Camiones camionDos = new Camiones("C2", colaCircular);

        productorUno.start();
        productorDos.start();
        productorTres.start();
        productorCuatro.start();

        camionUno.start();
        camionDos.start();
    }
}
