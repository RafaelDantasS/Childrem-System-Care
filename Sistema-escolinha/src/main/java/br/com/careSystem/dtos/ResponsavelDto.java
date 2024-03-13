package br.com.careSystem.dtos;

import java.io.Serializable;
import java.util.Objects;

import br.com.careSystem.models.Cadastro;

public class ResponsavelDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Cadastro cadastro;
	private String nome;
	private String cpf;
	private String telefone;

	public Long getId() {
		return id;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cadastro, cpf, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsavelDto other = (ResponsavelDto) obj;
		return Objects.equals(cadastro, other.cadastro) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
