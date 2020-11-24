package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class InsertOwner extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdOwner;
	private JTextField txtNombreOwner;
	private JTextField txtApellidoOwner;
	private JTextField txtStateResOwner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertOwner dialog = new InsertOwner();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertOwner() {
		setTitle("Registro Owner");
		setBounds(100, 100, 486, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("ID: ");
			label.setBounds(97, 43, 18, 14);
			contentPanel.add(label);
		}
		{
			txtIdOwner = new JTextField();
			txtIdOwner.setEnabled(false);
			txtIdOwner.setEditable(false);
			txtIdOwner.setColumns(10);
			txtIdOwner.setBounds(125, 37, 86, 20);
			contentPanel.add(txtIdOwner);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(69, 71, 46, 14);
			contentPanel.add(label);
		}
		{
			txtNombreOwner = new JTextField();
			txtNombreOwner.setColumns(10);
			txtNombreOwner.setBounds(125, 68, 186, 20);
			contentPanel.add(txtNombreOwner);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(69, 96, 46, 14);
			contentPanel.add(label);
		}
		{
			txtApellidoOwner = new JTextField();
			txtApellidoOwner.setColumns(10);
			txtApellidoOwner.setBounds(125, 93, 186, 20);
			contentPanel.add(txtApellidoOwner);
		}
		{
			JLabel label = new JLabel("State Residence:");
			label.setBounds(29, 127, 86, 14);
			contentPanel.add(label);
		}
		{
			txtStateResOwner = new JTextField();
			txtStateResOwner.setColumns(10);
			txtStateResOwner.setBounds(125, 124, 263, 20);
			contentPanel.add(txtStateResOwner);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Owners", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 160, 449, 176);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
