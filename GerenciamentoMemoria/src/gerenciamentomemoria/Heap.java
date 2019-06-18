package gerenciamentomemoria;

import java.util.Arrays;

public class Heap {
    private Integer tamanho; //em blocos de 1kb cada
    private Integer alocado = 0;
    private Integer[] vetor;

    public Integer getAlocado() {
        return alocado;
    }

    public void setAlocado(Integer alocado) {
        this.alocado = alocado;
    }
    
    public Integer getTamanho() {
        return tamanho * 256;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
        Integer tamanhoVetor = tamanho * 256; //1kb = 1024 bytes, 1 palavra = 4 bytes, 
                                              // 1024/4 = 256 palavras em um bloco
        this.vetor = new Integer[tamanhoVetor];
        Arrays.fill(this.vetor, 0);
    }

    public Integer[] getVetor() {
        return vetor;
    }    
    
    public void alocarVariavel(VetorRequisicoes requisicoes){
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();
        this.setAlocado(alocado + tamanhoVariavel);
        //algoritmo de alocação
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == 0 && tamanhoVariavel > 0){
                vetor[i] = requisicao.getId();
                tamanhoVariavel--;
            }
        }
    }
    
    public void desalocarVariavel(){
        //algoritmo de desalocação
        for (int i = 0; i < (vetor.length); i++) {
            if(vetor[i] != 0){
                vetor[i] = 0;
            }
        }
        this.setAlocado(0);
    }
}
