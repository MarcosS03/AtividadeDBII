package br.com.AulaJPA.DAOService.copy;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.AulaJPA.Telefones;
import br.com.AulaJPA.Veiculos;

import java.util.List;

public class VeiculoDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Veiculos veiculo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        em.close();
    }

    public Veiculos buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Veiculos veiculo = em.find(Veiculos.class, id);
        em.close();
        return veiculo;
    }
    public List<Veiculos> listar() {
    	EntityManager em = emf.createEntityManager();
        TypedQuery<Veiculos> query = em.createQuery("SELECT u FROM Veiculos", Veiculos.class);
        List<Veiculos> Veiculos = query.getResultList();
        em.close();
        return Veiculos;
    }
  

    public void atualizar(Veiculos veiculo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Telefones veiculo = em.find(Telefones.class, id);
        if (veiculo != null) {
            em.remove(veiculo);
        }
        em.getTransaction().commit();
        em.close();
    }
}


