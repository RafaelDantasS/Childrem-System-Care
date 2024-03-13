package br.com.careSystem.dtos;

import java.io.Serializable;
import java.util.Objects;

import br.com.careSystem.models.Cadastro;

public class CriancaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Cadastro cadastro;
	private String nome;
	private int idade;
	private String sala;
	private boolean visitante;
	private String info;

	public Long getId() {
		return id;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getSala() {
		return sala;
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

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public boolean isVisitante() {
		return visitante;
	}


	public String getInfo() {
		return info;
	}


	public void setVisitante(boolean visitante) {
		this.visitante = visitante;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cadastro, id, idade, nome, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriancaDto other = (CriancaDto) obj;
		return Objects.equals(cadastro, other.cadastro) && Objects.equals(id, other.id)
				&& Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome)
				&& Objects.equals(sala, other.sala);
	}
	
	
}
