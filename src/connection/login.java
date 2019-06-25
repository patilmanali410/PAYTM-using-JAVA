package connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

;

public class login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					login window = new login();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
    Connection conn=null;                                      //declaring conn gloablly
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		conn=DbConnection.dbConnector();                        //calling dbConnection class in DbConnection class
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 733, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(SystemColor.scrollbar, 8));
		panel.setBounds(20, 52, 642, 406);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblUserName.setBounds(125, 160, 142, 29);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblPassword.setBounds(125, 200, 142, 29);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(237, 160, 258, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 200, 258, 29);
		panel.add(passwordField);
		
		
		JButton btncreate = new JButton(" CREATE ACCOUNT");
		btncreate.setBackground(SystemColor.controlHighlight);
		btncreate.setForeground(new Color(0, 0, 128));
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{	
			      Statement st=conn.createStatement();
			      
			      String firstname=textField_3.getText();
			      String lastname=textField_2.getText();
			      String username=textField.getText();
			      String password = passwordField.getText();
			      String email = textField_1.getText();
			      if(textField_3.getText()=="")
			      {
			    	  JOptionPane.showMessageDialog(null, "PLEASE ENTER THE DETAILS PROPERLY..!!");
			      }
			      String q1="insert into createaccount values(NULL,'"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+email+"','0')";
			      st.executeUpdate(q1);
			      JOptionPane.showMessageDialog(null,"Account created Successfully...!!!!!");
			      frame.dispose();
			      PaytmLogin pl=new PaytmLogin();
			      pl.setVisible(true);
			      
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btncreate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btncreate.setBounds(232, 307, 228, 29);
		panel.add(btncreate);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblEmail.setBounds(125, 240, 142, 29);
		panel.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(237, 240, 258, 29);
		panel.add(textField_1);
		
		JLabel lblFirstName = new JLabel("Last Name:");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblFirstName.setBounds(125, 122, 142, 29);
		panel.add(lblFirstName);
		
		JLabel label = new JLabel("First Name:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label.setBounds(125, 83, 142, 29);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(237, 120, 258, 29);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(237, 82, 258, 29);
		panel.add(textField_3);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account ? ");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlreadyHaveAn.setForeground(new Color(199, 21, 133));
		lblAlreadyHaveAn.setBounds(143, 369, 166, 14);
		panel.add(lblAlreadyHaveAn);
		
		JButton btnClickHere = new JButton("Log In");
		btnClickHere.setForeground(new Color(0, 0, 128));
		btnClickHere.setBackground(SystemColor.menu);
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  frame.dispose();                                     //opening of next page..
			      PaytmLogin pl=new PaytmLogin();
			      pl.setVisible(true);
			}
		});
		btnClickHere.setBounds(307, 366, 85, 23);
		panel.add(btnClickHere);
		
		JLabel lblNeedToLogin = new JLabel("Create Paytm Account");
		lblNeedToLogin.setForeground(new Color(0, 0, 128));
		lblNeedToLogin.setFont(new Font("Segoe Print", Font.BOLD, 23));
		lblNeedToLogin.setBounds(20, 11, 380, 30);
		frame.getContentPane().add(lblNeedToLogin);
	}
}
