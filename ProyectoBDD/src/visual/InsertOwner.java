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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setResizable(false);
		setTitle("Registro Owner");
		setBounds(100, 100, 429, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel label = new JLabel("ID: ");
			label.setBounds(28, 32, 62, 14);
			contentPanel.add(label);
		}
		{
			txtIdOwner = new JTextField();
			txtIdOwner.setEnabled(false);
			txtIdOwner.setEditable(false);
			txtIdOwner.setColumns(10);
			txtIdOwner.setBounds(134, 29, 86, 20);
			contentPanel.add(txtIdOwner);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(28, 63, 86, 14);
			contentPanel.add(label);
		}
		{
			txtNombreOwner = new JTextField();
			txtNombreOwner.setColumns(10);
			txtNombreOwner.setBounds(134, 60, 186, 20);
			contentPanel.add(txtNombreOwner);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(28, 88, 86, 14);
			contentPanel.add(label);
		}
		{
			txtApellidoOwner = new JTextField();
			txtApellidoOwner.setColumns(10);
			txtApellidoOwner.setBounds(134, 85, 186, 20);
			contentPanel.add(txtApellidoOwner);
		}
		{
			JLabel label = new JLabel("State Residence:");
			label.setBounds(28, 119, 107, 14);
			contentPanel.add(label);
		}
		{
			txtStateResOwner = new JTextField();
			txtStateResOwner.setColumns(10);
			txtStateResOwner.setBounds(134, 116, 263, 20);
			contentPanel.add(txtStateResOwner);
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
