package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javass20142.dictionary.database.Databases;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AddButton extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField wordEN;
	private JEditorPane wordVI;
	private JButton addWordButton;
	private JLabel lbStatus;
	Databases dbDatabases = new Databases();

	/**
	 * Create the dialog.
	 */
	public AddButton() {
		setBounds(100, 100, 450, 300);
		setTitle("Add Word");
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

		wordEN = new JTextField();
		wordEN.setBounds(116, 45, 297, 20);
		contentPanel.add(wordEN);
		wordEN.setColumns(10);

		wordVI = new JEditorPane();
		wordVI.setBounds(116, 82, 297, 178);
		contentPanel.add(wordVI);
		// wordVI.setColumns(10);

		addWordButton = new JButton("Add Word");
		addWordButton.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 11));
		addWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbDatabases.initiAndConnectDB();
				 try {
				dbDatabases.insertDB2(wordEN.getText().charAt(0) + "",
						wordEN.getText(), wordVI.getText());
				lbStatus.setText("Add success!");

				} catch (Exception e) {
					// TODO: handle exception
					lbStatus.setText("Add fail @@!");
				}

			}
		});
		addWordButton.setBounds(10, 140, 96, 51);
		contentPanel.add(addWordButton);
		lbStatus = new JLabel("");
		lbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbStatus.setBounds(187, 11, 184, 16);
		contentPanel.add(lbStatus);
	}
}
