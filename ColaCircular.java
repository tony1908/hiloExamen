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

    public void insertar(String name, int num) {
        if (H == -1)
            H = 0;
        else if (T == cola.length - 1)
            T = -1;
        T++;
        cola[T] = num;
    }

    public int borrar(String nombre) {
        int aux = cola[H];
        if (H == T)
            H = T = -1;
        else if (H == cola.length - 1)
            H = 0;
        else
            H++;
        return aux;
    }

    public void listar() {
        int i;
        if (H <= T)
            for (i = H; i <= T; i++)
                System.out.println(cola[i]);
        else {
            for (i = H; i < cola.length; i++)
                System.out.println(cola[i]);
            for (i = 0; i <= T; i++)
                System.out.println(cola[i]);
        }

    }
}

