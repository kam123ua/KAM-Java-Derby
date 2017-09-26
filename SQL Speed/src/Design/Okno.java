package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Okno extends JFrame {

	private Panel contentPane;
	public static double derby=0;
	public static double MySQL=0;
	private JTextField textField;
	public static int n=1;
	
	public static void SQL_Derby(){
		try {
			String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
			String JDBC_URL="jdbc:derby:database\\derby;create=true";
			Class.forName(DRIVER);
			String comand;
			double timeout = 0;
			Connection connection=DriverManager.getConnection(JDBC_URL);
			
			double buf=0;
			derby=0;
			
			timeout= System.currentTimeMillis();
			
			for(int i=0;i<n;i++){
				
				comand="INSERT INTO tab0 values ('1')";
				connection.createStatement().execute(comand);			
			}
			
			timeout = System.currentTimeMillis() - timeout;
			derby=derby+timeout;
			buf=buf+timeout;
				
			comand="DELETE FROM tab0 where A='1'";
			connection.createStatement().execute(comand);
		
			
			if(connection !=null) connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void SQL_MySQL(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bmysql","root", "");
			
			String comand;
			double timeout=0;
			double buf=0;
			MySQL=0;
			timeout= System.currentTimeMillis();
			
			for(int i=0;i<n;i++){
				comand="INSERT INTO tab values ('1')";
				conn.createStatement().execute(comand);
				
			}
			timeout = System.currentTimeMillis() - timeout;
			MySQL=MySQL+timeout;
			buf=buf+timeout;
						
			comand="DELETE FROM tab where A='1'";
			conn.createStatement().execute(comand);
		
			
			if(conn !=null) conn.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	JButton btnNewButton;
	
	public Okno() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 351);
		contentPane = new Panel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(97, 127, 208, 29);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_1.setBounds(97, 167, 208, 29);
		contentPane.add(textArea_1);
		
		btnNewButton = new JButton("Почати тест швидкості");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				n=Integer.parseInt(textField.getText());
				
				double [] d=new double[100];
				double[] m=new double[100];
				
				for(int i=0;i<100;i++){
					SQL_Derby();
					SQL_MySQL();
					d[i]=derby;
					m[i]=MySQL;
				}
				double buf;
				
				for(int i=0;i<100;i++){
					for(int j=1+i;j<100;j++){
						if(m[i]>m[j]){
							buf=m[i];
							m[i]=m[j];
							m[j]=buf;
						}
						if(d[i]>d[j]){
							buf=d[i];
							d[i]=d[j];
							d[j]=buf;
						}
					}
				}
				
				
				
				derby=MySQL=0;
								
				for(int i=19;i<80;i++){
					derby=derby+d[i];
					MySQL=MySQL+m[i];
				}
				
				derby=derby/60;
				MySQL=MySQL/60;
					
				textArea.setText(""+derby);
				textArea_1.setText(""+MySQL);
				btnNewButton.setEnabled(false);
				textField.setEnabled(false);
				repaint();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(97, 11, 223, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblDerby = new JLabel("Derby:");
		lblDerby.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDerby.setBounds(10, 127, 80, 29);
		contentPane.add(lblDerby);
		
		JLabel lblMyS = new JLabel("MySQL:");
		lblMyS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMyS.setBounds(10, 167, 80, 29);
		contentPane.add(lblMyS);
		
		textField = new JTextField();
		textField.setBounds(154, 75, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u041A\u0456\u043B\u044C\u043A\u0456\u0441\u0442\u044C \u0437\u0430\u043F\u0438\u0442\u0456\u0432:");
		label.setBounds(25, 75, 119, 20);
		contentPane.add(label);
		
			
		setVisible(true);
	}
}
