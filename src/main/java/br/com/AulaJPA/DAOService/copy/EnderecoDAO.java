
	package br.com.AulaJPA.DAOService.copy;
	
	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.TypedQuery;

import br.com.AulaJPA.Endereco;
import br.com.AulaJPA.Telefones;

	import java.util.List;

	public class EnderecoDAO{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
	    EntityManager em = emf.createEntityManager();
	    
	    public void salvar(Endereco endereco) {
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(endereco);
	        em.getTransaction().commit();
	        em.close();
	    }

	    public Telefones buscarPorId(Long id) {
	        EntityManager em = emf.createEntityManager();
	        Telefones endereco = em.find(Telefones.class, id);
	        em.close();
	        return endereco;
	    }
	    public List<Endereco> listar() {
	    	EntityManager em = emf.createEntityManager();
	        TypedQuery<Endereco> query = em.createQuery("SELECT u FROM Endereco", Endereco.class);
	        List<Endereco> Endereco = query.getResultList();
	        em.close();
	        return Endereco;
	    }
	  

	    public void atualizar(Endereco endereco) {
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.merge(endereco);
	        em.getTransaction().commit();
	        em.close();
	    }

	    public void remover(Long id) {
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        Endereco endereco = em.find(Endereco.class, id);
	        if (endereco != null) {
	            em.remove(endereco);
	        }
	        em.getTransaction().commit();
	        em.close();
	    }


}
