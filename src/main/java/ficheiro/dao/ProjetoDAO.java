package ficheiro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ficheiro.database.Conexao;
import ficheiro.entities.Projeto;

public class ProjetoDAO implements GenericDAO<Projeto> {

	private Connection conex;
    private Statement statement;
	public ProjetoDAO() {
		conex = Conexao.getInstance().getConnection();
		try {Statement statement = conex.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("create table if not exists projeto (id serial primary key, nome string, dataInicio datetime, dataFim datetime, dx integer, dy integer, numIndex integer)");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void adiciona(Projeto entidade) {

		try {
			String sql = "INSERT INTO projeto VALUES(?,?,?,?,?,?,?)";
			PreparedStatement stm = conex.prepareStatement(sql);
		
			stm.setInt(1, entidade.getId());
			stm.setString(2, entidade.getNome());
			stm.setDate(3,  new Date(entidade.getDataInicio().getTime()));
			stm.setDate(4, new Date(entidade.getDataFim().getTime()));
			stm.setInt(5, entidade.getDx());
			stm.setInt(6, entidade.getDy());
			stm.setInt(7, entidade.getNumIndex());
			

			// executar
			stm.execute();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar " + e.getMessage());
		}
	}

	@Override
	public void altera(Projeto entidade) {

		try {
			String sql = "UPDATE projeto SET nome = ?, telefone = ? WHERE id = ?";
			PreparedStatement stm = conex.prepareStatement(sql);
			stm.setInt(1, entidade.getId());
			stm.setString(2, entidade.getNome());
			

			// executar
			stm.execute();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro ao tentar alterar o: \n" + entidade.getNome() + "\n" + e.getMessage());
		}

	}

	@Override
	public void remove(Object iD) {

		try {

			String sql = "DELETE FROM projeto WHERE id = ?";
			PreparedStatement stm = conex.prepareStatement(sql);
			stm.setObject(1, iD);
			// executa
			stm.execute();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar o: \n" + e.getMessage());
		}

	}

	@Override
	public Projeto listaPorID(Object iD) {
		Projeto projeto = null;
		try {

			String sql = "SELECT nome, telefone FROM projeto WHERE id = ?";
			PreparedStatement stm = conex.prepareStatement(sql);

			stm.setObject(1, iD);

			ResultSet resultSet = stm.executeQuery();
			if (resultSet.next()) {
				projeto = new Projeto();
				projeto.setId((Integer) iD);
				projeto.setNome(resultSet.getString(1));
				
			}

			resultSet.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar o: \n" + e.getMessage());
		}
		return projeto;
	}

	@Override
	public List<Projeto> listaTudo() {

		List<Projeto> projetos = new ArrayList();
		try {

			String sql = "SELECT id, nome, dataInicio, dataFim, dx, dy, numIndex FROM projeto ORDER BY id";
			PreparedStatement stm = conex.prepareStatement(sql);

			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				Projeto projeto = new Projeto();
				projeto.setId(resultSet.getInt(1));
				projeto.setNome(resultSet.getString(2));
				projeto.setDataInicio(resultSet.getDate(3));
				projeto.setDataFim(resultSet.getDate(4));
				projeto.setDx(resultSet.getInt(5));
				projeto.setDy(resultSet.getInt(6));
				projeto.setNumIndex(resultSet.getInt(7));
				

				projetos.add(projeto);
			}

			resultSet.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar o: \n" + e.getMessage());
		}
		return projetos;

	}
	
	public int count() {
		int contador = 0;
		try {

			String sql = "SELECT count(*) as cont FROM projeto";
			PreparedStatement stm = conex.prepareStatement(sql);

			ResultSet resultSet = stm.executeQuery();
			if (resultSet.next()) {							
		       contador = resultSet.getInt("cont");				
			}

			resultSet.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar o: \n" + e.getMessage());
		}
		return contador;

	}

}
