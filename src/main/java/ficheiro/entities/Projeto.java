package ficheiro.entities;

import java.util.Date;

public class Projeto {

	private Integer id;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	
	private int dx;
	private int dy;
	private int numIndex;
	
	public Projeto() {}

	public Projeto(Integer id, String nome, Date dataInicio, Date dataFim, int dx, int dy, int index) {
	
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dx = dx;
		this.dy = dy;
		this.numIndex = index;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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

	public int getNumIndex() {
		return numIndex;
	}

	public void setNumIndex(int index) {
		this.numIndex = index;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", dx="
				+ dx + ", dy=" + dy + ", index=" + numIndex + "]";
	}
	
	
	
	
}
