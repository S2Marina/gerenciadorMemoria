package gerenciamentomemoria;


public class Alocar extends Thread{
    private VetorRequisicoes requisicoes;
    private Heap h;

    public Alocar(Heap heap, VetorRequisicoes requisicoes) {
        this.h = heap;
        this.requisicoes = requisicoes;
    }
    
    public void run() {
        h.alocarVariavel(requisicoes);
        //h.imprimir();
    }
}
