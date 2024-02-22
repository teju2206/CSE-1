package send_data_reg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signin {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JPasswordField p1;
	private JPasswordField p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin window = new signin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		lblNewLabel.setBounds(21, 68, 66, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pswrd");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		lblNewLabel_1.setBounds(21, 131, 82, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb1 = new JTextField();
		tb1.setBounds(115, 82, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		lblNewLabel_2.setBounds(222, 82, 74, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pswrd");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 28));
		lblNewLabel_3.setBounds(224, 131, 72, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		tb2 = new JTextField();
		tb2.setBounds(319, 82, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=tb1.getText();
				String password=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mrec");
					PreparedStatement stn=con.prepareStatement("select user,password from users where user=? and password=?");
					stn.setString(1, user);
					stn.setString(2, password);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton, "valid user");	
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton, "invalid user");
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				} 
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton.setBounds(100, 191, 101, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btnNewButton_1.setBounds(301, 191, 107, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		p1 = new JPasswordField();
		p1.setBounds(115, 142, 86, 20);
		frame.getContentPane().add(p1);
		
		p2 = new JPasswordField();
		p2.setBounds(319, 142, 86, 20);
		frame.getContentPane().add(p2);
	}
}
