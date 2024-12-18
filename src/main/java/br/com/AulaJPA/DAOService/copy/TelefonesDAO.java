package br.com.AulaJPA.DAOService.copy;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.AulaJPA.Telefones;

import java.util.List;

public class TelefonesDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Telefones telefone) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(telefone);
        em.getTransaction().commit();
        em.close();
    }

    public Telefones buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Telefones telefone = em.find(Telefones.class, id);
        em.close();
        return telefone;
    }
    public List<Telefones> listar() {
    	EntityManager em = emf.createEntityManager();
        TypedQuery<Telefones> query = em.createQuery("SELECT u FROM Telefones", Telefones.class);
        List<Telefones> Telefones = query.getResultList();
        em.close();
        return Telefones;
    }
  

    public void atualizar(Telefones telefone) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(telefone);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Telefones telefone = em.find(Telefones.class, id);
        if (telefone != null) {
            em.remove(telefone);
        }
        em.getTransaction().commit();
        em.close();
    }
}

