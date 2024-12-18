package br.com.AulaJPA.DAOService.copy;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.AulaJPA.Pessoa;
import br.com.AulaJPA.Telefones;

import java.util.List;

public class PessoaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public Pessoa buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.close();
        return pessoa;
    }

    public List<Pessoa> listar(){
    	EntityManager em = emf.createEntityManager();
        TypedQuery<Pessoa> query = em.createQuery("SELECT u FROM Pessoa u LEFT JOIN FETCH u.telefones LEFT JOIN FETCH u.enderecos LEFT JOIN FETCH u.veiculos", Pessoa.class);
        List<Pessoa> Pessoa = query.getResultList();
        em.close();
        return Pessoa;
    }

    public void atualizar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.remove(pessoa);
        }
        em.getTransaction().commit();
        em.close();
    }
}

