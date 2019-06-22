package gerenciamentomemoria;

public class Configuracao {
    private Integer tamanhoHeap;
    private Integer limiarMaximoHeap;
    private Integer minRequisicao;
    private Integer maxRequisicao;
    private Integer tamanhoPagina;

    public Configuracao(Integer tamanhoHeap, Integer limiarMaximoHeap, Integer minRequisicao, Integer maxRequisicao, Integer tamanhoPagina) {
        this.tamanhoHeap = tamanhoHeap; //em bytes
        this.limiarMaximoHeap = limiarMaximoHeap; //em bytes
        this.minRequisicao = minRequisicao;
        this.maxRequisicao = maxRequisicao;
        this.tamanhoPagina = tamanhoPagina; //em bytes
    }

    public Integer getTamanhoHeap() {
        return tamanhoHeap;
    }

    public void setTamanhoHeap(Integer tamanhoHeap) {
        this.tamanhoHeap = tamanhoHeap;
    }

    public Integer getLimiarMaximoHeap() {
        return limiarMaximoHeap;
    }

    public void setLimiarMaximoHeap(Integer limiarMaximoHeap) {
        this.limiarMaximoHeap = limiarMaximoHeap;
    }

    public Integer getMinRequisicao() {
        return minRequisicao;
    }

    public void setMinRequisicao(Integer minRequisicao) {
        this.minRequisicao = minRequisicao;
    }

    public Integer getMaxRequisicao() {
        return maxRequisicao;
    }

    public void setMaxRequisicao(Integer maxRequisicao) {
        this.maxRequisicao = maxRequisicao;
    }

    public Integer getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(Integer tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }
    
}
