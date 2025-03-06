package practica1;

public class ListaBasica<T> implements Lista<T>  {
    /// declaro los atributos de mi clase
    private int maxElementos=10;
    private int numElementos =0;
    protected T[] elementos;



    //inicializo la ListaBasica
    public ListaBasica() {
        this.elementos = (T[]) new Object[this.maxElementos];
    }

    //implemento los metodos de la interfaz Lista<T>
    @Override
    public boolean add(T elemento) {
        //si la lista esta completa sumo uno al max elementos, añado el elemento y sumo 1 al num elementos
        if(numElementos == maxElementos) {
            maxElementos=maxElementos + 1;
            elementos[numElementos+1] = elemento;
            numElementos= numElementos + 1;
            return true;
        }
        //si no lo esta lo añado y sumo 1 al numElementos
        elementos[numElementos+1] = elemento;
        numElementos= numElementos + 1;
        return true;

    }

    @Override
    public boolean delete(T elemento) {
        //voy recorriendo cada una de las posiciones del array
        for (int i = 0; i < numElementos; i++) {
            //si elemento[i] es igual al elemento que busco le borro
            if (elementos[i].equals(elemento)) {
                elementos[i] = null;
                numElementos = numElementos - 1;
                //puedo dejar ahi el hueco o mover todos una posicion menos
                //para dejarlos seguidos
                //recorro la lista para restarle uno a cada pos
                for (int j = i + 1; j < numElementos; j++) {
                    elementos[j] = elementos[j - 1];
                }
                return true;
            }
        }
        //Si no encuentro el elemento devuelvo false
        return false;
    }

    @Override
    public IIterador<T> getIterador() {
        return new Iterador(this);
    }
    @Override
    public int getNumElementos() {
        return numElementos;
    }




}
