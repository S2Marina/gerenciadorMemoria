package gerenciamentomemoria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GerenciamentoMemoria {

    public static void main(String[] args) {
        //public Configuracao(tamanhoHeap (em bytes),limiarMaximoHeap,minRequisicao,maxRequisicao,tamanhoPagina(bytes))
        Configuracao conf = new Configuracao(512, 256, 1, 30, 8);
        Heap heap = new Heap(conf.getTamanhoHeap(), conf.getTamanhoPagina());
        VetorRequisicoes v = new VetorRequisicoes(conf);
        //threads
        Alocar alocar = new Alocar(heap, v);
        Desalocar desalocar = new Desalocar(heap, v);
        NovaRequisicao requisicao = new NovaRequisicao(v);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(requisicao);
            if (!v.vazia()) {
                executor.execute(alocar);
            }
            if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
                desalocar.start();
            }
        }
        executor.shutdown();

        //paralelo
//        requisicao.start();
//        if (!v.vazia()) {
//            alocar.start();
//        }
//
//        if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
//            desalocar.start();
//        }
        //sequencial
//        long tempoInicial = System.currentTimeMillis();
//        for (int i = 0; i < 25; i++) {
//            v.inserir();
//            if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
//                heap.desalocarVariavel();
//            }
//            heap.alocarVariavel(v);
//            heap.imprimir();
//        }
//        System.out.println("sequencial: " + (System.currentTimeMillis() - tempoInicial) + "ms");
    }
}
