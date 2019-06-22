package gerenciamentomemoria;

public class Pagina {
    private Integer id;
    private Integer instante;

    public Pagina(Integer id, Integer instante) {
        this.id = id;
        this.instante = instante;
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

    @Override
    public String toString() {
        return "Pagina{" + "id=" + id + ", instante=" + instante + '}';
    }
    
    
}