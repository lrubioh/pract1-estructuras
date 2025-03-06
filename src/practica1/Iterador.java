package practica1;

import java.util.Iterator;

public class Iterador<T> implements IIterador<T> {
    ListaBasica<T> milista;
    private int indice=0;

    Iterador(ListaBasica<T> milista) {
        this.milista = milista;
    }

    @Override
    public boolean hasNext() {
        while(indice < milista.getNumElementos()){
            if (milista.elementos[indice]!= null){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public T next() {
        T elemento = null;
        if (!hasNext()) {
            elemento= milista.elementos[indice];
            indice++;
        }
        return elemento;

    }

    @Override
    public void delete() {
        this.milista.delete(milista.elementos[indice]);
    }
}
