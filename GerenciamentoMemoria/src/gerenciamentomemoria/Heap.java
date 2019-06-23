package gerenciamentomemoria;

import java.util.Random;

public class Heap {

    private Integer tamanho; //em bytes
    private Integer alocado = 0;
    private Bloco[] vetor;
    private Integer tamanhoBloco;
    private Requisicao maior; //guarda a requisicao do maior bloco alocado contiguamente

    public Heap(Integer tamanho, Integer tamanhoPagina) {
        this.tamanho = tamanho;
        this.tamanhoBloco = tamanhoPagina;
        Integer tamanhoVetor = tamanho / tamanhoPagina;
        this.vetor = new Bloco[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            Bloco p = new Bloco(0, 0);
            this.vetor[i] = p;
        }
        this.maior = new Requisicao(0,0);
    }

    public Requisicao getMaior() {
        return maior;
    }

    public void setMaior(Requisicao maior) {
        this.maior = maior;
    }

    public Integer getTamanhoBloco() {
        return tamanhoBloco;
    }

    public void setTamanhoBloco(Integer tamanhoBloco) {
        this.tamanhoBloco = tamanhoBloco;
    }

    public Integer getAlocado() {
        return alocado * tamanhoBloco;
    }

    public void setAlocado(Integer alocado) {
        this.alocado = alocado / tamanhoBloco;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanhoHeap) {
        this.tamanho = tamanhoHeap;
    }

    public Bloco[] getVetor() {
        return vetor;
    }

    public void alocarVariavel(VetorRequisicoes requisicoes) {
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();
        this.setAlocado(this.getAlocado() + (tamanhoVariavel * tamanhoBloco));
        Integer instante = gerarInstante();

        if (requisicao.getTamVariavel() > this.maior.getTamVariavel()) {
            this.setMaior(requisicao);
        }

        //algoritmo de alocação
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getId() == 0 && tamanhoVariavel > 0) {
                Bloco alocar = new Bloco(requisicao.getId(), instante);
                vetor[i] = alocar;
                tamanhoVariavel--;
            }
        }

    }

    public void desalocarVariavel(Integer algoritmo) {
        Integer aloc = this.getAlocado() / this.getTamanhoBloco();
        Bloco vazia = new Bloco(0, 0);
        if (algoritmo == 0) {
            //algoritmo de desalocação LRU
            for (int i = 0; i < (vetor.length); i++) {
                if (vetor[i].getInstante() == 0) {
                    vetor[i] = vazia;
                    aloc--;
                }
            }
        } else {
            //algoritmo de desalocação maior bloco
            for (int i = 0; i < (vetor.length); i++) {
                if (vetor[i].getId() == this.maior.getId()) {
                    vetor[i] = vazia;
                    aloc--;
                }
            }
        }
        Requisicao r = new Requisicao(0, 0);
        this.setMaior(r);
        this.setAlocado(aloc * this.getTamanhoBloco());
    }

    //random.nextInt((max - min) + 1) + min;      
    public Integer gerarInstante() {
        Random random = new Random();
        //gera 0 ou 1
        Integer i = random.nextInt(2);
        return i;
    }
}
