package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQL.SQLDatabaseConnection;
import logic.Derby;
import logic.Race;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertRace extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRaceId;
	private JTextField txtDistancia;
	private JTextField txtFechaRace;
	private JTextField txtTiempoRace;
	private JComboBox cbxTipoRace;
	private JComboBox cbxClima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertRace dialog = new InsertRace();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertRace() {
		setResizable(false);
		setTitle("Registro Carrera");
		setBounds(100, 100, 325, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		{
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(24, 35, 46, 14);
		contentPanel.add(lblNewLabel);
		}
		{
		txtRaceId = new JTextField();
		txtRaceId.setEnabled(false);
		txtRaceId.setEditable(false);
		txtRaceId.setBounds(103, 32, 86, 20);
		contentPanel.add(txtRaceId);
		txtRaceId.setColumns(10);
		txtRaceId.setText(Integer.valueOf(Derby.getGenCodRace()).toString());
		}
		
		{
		JLabel lblNewLabel_1 = new JLabel("Distancia:");
		lblNewLabel_1.setBounds(24, 87, 64, 14);
		contentPanel.add(lblNewLabel_1);
		}
		
		{
		txtDistancia = new JTextField();
		txtDistancia.setBounds(103, 84, 86, 20);
		contentPanel.add(txtDistancia);
		txtDistancia.setColumns(10);
		}
		
		{
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setBounds(24, 134, 64, 14);
		contentPanel.add(lblNewLabel_2);
		}
		
		cbxTipoRace = new JComboBox();
		cbxTipoRace.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione la categoria>", "Plana", "Obst\u00E1culos", "Cl\u00E1sica"}));
		cbxTipoRace.setBounds(103, 131, 171, 20);
		contentPanel.add(cbxTipoRace);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(24, 183, 64, 14);
		contentPanel.add(lblFecha);
		
		txtFechaRace = new JTextField();
		txtFechaRace.setBounds(103, 180, 86, 20);
		contentPanel.add(txtFechaRace);
		txtFechaRace.setColumns(10);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(24, 232, 64, 14);
		contentPanel.add(lblTiempo);
		
		txtTiempoRace = new JTextField();
		txtTiempoRace.setBounds(103, 229, 86, 20);
		contentPanel.add(txtTiempoRace);
		txtTiempoRace.setColumns(10);
		
		JLabel lblClima = new JLabel("Clima:");
		lblClima.setBounds(24, 285, 64, 14);
		contentPanel.add(lblClima);
		
		cbxClima = new JComboBox();
		cbxClima.setModel(new DefaultComboBoxModel(new String[] {"<Clima>", "Soleado", "Nublado", "Lluvioso", "Ventoso", "Nevado"}));
		cbxClima.setBounds(103, 282, 86, 20);
		contentPanel.add(cbxClima);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Race carrera = new Race(Integer.parseInt(txtRaceId.getText()), Integer.parseInt(txtDistancia.getText()), cbxTipoRace.getSelectedItem().toString(), txtFechaRace.getText(), txtTiempoRace.getText(), cbxClima.getSelectedItem().toString());
						SQLDatabaseConnection.registrarCarreraSQL(carrera.getDistance(), carrera.getRaceType(), carrera.getRaceTime(), carrera.getRaceDate(), carrera.getWeather());
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
		txtRaceId.setText(Integer.valueOf(Derby.getGenCodRace()).toString());
		txtDistancia.setText("");
	    txtFechaRace.setText("");
	    txtTiempoRace.setText("");
	    cbxTipoRace.setSelectedIndex(-1);
	    cbxClima.setSelectedIndex(-1);
	    		
	}
}
