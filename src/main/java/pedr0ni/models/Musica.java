package pedr0ni.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe do modelo Musica
 * @author Matheus Pedroni
 */
public class Musica implements Serializable {

    private static final long serialVersionUID = 8384441712389102362L;
    private long id;
    private String titulo, cantor, estilo;
    private double preco;
    
    public Musica(long id, String titulo, String cantor, String estilo, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.cantor = cantor;
        this.estilo = estilo;
        this.preco = preco;
    }

    public long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCantor() {
        return this.cantor;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public double getPreco() {
        return this.preco;
    }    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Musica)) {
            return false;
        }
        Musica musica = (Musica) o;
        return id == musica.id && Objects.equals(titulo, musica.titulo) && Objects.equals(cantor, musica.cantor) && Objects.equals(estilo, musica.estilo) && preco == musica.preco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, cantor, estilo, preco);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", cantor='" + getCantor() + "'" +
            ", estilo='" + getEstilo() + "'" +
            ", preco='" + getPreco() + "'" +
            "}";
    }
    
}