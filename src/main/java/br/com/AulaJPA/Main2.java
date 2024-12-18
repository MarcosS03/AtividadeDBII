package br.com.AulaJPA;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.AulaJPA.DAOService.copy.EnderecoDAO;
import br.com.AulaJPA.DAOService.copy.PessoaDAO;
import br.com.AulaJPA.DAOService.copy.TelefonesDAO;



public class Main2 {
    public static void main(String[] args) {
    	  PessoaDAO dao = new PessoaDAO();

    	  
          // Criar e salvar Pessoa
          PessoaFisica pessoa1 = new PessoaFisica();
          pessoa1.setNome("João Silva");
          dao.salvar(pessoa1);
          
          PessoaFisica pessoa2 = new PessoaFisica();
          pessoa2.setNome("Marcos Suel");
          dao.salvar(pessoa2);

          
          
          //criar e salvar endereco
          Endereco endereco1 = new Endereco();         
          endereco1.setLogradouro("Rua B");
          endereco1.setCidade("Recife");
          endereco1.setPessoa(pessoa1);
          EnderecoDAO en1 = new EnderecoDAO();
          en1.salvar(endereco1);
      
          Endereco endereco2 = new Endereco();         
          endereco2.setLogradouro("Rua A");
          endereco2.setCidade("Palmares");
          endereco2.setPessoa(pessoa2);                   
          EnderecoDAO en2 = new EnderecoDAO();
          en2.salvar(endereco2);
          
          //cria e salva os telefones
          Telefones t1 = new Telefones();
          t1.setTelefone("8198744-5522");
          t1.setWhastApp("819 5466-77895");
          t1.setPessoa(pessoa1);
          TelefonesDAO daoT1 = new TelefonesDAO();
          daoT1.salvar(t1);
          
          Telefones t2 = new Telefones();
          t2.setTelefone("8198933-2144");
          t1.setWhastApp("81 9 3278-9645");
          t2.setPessoa(pessoa2);
          TelefonesDAO daoT2 = new TelefonesDAO();
          daoT1.salvar(t2);

          // Listar todas as Pessoas
          List<Pessoa> pessoas = dao.listar();
          for (Pessoa p : pessoas) {
              System.out.println(p.getNome());
              for (Endereco e : p.getEnderecos()) {
            	  System.out.println(e.getLogradouro());
            	  System.out.println(e.getCidade());
              } 
              for (Telefones t : p.getTelefones()) {
  				System.out.println("Numero de telefone: "+t.getTelefone());
  				System.out.println("WhatsAPP: "+t.getWhastApp());
  			}
              System.out.println("***************************************************************");
          }

  			
 

          // Buscar Pessoa por ID
          Pessoa pessoaBuscada = dao.buscarPorId(1l);
          System.out.println("Pessoa encontrada: " + pessoaBuscada.getNome());

    }
}

