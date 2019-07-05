/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentomemoria;

import java.util.Random;

public class VetorRequisicoes {

    private Requisicao inicio = null;
    private Requisicao fim = null;
    private Requisicao ultimo = null;
    private Configuracao conf;

    public VetorRequisicoes(Configuracao conf) {
        this.conf = conf;
    }

    public boolean vazia() {
        boolean retorno = false;
        if (inicio == null && fim == null) {
            retorno = true;
        }
        return retorno;
    }
   
    public synchronized void inserir() {
        Integer id, tamVariavel;
        id = gerarId();
        tamVariavel = gerarTamVariavel();
        Requisicao nova = new Requisicao(id, tamVariavel);
        if (this.vazia() == true) { //fila vazia
            inicio = nova;
            fim = nova;
            fim.setProxima(inicio);
        } else {
            nova.setProxima(inicio);
            fim.setProxima(nova);
            fim = nova;
            ultimo = nova;
        }
        //System.out.println(nova.toString());
    }

    public Requisicao remover() {
        Requisicao removida;
        if (this.vazia() == true) {
            removida = null;
        } else if (inicio == fim) {
            removida = inicio;
            inicio = null;
            fim = null;
        } else {
            removida = inicio;
            Requisicao vazia = new Requisicao(0, 0);
            fim = vazia;
            inicio = inicio.getProxima();
            fim.setProxima(inicio);
        }
        return removida;
    }

    public String listar() {
        String lista = "";
        if (this.vazia() == true) {
            return "Vetor de requisições vazio!";
        }else{
            Requisicao aux = inicio;
            do{
                lista = lista + aux.toString() + "\n";
                aux = aux.getProxima();
            }while(aux != fim.getProxima());
        }
        System.out.println(lista); 
        return lista;
    }

     //random.nextInt((max - min) + 1) + min;      
    public Integer gerarId(){
        Random random = new Random();
        Integer id = random.nextInt(1001);
        return id;
    }
    
    public Integer gerarTamVariavel(){
        Random random = new Random();
        Integer max = this.conf.getMaxRequisicao();
        Integer min = this.conf.getMinRequisicao();
        Integer tamanho = random.nextInt((max - min) + 1) + min;
        return tamanho;
    }
}
