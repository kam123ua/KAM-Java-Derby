package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Core.Member;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class View extends JFrame {

	private Panel contentPane;

	public View(){
		setTitle(Core.Language.table);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 266);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 487, 237);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Style.Fon);
		textArea.setForeground(Style.Shrift);
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
	
		textArea.setText(Core.SQLB.Colonku("View"));
		textArea.setText(textArea.getText()+Core.SQLB.Search(Member.comand_for_select));
		repaint();
		
		setVisible(true);
	}
}


