package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logic.Derby;
import logic.Employee;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaEmpleados extends JDialog {
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
			ListaEmpleados dialog = new ListaEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaEmpleados() {
		setTitle("Listado de Empleados");
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
			String[] columnNames = {"ID", "Nombre", "Apellido", "Edad", "Genero","Posicion"};
			tableModel.setColumnIdentifiers(columnNames);
			loadEmpleados();
		}
	}
	
	public static void loadEmpleados() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Employee emp : Derby.getInstance().getEmployees()) {
			fila[0] = emp.getID();
			fila[1] = emp.getFirstName();
			fila[2] = emp.getLastName();
			fila[3] = emp.getAge();
			fila[4] = emp.getGender();
			fila[5] = emp.getPosition();
			
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
