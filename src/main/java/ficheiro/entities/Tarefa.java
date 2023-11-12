package ficheiro.entities;

import java.awt.Dimension;

public class Tarefa {
	
	private Integer id;
	private String nome;
	private String cor;
	private int dx;
	private int dy;
	private int index;
	
	public Tarefa() {}

	public Tarefa(Integer id, String nome, String cor, int dx, int dy, int index) {
	
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.dx = dx;
		this.dy = dy;
		this.index = index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", cor=" + cor + ", dx=" + dx + ", dy=" + dy + ", index=" + index
				+ "]";
	}
	
	
	

}
