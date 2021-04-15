package petShop;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

	private Integer id;
	private String nome;
	private String nomeFantasia;
	private Integer cnpj;
	private LocalDate dataCadastro;
	private LocalDate dataEdicao;
	private LocalDate dataDeletado;
	private Status ativo;
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	
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
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFatasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public LocalDate getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(LocalDate dataEdicao) {
		this.dataEdicao = dataEdicao;
	}
	
	public LocalDate getDataDeletado() {
		return dataDeletado;
	}

	public void setDataDeletado(LocalDate dataDeletado) {
		this.dataDeletado = dataDeletado;
	}
	
	public Status getAtivo() {
		return ativo;
	}
	public void setAtivo(Status ativo) {
		this.ativo = ativo;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
}
