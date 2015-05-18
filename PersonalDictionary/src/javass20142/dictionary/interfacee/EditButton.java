package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class EditButton extends JDialog {
	MainView mainView;

	private final JPanel contentPanel = new JPanel();
	private JTextField wordEN;
	private JButton addChange;

	/**
	 * Create the dialog.
	 */
	public EditButton() {
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

		wordEN = new JTextField("hello");
		wordEN.setBounds(116, 45, 297, 20);
		contentPanel.add(wordEN);
		wordEN.setColumns(10);

		addChange = new JButton("Add Change");
		addChange.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				11));
		addChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		addChange.setBounds(10, 140, 96, 51);
		contentPanel.add(addChange);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(116, 82, 297, 178);
		contentPanel.add(editorPane);
	}
}
