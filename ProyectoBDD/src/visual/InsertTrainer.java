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
import javax.swing.border.TitledBorder;

import logic.Derby;
import logic.Trainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertTrainer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdTrainer;
	private JTextField txtNombreTrainer;
	private JTextField txtApellidoTrainer;
	private JTextField txtStateResTrainer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertTrainer dialog = new InsertTrainer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertTrainer() {
		setResizable(false);
		setTitle("Registro Trainer");
		setBounds(100, 100, 429, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(27, 36, 38, 14);
		contentPanel.add(lblId);
		
		txtIdTrainer = new JTextField();
		txtIdTrainer.setEnabled(false);
		txtIdTrainer.setEditable(false);
		txtIdTrainer.setBounds(133, 30, 86, 20);
		contentPanel.add(txtIdTrainer);
		txtIdTrainer.setColumns(10);
		txtIdTrainer.setText(Integer.valueOf(Derby.getGenCodTrainer()).toString());
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 64, 86, 14);
		contentPanel.add(lblNombre);
		
		txtNombreTrainer = new JTextField();
		txtNombreTrainer.setBounds(133, 61, 186, 20);
		contentPanel.add(txtNombreTrainer);
		txtNombreTrainer.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(27, 89, 86, 14);
		contentPanel.add(lblApellidos);
		
		txtApellidoTrainer = new JTextField();
		txtApellidoTrainer.setBounds(133, 86, 186, 20);
		contentPanel.add(txtApellidoTrainer);
		txtApellidoTrainer.setColumns(10);
		
		JLabel lblStateResidence = new JLabel("State Residence:");
		lblStateResidence.setBounds(27, 120, 108, 14);
		contentPanel.add(lblStateResidence);
		
		txtStateResTrainer = new JTextField();
		txtStateResTrainer.setBounds(133, 117, 263, 20);
		contentPanel.add(txtStateResTrainer);
		txtStateResTrainer.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Trainer tra = new Trainer(Integer.parseInt(txtIdTrainer.getText()), txtNombreTrainer.getText(), txtApellidoTrainer.getText(), txtStateResTrainer.getText());
						Derby.getInstance().registrarTrainer(tra);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
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
		txtIdTrainer.setText(Integer.valueOf(Derby.getGenCodTrainer()).toString());
		txtNombreTrainer.setText("");
		txtApellidoTrainer.setText("");
		txtStateResTrainer.setText("");
	}
}
