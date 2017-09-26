package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import Core.Member;
import Core.Metod;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Create_Table extends JFrame {

	private Panel contentPane;
	private JTextField textField_Name,textField_ADD;
	private JButton btnCreateTable,button_add,button_R;
	private JLabel lblNameOfTable;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Create_Table() {
		setTitle(Core.Language.tb_3);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 250);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNameOfTable = new JLabel(Core.Language.name_of_table);
		lblNameOfTable.setForeground(Style.Word);
		lblNameOfTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameOfTable.setBounds(10, 11, 133, 31);
		contentPane.add(lblNameOfTable);
		
		textField_ADD = new JTextField();
		textField_ADD.setForeground(Style.Text_Field);
		textField_ADD.setBackground(Style.Fon);
		textField_ADD.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_ADD.setBounds(144, 11, 236, 31);
		contentPane.add(textField_ADD);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Style.Shrift);
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(Style.Fon);
		comboBox.setModel(new DefaultComboBoxModel(Core.Member.items));
		comboBox.setBounds(22, 132, 156, 39);
		contentPane.add(comboBox);
		
		button_R = new JButton("");
		button_R.setForeground(Style.Shrift);
		button_R.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_R.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				Core.Member.str=textField_ADD.getText();
				String str=Core.Member.str;
				if(str.length() == 0){
					JOptionPane.showMessageDialog(null, Core.Language.mes_emp);
				}
				else{
					Core.Metod.ToFile();
					Core.Member.comand = Core.Member.comand+Core.Member.str+"(";
					Core.Member.n = 0;
					
					Metod.Write("database\\" + Member.name+"\\" + Core.Member.str, "");
				
					textField_ADD.setEditable(false);
					textField_ADD.setEnabled(false);
					button_R.setEnabled(false);
					comboBox.setEnabled(true);
					textField_Name.setEnabled(true);
					textField_Name.setEditable(true);
					button_add.setEnabled(true);

					repaint();
				}
				
			}
		});
		button_R.setBackground(Style.Fon);
		button_R.setIcon(new ImageIcon("image\\1343748666_green_tick_thumb.gif"));
		button_R.setBounds(390, 11, 89, 46);
		contentPane.add(button_R);
		
		textField_Name = new JTextField();
		textField_Name.setForeground(Style.Text_Field);
		textField_Name.setBackground(Style.Fon);
		textField_Name.setEnabled(false);
		textField_Name.setEditable(false);
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Name.setBounds(22, 73, 156, 46);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		button_add = new JButton("+");
		button_add.setForeground(Style.Shrift);
		button_add.setEnabled(false);
		button_add.setBackground(Style.Fon);
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField_Name.getText();
				String vubor = (String) comboBox.getSelectedItem();
				if(str.length() == 0){
					JOptionPane.showMessageDialog(null, Core.Language.mes_emp);
				}
				else{
					try {
						Metod.Update("database\\" + Member.name + "\\" + Core.Member.str,str+" "+vubor+"\n");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					if(Core.Member.n == 0){
						Core.Member.n++;
						Core.Member.comand = Core.Member.comand + str + " " + vubor;
						btnCreateTable.setEnabled(true);
						repaint();
					}
					
					else{
						Core.Member.comand = Core.Member.comand+","+str+" "+(String) comboBox.getSelectedItem();					
					}
				}				
			}
		});
		button_add.setFont(new Font("Tahoma", Font.PLAIN, 22));
		button_add.setBounds(198, 97, 62, 39);
		contentPane.add(button_add);
		
		btnCreateTable = new JButton(Core.Language.sv);
		btnCreateTable.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateTable.setIcon(new ImageIcon("image\\save.png"));
		btnCreateTable.setEnabled(false);
		btnCreateTable.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
				Core.SQLB.func_F();
				setVisible(false);
			}
		});
		btnCreateTable.setForeground(Style.Shrift);
		btnCreateTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateTable.setBackground(Style.Fon);
		btnCreateTable.setBounds(326, 171, 153, 39);
		contentPane.add(btnCreateTable);
		
		setVisible(true);
	}
}
