package ficheiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ficheiro.dao.ProjetoDAO;
import ficheiro.entities.Projeto;
import ficheiro.views.TelaPrincipal;

public class Main {

	public static void main(String[] args) {

		new TelaPrincipal();
		
		SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		Date d = new Date();
		try {
			d = df.parse("09/03/2023");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		 
		 
		Projeto p1 = new Projeto(1, "Contrução", data, d, 10, 20, 3);
		Projeto p2 = new Projeto(2, "Escavação", data, d, 10, 20, 1);
		Projeto p3 = new Projeto(3, "Terra Planagem", data, d, 10, 20, 4);
		Projeto p4 = new Projeto(3, "Eletrico", data, d, 10, 20, 2);
		
		ProjetoDAO dao = new ProjetoDAO();
		
//		dao.adiciona(p1);
//		dao.adiciona(p2);
//		dao.adiciona(p3);
//		dao.adiciona(p4);
		
		dao.listaTudo();
		int cont = dao.count();
		System.out.println(cont);
		for (Projeto p : dao.listaTudo()) {
			System.out.println(p);
		}
		
	
	}
}
