package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javass20142.dictionary.database.Databases;
import javass20142.dictionary.model.TranslateWord;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainFrame {

	private JFrame frame;
	private JTextField inputWord;
	private JLabel lb_outputWord;
	private JButton bt_search;
	@SuppressWarnings("rawtypes")
	private JList Jlist;
	TranslateWord lisWord = new TranslateWord();
	String[] defaultValues = lisWord.getListWord().toArray(
			new String[lisWord.getListWord().size()]);

	// protected AbstractButton Jlist;

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
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
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
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY,
				Color.CYAN, Color.BLUE, null));
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(50, 72, 132, 470);
		panel_1.setLayout(new BorderLayout());
		frame.getContentPane().add(panel_1);
		//
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();

		String[] fonts = ge.getAvailableFontFamilyNames();
		TranslateWord testTranslateWord = new TranslateWord();
		fonts = testTranslateWord.getListWord().toArray(
				new String[testTranslateWord.getListWord().size()]);

		//
		// @SuppressWarnings({ "rawtypes", "unchecked" })
		Jlist = new JList(createDefaultListModel());
		Jlist.getModel();
		// Jlist.setVisibleRowCount(6);
		// list.setBounds(50, 72, 132, 470);
		JScrollPane panes = new JScrollPane(Jlist);
		// panes.setViewportView(Jlist);
		// panes.add(Jlist);
		// panes.setPreferredSize(new Dimension(250, 200));
		panel_1.add(panes);
		// panel_1.add(list);
		// panel_1.add(panes);
		// Pack();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		panel_2.setBounds(183, 30, 610, 510);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// inputWord = new JTextField(15);
		// // //
		inputWord = createTextField();
		// //
		inputWord.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			private void filter() {
				String filter = inputWord.getText();
				filterModel((DefaultListModel<String>) Jlist.getModel(), filter);
			}
		});
		inputWord.setBounds(3, 3, 508, 20);
		panel_2.add(inputWord);
		inputWord.setColumns(10);

		lb_outputWord = new JLabel("");
		lb_outputWord.setBackground(Color.GREEN);
		lb_outputWord.setHorizontalAlignment(SwingConstants.CENTER);
		lb_outputWord.setBounds(13, 34, 320, 307);
		//
		String lyrics = "<html>It's way too late to think of<br>"
				+ "Someone I would call now<br>"
				+ "And neon signs got tired<br>"
				+ "Red eye flights help the stars out<br>"
				+ "I'm safe in a corner<br>" + "Just hours before me<br>"
				+ "<br>" + "I'm waking with the roaches<br>"
				+ "The world has surrendered<br>"
				+ "I'm dating ancient ghosts<br>"
				+ "The ones I made friends with<br>"
				+ "The comfort of fireflies<br>"
				+ "Long gone before daylight<br>" + "<br>"
				+ "And if I had one wishful field tonight<br>"
				+ "I'd ask for the sun to never rise<br>"
				+ "If God leant his voice for me to speak<br>"
				+ "I'd say go to bed, world<br>" + "<br>"
				+ "I've always been too late<br>"
				+ "To see what's before me<br>"
				+ "And I know nothing sweeter than<br>"
				+ "Champaign from last New Years<br>"
				+ "Sweet music in my ears<br>"
				+ "And a night full of no fears<br>" + "<br>"
				+ "But if I had one wishful field tonight<br>"
				+ "I'd ask for the sun to never rise<br>"
				+ "If God passed a mic to me to speak<br>"
				+ "I'd say stay in bed, world<br>" + "Sleep in peace</html>";

		//
		lb_outputWord.setText(lyrics);
		panel_2.add(lb_outputWord);

		bt_search = new JButton("New button");
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TranslateWord searchword = new TranslateWord();
				String inString = inputWord.getText();
				if (searchword.checkWord(inString)) {
					Databases testDbUtils = new Databases();
					testDbUtils.initiAndConnectDB();
					lb_outputWord.setText(testDbUtils.getwordVI(inString));
				} else {
					lb_outputWord.setText("khong co tu can tim");
				}

			}
		});
		bt_search.setBounds(511, 2, 89, 23);
		panel_2.add(bt_search);

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBounds(96, 41, 67, 20);
		frame.getContentPane().add(lblNewLabel);
	}

	private ListModel<String> createDefaultListModel() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : defaultValues) {
			model.addElement(s);
		}
		return model;
	}

	public void filterModel(DefaultListModel<String> model, String filter) {
		// TranslateWord lisWord = new TranslateWord();
		// String[] defaultValues = lisWord.getListWord().toArray(
		// new String[lisWord.getListWord().size()]);
		for (String s : defaultValues) {
			if (!s.startsWith(filter)) {
				if (model.contains(s)) {
					model.removeElement(s);
				}
			} else {
				if (!model.contains(s)) {
					model.addElement(s);
				}
			}
		}
	}

	private JTextField createTextField() {
		final JTextField field = new JTextField();
		field.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			@SuppressWarnings("unchecked")
			private void filter() {
				String filter = field.getText();
				filterModel((DefaultListModel<String>) Jlist.getModel(), filter);
			}
		});
		return field;
	}
}
