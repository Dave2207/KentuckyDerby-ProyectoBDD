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
import javax.swing.border.TitledBorder;

import logic.Derby;
import logic.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdEmp;
	private JTextField txtStateResEmp;
	private JTextField txtNombreEmp;
	private JTextField txtApellidoEmp;
	private JTextField txtFechaNac;
	private JSpinner spnEdad;
	private JTextField txtZipCode;
	private JRadioButton rdbnGenMasc;
	private JRadioButton rdbnGenFem;
	private JComboBox cbxPos;

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
		setResizable(false);
		setTitle("Registro Empleado\r\n");
		setBounds(100, 100, 443, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("ID:");
			label.setBounds(34, 21, 46, 14);
			contentPanel.add(label);
		}
		{
			txtIdEmp = new JTextField();
			txtIdEmp.setEditable(false);
			txtIdEmp.setEnabled(false);
			txtIdEmp.setColumns(10);
			txtIdEmp.setBounds(149, 18, 86, 20);
			contentPanel.add(txtIdEmp);
			txtIdEmp.setText(Integer.valueOf(Derby.getGenCodEmp()).toString());
		}
		{
			JLabel label = new JLabel("State Residence:");
			label.setBounds(34, 165, 109, 14);
			contentPanel.add(label);
		}
		{
			txtStateResEmp = new JTextField();
			txtStateResEmp.setColumns(10);
			txtStateResEmp.setBounds(149, 164, 263, 20);
			contentPanel.add(txtStateResEmp);
		}
		{
			txtNombreEmp = new JTextField();
			txtNombreEmp.setColumns(10);
			txtNombreEmp.setBounds(149, 49, 263, 20);
			contentPanel.add(txtNombreEmp);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(34, 52, 86, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(34, 77, 86, 14);
			contentPanel.add(label);
		}
		{
			txtApellidoEmp = new JTextField();
			txtApellidoEmp.setColumns(10);
			txtApellidoEmp.setBounds(149, 74, 263, 20);
			contentPanel.add(txtApellidoEmp);
		}
		{
			JLabel label = new JLabel("G\u00E9nero:");
			label.setBounds(34, 105, 86, 14);
			contentPanel.add(label);
		}
		{
			rdbnGenMasc = new JRadioButton("M");
			rdbnGenMasc.setSelected(true);
			rdbnGenMasc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbnGenMasc.setSelected(true);
					rdbnGenFem.setSelected(false);
				}
			});
			rdbnGenMasc.setBounds(149, 101, 46, 23);
			contentPanel.add(rdbnGenMasc);
		}
		{
			rdbnGenFem = new JRadioButton("F");
			rdbnGenFem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbnGenMasc.setSelected(false);
					rdbnGenFem.setSelected(true);
				}
			});
			rdbnGenFem.setBounds(206, 101, 46, 23);
			contentPanel.add(rdbnGenFem);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(34, 196, 95, 14);
			contentPanel.add(lblPosicin);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setBounds(290, 105, 46, 14);
			contentPanel.add(label);
		}
		{
			spnEdad = new JSpinner();
			spnEdad.setBounds(342, 102, 70, 20);
			contentPanel.add(spnEdad);
		}
		{
			JLabel label = new JLabel("Fecha Nacimiento:");
			label.setBounds(34, 139, 109, 14);
			contentPanel.add(label);
		}
		{
			txtFechaNac = new JTextField();
			txtFechaNac.setColumns(10);
			txtFechaNac.setBounds(149, 133, 263, 20);
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
			txtZipCode.setBounds(149, 226, 263, 20);
			contentPanel.add(txtZipCode);
		}
		
		cbxPos = new JComboBox();
		cbxPos.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione la posicion>", "Veterinario Equino", "Manager", "Cuidador de Caballos", "Taquillero", "Fot\u00F3grafo Ecuestre"}));
		cbxPos.setBounds(149, 195, 263, 20);
		contentPanel.add(cbxPos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbnGenMasc.isSelected()) {
							Employee emp = new Employee(Integer.parseInt(txtIdEmp.getText()), txtNombreEmp.getText(), txtApellidoEmp.getText(), Integer.parseInt(spnEdad.getValue().toString()), txtFechaNac.getText(), "M", cbxPos.getSelectedItem().toString(), Integer.parseInt(txtZipCode.getText()));
							Derby.getInstance().registrarEmpleado(emp);
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
						if(rdbnGenFem.isSelected()) {
							Employee emp = new Employee(Integer.parseInt(txtIdEmp.getText()), txtNombreEmp.getText(), txtApellidoEmp.getText(), Integer.parseInt(spnEdad.getValue().toString()), txtFechaNac.getText(), "F", cbxPos.getSelectedItem().toString(), Integer.parseInt(txtZipCode.getText()));
							Derby.getInstance().registrarEmpleado(emp);
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
		txtIdEmp.setText(Integer.valueOf(Derby.getGenCodEmp()).toString());
		txtNombreEmp.setText("");
		txtApellidoEmp.setText("");
		txtFechaNac.setText("");
		txtStateResEmp.setText("");
		txtZipCode.setText("");
		cbxPos.setSelectedIndex(-1);
		spnEdad.setValue(0);
	}
}
