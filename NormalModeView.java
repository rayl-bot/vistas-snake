package aceptaelreto.views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;

public class NormalModeView{

	private Font font = new Font("Agency FB", Font.BOLD, 20);
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JButton nuevoJuego;
	private JButton record;
	private JLabel puntuacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NormalModeView window = new NormalModeView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NormalModeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Snake");
		frame.setBounds(100, 100, 453, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 26, 240, 240);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		DefaultTableModel model = new DefaultTableModel();
		for (int i = 0; i < 15; i++) {
			model.addColumn("");
			for (int j = 0; j < 15; j++) {
				model.addRow(new Vector<>());
			}
		}
		table.setModel(model);
		table.setDefaultRenderer( Object.class, new MiRender(15) );
		panel.add(table, gbc_table);
		
		nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.setBounds(260, 87, 121, 23);
		frame.getContentPane().add(nuevoJuego);
		
		record = new JButton("R�cords");
		record.setBounds(260, 149, 121, 23);
		frame.getContentPane().add(record);
		
		puntuacion = new JLabel("Puntuaci�n: ");
		puntuacion.setBounds(260, 26, 121, 35);
		puntuacion.setFont(font);
		frame.getContentPane().add(puntuacion);
	}
}
