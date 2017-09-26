package Design;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Language extends JFrame {

	private JPanel contentPane;
	private JButton btnUkr,btnEng;

	public Language() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 183, 142);
		contentPane = new JPanel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnUkr = new JButton("” –");
		btnUkr.setIcon(new ImageIcon("image\\Ukraine_29764_30x20.png"));
		btnUkr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.Metod.Write("language.lang", "ukr");
				setVisible(false);
				@SuppressWarnings("unused")
				Okno OknoFrame=new Okno();
			}
		});
		contentPane.setLayout(null);
		btnUkr.setForeground(Style.Shrift);
		btnUkr.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUkr.setBackground(Style.Fon);
		btnUkr.setBounds(23, 11, 144, 41);
		contentPane.add(btnUkr);
		
		btnEng = new JButton("ENG");
		btnEng.setIcon(new ImageIcon("image\\Flag_of_the_United_States.svg_30x16.png"));
		btnEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.Metod.Write("language.lang", "en");
				setVisible(false);
				@SuppressWarnings("unused")
				Okno OknoFrame=new Okno();	
			}
		});
		btnEng.setForeground(Style.Shrift);
		btnEng.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEng.setBackground(Style.Fon);
		btnEng.setBounds(23, 63, 144, 41);
		contentPane.add(btnEng);
		
		setVisible(true);
	}
}
