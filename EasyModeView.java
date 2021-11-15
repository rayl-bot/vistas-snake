package aceptaelreto.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.table.DefaultTableCellRenderer;
//import java.awt.Component;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EasyModeView {

	private Font font = new Font("Agency FB", Font.BOLD, 20);
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JButton nuevoJuego;
	private JButton record;
	private JLabel serpiente, base;
	private ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasyModeView window = new EasyModeView();
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
	public EasyModeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Snake");
		frame.setBounds(100, 100, 515, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 26, 320, 320);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		DefaultTableModel model = new DefaultTableModel();

		for (int i = 0; i < 20; i++) {
			model.addColumn("");
			for (int j = 0; j < 20; j++) {
				base = new JLabel();
				base.setBackground(Color.orange);
				base.setBounds(0,0,10,10);
				base.isOpaque();
				model.addRow(new Vector<>());
			}
		}
		table.setModel(model);
		//Se tienen que crear dos clases que extiendan de DefaultTableCellRenderer, una que 
		//ponga la fruta aleatoriamente en la tabla y otra que vaya alargando la serpiente
		table.setDefaultRenderer( Object.class, new MiRender(20) );
		panel.add(table, gbc_table);

		nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.setBounds(340, 101, 121, 23);
		frame.getContentPane().add(nuevoJuego);

		record = new JButton("Récords");
		record.setBounds(340, 219, 121, 23);
		frame.getContentPane().add(record);

		JLabel puntuacion = new JLabel("Puntuación: ");
		puntuacion.setBackground(Color.green);
		puntuacion.setBounds(340, 26, 121, 38);
		puntuacion.setFont(font);
		frame.getContentPane().add(puntuacion);
	}
}