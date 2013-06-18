package cl.ufro.infocleta.core.imp.linked;

public class Nodo<T extends Comparable<T>> {
    private T value;
    protected Nodo<T> prev;
    protected Nodo<T> next;
    
    public Nodo (T value){
	this.value = value;
    }
    
    public T getValue(){
	return value;
    }
    
    public String toString(){
	return ""+value;
    }

    /**
     * @return the prev
     */
    public  Nodo<T> getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public final void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public final Nodo<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public final void setNext(Nodo<T> next) {
        this.next = next;
    }
    
}
