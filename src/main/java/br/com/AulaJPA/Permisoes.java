package br.com.AulaJPA;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permisoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean visualizarDashBoard;
	private boolean darDescontos;
	private boolean cadastrarUsuario;
	private boolean finaceiro;
	private boolean cadastrarTipoVaga;
	private boolean cadastrarVaga;
	private boolean alterarValorVaga;
	private boolean carteira;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isVisualizarDashBoard() {
		return visualizarDashBoard;
	}

	public void setVisualizarDashBoard(boolean visualizarDashBoard) {
		this.visualizarDashBoard = visualizarDashBoard;
	}

	public boolean isDarDescontos() {
		return darDescontos;
	}

	public void setDarDescontos(boolean darDescontos) {
		this.darDescontos = darDescontos;
	}

	public boolean isCadastrarUsuario() {
		return cadastrarUsuario;
	}

	public void setCadastrarUsuario(boolean cadastrarUsuario) {
		this.cadastrarUsuario = cadastrarUsuario;
	}

	public boolean isFinaceiro() {
		return finaceiro;
	}

	public void setFinaceiro(boolean finaceiro) {
		this.finaceiro = finaceiro;
	}

	public boolean isCadastrarTipoVaga() {
		return cadastrarTipoVaga;
	}

	public void setCadastrarTipoVaga(boolean cadastrarTipoVaga) {
		this.cadastrarTipoVaga = cadastrarTipoVaga;
	}

	public boolean isCadastrarVaga() {
		return cadastrarVaga;
	}

	public void setCadastrarVaga(boolean cadastrarVaga) {
		this.cadastrarVaga = cadastrarVaga;
	}

	public boolean isAlterarValorVaga() {
		return alterarValorVaga;
	}

	public void setAlterarValorVaga(boolean alterarValorVaga) {
		this.alterarValorVaga = alterarValorVaga;
	}

	public boolean isCarteira() {
		return carteira;
	}

	public void setCarteira(boolean carteira) {
		this.carteira = carteira;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
