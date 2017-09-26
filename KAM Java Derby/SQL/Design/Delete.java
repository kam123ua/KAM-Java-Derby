package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import Core.Member;
import Core.Metod;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Delete extends JFrame {

	private Panel contentPane;
	private JTextField textField;
	private String comand;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Delete(){
		setTitle(Core.Language.delete);
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
		
		String tab=(String) Table.comboBox.getSelectedItem();
		
		String mas[] = null;
		String buf="";
		String buf1="";
		try {
			
			mas = Metod.Read("database\\"+Member.name+"\\"+Core.Member.str).split("\n");
			for(int i=0;i<mas.length;i++){
				String l[]=mas[i].split(" ");
				for(int j=0;j<2;j++){
					if(j%2==0){
						buf=buf+l[j]+" ";
					}
					else{
						buf1=buf1+l[j]+" ";
					}
				}
			}
			mas=null;
			mas=buf.split(" ");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String abc=buf1;

				
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Style.Text_Field);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(Style.Fon);
		comboBox.setModel(new DefaultComboBoxModel(mas));
		comboBox.setBounds(10, 65, 161, 27);
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton(Core.Language.delete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String colon=(String)comboBox.getSelectedItem();
				int n=comboBox.getSelectedIndex();
				String inf[]=abc.split(" ");
		
				String type=inf[n];

				if(type.equals("VARCHAR(50)")||type.equals("DATE")||type.equals("TIME")){
					comand="DELETE FROM "+tab+" WHERE "+colon+" = '"+textField.getText()+"'";
				}
				if(type.equals("INTEGER")||type.equals("DOUBLE")){
					comand="DELETE FROM "+tab+" WHERE "+colon+" = "+textField.getText();
				}
				
				Core.SQLB.SQL(comand);
				
				textArea.setText(Core.Member.res);
				repaint();
				
			}
		});
		btnDelete.setIcon(new ImageIcon("image\\delete-256_39x39.png"));
		btnDelete.setForeground(Style.Shrift_Button);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBackground(Style.Fon);
		btnDelete.setBounds(390, 22, 168, 29);
		contentPane.add(btnDelete);
		
		setVisible(true);
	}
}


