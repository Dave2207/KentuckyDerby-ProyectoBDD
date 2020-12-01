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
import logic.RaceEntry;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaRaceEntry extends JDialog {
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
			ListaRaceEntry dialog = new ListaRaceEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaRaceEntry() {
		setTitle("Listado de Entradas");
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
						RaceEntry entry = Derby.getInstance().FindRaceEntryByID(code);
						Derby.getInstance().eliminarRaceEntry(entry);
						SQLDatabaseConnection.EliminarEntradaSQL(code);
						JOptionPane.showMessageDialog(null, "Se ha borrado este registro", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						loadEntry();
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
			String[] columnNames = {"Número de Puerta", "Nombre del Jinete", "Nombre del Caballo", "Márgenes", "Posición Final","Tiempo", "Cantidad Ganada", "Morning Line Odds", "Final Odds"};
			tableModel.setColumnIdentifiers(columnNames);
			loadEntry();
		}
	}
	
	public static void loadEntry() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (RaceEntry entry: Derby.getInstance().getRaceEntrys()) {
			fila[0] = entry.getGateNumber();
			fila[1] = entry.getJockeyName();
			fila[2] = entry.getHorseName();
			fila[3] = entry.getMargins();
			fila[4] = entry.getFinishPositon();
			fila[5] = entry.getTimeElapsed();
			fila[6] = entry.getAmountWon();
			fila[7] = entry.getMorningLineOdds();
			fila[8] = entry.getFinalOdds();
			
			
			
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
