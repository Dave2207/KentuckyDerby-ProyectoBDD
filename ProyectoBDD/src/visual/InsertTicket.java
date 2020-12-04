package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Horse;
import logic.Ticket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertTicket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	private JTextField txtPrecio;
	private JTextField txtBetHorse;
	private JTextField txtDateRace;
	private JTextField txtTimeRace;
	private JTextField txtDatePurchase;
	private JTextField txtTimePurchase;
	private JComboBox cbxModoPago;
	private JTextField txtRace;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			InsertTicket dialog = new InsertTicket();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public InsertTicket() {
		setTitle("Insertar Ticket");
		setBounds(100, 100, 405, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(43, 35, 71, 14);
			contentPanel.add(lblCdigo);
		}
		{
			txtCode = new JTextField();
			txtCode.setEnabled(false);
			txtCode.setEditable(false);
			txtCode.setBounds(180, 35, 86, 20);
			contentPanel.add(txtCode);
			txtCode.setColumns(10);
		}
		{
			JLabel lblModoDePago = new JLabel("Modo de Pago:");
			lblModoDePago.setBounds(43, 77, 103, 14);
			contentPanel.add(lblModoDePago);
		}
		
	    cbxModoPago = new JComboBox();
		cbxModoPago.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Modo>", "Efectivo", "Tarjeta "}));
		cbxModoPago.setBounds(180, 77, 131, 20);
		contentPanel.add(cbxModoPago);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(43, 125, 46, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(180, 125, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCaballoApostado = new JLabel("Caballo Apostado:");
		lblCaballoApostado.setBounds(43, 171, 103, 14);
		contentPanel.add(lblCaballoApostado);
		
		txtBetHorse = new JTextField();
		txtBetHorse.setBounds(180, 168, 131, 20);
		contentPanel.add(txtBetHorse);
		txtBetHorse.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha Carrera:");
		lblFecha.setBounds(43, 261, 103, 14);
		contentPanel.add(lblFecha);
		
		txtDateRace = new JTextField();
		txtDateRace.setBounds(180, 258, 86, 20);
		contentPanel.add(txtDateRace);
		txtDateRace.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora Carrera:");
		lblHora.setBounds(43, 308, 103, 14);
		contentPanel.add(lblHora);
		
		txtTimeRace = new JTextField();
		txtTimeRace.setBounds(180, 305, 86, 20);
		contentPanel.add(txtTimeRace);
		txtTimeRace.setColumns(10);
		
		JLabel lblFechaCompra = new JLabel("Fecha Compra:");
		lblFechaCompra.setBounds(43, 351, 103, 14);
		contentPanel.add(lblFechaCompra);
		
		txtDatePurchase = new JTextField();
		txtDatePurchase.setBounds(180, 348, 86, 20);
		contentPanel.add(txtDatePurchase);
		txtDatePurchase.setColumns(10);
		
		JLabel lblHoraCompra = new JLabel("Hora Compra:");
		lblHoraCompra.setBounds(43, 393, 86, 14);
		contentPanel.add(lblHoraCompra);
		
		txtTimePurchase = new JTextField();
		txtTimePurchase.setBounds(180, 390, 86, 20);
		contentPanel.add(txtTimePurchase);
		txtTimePurchase.setColumns(10);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(43, 216, 46, 14);
		contentPanel.add(lblCarrera);
		
		txtRace = new JTextField();
		txtRace.setBounds(180, 213, 86, 20);
		contentPanel.add(txtRace);
		txtRace.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Ticket boleto = new Ticket(Integer.parseInt(txtCode.getText()), cbxModoPago.getSelectedItem().toString(), Float.parseFloat(txtPrecio.getText()), txtBetHorse.getText(), Integer.parseInt(txtRace.getText()), txtDateRace.getText(), txtTimeRace.getText(), txtDatePurchase.getText(), txtTimePurchase.getText());
						Derby.getInstance().registrarTicket(boleto);
						SQLDatabaseConnection.registrarTicketSQL(boleto.getCode(), boleto.getPaymentMode(), boleto.getPrice(), boleto.getRace(), boleto.getBetHorse(), boleto.getDateRace(), boleto.getTimeRace(), boleto.getDatePurchase(), boleto.getTimePurchase());
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
		txtCode.setText(Integer.valueOf(Derby.getGenCodTicket()).toString());
		txtBetHorse.setText("");
		txtPrecio.setText("");
		txtRace.setText("");
		txtDateRace.setText("");
		txtTimeRace.setText("");
		txtDatePurchase.setText("");
		txtTimePurchase.setText("");
		cbxModoPago.setSelectedIndex(-1);
		
	}
}
