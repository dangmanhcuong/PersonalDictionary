package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainView {

	private JFrame frame;
	private JTextField wordSearch;
	@SuppressWarnings("rawtypes")
	private JList jListWordEN;
	JTextPane txtWordVI;
	TranslateWord translateWord = new TranslateWord();
	Databases databases = new Databases();
	String[] listWordEN = translateWord.getListWord().toArray(
			new String[translateWord.getListWord().size()]);

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
		jListWordEN = new JList(createDefaultListModel());
		jListWordEN.getModel();
		// ///////////////////////////
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				JList theList = (JList) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						String wordEN = theList.getModel().getElementAt(index)
								.toString();
						txtWordVI.setText(databases.getwordVI(wordEN));
						System.out.println("Double-clicked on: " + wordEN);
					}
				}
			}
		};
		jListWordEN.addMouseListener(mouseListener);
		JScrollPane pane = new JScrollPane(jListWordEN);
		// pane.setHorizontalScrollBar(null);
		panel_1.add(pane);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(235, 93, 559, 441);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		txtWordVI = new JTextPane();
		txtWordVI.setBounds(39, 29, 479, 375);
		panel_2.add(txtWordVI);

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

	private ListModel<String> createDefaultListModel() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : listWordEN) {
			model.addElement(s);
		}
		return model;
	}

	public void filterModel(DefaultListModel<String> model, String filter) {
		for (String s : listWordEN) {
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
		final JTextField wordSearch = new JTextField(15);
		wordSearch.getDocument().addDocumentListener(new DocumentListener() {
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
				String filter = wordSearch.getText();
				filterModel((DefaultListModel<String>) jListWordEN.getModel(),
						filter);
			}
		});
		return wordSearch;
	}
}
