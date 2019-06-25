package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMoney extends JFrame {

	private JPanel contentPane;
	String uname;
	
	AddMoney(String username)
	{
		uname=username;
		conn=DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 428);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 8));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(36, 101, 542, 257);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Amount:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label_1.setBounds(52, 113, 160, 29);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 113, 160, 29);
		panel.add(textField_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Statement st = conn.createStatement();
					int amount=Integer.parseInt(textField_1.getText());
					
					
		            String q1="update createaccount set balance=balance+'"+amount+"' where username='"+uname+"'";
		            String q2="select balance from createaccount where username='"+uname+"' ";
		            
					st.executeUpdate(q1);
					JOptionPane.showMessageDialog(null, "Amount has been added successfully");
			        ResultSet rs=st.executeQuery(q2);
			        while(rs.next())
			        {
			        	textField_2.setText(Integer.toString(rs.getInt(1)));
			        }
				
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnAdd.setBounds(212, 193, 96, 29);
		panel.add(btnAdd);
		
		JLabel label = new JLabel("My Balance:");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label.setBounds(52, 28, 160, 43);
		panel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 28, 122, 36);
		panel.add(textField_2);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Content con=new Content(uname);
				con.setVisible(true);
			}
		});
		btnHome.setBounds(457, 223, 61, 23);
		panel.add(btnHome);
		
		JLabel lblAddMoneyTo = new JLabel("ADD MONEY TO WALLET..!!");
		lblAddMoneyTo.setFont(new Font("Segoe Script", Font.BOLD, 26));
		lblAddMoneyTo.setBounds(36, 35, 455, 39);
		contentPane.add(lblAddMoneyTo);		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMoney frame = new AddMoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection conn = null;
    private JTextField textField_1;
    private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public AddMoney() {
	


			}
}
