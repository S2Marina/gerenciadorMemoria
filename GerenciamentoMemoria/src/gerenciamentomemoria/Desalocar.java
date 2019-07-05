package gerenciamentomemoria;

public class Desalocar extends Thread {
    private Heap h;

    public Desalocar(Heap heap) {
        this.h = heap;
    }

    public void run() {
        h.desalocarVariavel();
        //h.imprimir();
    }
}
