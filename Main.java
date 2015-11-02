public class Main {
    public static void main(String[] args) {

        //Creamos una cola
        ColaCircular colaCircular = new ColaCircular(10);

        //Creamos a los productoes (deben de ser 4)
        Productor productorUno = new Productor("A", colaCircular);
        Productor productorDos = new Productor("B", colaCircular);
        Productor productorTres = new Productor("C", colaCircular);
        Productor productorCuatro = new Productor("D", colaCircular);

        //Creamos a los dos camiones (seran 2)
        Camiones camionUno = new Camiones("Camion1", colaCircular);
        Camiones camionDos = new Camiones("Camion2", colaCircular);

        productorUno.start();
        productorDos.start();
        productorTres.start();
        productorCuatro.start();

        camionUno.start();
        camionDos.start();
    }
}
