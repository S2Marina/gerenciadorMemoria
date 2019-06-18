/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentomemoria;



/**
 *
 * @author alunos
 */
public class GerenciamentoMemoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //public Configuracao(tamanhoHeap (em kb),limiarMaximoHeap,minRequisicao,maxRequisicao)
        Configuracao conf = new Configuracao(1, 0.5 , 1, 30); 
        Heap heap = new Heap();
        heap.setTamanho(conf.getTamanhoHeap());
        VetorRequisicoes v = new VetorRequisicoes(conf);
        
        for (int i = 0; i < 25; i++) { 
            v.inserir();
            heap.alocarVariavel(v);
            if(heap.getAlocado() > conf.getLimiarMaximoHeap()){
                heap.desalocarVariavel();
            }
        }
        for (Integer vetor : heap.getVetor()) {
            System.out.println(vetor);
        }
    }
}
