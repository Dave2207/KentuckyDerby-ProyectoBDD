package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Jockey;
import logic.Jockey;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListadoJockey extends JDialog {
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private int code;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoJockey dialog = new ListadoJockey();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoJockey() {
		setTitle("Listado de Jinetes");
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
						Jockey jockey = Derby.getInstance().FindJockeyByID(code);
						Derby.getInstance().eliminarJockey(jockey);
						SQLDatabaseConnection.EliminarEmpleadoSQL(code);
						loadJockeys();
						btnEliminar.setEnabled(false);
					}
				});
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
						int index = table.getSelectedRow();
						code = (int)table.getModel().getValueAt(index, 0);
					}
				}
			});
			scrollPane.setViewportView(table);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"ID", "Nombre", "Apellido", "Genero","Esatdo de Residencia", "Carreras Ganadas", "Años de Experiencia", "Peso"};
			tableModel.setColumnIdentifiers(columnNames);
			loadJockeys();
		}
	}
	
	public static void loadJockeys() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Jockey jockey : Derby.getInstance().getJockeys()) {
			fila[0] = jockey.getJockeyID();
			fila[1] = jockey.getFirstName();
			fila[2] = jockey.getLastName();
			fila[3] = jockey.getGender();
			fila[4] = jockey.getStateResidence();
			fila[5] = jockey.getJockeyWeight();
			
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(5).setPreferredWidth(104);
	}
}

