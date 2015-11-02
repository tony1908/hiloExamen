public class Main {
    public static void main(String[] args) {

        //Creamos una cola
        ColaCircular colaCircular = new ColaCircular(15);
        ColaCircular colaCircular2 = new ColaCircular(15);
        ColaCircular colaCircular3 = new ColaCircular(15);

        //Creamos a los productoes (deben de ser 4)
        Productor productorUno = new Productor("A", colaCircular);
        Productor productorDos = new Productor("B", colaCircular);
        Productor productorTres = new Productor("C", colaCircular);
        Productor productorCuatro = new Productor("D", colaCircular);

        //Creamos a los dos camiones (seran 2)
        Camiones camionUno = new Camiones("C1", colaCircular, colaCircular2);
        Camiones camionDos = new Camiones("C2", colaCircular, colaCircular3);

        productorUno.start();
        productorDos.start();
        productorTres.start();
        productorCuatro.start();

        camionUno.start();
        camionDos.start();

    }
}
