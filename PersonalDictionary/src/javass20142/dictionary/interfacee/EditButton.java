package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javass20142.dictionary.database.Databases;
import javass20142.dictionary.model.TranslateWord;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditButton extends JDialog {
	// MainView mainView;

	private final JPanel contentPanel = new JPanel();
	private static JTextField wordEN;
	private JButton addChange;
	private JEditorPane wordVI;
	private JLabel lbStatus;
	Databases db = new Databases();
	TranslateWord checkWord = new TranslateWord();

	/**
	 * Create the dialog.
	 * 
	 * @throws IOException
	 */
	public EditButton() throws IOException {
		setBounds(100, 100, 450, 300);
		setTitle("Edit Word");
		setLocation(600, 270);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Word English");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 45, 96, 20);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ngh\u0129aTi\u1EBFng Vi\u1EC7t ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 87, 96, 20);
		contentPanel.add(lblNewLabel_1);

		wordEN = new JTextField(MainView.getwordEdit());
		wordEN.setBounds(116, 45, 297, 20);
		contentPanel.add(wordEN);
		wordEN.setColumns(10);

		addChange = new JButton("Add Change");
		addChange.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				11));
		addChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if (checkWord.checkWord(wordEN.getText())) {
				// System.out.println("done");
				// System.out.println(wordEN.getText());
				// System.out.println(db.getwordVI("tbl_word"
				// + wordEN.getText().charAt(0) + "", wordEN.getText()));
				// System.out.println(db.getWordID(wordEN.getText()));
				// } else {
				// System.out.println("failse");
				// }
				try {
					int wordID = db.getWordID(MainView.getwordEdit());
					db.upDateDB(wordID, wordEN.getText(), wordVI.getText());
					lbStatus.setText("update success");
				} catch (Exception e) {
					// TODO: handle exception
					lbStatus.setText("update fail");
				}

			}
		});
		addChange.setBounds(10, 140, 96, 51);
		contentPanel.add(addChange);
		String wordEn = MainView.getwordEdit();
		wordVI = new JEditorPane();
		if (wordEn.equals("")) {
			wordVI.setText("ban chua chon tu can edit");
		} else {
			wordVI.setText(db.getwordVI("tbl_word" + wordEn.charAt(0) + "",
					wordEn));
		}
		wordVI.setBounds(116, 82, 297, 178);
		contentPanel.add(wordVI);

		lbStatus = new JLabel("");
		lbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbStatus.setBounds(187, 11, 184, 16);
		contentPanel.add(lbStatus);
	}
}
