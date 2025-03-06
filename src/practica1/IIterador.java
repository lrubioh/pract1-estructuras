package practica1;

public interface IIterador<T>  {
    boolean hasNext();
    T next();
    void delete();
}
