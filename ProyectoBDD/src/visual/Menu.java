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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Registro");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmInsertarUsuario = new JMenuItem("Insertar Usuario");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
