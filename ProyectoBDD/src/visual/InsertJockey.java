package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertJockey extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdJockey;
	private JTextField txtNombreJockey;
	private JTextField txtApellidoJockey;
	private JTextField txtStateResJockey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertJockey dialog = new InsertJockey();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertJockey() {
		setResizable(false);
		setTitle("Registro Jockey");
		setBounds(100, 100, 422, 297);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(22, 25, 46, 14);
			contentPanel.add(lblId);
		}
		{
			txtIdJockey = new JTextField();
			txtIdJockey.setEditable(false);
			txtIdJockey.setEnabled(false);
			txtIdJockey.setBounds(88, 22, 86, 20);
			contentPanel.add(txtIdJockey);
			txtIdJockey.setColumns(10);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(22, 56, 64, 14);
			contentPanel.add(label);
		}
		{
			txtNombreJockey = new JTextField();
			txtNombreJockey.setColumns(10);
			txtNombreJockey.setBounds(88, 53, 312, 20);
			contentPanel.add(txtNombreJockey);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(22, 87, 64, 14);
			contentPanel.add(label);
		}
		{
			txtApellidoJockey = new JTextField();
			txtApellidoJockey.setColumns(10);
			txtApellidoJockey.setBounds(88, 84, 312, 20);
			contentPanel.add(txtApellidoJockey);
		}
		{
			JLabel label = new JLabel("State Residence:");
			label.setBounds(22, 185, 109, 14);
			contentPanel.add(label);
		}
		{
			txtStateResJockey = new JTextField();
			txtStateResJockey.setColumns(10);
			txtStateResJockey.setBounds(137, 182, 263, 20);
			contentPanel.add(txtStateResJockey);
		}
		{
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(243, 127, 52, 14);
			contentPanel.add(lblGnero);
		}
		{
			JLabel lblNewLabel = new JLabel("Carreras Ganadas:");
			lblNewLabel.setBounds(22, 129, 109, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPeso = new JLabel("Peso (kg):");
			lblPeso.setBounds(22, 154, 86, 14);
			contentPanel.add(lblPeso);
		}
		
		JRadioButton rdbtnGenMasc = new JRadioButton("M");
		rdbtnGenMasc.setBounds(293, 123, 46, 23);
		contentPanel.add(rdbtnGenMasc);
		
		JRadioButton rdbtnGenFem = new JRadioButton("F");
		rdbtnGenFem.setBounds(341, 123, 46, 23);
		contentPanel.add(rdbtnGenFem);
		
		JSpinner spnWonRaces = new JSpinner();
		spnWonRaces.setBounds(137, 126, 70, 20);
		contentPanel.add(spnWonRaces);
		
		JSpinner spnWeight = new JSpinner();
		spnWeight.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(100), new Float(1)));
		spnWeight.setBounds(137, 151, 70, 20);
		contentPanel.add(spnWeight);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
}
