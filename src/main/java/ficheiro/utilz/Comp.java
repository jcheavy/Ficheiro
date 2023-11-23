package ficheiro.utilz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;


public class Comp {
	
	/**
	 * classe fontes
	 */
	public static Font taoma_14 = new Font("Taoma", Font.PLAIN, 14);
	public static Font taoma_12 = new Font("Taoma", Font.PLAIN, 12);
	
	public static Font taoma_12_b = new Font("Taoma", Font.BOLD, 12);
	
	public static Font jokerman_20 = new Font("Jokerman", Font.PLAIN, 20);
	static int style = Font.BOLD | Font.ITALIC;

	public static Font gramond_30 = new Font("Garamond", style, 30);
	public static Font gramond_20 = new Font("Garamond", style, 20);
	public static Font gramond_15 = new Font("Garamond", style, 15);
	public static Font gramond_14 = new Font("Garamond", Font.BOLD, 14);
	public static Font gramond_13 = new Font("Garamond", Font.BOLD, 15);
	
	
	/**
	 * paleta de cores
	 */

	public static Color bege = new Color(231, 223, 213);
	public static Color verde = new Color(132, 169, 172);
	public static Color verdeoliva = new Color(59, 105, 120);
	public static Color azul = new Color(93, 210, 246);
	public static Color azul_esc = new Color(32, 64, 81);
	
	
	/**
	 * Button branco quadrado
	 * @param desc
	 * @return
	 */
	
	public static JButton btQuad(String desc) {
		JButton but = new JButton(desc);
		but.setPreferredSize(new Dimension(119, 30));
		but.setFont(taoma_14);
		but.setBackground(azul_esc);
		but.setForeground(Color.red);
		but.setBorder(javax.swing.BorderFactory.createLineBorder(verde, 1));
		but.setRequestFocusEnabled(false);
		but.setRolloverEnabled(false);
	    //but.setMargin(new Insets(2, 1000, 2, 14));
		return but;
	}
	
	
	
}
