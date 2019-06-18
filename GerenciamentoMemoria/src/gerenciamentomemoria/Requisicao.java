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
public class Requisicao {
    private Integer id;
    private Integer tamVariavel; //em palavras
    private Requisicao proxima;

    public Requisicao(Integer id, Integer tamVariavel) {
        this.id = id;
        this.tamVariavel = tamVariavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTamVariavel() {
        return tamVariavel;
    }

    public void setTamVariavel(Integer tamVariavel) {
        this.tamVariavel = tamVariavel;
    }

    public Requisicao getProxima() {
        return proxima;
    }

    public void setProxima(Requisicao proxima) {
        this.proxima = proxima;
    }

    @Override
    public String toString() {
        return "Requisicao{ " + "Id = " + id + ", Tamanho da Variável Dinâmica = " + tamVariavel + " }";
    }
   
    
}
