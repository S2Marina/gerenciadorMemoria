package gerenciamentomemoria;

import java.util.concurrent.Semaphore;

public class Bloco {
    private Integer id;
    private Integer instante;
    private Semaphore semaforo;

    public Bloco(Integer id, Integer instante) {
        this.id = id;
        this.instante = instante;
        this.semaforo = new Semaphore(1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstante() {
        return instante;
    }

    public void setInstante(Integer instante) {
        this.instante = instante;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public String toString() {
        return "Pagina{" + "id=" + id + ", instante=" + instante + '}';
    }
    
    
}