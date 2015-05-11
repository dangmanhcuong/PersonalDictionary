package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainView {

	private JFrame frame;
	private JTextField textField;
	@SuppressWarnings("rawtypes")
	private JList jList;
	// String array test list
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] fonts = ge.getAvailableFontFamilyNames();

	// ////

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
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
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(300, 100, 800, 600);
		frame.setResizable(false);
		frame.setTitle("Java SS 20142 Đặng Mạnh Cường 20101206 - Dictionary ver1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 794, 43);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(57, 93, 178, 441);
		frame.getContentPane().add(panel_1);
		jList = new JList(fonts);
		jList.getModel();
		JScrollPane pane = new JScrollPane(jList);
		pane.setHorizontalScrollBar(null);
		panel_1.add(pane);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(235, 93, 559, 441);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JTextPane txtpnHihi = new JTextPane();
		txtpnHihi.setBounds(39, 29, 479, 375);
		panel_2.add(txtpnHihi);

		textField = new JTextField();
		textField.setBounds(235, 54, 372, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(57, 54, 178, 28);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Translate");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(652, 54, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
