package gerenciamentomemoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alunos
 */
public class Configuracao {
    private Integer tamanhoHeap;
    private Double limiarMaximoHeap;
    private Integer minRequisicao;
    private Integer maxRequisicao;

    public Configuracao(Integer tamanhoHeap, Double limiarMaximoHeap, Integer minRequisicao, Integer maxRequisicao) {
        this.tamanhoHeap = tamanhoHeap; //em kb
        this.limiarMaximoHeap = limiarMaximoHeap * 256; //recebe em kb passa para palavras
        this.minRequisicao = minRequisicao;
        this.maxRequisicao = maxRequisicao;
    }

    public Integer getTamanhoHeap() {
        return tamanhoHeap;
    }

    public void setTamanhoHeap(Integer tamanhoHeap) {
        this.tamanhoHeap = tamanhoHeap;
    }

    public Double getLimiarMaximoHeap() {
        return limiarMaximoHeap;
    }

    public void setLimiarMaximoHeap(Double limiarMaximoHeap) {
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
    
    
}
