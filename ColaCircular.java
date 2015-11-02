import java.util.Random;

public class ColaCircular {

    /*Esta cola se comparte entra productores y camiones*/
    int[] cola;
    int H, T;
    int maxProductos;
    static int count = 1;
    static int capCamiones;
    static int capMaxCamiones;

    public ColaCircular(int max, int maxProductos, int capCamiones) {
        this.maxProductos = maxProductos;
        this.capCamiones =capCamiones;
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
        if(count <= maxProductos) {
            while (!validaEspacio()) {
                try {
                    System.out.println("Las lineas de produccion duermen, cola llena");
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
            System.out.println("La linea " + nombre + " termino el producto: " + num);
            count++;
            System.out.println("CONTADOR " +count);
            System.out.println("MAXIMO " +maxProductos);
            listar();
        }else{
            try {
                System.out.println("La linea " + nombre + " acabo su produccion");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //}while (count <= maxProductos);

    }

    public synchronized int borrar(String nombre) {
        if(capMaxCamiones != capCamiones) {
            while (validaVacio()) {
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
            System.out.println("El conductor " + nombre + " tomo el producto: " + aux);
            capMaxCamiones++;
            System.out.println("LO QUE LLEVAN LOS CAMIONES: " + capMaxCamiones);
            System.out.println("LO QUE PUEDEN LLEVAR: " + capCamiones);
            if (!validaVacio())
                listar();
            return aux;
        }else{
            try {
                wait();
                System.out.println("Los camiones se han llenado");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void listar() {
        int i;
        if (H <= T) {
            for (i = H; i <= T; i++)
                System.out.print(cola[i] + ", ");
            System.out.print("\n");

        } else {
            for (i = H; i < cola.length; i++) {
                System.out.print(cola[i] + ", ");
            }
            for (i = 0; i <= T; i++) {
                System.out.print(cola[i] + ", ");
            }
            System.out.print("\n");
        }

    }
}

