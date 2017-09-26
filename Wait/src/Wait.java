import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Color;

@SuppressWarnings("serial")
public class Wait extends JFrame {

	private JPanel contentPane;

	public Wait() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Style.Fon);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 191, 255));
		progressBar.setEnabled(false);
		progressBar.setIndeterminate(true);
		progressBar.setBounds(10, 11, 300, 54);
		progressBar.setBackground(Style.Fon);
		contentPane.add(progressBar);
		
		setVisible(true);
		
		while(true){
			String fileName = "table.tab";
			if ((new File(fileName)).exists()) {
			    System.exit(0);
			    break;
			}
		}
		
		setVisible(true);
		
		
		
		
	}
}
