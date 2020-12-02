package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Derby;
import logic.RaceEntry;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertRaceEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtGateNumber;
	private JTextField txtJockey;
	private JTextField txtHorse;
	private JTextField txtMargins;
	private JTextField txtFinishPos;
	private JTextField txtTimeElapsed;
	private JTextField txtMLineOdds;
	private JTextField txtFinalOdds;
	private JTextField txtAmountWon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertRaceEntry dialog = new InsertRaceEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertRaceEntry() {
		setTitle("Registrar Entrada de Carrera");
		setBounds(100, 100, 383, 513);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblGateNo = new JLabel("Gate No.");
			lblGateNo.setBounds(25, 48, 78, 14);
			contentPanel.add(lblGateNo);
		}
		{
			txtGateNumber = new JTextField();
			txtGateNumber.setEnabled(false);
			txtGateNumber.setEditable(false);
			txtGateNumber.setBounds(156, 45, 86, 20);
			contentPanel.add(txtGateNumber);
			txtGateNumber.setColumns(10);
			txtGateNumber.setText(Integer.valueOf(Derby.getGenCodRaceEntry()).toString());
		}
		{
			JLabel lblJinete = new JLabel("Jinete:");
			lblJinete.setBounds(25, 87, 78, 14);
			contentPanel.add(lblJinete);
		}
		{
			txtJockey = new JTextField();
			txtJockey.setBounds(156, 87, 181, 20);
			contentPanel.add(txtJockey);
			txtJockey.setColumns(10);
		}
		{
			JLabel lblCaballo = new JLabel("Caballo:");
			lblCaballo.setBounds(25, 126, 105, 14);
			contentPanel.add(lblCaballo);
		}
		{
			txtHorse = new JTextField();
			txtHorse.setBounds(156, 126, 181, 20);
			contentPanel.add(txtHorse);
			txtHorse.setColumns(10);
		}
		{
			JLabel lblMrgenes = new JLabel("M\u00E1rgenes:");
			lblMrgenes.setBounds(25, 170, 94, 14);
			contentPanel.add(lblMrgenes);
		}
		{
			txtMargins = new JTextField();
			txtMargins.setBounds(156, 170, 86, 20);
			contentPanel.add(txtMargins);
			txtMargins.setColumns(10);
		}
		{
			JLabel lblPosicinFinal = new JLabel("Posici\u00F3n Final:");
			lblPosicinFinal.setBounds(22, 215, 108, 14);
			contentPanel.add(lblPosicinFinal);
		}
		{
			txtFinishPos = new JTextField();
			txtFinishPos.setBounds(156, 215, 86, 20);
			contentPanel.add(txtFinishPos);
			txtFinishPos.setColumns(10);
		}
		{
			JLabel lblTiempo = new JLabel("Tiempo:");
			lblTiempo.setBounds(25, 255, 61, 14);
			contentPanel.add(lblTiempo);
		}
		{
			txtTimeElapsed = new JTextField();
			txtTimeElapsed.setBounds(156, 255, 86, 20);
			contentPanel.add(txtTimeElapsed);
			txtTimeElapsed.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Morning Line Odds:");
			lblNewLabel.setBounds(25, 346, 121, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtMLineOdds = new JTextField();
			txtMLineOdds.setColumns(10);
			txtMLineOdds.setBounds(156, 343, 86, 20);
			contentPanel.add(txtMLineOdds);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Final Odds:");
			lblNewLabel_1.setBounds(25, 389, 105, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtFinalOdds = new JTextField();
			txtFinalOdds.setColumns(10);
			txtFinalOdds.setBounds(156, 386, 86, 20);
			contentPanel.add(txtFinalOdds);
		}
		{
			JLabel lblCantidadGanada = new JLabel("Cantidad Ganada:");
			lblCantidadGanada.setBounds(25, 299, 121, 14);
			contentPanel.add(lblCantidadGanada);
		}
		{
			txtAmountWon = new JTextField();
			txtAmountWon.setBounds(156, 296, 86, 20);
			contentPanel.add(txtAmountWon);
			txtAmountWon.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RaceEntry entry = new RaceEntry(Integer.parseInt(txtGateNumber.getText()), txtJockey.getText(), txtHorse.getText(), Integer.parseInt(txtMargins.getText()), Integer.parseInt(txtFinishPos.getText()), Integer.parseInt(txtTimeElapsed.getText()), Integer.parseInt(txtAmountWon.getText()), Integer.parseInt(txtMLineOdds.getText()), Integer.parseInt(txtFinalOdds.getText()));
						Derby.getInstance().registrarRaceEntry(entry);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void clean() {
		txtGateNumber.setText(Integer.valueOf(Derby.getGenCodRaceEntry()).toString());
		txtJockey.setText("");
		txtHorse.setText("");
		txtMargins.setText("");
		txtFinishPos.setText("");
		txtTimeElapsed.setText("");
		txtAmountWon.setText("");
		txtMLineOdds.setText("");
		txtFinalOdds.setText("");
		
	}
	
}
