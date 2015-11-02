public class ColaCircular {

    /*Esta cola se comparte entra productores y camiones*/

    int[] cola;
    int H, T;

    public ColaCircular(int max) {
        cola = new int[max];
        H = T = -1;
    }

    public boolean validaVacio() {
        return (H == -1);//regresa un "true" si esta vacio
    }

    public boolean validaEspacio() {
        return !((H == 0 && T == cola.length - 1) || (T + 1 == H));//regresa un "true" si hay una casilla disponible
    }

    public synchronized void insertar(String nombre, int num) {
        while (!validaEspacio()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (H == -1)
            H = 0;
        else if (T == cola.length - 1)
            T = -1;
        T++;
        cola[T] = num;
        notifyAll();
        System.out.println("Se creo el producto: " + num + " por el hilo: " + nombre);
        listar();
    }

    public synchronized int borrar(String nombre) {
        while (validaVacio()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int aux = cola[H];
        if (H == T)
            H = T = -1;
        else if (H == cola.length - 1)
            H = 0;
        else
            H++;
        notifyAll();
        System.out.println("El camion " + nombre + " cargo el paquete: " + aux);
        if(!validaVacio())
            listar();
        return aux;
    }

    public void listar() {
        int i;
        if (H <= T){
            for (i = H; i <= T; i++)
                System.out.print(cola[i] + ", ");
            System.out.print("\n");

        }
        else {
            for (i = H; i < cola.length; i++) {
                System.out.print(cola[i] + ", ");
            }
            System.out.print("\n");
            for (i = 0; i <= T; i++) {
                System.out.print(cola[i] + ", ");
            }
            System.out.print("\n");
        }

    }
}

