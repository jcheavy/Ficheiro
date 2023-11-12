package ficheiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ficheiro.database.Conexao;
import ficheiro.entities.Produto;

public class ProdutoDAO implements GenericDAO<Produto> {

	private Connection conex;
    private Statement statement;
	public ProdutoDAO() {
		conex = Conexao.getInstance().getConnection();
		try {Statement statement = conex.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("create table if not exits projeto (id integer, nome string, dataInicio date, dataFim date, dx integer, dy integer, index integer)");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void adiciona(Produto entidade) {

		try {
			String sql = "INSERT INTO projeto VALUES(?,?,?)";
			PreparedStatement stm = conex.prepareStatement(sql);
			stm.setInt(1, entidade.getId());
			stm.setString(2, entidade.getNome());
			stm.setString(3, entidade.getTelefone());

			// executar
			stm.execute();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar adicionar " + e.getMessage());
		}
	}

	@Override
	public void altera(Produto entidade) {

		try {
			String sql = "UPDATE projeto SET nome = ?, telefone = ? WHERE id = ?";
			PreparedStatement stm = conex.prepareStatement(sql);
			stm.setInt(1, entidade.getId());
			stm.setString(2, entidade.getNome());
			stm.setString(3, entidade.getTelefone());

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
	public Produto listaPorID(Object iD) {
		Produto produto = null;
		try {

			String sql = "SELECT nome, telefone FROM projeto WHERE id = ?";
			PreparedStatement stm = conex.prepareStatement(sql);

			stm.setObject(1, iD);

			ResultSet resultSet = stm.executeQuery();
			if (resultSet.next()) {
				produto = new Produto();
				produto.setId((Integer) iD);
				produto.setNome(resultSet.getString(1));
				produto.setTelefone(resultSet.getString(2));
			}

			resultSet.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar o: \n" + e.getMessage());
		}
		return produto;
	}

	@Override
	public List<Produto> listaTudo() {

		List<Produto> produtos = new ArrayList();
		try {

			String sql = "SELECT id, nome, telefone FROM projeto ORDER BY id";
			PreparedStatement stm = conex.prepareStatement(sql);

			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				Produto produto = new Produto();
				produto.setId(resultSet.getInt(1));
				produto.setNome(resultSet.getString(2));
				produto.setTelefone(resultSet.getString(3));

				produtos.add(produto);
			}

			resultSet.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar o: \n" + e.getMessage());
		}
		return produtos;

	}

}
