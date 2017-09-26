package Design;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Open extends JFrame {

	private Panel contentPane;
	private JLabel lblName;
	private JTextField textArea_NameDatabase;
	private JButton btnOpenDatabase;
	
	private static void Funk(){
		Core.Metod.Wait();
		Core.SQLB.Conn();
		Core.Member.kof="2";
		@SuppressWarnings("unused")
		Table TableF=new Table();
	}

	public Open() {
		setTitle(Core.Language.okno_op);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 177);
		contentPane = new Panel();
		contentPane.setBackground(Style.Fon);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel(Core.Language.cr_name);
		lblName.setForeground(Style.Word);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(10, 11, 186, 54);
		contentPane.add(lblName);
		
		textArea_NameDatabase = new JTextField();
		textArea_NameDatabase.setBackground(Style.Fon);
		textArea_NameDatabase.setForeground(Style.Text_Field);
		textArea_NameDatabase.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_NameDatabase.setBounds(192, 23, 370, 29);
		contentPane.add(textArea_NameDatabase);
		
		textArea_NameDatabase.addKeyListener (new KeyListener () {
            public void keyTyped    (KeyEvent e) {}
            public void keyPressed  (KeyEvent e) {
                if (e.getKeyCode () == 10) {
                	Core.Member.name=textArea_NameDatabase.getText();
    				
    				if(Core.Member.name.length()==0){
    					JOptionPane.showMessageDialog(null, Core.Language.mes_emp);
    				}
    				else{
    					setVisible(false);
    					Funk();
    				}
                }
            }
            public void keyReleased (KeyEvent e) {}
        });
		
		contentPane.addKeyListener (new KeyListener () {
            public void keyTyped    (KeyEvent e) {}
            public void keyPressed  (KeyEvent e) {
                if (e.getKeyCode () == 10) {
                	Core.Member.name=textArea_NameDatabase.getText();
    				
    				if(Core.Member.name.length()==0){
    					JOptionPane.showMessageDialog(null, Core.Language.mes_emp);
    				}
    				else{
    					setVisible(false);
    					Funk();
    				}
                }
            }
            public void keyReleased (KeyEvent e) {}
        });
		
		btnOpenDatabase = new JButton(Core.Language.okno_op);
		btnOpenDatabase.setIcon(new ImageIcon("image\\add_create.png"));
		btnOpenDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Core.Member.name=textArea_NameDatabase.getText();
				
				if(Core.Member.name.length()==0){
					JOptionPane.showMessageDialog(null, Core.Language.mes_emp);
				}
				else{
					setVisible(false);
					Funk();
				}
			}
		});
		btnOpenDatabase.setForeground(Style.Shrift);
		btnOpenDatabase.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnOpenDatabase.setBackground(Style.Fon);
		btnOpenDatabase.setBounds(242, 77, 320, 41);
		contentPane.add(btnOpenDatabase);
		
		setVisible(true);
	}
}