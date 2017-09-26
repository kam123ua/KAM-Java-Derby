package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Core.Member;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class Table extends JFrame {

	private Panel contentPane;
	@SuppressWarnings("rawtypes")
	public static JComboBox comboBox;
	private JButton btnCreateTable,btnSql,btnView;
	private JButton button_Insert;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Table() {
		setTitle(Core.Language.table);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 394);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Core.Metod.Tabb();
		
		JLabel lblNam = new JLabel(Core.Language.tb_n);
		lblNam.setForeground(Style.Word);
		lblNam.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		lblNam.setBounds(10, 11, 211, 54);
		contentPane.add(lblNam);
		
		String[] items=Core.Member.mas.trim().split("\n");
		
		comboBox = new JComboBox();
		comboBox.setForeground(Style.Word);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(Style.Fon);
		comboBox.setModel(new DefaultComboBoxModel(items));
		comboBox.setBounds(20, 60, 184, 27);
		contentPane.add(comboBox);
		
		btnCreateTable = new JButton(Core.Language.tb_3);
		btnCreateTable.setIcon(new ImageIcon("image\\add_cross_new_plus_create-512.png"));
		btnCreateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					@SuppressWarnings("unused")
					Create_Table Create_TableF=new Create_Table();
					setVisible(false);
			}
		});
		btnCreateTable.setForeground(Style.Shrift);
		btnCreateTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateTable.setBackground(Style.Fon);
		btnCreateTable.setBounds(192, 313, 255, 41);
		contentPane.add(btnCreateTable);
		
		btnSql = new JButton("SQL");
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Sql SQLF=new Sql();
			}
		});
		btnSql.setIcon(new ImageIcon("image\\Sql-runner.png"));
		btnSql.setForeground(Style.Shrift);
		btnSql.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSql.setBackground(Style.Fon);
		btnSql.setBounds(26, 313, 156, 39);
		contentPane.add(btnSql);
		
		btnView = new JButton(Core.Language.tb_1);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member.comand_for_select="Select * FROM "+(String) Table.comboBox.getSelectedItem();
				@SuppressWarnings("unused")
				View ViewFrame=new View();
			}
		});
		btnView.setIcon(new ImageIcon("image\\k-ghost-view-icon.png"));
		btnView.setForeground(Style.Shrift);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnView.setBackground(Style.Fon);
		btnView.setBounds(221, 48, 226, 41);
		contentPane.add(btnView);
		
		JButton button_search = new JButton(Core.Language.tb_2);
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Search SearchF=new Search();
			}
		});
		button_search.setForeground(Style.Shrift);
		button_search.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_search.setIcon(new ImageIcon("image\\k-ghost-view-icon1.png"));
		button_search.setBackground(Style.Fon);
		button_search.setBounds(20, 246, 201, 41);
		contentPane.add(button_search);
		
		JButton button_delete = new JButton(Core.Language.delete);
		button_delete.setIcon(new ImageIcon("image\\delete-256_39x39.png"));
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Delete DeleteF=new Delete();
			}
		});
		button_delete.setForeground(Style.Shrift_Button);
		button_delete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_delete.setBackground(Style.Fon);
		button_delete.setBounds(243, 246, 204, 41);
		contentPane.add(button_delete);
		
		button_Insert = new JButton(Core.Language.insert);
		button_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Insert InsertF=new Insert();
			}
		});
		button_Insert.setIcon(new ImageIcon("image\\create.png"));
		button_Insert.setForeground(Style.Shrift_Button);
		button_Insert.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button_Insert.setBackground(Style.Fon);
		button_Insert.setBounds(243, 194, 204, 41);
		contentPane.add(button_Insert);
		
		JButton button_dl_tb = new JButton(Core.Language.dl_tab);
		button_dl_tb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Core.SQLB.SQL("DROP TABLE "+(String)Table.comboBox.getSelectedItem());
				String s=(String) comboBox.getSelectedItem();
				Core.Metod.del_tabl(s);
				JOptionPane.showMessageDialog(null,"OK");	
				setVisible(false);
				Core.SQLB.Conn();
				@SuppressWarnings("unused")
				Table TableF=new Table();
			}
		});
		button_dl_tb.setForeground(Style.Shrift_Button);
		button_dl_tb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_dl_tb.setBackground(Style.Fon);
		button_dl_tb.setBounds(17, 194, 204, 41);
		contentPane.add(button_dl_tb);
				
		JLabel label = new JLabel("__________________________________________________________________________________");
		label.setForeground(Color.WHITE);
		label.setBounds(-19, 158, 494, 14);
		contentPane.add(label);
		
		JButton button_dl_db = new JButton(Core.Language.dl_basa);
		button_dl_db.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Core.Metod.delete_basa();
			}
		});
		button_dl_db.setForeground(Style.Shrift_Button);
		button_dl_db.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_dl_db.setBackground(Style.Fon);
		button_dl_db.setBounds(129, 113, 184, 41);
		contentPane.add(button_dl_db);
		
		setVisible(true);
	}
}
