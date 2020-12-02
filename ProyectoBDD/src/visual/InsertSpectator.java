package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Spectator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertSpectator extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTicketNo;
	private JTextField txtBetAmount;
	private JTextField txtAccountNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertSpectator dialog = new InsertSpectator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertSpectator() {
		setTitle("Registrar Espectador");
		setBounds(100, 100, 347, 251);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTicketNo = new JLabel("Ticket No:");
		lblTicketNo.setBounds(62, 37, 70, 14);
		contentPanel.add(lblTicketNo);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setBounds(185, 34, 86, 20);
		contentPanel.add(txtTicketNo);
		txtTicketNo.setColumns(10);
		
		JLabel lblCantidadApostada = new JLabel("Cantidad Apostada:");
		lblCantidadApostada.setBounds(62, 79, 122, 14);
		contentPanel.add(lblCantidadApostada);
		
		txtBetAmount = new JTextField();
		txtBetAmount.setBounds(185, 76, 86, 20);
		contentPanel.add(txtBetAmount);
		txtBetAmount.setColumns(10);
		
		JLabel lblNmeroDeCuenta = new JLabel("N\u00FAmero de Cuenta:");
		lblNmeroDeCuenta.setBounds(62, 121, 106, 14);
		contentPanel.add(lblNmeroDeCuenta);
		
		txtAccountNo = new JTextField();
		txtAccountNo.setBounds(185, 118, 86, 20);
		contentPanel.add(txtAccountNo);
		txtAccountNo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Spectator spec = new Spectator(Integer.parseInt(txtTicketNo.getText()), Integer.parseInt(txtBetAmount.getText()), Integer.parseInt(txtAccountNo.getText()));
						SQLDatabaseConnection.registrarEspectadorSQL(spec.getTicketNo(), spec.getBetAmount(), spec.getAccountNo());
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
		txtTicketNo.setText(Integer.valueOf(Derby.getGenCodSpectator()).toString());
		txtBetAmount.setText("");
		txtAccountNo.setText("");
		
	}
}
