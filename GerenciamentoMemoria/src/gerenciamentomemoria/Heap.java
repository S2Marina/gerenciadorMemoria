package gerenciamentomemoria;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.fill;
import java.util.List;
import java.util.Random;

public class Heap {
    private Integer tamanho; //em blocos de 1kb cada
    private Integer alocado = 0;
    private List<Pagina> vetor;

     public Heap() {
        this.vetor = new ArrayList();
    }
  
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
        Pagina p = new Pagina(0,0);
        for (int i = 0; i < tamanhoVetor; i++) {
            this.vetor.add(i, p);
        }
    }

    public List<Pagina> getVetor() {
        return vetor;
    }    
    
    public void alocarVariavel(VetorRequisicoes requisicoes){
        Requisicao requisicao = requisicoes.remover();
        Integer tamanhoVariavel = requisicao.getTamVariavel();
        this.setAlocado(alocado + tamanhoVariavel);
        //algoritmo de alocação
        Integer instante = gerarInstante();
        for (int i = 0; i < tamanhoVariavel; i++) {        
            if(vetor.get(i).getId() == 0 && tamanhoVariavel > 0){
                Pagina pagina = new Pagina(requisicao.getId(), instante);
                vetor.set(i, pagina);
                tamanhoVariavel--;
            }
        }
    }
    
    public void desalocarVariavel(){
        //algoritmo de desalocação
        for (Pagina pagina : vetor) {
            if(pagina.getId() != 0){
                pagina.setId(0);
            }
        }
        this.setAlocado(0);
    }

     //random.nextInt((max - min) + 1) + min;      
    public Integer gerarInstante(){
        Random random = new Random();
        Integer i = random.nextInt(16);
        return i;
    }
    
}

