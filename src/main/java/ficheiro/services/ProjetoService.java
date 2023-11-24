package ficheiro.services;

import java.util.List;

import ficheiro.dao.ProjetoDAO;
import ficheiro.entities.Projeto;

public class ProjetoService {
	
	private ProjetoDAO dao;
	
	
	public ProjetoService(ProjetoDAO dao) {
		this.dao = dao;
	}
	
	public void salvar(Projeto projeto) {
		dao.adiciona(projeto);
	}
	
	public List<Projeto> findAll(){
		return dao.listaTudo();
	}
	
	

}
