package gerenciamentomemoria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GerenciamentoMemoria {

    public static void main(String[] args) {
        //public Configuracao(tamanhoHeap (em bytes),limiarMaximoHeap,minRequisicao,maxRequisicao,tamanhoPagina(bytes))
        Configuracao conf = new Configuracao(512, 256, 1, 30, 8);
        Integer requisicoes = 100;
        Heap heap = new Heap(conf.getTamanhoHeap(), conf.getTamanhoPagina());
        VetorRequisicoes vetorRequisicoes = new VetorRequisicoes(conf);

        //threads
        Alocar alocar = new Alocar(heap, vetorRequisicoes);
        Desalocar desalocar = new Desalocar(heap);
        //NovaRequisicao requisicao = new NovaRequisicao(vetorRequisicoes);
        for (int i = 0; i < requisicoes; i++) {
            vetorRequisicoes.inserir();
        }

        //paralelo
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        long tempoInicial = System.currentTimeMillis();
        do {           
            executor.execute(alocar);
            requisicoes--;

            if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
                executor.execute(desalocar);
            }
        } while (requisicoes!= 0);
        executor.shutdown();
        if(executor.isTerminated()){
            System.out.println("Paralelo: " + (System.currentTimeMillis() - tempoInicial) + "ms");
        }
        

 
          //sequencial
//        long tempoInicial = System.currentTimeMillis();
//        for (int i = 0; i < 25; i++) {
//            vetorRequisicoes.inserir();
//            if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
//                heap.desalocarVariavel();
//                //heap.imprimir();
//            }
//            heap.alocarVariavel(vetorRequisicoes);
//            //heap.imprimir();
//
//        }
//        System.out.println("sequencial: " + (System.currentTimeMillis() - tempoInicial) + "ms");
    }
}
