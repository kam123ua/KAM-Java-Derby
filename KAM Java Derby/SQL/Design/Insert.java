package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Insert extends JFrame {

	private Panel contentPane;
	private JTextField textField;
	private String comand;

	public Insert(){
		setTitle(Core.Language.insert);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 217);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 536, 60);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Style.Fon);
		textArea.setForeground(Style.Shrift);
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(Style.Text_Field);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField.setBackground(Style.Fon);
		textField.setBounds(10, 22, 370, 29);
		contentPane.add(textField);
				
		JButton btnInsert = new JButton(Core.Language.insert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comand="INSERT INTO "+(String) Table.comboBox.getSelectedItem()+" values ( "+textField.getText()+" )";
				Core.SQLB.SQL(comand);
				textArea.setText(Core.Member.res);
				repaint();
				
			}
		});
		btnInsert.setIcon(new ImageIcon("image\\create.png"));
		btnInsert.setForeground(Style.Shrift_Button);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBackground(Style.Fon);
		btnInsert.setBounds(390, 22, 168, 29);
		contentPane.add(btnInsert);
		
		setVisible(true);
	}
}


