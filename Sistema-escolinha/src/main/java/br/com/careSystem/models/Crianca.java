package br.com.careSystem.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crianca")
public class Crianca implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @JoinColumn(name = "cadastro_id")
	private Cadastro cadastro;
	@Column
	private String nome;
	@Column
	private int idade;
	@Column
	private String sala;

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
		Crianca other = (Crianca) obj;
		return Objects.equals(cadastro, other.cadastro) && Objects.equals(id, other.id)
				&& Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome)
				&& Objects.equals(sala, other.sala);
	}
	
	
}
