package gerenciamentomemoria;

public class Desalocar extends Thread {
    private VetorRequisicoes requisicoes;
    private Heap h;

    public Desalocar(Heap heap, VetorRequisicoes requisicoes) {
        this.h = heap;
        this.requisicoes = requisicoes;
    }

    public void run() {
        h.alocarVariavel(requisicoes);
    }
}
