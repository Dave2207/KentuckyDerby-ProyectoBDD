package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Men\u00FA principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 469);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Registro");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmInsertarUsuario = new JMenuItem("Registrar Empleado");
		mntmInsertarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertEmployee insEmp = new InsertEmployee();
				insEmp.setModal(true);
				insEmp.setVisible(true);
			}
		});
		mnUsuarios.add(mntmInsertarUsuario);
		
		JMenuItem mntmRegistrarCaballo = new JMenuItem("Registrar Caballo");
		mntmRegistrarCaballo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertHorse insHorse = new InsertHorse();
				insHorse.setModal(true);
				insHorse.setVisible(true);
			}
		});
		mnUsuarios.add(mntmRegistrarCaballo);
		
		JMenuItem mntmRegistrarJockey = new JMenuItem("Registrar Jockey");
		mntmRegistrarJockey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertJockey insJoc = new InsertJockey();
				insJoc.setModal(true);
				insJoc.setVisible(true);
			}
		});
		mnUsuarios.add(mntmRegistrarJockey);
		
		JMenuItem mntmRegistrarEntrenador = new JMenuItem("Registrar Entrenador");
		mntmRegistrarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertTrainer insTrainer = new InsertTrainer();
				insTrainer.setModal(true);
				insTrainer.setVisible(true);
			}
		});
		mnUsuarios.add(mntmRegistrarEntrenador);
		
		JMenuItem mntmRegistrarDueo = new JMenuItem("Registrar Due\u00F1o");
		mntmRegistrarDueo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertOwner insOwn = new InsertOwner();
				insOwn.setModal(true);
				insOwn.setVisible(true);
			}
		});
		mnUsuarios.add(mntmRegistrarDueo);
		
		JMenuItem mntmInsertarCarrera = new JMenuItem("Insertar Carrera");
		mntmInsertarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertRace insRace = new InsertRace();
				insRace.setModal(true);
				insRace.setVisible(true);
			}
		});
		mnUsuarios.add(mntmInsertarCarrera);
		
		JMenuItem mntmInsertarTicket = new JMenuItem("Insertar Ticket");
		mntmInsertarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertTicket insTicket = new InsertTicket();
				insTicket.setModal(true);
				insTicket.setVisible(true);
			}
		});
		mnUsuarios.add(mntmInsertarTicket);
		
		JMenuItem mntmInsertarRaceentry = new JMenuItem("Insertar RaceEntry");
		mntmInsertarRaceentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertRaceEntry insRaceE = new InsertRaceEntry();
				insRaceE.setModal(true);
				insRaceE.setVisible(true);
			}
		});
		mnUsuarios.add(mntmInsertarRaceentry);
		
		JMenuItem mntmInsertarEspectador = new JMenuItem("Insertar Espectador");
		mntmInsertarEspectador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertSpectator insEspectador = new InsertSpectator();
				insEspectador.setModal(true);
				insEspectador.setVisible(true);
			}
		});
		mnUsuarios.add(mntmInsertarEspectador);
		
		JMenu mnListas = new JMenu("Listas");
		menuBar.add(mnListas);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmpleados listE = new ListaEmpleados();
				listE.setModal(true);
				listE.setVisible(true);
			}
		});
		mnListas.add(mntmEmpleados);
		
		JMenuItem mntmCaballos = new JMenuItem("Caballos");
		mntmCaballos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCaballos listC = new ListaCaballos();
				listC.setModal(true);
				listC.setVisible(true);
			}
		});
		mnListas.add(mntmCaballos);
		
		JMenuItem mntmDueos = new JMenuItem("Due\u00F1os");
		mntmDueos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaOwners listO = new ListaOwners();
				listO.setModal(true);
				listO.setVisible(true);
			}
		});
		mnListas.add(mntmDueos);
		
		JMenuItem mntmEntrenadores = new JMenuItem("Entrenadores");
		mntmEntrenadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEntrenador listEn = new ListaEntrenador();
				listEn.setModal(true);
				listEn.setVisible(true);
			}
		});
		mnListas.add(mntmEntrenadores);
		
		JMenuItem mntmJockey = new JMenuItem("Jockey");
		mntmJockey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoJockey listJ = new ListadoJockey();
				listJ.setModal(true);
				listJ.setVisible(true);
			}
		});
		mnListas.add(mntmJockey);
		
		JMenuItem mntmCarreras = new JMenuItem("Carreras");
		mntmCarreras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaRaces listR = new ListaRaces();
				listR.setModal(true);
				listR.setVisible(true);
			}
		});
		mnListas.add(mntmCarreras);
		
		JMenuItem mntmEspectadores = new JMenuItem("Espectadores");
		mntmEspectadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEspectador listEsp = new ListaEspectador();
				listEsp.setModal(true);
				listEsp.setVisible(true);
			}
		});
		mnListas.add(mntmEspectadores);
		
		JMenuItem mntmTickets = new JMenuItem("Tickets");
		mntmTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaTickets listTicket = new ListaTickets();
				listTicket.setModal(true);
				listTicket.setVisible(true);
			}
		});
		mnListas.add(mntmTickets);
		
		JMenuItem mntmRaceEntry = new JMenuItem("Race Entry");
		mntmRaceEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaRaceEntry listEntry = new ListaRaceEntry();
				listEntry.setModal(true);
				listEntry.setVisible(true);
			}
		});
		mnListas.add(mntmRaceEntry);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
