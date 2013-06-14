package cl.ufro.proyecto.core.imp.linked;

public class Nodo {
    private int value;
    protected Nodo prev;
    protected Nodo next;
    
    public Nodo (int value){
	this.value = value;
    }
    
    public int getValue(){
	return value;
    }
    
    public String toString(){
	return ""+value;
    }

    /**
     * @return the prev
     */
    public final Nodo getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public final void setPrev(Nodo prev) {
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public final Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public final void setNext(Nodo next) {
        this.next = next;
    }
    
}
