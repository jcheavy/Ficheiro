package ficheiro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Conexao {

	private Connection conn;    
	private static Conexao conexaoInstance;
	
	 //jdbc:sqlite:ficheiro.db";

	private Conexao() {

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:ficheiro.db");
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro na conexão com o banco :" + e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Erro ao fechar a conexão com o banco :" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static Conexao getInstance() {
		
		if (conexaoInstance == null) {
			conexaoInstance = new Conexao();
		}

		return conexaoInstance;
	}
	
	
}
