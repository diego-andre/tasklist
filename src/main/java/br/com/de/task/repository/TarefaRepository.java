package br.com.de.task.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.de.task.model.Tarefa;
import br.com.de.task.util.Uteis;

public class TarefaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager entityManager;

	public void insert(Tarefa tarefa) {
		entityManager = Uteis.JpaEntityManager();

		entityManager.persist(tarefa);
	}

	public void update(Tarefa tarefa) {
		entityManager = Uteis.JpaEntityManager();

		entityManager.merge(tarefa);
	}

	public void delete(long codigo) {
		entityManager = Uteis.JpaEntityManager();

		Tarefa tarefa = entityManager.find(Tarefa.class, codigo);
		entityManager.remove(tarefa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> findAll(){	 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("Tarefa.findAll");
 
		return (List<Tarefa>)query.getResultList();		 
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarefa> findByTitulo(String titulo){	 
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("Tarefa.findByTitulo");
		query.setParameter("titulo", "%"+titulo+"%");
 
		return (List<Tarefa>)query.getResultList();		 
	}

}
