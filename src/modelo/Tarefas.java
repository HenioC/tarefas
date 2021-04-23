package modelo;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tarefas
 *
 */
@Entity
@Table(name="tarefas")
public class Tarefas implements Serializable {

    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descricao;
    
    private Boolean finalizada;
    
    private Timestamp cadastro;
    
    private Timestamp entrega;
    
    private Timestamp limite;
    
    @ManyToOne()
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   
    public Boolean getFinalizada() {
        return this.finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }   
    public Timestamp getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(Timestamp cadastro) {
        this.cadastro = cadastro;
    }   
    public Timestamp getEntrega() {
        return this.entrega;
    }

    public void setEntrega(Timestamp entrega) {
        this.entrega = entrega;
    }   
    public Timestamp getLimite() {
        return this.limite;
    }

    public void setLimite(Timestamp limite) {
        this.limite = limite;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
}
