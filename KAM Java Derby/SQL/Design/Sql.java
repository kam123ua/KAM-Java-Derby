package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Core.Member;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Sql extends JFrame {

	private Panel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnOk;

	public Sql() {
		setTitle("SQL");
		setResizable(false);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 266);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 487, 185);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(Style.Text_Field);
		textArea.setBackground(Style.Fon);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		btnOk = new JButton("\u041E\u041A");
		btnOk.setForeground(Style.Shrift);
		btnOk.setHorizontalAlignment(SwingConstants.LEFT);
		btnOk.setIcon(new ImageIcon("image\\free-vector-ok-icon_101807_OK_icon.png"));
		btnOk.setBackground(Style.Fon);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=textArea.getText();
				String comand[] = text.split(" ");
				String buf=comand[0].toLowerCase();
				if(buf.equals("select")==true){
					Member.comand_for_select=text;
					@SuppressWarnings("unused")
					View ViewFrame=new View();
				}
				else{
					Core.SQLB.SQL(text);
				}
				
				setVisible(false);
			}
		});
		btnOk.setBounds(368, 203, 109, 23);
		contentPane.add(btnOk);
		
		setVisible(true);
	}
}
