public class Main {
    public static void main(String[] args) {

        //Productos por dia
        //int productosDia = 20;
        int productosDia;
        productosDia = Teclado.entero("Productos por dia: ");

        //Tamaño de la cola
        //int tamañoCola = 10;
        int tamañoCola;
        tamañoCola = Teclado.entero("Tamaño de la cola: ");

        //Capacidad camiones
        //int capCamiones = 30;
        int capCamiones;
        capCamiones = Teclado.entero("Capacidad de cada camion: ");

        //Creamos una cola
        ColaCircular colaCircular = new ColaCircular(tamañoCola);

        //Creamos a los productoes (deben de ser 4)
        Productor productorUno = new Productor("A", colaCircular);
        Productor productorDos = new Productor("B", colaCircular);
        Productor productorTres = new Productor("C", colaCircular);
        Productor productorCuatro = new Productor("D", colaCircular);

        //Creamos a los dos camiones (seran 2)
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
