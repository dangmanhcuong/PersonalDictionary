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

@SuppressWarnings("serial")
public class AddButton extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField wordEN;
	private JTextField wordVI;
	private JButton addChange;

	/**
	 * Create the dialog.
	 */
	public AddButton() {
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
		lblNewLabel.setBounds(40, 45, 96, 20);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ngh\u0129aTi\u1EBFng Vi\u1EC7t ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(40, 83, 96, 20);
		contentPanel.add(lblNewLabel_1);

		wordEN = new JTextField();
		wordEN.setBounds(146, 45, 86, 20);
		contentPanel.add(wordEN);
		wordEN.setColumns(10);

		wordVI = new JTextField();
		wordVI.setBounds(146, 83, 86, 20);
		contentPanel.add(wordVI);
		wordVI.setColumns(10);

		addChange = new JButton("Add Change");
		addChange.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				11));
		addChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		addChange.setBounds(146, 154, 89, 23);
		contentPanel.add(addChange);
	}
}
