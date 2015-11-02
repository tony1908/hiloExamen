public class Main {
    public static void main(String[] args) {

        //Creamos una cola
        ColaCircular colaCircular = new ColaCircular(15);

        //Creamos a los productoes (deben de ser 4)
        Productor productorUno = new Productor("P1", colaCircular);

        //Creamos a los dos camiones (seran 2)
        Camiones camionUno = new Camiones("C1", colaCircular);
        Camiones camionDos = new Camiones("C2", colaCircular);

        productorUno.start();

        camionUno.start();
        camionDos.start();

    }
}
