package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;              //imported from connection.
import javax.swing.*;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaytmLogin extends JFrame {

	public JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaytmLogin frame = new PaytmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
    Connection conn = null;
    private JTextField textField;
    private JPasswordField passwordField;
    public String username;
    public int id;
 
    
	/**
	 * Create the frame.
	 */
	public PaytmLogin() {
		setBackground(SystemColor.activeCaption);
		conn=DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 455);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(SystemColor.scrollbar, 8));
		panel.setBounds(53, 78, 543, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblUserName.setBounds(183, 104, 142, 29);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblPassword.setBounds(197, 144, 142, 29);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(305, 104, 214, 29);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 144, 214, 28);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent e) {
	   
					username=textField.getText();
					System.out.println();
					String password=passwordField.getText();
					try
					{
					String q1="select * from createaccount where username=? and password=? ";
					PreparedStatement ps=conn.prepareStatement(q1);
					ps.setString(1, username);
					ps.setString(2, password);

					
					ResultSet rs = ps.executeQuery();
					
					int count=0;
				while(rs.next())
					{
						count++;
						if(count==1)
						{
							JOptionPane.showMessageDialog(null,"Correct username and password:");
	                        System.out.println("Content visible");
							Content c= new Content(username);
							c.setVisible(true);
							id=rs.getInt(1);
							System.out.println(id);
						}
					
					}
				if(count==0)
				{
				    JOptionPane.showMessageDialog(null, "INCORRECT USERNAME AND PASSWORD");
				    textField.setText("");
				    passwordField.setText("");
				}
					
				} 
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
				     JOptionPane.showMessageDialog(null, e1);
				}
				username=textField.getText();
				System.out.println("***"+username);
			}

		});
		
		btnLogin.setForeground(new Color(0, 0, 128));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setBounds(273, 201, 152, 29);
		panel.add(btnLogin);
		
		JLabel lblWelcomeToPaytm = new JLabel("WELCOME TO PAYTM..!!!");
		lblWelcomeToPaytm.setForeground(new Color(0, 0, 128));
		lblWelcomeToPaytm.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblWelcomeToPaytm.setBounds(54, 31, 437, 36);
		panel.add(lblWelcomeToPaytm);
		
		JLabel lblLoginToPaytm = new JLabel("Login to Paytm Account");
		lblLoginToPaytm.setForeground(new Color(0, 0, 128));
		lblLoginToPaytm.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblLoginToPaytm.setBounds(52, 27, 380, 30);
		contentPane.add(lblLoginToPaytm);
	}
	
}
 

