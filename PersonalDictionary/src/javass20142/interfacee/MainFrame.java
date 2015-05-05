package javass20142.interfacee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class MainFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
					window.frame.setSize(800, 600);
					window.frame.setLocation(300, 50);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 255));
		frame.setBounds(100, 100, 835, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 800, 30);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.CYAN, Color.BLUE, null));
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(50, 72, 132, 470);
		panel_1.setLayout(new BorderLayout());
		frame.getContentPane().add(panel_1);
		//
		GraphicsEnvironment ge =
	            GraphicsEnvironment.getLocalGraphicsEnvironment();

	        String[] fonts = ge.getAvailableFontFamilyNames();

		//
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList list = new JList(fonts);
		//list.setBounds(50, 72, 132, 470);
		JScrollPane panes = new JScrollPane();
        panes.setViewportView(list);
        panes.setPreferredSize(new Dimension(250, 200));
        panel_1.add(panes);
		//panel_1.add(list);
		//panel_1.add(panes);
		//Pack();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		panel_2.setBounds(183, 30, 610, 510);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(3, 3, 489, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(13, 34, 320, 307);
		//
		 String lyrics =  "<html>It's way too late to think of<br>" + 
			        "Someone I would call now<br>" + 
			        "And neon signs got tired<br>" + 
			        "Red eye flights help the stars out<br>" + 
			        "I'm safe in a corner<br>" + 
			        "Just hours before me<br>" + 
			        "<br>" + 
			        "I'm waking with the roaches<br>" + 
			        "The world has surrendered<br>" + 
			        "I'm dating ancient ghosts<br>" + 
			        "The ones I made friends with<br>" + 
			        "The comfort of fireflies<br>" + 
			        "Long gone before daylight<br>" + 
			        "<br>" + 
			        "And if I had one wishful field tonight<br>" + 
			        "I'd ask for the sun to never rise<br>" + 
			        "If God leant his voice for me to speak<br>" + 
			        "I'd say go to bed, world<br>" + 
			        "<br>" + 
			        "I've always been too late<br>" + 
			        "To see what's before me<br>" + 
			        "And I know nothing sweeter than<br>" + 
			        "Champaign from last New Years<br>" + 
			        "Sweet music in my ears<br>" + 
			        "And a night full of no fears<br>" + 
			        "<br>" + 
			        "But if I had one wishful field tonight<br>" + 
			        "I'd ask for the sun to never rise<br>" + 
			        "If God passed a mic to me to speak<br>" + 
			        "I'd say stay in bed, world<br>" + 
			        "Sleep in peace</html>";
			 
			        
		//
		lblNewLabel_1.setText(lyrics);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Translate");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(502, 2, 98, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBounds(96, 41, 67, 20);
		frame.getContentPane().add(lblNewLabel);
	}
}
