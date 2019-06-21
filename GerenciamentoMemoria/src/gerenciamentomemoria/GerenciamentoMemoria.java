package gerenciamentomemoria;

import java.util.List;


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
            /*if(heap.getAlocado() > conf.getLimiarMaximoHeap()){
                heap.desalocarVariavel();
            }*/
        }
        //for (Pagina vetor : heap.getVetor()) {
        for (int i = 0; i < heap.getVetor().size(); i++) {
            System.out.println(heap.getVetor().get(i));
        }
    }
}
