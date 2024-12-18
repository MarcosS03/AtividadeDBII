package br.com.AulaJPA;


import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nome;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected Set<Endereco> enderecos;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Telefones> telefones;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Veiculos> veiculos;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Endereco> getEnderecos() { return enderecos; }
    public void setEnderecos(Set<Endereco> enderecos) { this.enderecos = enderecos; }	
    public Set<Telefones> getTelefones() { return telefones; }
    public void setTelefones(Set <Telefones> telefone) { this.telefones = (Set<Telefones>) telefone; }
    
	public Set<Veiculos> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Set<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}
	@Override
    public String toString() {
        return this.nome;
    }

}

