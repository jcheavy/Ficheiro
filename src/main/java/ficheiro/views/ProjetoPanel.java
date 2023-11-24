package ficheiro.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ficheiro.utilz.Comp;

public class ProjetoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel titulo;
	private JLabel descricao;
	private int offsetX, offsetY;

	private JButton btAddTarefa;

	private JPanel listPanel;
	private JPanel topPanel;

	public ProjetoPanel() {

		GridLayout layout = new GridLayout(100, 1);

		this.setPreferredSize(new Dimension(210, 400));
		this.setLayout(new BorderLayout());

		titulo = new JLabel();
		descricao = new JLabel("Um breve descição da tarefa");

		topPanel = new JPanel(new GridLayout(3, 1));

		listPanel = new JPanel();
		listPanel.setLayout(layout);
		
		JScrollPane scrollPane = new JScrollPane(listPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		btAddTarefa = Comp.btQuad("  Adicionar Tarefa");

		topPanel.add(titulo);
		topPanel.add(btAddTarefa);
		
		

		this.add(topPanel, BorderLayout.NORTH);

		this.add(listPanel, BorderLayout.CENTER);
	}
	
	public void setTitulo(String titulo) {
		this.titulo.setText(titulo);
	}

}
