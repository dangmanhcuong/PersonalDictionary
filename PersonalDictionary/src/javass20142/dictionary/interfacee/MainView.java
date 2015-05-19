package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Calendar;

import javass20142.dictionary.database.Databases;
import javass20142.dictionary.model.TranslateWord;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainView {

	private JFrame frame;
	private JTextField wordSearch;
	private JList<String> jListWordEN = null;
	JTextPane txtWordVI;
	private static String wordEdit = "";
	TranslateWord translateWord = new TranslateWord();
	Databases databases = new Databases();
	int numWord;
	String[] listWordEN;

	public static String getwordEdit() {
		return wordEdit;
	}

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
		long cs = Calendar.getInstance().getTimeInMillis();
		// numWord = databases.getListWordEN("tbl_translateev",
		// "wordEN").size();
		cs = Calendar.getInstance().getTimeInMillis() - cs;
		System.out.println("run initi:" + cs);

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
		// panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 794, 43);
		frame.getContentPane().add(panel);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.setIcon(new ImageIcon(
				MainView.class
						.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")));
		menu.setBackground(Color.RED);
		menu.setMnemonic(KeyEvent.VK_F);
		JMenuItem close = new JMenuItem(
				"Close",
				new ImageIcon(
						MainView.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		close.setMnemonic(KeyEvent.VK_C);
		close.setToolTipText("Exit application");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		// panel.setLayout(new BorderLayout(0, 0));
		menu.add(close);
		menuBar.add(menu);
		JMenuBar menuBar_1 = new JMenuBar();
		JMenu myWord = new JMenu("My Word");
		myWord.setBackground(Color.RED);
		myWord.setMnemonic(KeyEvent.VK_F);
		myWord.setSize(10, 20);
		menuBar_1.add(myWord);

		JMenuBar menuBar_12 = new JMenuBar();
		JMenu about = new JMenu("About");
		about.setBackground(Color.RED);
		about.setMnemonic(KeyEvent.VK_F);
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("sfdfdf");
				System.exit(0);
			}
		});
		menuBar_12.add(about);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		panel.add(menuBar);
		panel.add(menuBar_1);
		panel.add(menuBar_12);
		// panel.add(menuBar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(57, 93, 178, 441);
		frame.getContentPane().add(panel_1);
		// //
		long c = Calendar.getInstance().getTimeInMillis();
		jListWordEN = new JList(createDefaultListModel());
		c = Calendar.getInstance().getTimeInMillis() - c;
		System.out.println("thoi gian load tu 1 la(s):" + c);
		c = Calendar.getInstance().getTimeInMillis();

		clickListioner();

		c = Calendar.getInstance().getTimeInMillis() - c;
		System.out.println("thoi gian load tu 2 la(s):" + c);
		JScrollPane pane = new JScrollPane(jListWordEN);
		// pane.setVerticalScrollBar(null);
		panel_1.add(pane);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(245, 93, 559, 441);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		txtWordVI = new JTextPane();
		txtWordVI.setBounds(10, 36, 479, 375);
		panel_2.add(txtWordVI);

		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				EditButton btEditButton = null;
				try {
					btEditButton = new EditButton();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btEditButton.show();
				// about.createFrame();
			}
		});
		btnNewButton_2.setBounds(132, 0, 89, 23);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(" Add Word");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				AddButton btAddButton = new AddButton();
				btAddButton.show();
			}
		});
		btnNewButton_3.setBounds(235, 0, 89, 23);
		panel_2.add(btnNewButton_3);

		wordSearch = createTextField();
		wordSearch.setBounds(235, 54, 372, 28);
		frame.getContentPane().add(wordSearch);
		wordSearch.setColumns(10);

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(57, 54, 178, 28);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Translate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				translateWord.translateWord(wordSearch, txtWordVI);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(652, 54, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}

	private DefaultListModel<String> createDefaultListModel() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : databases.filterWord2l("a", "a")
				.toArray(new String[50])) {
			model.addElement(s);
		}
		return model;
	}

	public void filterModel(DefaultListModel<String> model, String filter) {
		long c = Calendar.getInstance().getTimeInMillis();
		String tblString;
		model.clear();
		if (filter.equals("")) {
			tblString = "a";
			filter = "a";
		} else if (filter.charAt(0) < 97 || filter.charAt(0) > 122) {
			tblString = "other";
			// filter = "A";
		} else {
			tblString = filter.charAt(0) + "";
		}

		DefaultListModel<String> model2 = databases.filterWord2(tblString,
				filter);
		System.out.println(model2.size());
		for (int i = 0; i < model2.size(); i++) {
			model.addElement(databases.filterWord2(tblString, filter)
					.getElementAt(i));
			// model.addElement(model2.getElementAt(i));
			// ArrayList<String> model3 = databases.filterWord2l(tblString,
			// filter);
			// for (String s : model3.toArray(new String[model3.size()])) {
			// if (!s.startsWith(filter)) {
			// if (model.contains(s)) {
			// model.removeElement(s);
			// }
			// } else {
			// if (!model.contains(s)) {
			// model.addElement(s);
			// }
			// }
			// }
		}
		c = Calendar.getInstance().getTimeInMillis() - c;
		System.out.println("tg filter toan bo: " + c);
	}

	private JTextField createTextField() {
		final JTextField wordSearch = new JTextField(50);
		wordSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// wordSearch.removeAll();
				filter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			private void filter() {
				String filter = wordSearch.getText();
				filterModel((DefaultListModel<String>) jListWordEN.getModel(),
						filter);
			}
		});
		return wordSearch;
	}

	public void clickListioner() {
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList<?> theList = (JList<?>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String wordEN = theList.getModel().getElementAt(index)
								.toString();
						wordEdit = wordEN;
						// wordSearch.setText(wordEN);
						txtWordVI.setText(databases.getwordVI("tbl_word"
								+ wordEN.charAt(0), wordEN));
						// System.out.println("clicked on: " + wordEN);
					} else {
						System.out.println("null");
					}
				}
			}
		};
		jListWordEN.addMouseListener(mouseListener);
	}
}
