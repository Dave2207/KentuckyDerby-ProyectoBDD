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
import logic.Horse;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaCaballos extends JDialog {
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private String code;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaCaballos dialog = new ListaCaballos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCaballos() {
		setTitle("Listado de Caballos");
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
						Horse horse = Derby.getInstance().FindHorseByName(code);
						Derby.getInstance().eliminarCaballo(horse);
						SQLDatabaseConnection.EliminarCaballoSQL(code);
						JOptionPane.showMessageDialog(null, "Se ha borrado este registro", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						loadHorses();
						btnEliminar.setEnabled(false);
					}
				});
				{
					JButton btnModificar = new JButton("Modificar");
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
						int index = table.getSelectedRow();
						code = (String)table.getModel().getValueAt(index, 0);
					}
				}
			});
			scrollPane.setViewportView(table);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Nombre", "Establo", "Genero", "Edad", "Equipo","Score", "Carreras Ganadas", "Raza"};
			tableModel.setColumnIdentifiers(columnNames);
			loadHorses();
		}
	}
	
	public static void loadHorses() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Horse h : Derby.getInstance().getHorses()) {
			fila[0] = h.getHorseName();
			fila[1] = h.getBarn();
			fila[2] = h.getGender();
			fila[3] = h.getAge();
			fila[4] = h.getGear();
			fila[5] = h.getScore();
			fila[6] = h.getWonRaces();
			fila[7] = h.getBreed();
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		//TableColumnModel columnModel = table.getColumnModel();
	}
}
