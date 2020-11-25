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
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdEmp;
	private JTextField txtStateResEmp;
	private JTextField txtNombreEmp;
	private JTextField txtApellidoEmp;
	private JTextField txtPosEmp;
	private JTextField txtFechaNac;
	private JSpinner spnEdad;
	private JTextField txtZipCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertEmployee dialog = new InsertEmployee();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertEmployee() {
		setTitle("Registro Empleado\r\n");
		setBounds(100, 100, 443, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("ID:");
			label.setBounds(34, 21, 46, 14);
			contentPanel.add(label);
		}
		{
			txtIdEmp = new JTextField();
			txtIdEmp.setEnabled(false);
			txtIdEmp.setEditable(false);
			txtIdEmp.setColumns(10);
			txtIdEmp.setBounds(139, 18, 86, 20);
			contentPanel.add(txtIdEmp);
		}
		{
			JLabel label = new JLabel("State Residence:");
			label.setBounds(34, 165, 86, 14);
			contentPanel.add(label);
		}
		{
			txtStateResEmp = new JTextField();
			txtStateResEmp.setColumns(10);
			txtStateResEmp.setBounds(139, 164, 263, 20);
			contentPanel.add(txtStateResEmp);
		}
		{
			txtNombreEmp = new JTextField();
			txtNombreEmp.setColumns(10);
			txtNombreEmp.setBounds(139, 49, 263, 20);
			contentPanel.add(txtNombreEmp);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(34, 52, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(34, 77, 46, 14);
			contentPanel.add(label);
		}
		{
			txtApellidoEmp = new JTextField();
			txtApellidoEmp.setColumns(10);
			txtApellidoEmp.setBounds(139, 74, 263, 20);
			contentPanel.add(txtApellidoEmp);
		}
		{
			JLabel label = new JLabel("G\u00E9nero:");
			label.setBounds(34, 105, 52, 14);
			contentPanel.add(label);
		}
		{
			JRadioButton rdbnGenMasc = new JRadioButton("M");
			rdbnGenMasc.setBounds(139, 101, 46, 23);
			contentPanel.add(rdbnGenMasc);
		}
		{
			JRadioButton rdbnGenFem = new JRadioButton("F");
			rdbnGenFem.setBounds(193, 101, 46, 23);
			contentPanel.add(rdbnGenFem);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(34, 196, 86, 14);
			contentPanel.add(lblPosicin);
		}
		{
			txtPosEmp = new JTextField();
			txtPosEmp.setColumns(10);
			txtPosEmp.setBounds(139, 195, 263, 20);
			contentPanel.add(txtPosEmp);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setBounds(276, 109, 46, 14);
			contentPanel.add(label);
		}
		{
			spnEdad = new JSpinner();
			spnEdad.setBounds(332, 106, 70, 20);
			contentPanel.add(spnEdad);
		}
		{
			JLabel label = new JLabel("Fecha Nacimiento:");
			label.setBounds(34, 139, 101, 14);
			contentPanel.add(label);
		}
		{
			txtFechaNac = new JTextField();
			txtFechaNac.setColumns(10);
			txtFechaNac.setBounds(139, 134, 263, 20);
			contentPanel.add(txtFechaNac);
		}
		{
			JLabel lblZipCode = new JLabel("ZIP Code:");
			lblZipCode.setBounds(34, 229, 86, 14);
			contentPanel.add(lblZipCode);
		}
		{
			txtZipCode = new JTextField();
			txtZipCode.setColumns(10);
			txtZipCode.setBounds(139, 226, 263, 20);
			contentPanel.add(txtZipCode);
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
