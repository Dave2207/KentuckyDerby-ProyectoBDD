package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Ticket;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaTickets extends JDialog {
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private static JButton btnModificar;
	private int code;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaTickets dialog = new ListaTickets();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaTickets() {
		setTitle("Listado de Tickets");
		setResizable(false);
		setBounds(100, 100, 538, 349);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Ticket ticket = Derby.getInstance().FindTicketByID(code);
						Derby.getInstance().eliminarTicket(ticket);
						SQLDatabaseConnection.EliminarTicketSQL(code);
						JOptionPane.showMessageDialog(null, "Se ha borrado este registro", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						loadTickets();
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow()>=0) {
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						int index = table.getSelectedRow();
						code = (int)table.getModel().getValueAt(index, 0);
					}
				}
			});
			scrollPane.setViewportView(table);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"C�digo", "Modo de Pago", "Precio", "Caballo Apostado", "Fecha de la Carrera", "Hora de la Carrera", "Fecha de Compra", "Hora de Compra"};
			tableModel.setColumnIdentifiers(columnNames);
			loadTickets();
		}
	}
	
	public static void loadTickets() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Ticket ticket : Derby.getInstance().getTickets()) {
			fila[0] = ticket.getCode();
			fila[1] = ticket.getPaymentMode();
			fila[2] = ticket.getPrice();
			fila[3] = ticket.getBetHorse();
			fila[4] = ticket.getDateRace();
			fila[5] = ticket.getTimeRace();
			fila[6] = ticket.getDatePurchase();
			fila[7] = ticket.getTimePurchase();
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		//TableColumnModel columnModel = table.getColumnModel();
	}
}

