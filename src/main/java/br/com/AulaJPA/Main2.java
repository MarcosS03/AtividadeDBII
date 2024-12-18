package br.com.AulaJPA;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.AulaJPA.DAOService.copy.EnderecoDAO;
import br.com.AulaJPA.DAOService.copy.PessoaDAO;
import br.com.AulaJPA.DAOService.copy.PessoaFisicaDAO;
import br.com.AulaJPA.DAOService.copy.TelefonesDAO;



public class Main2 {
    public static void main(String[] args) {

    	  PessoaFisicaDAO daoP =  new PessoaFisicaDAO();

    	  
          // Criar e salvar Pessoa
          PessoaFisica pessoa1 = new PessoaFisica();
          pessoa1.setNome("João Silva");
          daoP.salvar(pessoa1);
          
          PessoaFisica pessoa2 = new PessoaFisica();
          pessoa2.setNome("Marcos Suel");
          daoP.salvar(pessoa2);
          
          PessoaFisica pessoa3 = new PessoaFisica();
          pessoa3.setNome("Thallison IFPE");
          daoP.salvar(pessoa3);

          
          
          //criar e salvar endereco
          Endereco endereco1 = new Endereco();         
          endereco1.setLogradouro("Rua B");
          endereco1.setCidade("Recife");
          endereco1.setPessoa(pessoa1);
          EnderecoDAO daoE = new EnderecoDAO();
          daoE.salvar(endereco1);
      
          Endereco endereco2 = new Endereco();         
          endereco2.setLogradouro("Rua A");
          endereco2.setCidade("Palmares");
          endereco2.setPessoa(pessoa2);                   
          daoE.salvar(endereco2);
          
          Endereco endereco3 = new Endereco();         
          endereco3.setLogradouro("Rua teste");
          endereco3.setCidade("Palmares");
          endereco3.setPessoa(pessoa3);                   
          daoE.salvar(endereco3);
          
          //cria e salva os telefones
          Telefones t1 = new Telefones();
          t1.setTelefone("8198744-5522");
          t1.setWhastApp("819 5466-77895");
          t1.setPessoa(pessoa1);
          TelefonesDAO daoT = new TelefonesDAO();
          daoT.salvar(t1);
          
          Telefones t2 = new Telefones();
          t2.setTelefone("8198933-2144");
          t2.setWhastApp("81 9 3278-9645");
          t2.setPessoa(pessoa2);
          daoT.salvar(t2);
          
          Telefones t3 = new Telefones();
          t3.setTelefone("819 6677-5897");
          t3.setWhastApp("81 9 3278-9645");
          t3.setPessoa(pessoa3);
          daoT.salvar(t3);

          
          List<PessoaFisica> pessoas = daoP.listar();
          for (Pessoa p : pessoas) {
              System.out.println(p.getNome());
              for (Endereco e : p.getEnderecos()) {
            	  System.out.println("Rua: "+e.getLogradouro());
            	  System.out.println("Cidade: " +e.getCidade());
              } 
              for (Telefones t : p.getTelefones()) {
  				System.out.println("Numero de telefone: "+t.getTelefone());
  				System.out.println("WhatsAPP: "+t.getWhastApp());
  			}
              System.out.println("\n***************************************************************");
          }

  			

          // Buscar Pessoa por ID
          PessoaFisica pessoaBuscada1 =  daoP.buscarPorId(pessoa1.getId());
          System.out.println("Pessoa buscada por ID: " + pessoaBuscada1.getNome());
          PessoaFisica pessoaBuscada2 =  daoP.buscarPorId(pessoa2.getId());
          System.out.println("Pessoa buscada por ID: " + pessoaBuscada2.getNome());
          PessoaFisica pessoaBuscada3 =  daoP.buscarPorId(pessoa3.getId());
          System.out.println("Pessoa buscada por ID: " + pessoaBuscada3.getNome());
         
          System.out.println("\n***************************************************************");
          
          //atualizar os dados 
          
          pessoaBuscada1.setNome("João dados atualizados");
          
          daoP.atualizar(pessoaBuscada1);
          System.out.println("Pessoa com dados atualizados: \n");
          
          Endereco enB = new Endereco();
          enB = daoE.buscarPorId(endereco1.getId());
          enB.setLogradouro("Rua Atualizada");
          enB.setCidade("Cidade Atualizada");
          
          System.out.println("Nome: "+ pessoaBuscada1.getNome());
          System.out.println("Rua: "+enB.getLogradouro());
          System.out.println("Cidade: "+enB.getCidade());
         
          System.out.println("\n***************************************************************");
          
          
          //remover pessoa! 
          System.out.println("\nPessoa removida: \n" + pessoaBuscada1.getNome() );
          daoP.remover(pessoaBuscada1.getId());
          System.out.println("\n***************************************************************");
          
          //lista com os dados atualizados
          List<PessoaFisica> pessoasA = daoP.listar();
          for (Pessoa p : pessoasA) {
              System.out.println(p.getNome());
              for (Endereco e : p.getEnderecos()) {
            	  System.out.println(e.getLogradouro());
            	  System.out.println(e.getCidade());
              } 
              for (Telefones t : p.getTelefones()) {
  				System.out.println("Numero de telefone: "+t.getTelefone());
  				System.out.println("WhatsAPP: "+t.getWhastApp()+"\n");
              }
          }
          System.out.println("\n***************************************************************");
    }
}

