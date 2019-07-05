package gerenciamentomemoria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void alocarVariavel(VetorRequisicoes requisicoes) {
        //colocar no run para trancar só a seção critica
        //trancar só onde eu for mexer
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();

//        if (tamanhoVariavel > (this.getTamanho() - this.getAlocado())) {
//            this.desalocarVariavel();
//        }

        //altera a variavel alocado
        this.setAlocado(this.getAlocado() + (tamanhoVariavel * tamanhoBloco));
        Integer instante = gerarInstante();

        //algoritmo de alocação
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getId() == 0 && tamanhoVariavel > 0) {
                Bloco alocar = new Bloco(requisicao.getId(), instante);
                try {
                   // System.out.println(requisicao.getId() + " acquire pra posição: " + i);
                    vetor[i].getSemaforo().acquire();
                    vetor[i] = alocar;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Heap.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    vetor[i].getSemaforo().release();
                }
                tamanhoVariavel--;
            }
        }
        System.out.println("alocar id: " + requisicao.getId());

    }

    public void desalocarVariavel() {
        Integer aloc = this.getAlocado() / this.getTamanhoBloco();
        Bloco vazia = new Bloco(0, 0);
        //algoritmo de desalocação LRU
        for (int i = 0; i < (vetor.length); i++) {
            if (vetor[i].getInstante() == 0) {
                try {
                    //System.out.println("desaloca posicao: " + i);
                    vetor[i].getSemaforo().acquire();
                    vetor[i] = vazia;
                    aloc--;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Heap.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    vetor[i].getSemaforo().release();
                }
            }
        }

        this.setAlocado(aloc * this.getTamanhoBloco());

        //apos 3 desalocações zera todos os instantes
        if (this.getCont() >= 2) {
            for (int i = 0; i < (vetor.length); i++) {
                try {
                    vetor[i].getSemaforo().acquire();
                    vetor[i].setInstante(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Heap.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    vetor[i].getSemaforo().release();
                }
            }
            this.setCont(0);
        } else {
            this.setCont(this.getCont() + 1);
        }
        System.out.println("desalocar");
    }

    //random.nextInt((max - min) + 1) + min;      
    public Integer gerarInstante() {
        Random random = new Random();
        //gera 0 ou 1
        Integer i = random.nextInt(2);
        return i;
    }

    public synchronized void imprimir() {
        for (int j = 0; j < this.getVetor().length; j++) {
            System.out.println(this.getVetor()[j]);
        }
        System.out.println("-------------");
    }
}
