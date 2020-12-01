package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Jockey;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertJockey extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdJockey;
	private JTextField txtNombreJockey;
	private JTextField txtApellidoJockey;
	private JTextField txtStateResJockey;
	private JRadioButton rdbtnGenMasc;
	private JRadioButton rdbtnGenFem;
	private JSpinner spnWonRaces;
	private JSpinner spnWeight;
	private JSpinner spnEdad;

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
			txtIdJockey.setText(Integer.valueOf(Derby.getGenCodJockey()).toString());
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
		
		rdbtnGenMasc = new JRadioButton("M");
		rdbtnGenMasc.setSelected(true);
		rdbtnGenMasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnGenMasc.isSelected()) {
					rdbtnGenMasc.setSelected(true);
					rdbtnGenFem.setSelected(false);
				}
			}
		});
		rdbtnGenMasc.setBounds(293, 123, 46, 23);
		contentPanel.add(rdbtnGenMasc);
		
		rdbtnGenFem = new JRadioButton("F");
		rdbtnGenFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnGenFem.isSelected()) {
					rdbtnGenMasc.setSelected(false);
					rdbtnGenFem.setSelected(true);
				}
			}
		});
		rdbtnGenFem.setBounds(341, 123, 46, 23);
		contentPanel.add(rdbtnGenFem);
		
		spnWonRaces = new JSpinner();
		spnWonRaces.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnWonRaces.setBounds(137, 126, 70, 20);
		contentPanel.add(spnWonRaces);
		
		spnWeight = new JSpinner();
		spnWeight.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spnWeight.setBounds(137, 151, 70, 20);
		contentPanel.add(spnWeight);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(243, 155, 46, 13);
		contentPanel.add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnEdad.setBounds(293, 151, 46, 20);
		contentPanel.add(spnEdad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnGenMasc.isSelected()) {
							Jockey jockey = new Jockey(Integer.parseInt(txtIdJockey.getText()), txtNombreJockey.getText(), txtApellidoJockey.getText(), "M", txtStateResJockey.getText(), (int) spnWonRaces.getValue(), (int) spnEdad.getValue(), (int) spnWeight.getValue());
							Derby.getInstance().registrarJockey(jockey);
							SQLDatabaseConnection.registrarJineteSQL(jockey.getFirstName(), jockey.getLastName(), jockey.getGender(), jockey.getStateResidence(), jockey.getWonRaces(), jockey.getYearsOfExp(), jockey.getJockeyWeight());
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if(rdbtnGenFem.isSelected()) {
							Jockey jockey = new Jockey(Integer.parseInt(txtIdJockey.getText()), txtNombreJockey.getText(), txtApellidoJockey.getText(), "F", txtStateResJockey.getText(), (int) spnWonRaces.getValue(), (int) spnEdad.getValue(), (int) spnWeight.getValue());
							Derby.getInstance().registrarJockey(jockey);
							SQLDatabaseConnection.registrarJineteSQL(jockey.getFirstName(), jockey.getLastName(), jockey.getGender(), jockey.getStateResidence(), jockey.getWonRaces(), jockey.getYearsOfExp(), jockey.getJockeyWeight());
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
					}
				});
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
	public void clean() {
		txtIdJockey.setText(Integer.valueOf(Derby.getGenCodJockey()).toString());
		txtNombreJockey.setText("");
		txtApellidoJockey.setText("");
		txtStateResJockey.setText("");
		spnEdad.setValue(0);
		spnWeight.setValue(1);
		spnWonRaces.setValue(0);
	}
}
