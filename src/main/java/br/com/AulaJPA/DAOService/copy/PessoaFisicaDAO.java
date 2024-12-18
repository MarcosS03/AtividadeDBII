package br.com.AulaJPA.DAOService.copy;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Pessoa;
import br.com.AulaJPA.PessoaFisica;

import java.util.List;

public class PessoaFisicaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");
    EntityManager em = emf.createEntityManager();
    
    public void salvar(PessoaFisica pessoa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public PessoaFisica buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
        em.close();
        return pessoaFisica;
    }

    public List<PessoaFisica> listar() {
        EntityManager em = emf.createEntityManager();
        List<PessoaFisica> pessoas = em.createQuery("SELECT u FROM PessoaFisica u LEFT JOIN FETCH u.telefones", PessoaFisica.class).getResultList();
        em.close();
        return pessoas;
    }

    public void atualizar(PessoaFisica pessoa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pessoa);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PessoaFisica pessoa = em.find(PessoaFisica.class, id);
        if (pessoa != null) {
            em.remove(pessoa);
        }
        em.getTransaction().commit();
        em.close();
    }
}

