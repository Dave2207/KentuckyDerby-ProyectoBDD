package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Race;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaRaces extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Object[] fila;
	private static JButton btnEliminar;
	private static DefaultTableModel tableModel;
	private static JTable table;
	private static int code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaRaces dialog = new ListaRaces();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaRaces() {
		setTitle("Listado de Carreras");
		setResizable(false);
		setBounds(100, 100, 578, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Race race = Derby.getInstance().FindRaceByID(code);
						Derby.getInstance().eliminarRace(race);
						SQLDatabaseConnection.EliminarCarreraSQL(code);
						JOptionPane.showMessageDialog(null, "Se ha borrado este registro", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
						loadRaces();
						btnEliminar.setEnabled(false);
					}
				});
				{
					JButton btnModificar = new JButton("Modificar");
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				btnEliminar.setEnabled(false);
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
						code = (int) table.getModel().getValueAt(index, 0);
					}
				}
			});
			scrollPane.setViewportView(table);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"ID", "Distancia", "Tipo", "Fecha", "Hora", "Clima"};
			tableModel.setColumnIdentifiers(columnNames);
			loadRaces();
		}
	}
	public static void loadRaces() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Race race : Derby.getInstance().getRaces()) {
			fila[0] = race.getRaceID();
			fila[1] = race.getDistance();
			fila[2] = race.getRaceType();
			fila[3] = race.getRaceDate();
			fila[4] = race.getRaceTime();
			fila[5] = race.getWeather();
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
	}
}
