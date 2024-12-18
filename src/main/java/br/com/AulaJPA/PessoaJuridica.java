package br.com.AulaJPA;

public class PessoaJuridica extends Pessoa {
	
	private String razaoSocial;
	private String cnpj;
	private String iscricaoEstadual;
	
	
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIscricaoEstadual() {
		return iscricaoEstadual;
	}
	public void setIscricaoEstadual(String iscricaoEstadual) {
		this.iscricaoEstadual = iscricaoEstadual;
	}

	
	
	
	
}
