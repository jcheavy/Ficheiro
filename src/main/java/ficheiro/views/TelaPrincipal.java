package ficheiro.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ficheiro.utilz.Comp;

public class TelaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel panelPrincipal;
	private JPanel panelEsquerdo;
	private JButton btAdd;
	private int panelCount = 0;
	
	public TelaPrincipal() {
		
	  panelPrincipal = new JPanel(new FlowLayout());
	  
	  panelEsquerdo =  new JPanel(new FlowLayout());
	  panelEsquerdo.setPreferredSize(new Dimension(180,500));
	  panelEsquerdo.setBackground(Comp.azul);
	  
	  btAdd = Comp.btQuad("Adicionar");
	  
	  panelEsquerdo.add(btAdd);
	  
	  //setSize(800,500);
	  setLayout(new BorderLayout());
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  
	  add(panelPrincipal, BorderLayout.CENTER);
	  add(panelEsquerdo, BorderLayout.WEST);
	  
	  btAdd.addActionListener(ev ->{
		  addPanelTarefa();
	  });
	  
	  resolution();
	  setVisible(true);
	 
	  
	}
	
	private void resolution() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension dimension = t.getScreenSize();
		setSize((dimension.width + 5), (dimension.height - 38));
	}
	
	private void addPanelTarefa() {
		
		TelaDados dados = new TelaDados(this, true);
		
		
	}

}
