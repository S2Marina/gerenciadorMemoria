package gerenciamentomemoria;

public class NovaRequisicao extends Thread{
    private VetorRequisicoes requisicoes;

    public NovaRequisicao(VetorRequisicoes requisicoes) {
        this.requisicoes = requisicoes;
    }
    
    public void run() {
        requisicoes.inserir();
    }
}
