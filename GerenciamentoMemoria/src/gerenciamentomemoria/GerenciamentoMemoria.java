package gerenciamentomemoria;

public class GerenciamentoMemoria {

    public static void main(String[] args) {
        //public Configuracao(tamanhoHeap (em bytes),limiarMaximoHeap,minRequisicao,maxRequisicao,tamanhoPagina(bytes))
        Configuracao conf = new Configuracao(512, 256, 1, 30, 8);
        Heap heap = new Heap(conf.getTamanhoHeap(), conf.getTamanhoPagina());
        VetorRequisicoes v = new VetorRequisicoes(conf);

        for (int i = 0; i < 25; i++) {
            v.inserir();
            if (heap.getAlocado() >= conf.getLimiarMaximoHeap()) {
                heap.desalocarVariavel(0);
                System.out.println("DESALOCA LRU");
                for (int j = 0; j < heap.getVetor().length; j++) {
                    System.out.println(heap.getVetor()[j]);
                }
                System.out.println("-------------");
            }
            if(heap.getAlocado() >= conf.getLimiarMaximoHeap()){
                heap.desalocarVariavel(1);
                System.out.println("DESALOCA MAIOR BLOCO");
                for (int j = 0; j < heap.getVetor().length; j++) {
                    System.out.println(heap.getVetor()[j]);
                }
                System.out.println("-------------");
            }
            heap.alocarVariavel(v);
            for (int j = 0; j < heap.getVetor().length; j++) {
                System.out.println(heap.getVetor()[j]);
            }
        }
    }
}
