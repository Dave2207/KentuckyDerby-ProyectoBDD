package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertHorse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtGear;
	private JTextField txtNombreHorse;
	private JTextField txtEstablo;
	private JTextField txtBreed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertHorse dialog = new InsertHorse();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertHorse() {
		setTitle("Registro Horse");
		setBounds(100, 100, 424, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGear = new JLabel("Gear:");
			lblGear.setBounds(22, 111, 70, 14);
			contentPanel.add(lblGear);
		}
		{
			txtGear = new JTextField();
			txtGear.setColumns(10);
			txtGear.setBounds(78, 110, 316, 20);
			contentPanel.add(txtGear);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(22, 29, 46, 14);
			contentPanel.add(label);
		}
		{
			txtNombreHorse = new JTextField();
			txtNombreHorse.setColumns(10);
			txtNombreHorse.setBounds(78, 26, 186, 20);
			contentPanel.add(txtNombreHorse);
		}
		{
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(22, 139, 46, 14);
			contentPanel.add(lblEdad);
		}
		{
			JSpinner spnEdad = new JSpinner();
			spnEdad.setBounds(78, 136, 70, 20);
			contentPanel.add(spnEdad);
		}
		{
			JLabel lblEstablo = new JLabel("Establo:");
			lblEstablo.setBounds(22, 57, 46, 14);
			contentPanel.add(lblEstablo);
		}
		{
			txtEstablo = new JTextField();
			txtEstablo.setColumns(10);
			txtEstablo.setBounds(78, 54, 186, 20);
			contentPanel.add(txtEstablo);
		}
		{
			JLabel lblScore = new JLabel("Score:");
			lblScore.setBounds(266, 142, 52, 14);
			contentPanel.add(lblScore);
		}
		{
			JSpinner spnScore = new JSpinner();
			spnScore.setBounds(320, 138, 70, 20);
			contentPanel.add(spnScore);
		}
		{
			JLabel label = new JLabel("G\u00E9nero:");
			label.setBounds(22, 167, 52, 14);
			contentPanel.add(label);
		}
		{
			JRadioButton rdbnGenMasc = new JRadioButton("M");
			rdbnGenMasc.setBounds(78, 163, 46, 23);
			contentPanel.add(rdbnGenMasc);
		}
		{
			JRadioButton rdbnGenFem = new JRadioButton("F");
			rdbnGenFem.setBounds(135, 163, 46, 23);
			contentPanel.add(rdbnGenFem);
		}
		{
			JLabel label = new JLabel("Carreras Ganadas:");
			label.setBounds(215, 170, 98, 14);
			contentPanel.add(label);
		}
		{
			JSpinner spnWonRaces = new JSpinner();
			spnWonRaces.setBounds(320, 167, 70, 20);
			contentPanel.add(spnWonRaces);
		}
		{
			JLabel lblRaza = new JLabel("Raza:");
			lblRaza.setBounds(22, 85, 46, 14);
			contentPanel.add(lblRaza);
		}
		{
			txtBreed = new JTextField();
			txtBreed.setColumns(10);
			txtBreed.setBounds(78, 82, 186, 20);
			contentPanel.add(txtBreed);
		}
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
