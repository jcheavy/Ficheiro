package ficheiro.services;

import java.util.List;

import ficheiro.dao.ProjetoDAO;
import ficheiro.entities.Projeto;

public class ProjetoService {
	
	private ProjetoDAO dao;
	
	
	public ProjetoService(ProjetoDAO dao) {
		this.dao = dao;
	}
	
	public List<Projeto> findAll(){
		return dao.listaTudo();
	}
	
	

}
