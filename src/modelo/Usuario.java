package modelo;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@NamedQueries(value = { @NamedQuery(
        name = "Usuario.buscaPorUsuarioSenha",
        query = "select u from Usuario u where u.usuario = :user and u.senha = :pwd")})
@Table(name="usuario")
public class Usuario implements Serializable {

    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String usuario;
    private String senha;
    private String nome;

    @OneToMany(mappedBy = "usuario")
    @OrderBy("limite ASC")
    private Collection<Tarefas> tarefas;

    public Usuario() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }   

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Tarefas> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Collection<Tarefas> tarefas) {
        this.tarefas = tarefas;
    }
}

