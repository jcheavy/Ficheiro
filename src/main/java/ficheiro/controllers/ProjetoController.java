package ficheiro.controllers;

import java.util.Date;

import ficheiro.entities.Projeto;
import ficheiro.services.ProjetoService;

public class ProjetoController {

	private ProjetoService service;
	
	public ProjetoController(ProjetoService service) {
		this.service = service;
	}
	
	public void salvar(String id, String nome, Date dataInicio, Date dataFim) {
		
		Projeto projeto = new Projeto(Integer.parseInt(id), nome, dataInicio, dataFim);
		service.salvar(projeto);
	}
}
