package gerenciamentomemoria;

import java.util.Random;

public class Heap {

    private Integer tamanho; //em bytes
    private Integer alocado = 0;
    private Pagina[] vetor;
    private Integer tamanhoPagina;

    public Heap(Integer tamanho, Integer tamanhoPagina) {
        this.tamanho = tamanho;
        this.tamanhoPagina = tamanhoPagina;
        Integer tamanhoVetor = tamanho / tamanhoPagina; 
        this.vetor = new Pagina[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            Pagina p = new Pagina(0, 0);
            this.vetor[i] = p;
        }
    }

    public Integer getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(Integer tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public Integer getAlocado() {
        return alocado * tamanhoPagina;
    }

    public void setAlocado(Integer alocado) {
        this.alocado = alocado / tamanhoPagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanhoHeap) {
        this.tamanho = tamanhoHeap;
    }

    public Pagina[] getVetor() {
        return vetor;
    }

    public void alocarVariavel(VetorRequisicoes requisicoes) {
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();
        this.setAlocado(this.getAlocado() + (tamanhoVariavel * tamanhoPagina));
        Integer instante = gerarInstante();
        //algoritmo de alocação
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getId() == 0 && tamanhoVariavel > 0) {
                Pagina alocar = new Pagina(requisicao.getId(), instante);
                vetor[i] = alocar;                
                tamanhoVariavel--;
            }
        }
    }

    public void desalocarVariavel() {
        Integer aloc = this.getAlocado() / this.getTamanhoPagina();
        Pagina vazia = new Pagina(0,0);
        //algoritmo de desalocação
        for (int i = 0; i < (vetor.length); i++) {
//            desaloca tudo
//            if (vetor[i].getId() != 0) {
//                vetor[i].setId(0);
//                vetor[i].setInstante(0);
//            }
            if(vetor[i].getInstante() == 0){
                vetor[i] = vazia;
                aloc--;
            }
        }
        this.setAlocado(aloc * this.getTamanhoPagina());
    }

    //random.nextInt((max - min) + 1) + min;      
    public Integer gerarInstante() {
        Random random = new Random();
        //gera 0 ou 1
        Integer i = random.nextInt(2);
        return i;
    }
}
