class PilaEstatica { //f

    private int[] pila;
    private static int tope;


    public PilaEstatica(int max) {
        pila = new int[max];
        tope = -1;
    }

    public synchronized void push(String nombreHilo, int num) {
        while (tope == pila.length -1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tope++;
        pila[tope] = num;
        System.out.println("El hilo " + nombreHilo + " genero " + num);
        listar();
        notifyAll();
    }

    public synchronized int pop(String nombre) {
        while (tope == -1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int aux = pila[tope];
        System.out.println("El consumidor " + nombre + " consumio el dato: " + pila[tope]);
        tope--;
        listar();
        notifyAll();
        return aux;
    }

    public void listar() {
        int i;
        for (i = 0; i <= tope; i++)
            System.out.print("[" + i + "]=" + pila[i] + "  ");
        System.out.println();
    }
}