package br.com.AulaJPA;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Permisoes permisaes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Permisoes getPermisaes() {
		return permisaes;
	}

	public void setPermisaes(Permisoes permisaes) {
		this.permisaes = permisaes;
	}
	
	
	
}
