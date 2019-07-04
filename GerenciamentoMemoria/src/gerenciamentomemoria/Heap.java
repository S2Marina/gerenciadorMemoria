package gerenciamentomemoria;

import java.util.Random;

public class Heap {

    private Integer tamanho; //em bytes
    private Integer alocado = 0; //guarda a quantidade de blocos ocupados
    private Bloco[] vetor;
    private Integer tamanhoBloco;
    private Integer cont;

    public Heap(Integer tamanho, Integer tamanhoPagina) {
        this.tamanho = tamanho;
        this.tamanhoBloco = tamanhoPagina;
        Integer tamanhoVetor = tamanho / tamanhoPagina;
        this.vetor = new Bloco[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            Bloco p = new Bloco(0, 0);
            this.vetor[i] = p;
        }
        this.cont = 0;
    }

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
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

    public synchronized void alocarVariavel(VetorRequisicoes requisicoes) {
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();

        if (tamanhoVariavel > (this.getTamanho() - this.getAlocado())) {
            this.desalocarVariavel();
        }

        //altera a variavel alocado
        this.setAlocado(this.getAlocado() + (tamanhoVariavel * tamanhoBloco));
        Integer instante = gerarInstante();

        //algoritmo de alocação
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getId() == 0 && tamanhoVariavel > 0) {
                Bloco alocar = new Bloco(requisicao.getId(), instante);
                vetor[i] = alocar;
                tamanhoVariavel--;
            }
        }

    }

    public synchronized void desalocarVariavel() {
        Integer aloc = this.getAlocado() / this.getTamanhoBloco();
        Bloco vazia = new Bloco(0, 0);
        //algoritmo de desalocação LRU
        for (int i = 0; i < (vetor.length); i++) {
            if (vetor[i].getInstante() == 0) {
                vetor[i] = vazia;
                aloc--;
            }
        }

        this.setAlocado(aloc * this.getTamanhoBloco());

        //apos 3 desalocações zera todos os instantes
        if (this.getCont() >= 2) {
            System.out.println("ALTERA INSTANTE");
            for (int i = 0; i < (vetor.length); i++) {
                vetor[i].setInstante(0);
            }
            this.setCont(0);
        } else {
            this.setCont(this.getCont() + 1);
            System.out.println("cont: " + this.getCont());
        }

        this.imprimir();
    }

    //random.nextInt((max - min) + 1) + min;      
    public Integer gerarInstante() {
        Random random = new Random();
        //gera 0 ou 1
        Integer i = random.nextInt(2);
        return i;
    }

    public void imprimir() {
        System.out.println("DESALOCA");
        for (int j = 0; j < this.getVetor().length; j++) {
            System.out.println(this.getVetor()[j]);
        }
        System.out.println("-------------");
    }
}
