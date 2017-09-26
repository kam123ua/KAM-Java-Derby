package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Okno extends JFrame {

	private Panel contentPane;
	private JButton btnExit,btnCreateDatabase,btnOpenDatabase;
	private JLabel lblCreatedByKam;
	private JButton button_web;
	private JButton button_Chang;
	private JButton button;

	public Okno() {
		setTitle("KAM Java Derby");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 375, 410);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Core.Language.Lang();
		
		btnExit = new JButton(Core.Language.okno_exit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Style.Shrift_Button);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExit.setBackground(Style.Fon);
		btnExit.setIcon(new ImageIcon("image\\exit.jpg"));
		btnExit.setBounds(23, 271, 323, 41);
		contentPane.add(btnExit);
		
		btnCreateDatabase = new JButton(Core.Language.okno_cr);
		btnCreateDatabase.setIcon(new ImageIcon("image\\create.png"));
		btnCreateDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Create_Database Create_DatabaseFrame=new Create_Database();
			}
		});
		btnCreateDatabase.setForeground(Style.Shrift);
		btnCreateDatabase.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCreateDatabase.setBackground(Style.Fon);
		btnCreateDatabase.setBounds(23, 11, 323, 41);
		contentPane.add(btnCreateDatabase);
		
		btnOpenDatabase = new JButton(Core.Language.okno_op);
		btnOpenDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Open OpenF=new Open();	
			}
		});
		btnOpenDatabase.setIcon(new ImageIcon("image\\open.png"));
		btnOpenDatabase.setForeground(Style.Shrift);
		btnOpenDatabase.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnOpenDatabase.setBackground(Style.Fon);
		btnOpenDatabase.setBounds(23, 63, 323, 41);
		contentPane.add(btnOpenDatabase);
		
		lblCreatedByKam = new JLabel(Core.Language.okno_av);
		lblCreatedByKam.setForeground(Style.Word);
		lblCreatedByKam.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCreatedByKam.setBounds(110, 325, 189, 37);
		contentPane.add(lblCreatedByKam);
		
		button_web = new JButton(Core.Language.okno_st);
		button_web.setIcon(new ImageIcon("image\\web.png"));
		button_web.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				Core.Metod.ConnectToWeb("https://sites.google.com/site/jkamderby/");
			}
		});
		button_web.setForeground(Style.Shrift_Button);
		button_web.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_web.setBackground(Style.Fon);
		button_web.setBounds(23, 115, 323, 41);
		contentPane.add(button_web);
		
		button_Chang = new JButton(Core.Language.okno_chang);
		button_Chang.setIcon(new ImageIcon(Okno.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		button_Chang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				@SuppressWarnings("unused")
				Language LanguageOkno=new Language();
			}
		});
		button_Chang.setForeground(Style.Shrift_Button);
		button_Chang.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_Chang.setBackground(Style.Fon);
		button_Chang.setBounds(23, 219, 323, 41);
		contentPane.add(button_Chang);
		
		button = new JButton(Core.Language.instruction);
		button.setIcon(new ImageIcon(Okno.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Justify.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Core.Metod.ConnectToWeb("https://docs.google.com/document/d/13bbjA49fBAgdWQGTYTycb0mJS7xfzXdlw8rAfqu0ypE/edit");
			}
		});
		button.setForeground(new Color(60, 179, 113));
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setBackground(Color.WHITE);
		button.setBounds(23, 167, 323, 41);
		contentPane.add(button);
		
		setVisible(true);
	}
}
