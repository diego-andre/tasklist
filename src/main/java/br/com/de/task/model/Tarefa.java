package br.com.de.task.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")
@NamedQueries({ 
	@NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t"),
	@NamedQuery(name = "Tarefa.findByTitulo", query= "SELECT t FROM Tarefa t WHERE t.titulo LIKE :titulo")
})
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descricao;
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	@Column(name = "data_edicao")
	private Date dataEdicao;
	@Column(name = "data_conclusao")
	private Date dataConclucao;
	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Date dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Date getDataConclucao() {
		return dataConclucao;
	}

	public void setDataConclucao(Date dataConclucao) {
		this.dataConclucao = dataConclucao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
