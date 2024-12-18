package br.com.AulaJPA;

import java.util.List;

import br.com.AulaJPA.DAOService.copy.PessoaDAO;
import br.com.AulaJPA.DAOService.copy.PessoaJuridicaDAO;
import br.com.AulaJPA.DAOService.copy.VeiculoDAO;

public class Main {
    public static void main(String[] args) {
    	PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
        
        // Criar e Salvar Pessoa
        PessoaJuridica pJ1 = new PessoaJuridica();
        pJ1.setNome("Empresa 1");
        pJ1.setRazaoSocial("Empresa 01");
        pJ1.setCnpj("11.111.111/1111-11");
        pJ1.setIscricaoEstadual("111");
        dao.salvar(pJ1);
        
        PessoaJuridica pJ2 = new PessoaJuridica();
        pJ2.setNome("Empresa 2");
        pJ2.setRazaoSocial("Empresa 02");
        pJ2.setCnpj("22.222.222/2222-22");
        pJ2.setIscricaoEstadual("222");
        dao.salvar(pJ2);
        
        // Criar e Salvar Veículo
        Veiculos veiculo1 = new Veiculos();
        veiculo1.setModelo("Celta");
        veiculo1.setMarca("Chevrolet");
        veiculo1.setChassi("chasse 1");
        veiculo1.setRenavam("renavam 1");
        veiculo1.setAnoFabricacao("2020");
        veiculo1.setAnoModelo("2020");
        veiculo1.setCor("Cinza");
        veiculo1.setPotencia(40);
        veiculo1.setCapacidade(5);
        veiculo1.setPessoa(pJ1);
        
        VeiculoDAO daoV = new VeiculoDAO();
        daoV.salvar(veiculo1);
        
        Veiculos veiculo2 = new Veiculos();
        veiculo2.setModelo("Onix");
        veiculo2.setMarca("Chevrolet");
        veiculo2.setChassi("chasse 2");
        veiculo2.setRenavam("renavam 2");
        veiculo2.setAnoFabricacao("2021");
        veiculo2.setAnoModelo("2021");
        veiculo2.setCor("Preto");
        veiculo2.setPotencia(50);
        veiculo2.setCapacidade(5);
        veiculo2.setPessoa(pJ1);
          
        daoV.salvar(veiculo2);
        
        Veiculos veiculo3 = new Veiculos();
        veiculo3.setModelo("Celta");
        veiculo3.setMarca("Chevrolet");
        veiculo3.setChassi("chasse 1");
        veiculo3.setRenavam("renavam 1");
        veiculo3.setAnoFabricacao("2020");
        veiculo3.setAnoModelo("2020");
        veiculo3.setCor("Cinza");
        veiculo3.setPotencia(40);
        veiculo3.setCapacidade(5);
        veiculo3.setPessoa(pJ2);
        
        daoV.salvar(veiculo3);
        
        
        
        // Listar Pessoa Juridica
        //System.out.println("\n--- Listando Pessoas Jurídicas ---");
        System.out.println("\n--- Listando Pessoas Jurídicas e seus Veículos ---");
        List<PessoaJuridica> listaPessoas = dao.listar();
        for (PessoaJuridica pessoa : listaPessoas) {
            System.out.println("ID: " + pessoa.getId());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Razão Social: " + pessoa.getRazaoSocial());
            System.out.println("CNPJ: " + pessoa.getCnpj());
            System.out.println("Veículos:");
            System.out.println("-----------------------------------");
        }

    }
}