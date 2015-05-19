package javass20142.dictionary.interfacee;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javass20142.dictionary.database.UpDateDatabase;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

@SuppressWarnings("serial")
public class UpdateButton extends JPanel implements ActionListener {
	UpDateDatabase upDateDatabase = new UpDateDatabase();
	static private final String newline = "\n";
	JButton selectFileButton, upDateButton;
	JTextArea log;
	JFileChooser fc;
	String noteString = " Lựa chọn file txt có định dạng các dòng là từ tiếng anh và tiếng việt phân các nhau bởi dấu @\n ví dụ: hello @ xin chào";
	String linkFile;

	public UpdateButton() {
		super(new BorderLayout());
		log = new JTextArea(10, 50);
		log.setText(noteString);
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);
		fc = new JFileChooser();
		selectFileButton = new JButton("select a File...");
		selectFileButton.addActionListener(this);
		upDateButton = new JButton("update");
		upDateButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(selectFileButton);
		buttonPanel.add(upDateButton);
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == selectFileButton) {
			int returnVal = fc.showOpenDialog(UpdateButton.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				linkFile = file.getAbsolutePath().replace("\\", "\\" + "\\");
				log.setText("File Select: " + linkFile);
			} else {
				log.setText("Bạn chưa chọn file " + newline + noteString);
			}
			// log.setCaretPosition(log.getDocument().getLength());
		} else {
			if (e.getSource() == upDateButton) {
				try {
					log.setText(upDateDatabase.readFile(linkFile));
				} catch (MySQLSyntaxErrorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		// JFrame.setDefaultLookAndFeelDecorated(true);
		// JDialog.setDefaultLookAndFeelDecorated(true);
		// Create and set up the window.
		JFrame frame = new JFrame("UpDate Database");
		// frame.setBounds(550, 250, 400, 300);
		frame.setLocation(550, 250);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create and set up the content pane.
		JComponent newContentPane = new UpdateButton();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);
		// // Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
