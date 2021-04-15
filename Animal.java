package petShop;

import java.time.LocalDate;

public class Animal {

	private Integer id;
	private String nome;
	private Integer idade;
	private Status ativo;
	private Tipo tipo;
	private LocalDate dataDeletado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Status getAtivo() {
		return ativo;
	}

	public void setAtivo(Status ativo) {
		this.ativo = ativo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataDeletado() {
		return dataDeletado;
	}

	public void setDataDeletado(LocalDate dataDeletado) {
		this.dataDeletado = dataDeletado;
	}

}
