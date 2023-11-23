package ficheiro.views;

import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import ficheiro.utilz.Comp;

public class TelaDados extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField txfNome;
	private JLabel lbNome;
	private JLabel lbDataInicio;
	private JLabel lbDataFim;
	private JButton btPicker;

	private DatePicker datePickerIni;
	private DatePicker datePickerFim;

	public TelaDados(JFrame frame, boolean modal) {
		super(frame, modal);
		setTitle("Dados do Projeto");
		getContentPane().setLayout(null);

		ImageIcon dateIcon = new ImageIcon(getClass().getResource("/imagens/datepickerbutton1.png"));

		lbNome = new JLabel("Nome :");
		lbNome.setFont(Comp.taoma_12_b);

		txfNome = new JTextField();
		txfNome.setFont(Comp.taoma_12);

		lbDataInicio = new JLabel("Inicio :");
		lbDataInicio.setFont(Comp.taoma_12_b);

		lbDataFim = new JLabel("Fim :");
		lbDataFim.setFont(Comp.taoma_12_b);

		datePickerIni = new DatePicker();
		datePickerIni.setDate(LocalDate.now());
		btPicker = datePickerIni.getComponentToggleCalendarButton();
		btPicker.setText("");
		btPicker.setIcon(dateIcon);

		datePickerFim = datePickerIcon(dateIcon);

		lbNome.setBounds(15, 20, 54, 20);
		txfNome.setBounds(74, 20, 190, 20);

		lbDataInicio.setBounds(15, 50, 70, 20);
		datePickerIni.setBounds(74, 50, 190, 30);

		lbDataFim.setBounds(15, 90, 90, 20);
		datePickerFim.setBounds(74, 90, 190, 30);

		getContentPane().add(lbNome);
		getContentPane().add(txfNome);
		getContentPane().add(lbDataInicio);
		getContentPane().add(datePickerIni);

		getContentPane().add(lbDataFim);
		getContentPane().add(datePickerFim);

		/// setLocationRelativeTo(null);
		setLocation(200, 200);
		setResizable(false);
		setSize(400, 200);
		setVisible(true);

	}

	public JTextField getTxfNome() {
		return txfNome;
	}

	public void setTxfNome(JTextField txfNome) {
		this.txfNome = txfNome;
	}

	public DatePicker getDatePickerIni() {
		return datePickerIni;
	}

	public void setDatePickerIni(DatePicker datePickerIni) {
		this.datePickerIni = datePickerIni;
	}

	public DatePicker getDatePickerFim() {
		return datePickerFim;
	}

	public void setDatePickerFim(DatePicker datePickerFim) {
		this.datePickerFim = datePickerFim;
	}

	public static DatePicker datePickerIcon(ImageIcon Icon) {
		DatePicker picker = new DatePicker();
		JButton btPicker = new JButton();
		picker.setDate(LocalDate.now());
		btPicker = picker.getComponentToggleCalendarButton();
		btPicker.setText("");
		btPicker.setIcon(Icon);
		return picker;
	}
}
