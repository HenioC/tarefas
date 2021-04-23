package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Usuario;

@ManagedBean(name = "cadastro")
@SessionScoped
public class Cadastro {
    
    private String mensagem = "Informe os dados do usuário!";
    private String confirmaSenha;
    private Usuario usuario;
    
    private static final String PERSISTENCE_UNIT_NAME = "tarefas";
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public Cadastro() {
        this.usuario = new Usuario();
        entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String cadastrar() {
        if (this.validaDados()) {
            if (!entityTransaction.isActive()) {
                entityTransaction.begin();
            }

            entityManager.persist(this.usuario);

            entityTransaction.commit();
            
            this.usuario = new Usuario();
            this.setMensagem("usuário cadastrado com sucesso!");
            
            return "login.xhtml?faces-redirect=true?faces-redirect=true";
        }

        return null;
    }
    
    public boolean validaDados()
    {
        if(!this.usuario.getSenha().equals(this.getConfirmaSenha()))
        {
            this.setMensagem("A senha e a confirmação não coincidem!");
            return false;
        }
        
        return true;
    }

}
