package br.com.de.task.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.de.task.model.Tarefa;
import br.com.de.task.repository.TarefaRepository;
import br.com.de.task.util.Uteis;

@Named(value = "taskBean")
@SessionScoped 
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	private List<Tarefa> listaTarefa = new ArrayList<>();	
	private Tarefa tarefa = new Tarefa();

	@Inject
	private TarefaRepository tarefaRepository;

	private String filter = "";

	@PostConstruct
	public void init() {
		this.listaTarefa = this.tarefaRepository.findAll();
	}

	public void novo() {
		this.tarefa = new Tarefa();
	}

	public void salvar() {
		if (this.tarefa.getId() == null) {
			this.tarefa.setDataCadastro(new Date());
			this.tarefa.setStatus(false);

			this.tarefaRepository.insert(this.tarefa);

			Uteis.MensagemInfo("Tarefa cadastrada com sucesso");
		} else {
			this.tarefa.setDataEdicao(new Date());

			this.tarefaRepository.update(this.tarefa);

			Uteis.MensagemInfo("Tarefa atualizada com sucesso");
		}
		
		buscar();
	}

	public void buscar() {
		if (!this.filter.equals("")) {
			this.listaTarefa = this.tarefaRepository.findByTitulo(this.filter);
		} else {
			this.listaTarefa = this.tarefaRepository.findAll();
		}
	}

	public void excluir(Tarefa tarefa) {
		this.tarefaRepository.delete(tarefa.getId());

		Uteis.MensagemInfo("Tarefa excluída com sucesso");
		
		buscar();
	}

	public void updateStatus(Tarefa tarefa) {
		tarefa.setDataEdicao(new Date());
		tarefa.setStatus(!tarefa.getStatus());
		tarefa.setDataConclucao(new Date());

		this.tarefaRepository.update(tarefa);

		Uteis.MensagemInfo("Status atualizado com sucesso");
		
		buscar();
	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}
