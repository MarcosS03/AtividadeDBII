package br.com.AulaJPA.DAOService.copy;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.com.AulaJPA.PessoaJuridica;


import java.util.List;

public class PessoaJuridicaDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(PessoaJuridica pj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pj);
        em.getTransaction().commit();
        em.close();
    }

    public PessoaJuridica buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        PessoaJuridica pj = em.find(PessoaJuridica.class, id);
        em.close();
        return pj;
    }
    public List<PessoaJuridica> listar() {
    	EntityManager em = emf.createEntityManager();
        TypedQuery<PessoaJuridica> query = em.createQuery("FROM PessoaJuridica", PessoaJuridica.class);
        List<PessoaJuridica> PessoaJuridica = query.getResultList();
        em.close();
        return PessoaJuridica;
    }
  

    public void atualizar(PessoaJuridica pj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pj);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PessoaJuridica pj = em.find(PessoaJuridica.class, id);
        if (pj != null) {
            em.remove(pj);
        }
        em.getTransaction().commit();
        em.close();
    }
}

