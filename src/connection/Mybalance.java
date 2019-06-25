package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;

public class Mybalance extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	String uname;

     
	Mybalance(String username)
	{
		uname=username;
		conn=DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 694, 411);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.DARK_GRAY, 8));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(36, 104, 542, 257);
		panel.add(panel_1);
		
		JButton btnShow = new JButton("SHOW BALANCE");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Statement st=conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						textField_2.setText(Integer.toString(rs.getInt(1)));
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnShow.setBounds(192, 172, 134, 29);
		panel_1.add(btnShow);
		
		JLabel label_2 = new JLabel("My Balance:");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		label_2.setBounds(67, 85, 160, 43);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 93, 122, 29);
		panel_1.add(textField_2);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Content con= new Content(uname);
				con.setVisible(true);
			}
		});
		btnHome.setBounds(447, 212, 74, 23);
		panel_1.add(btnHome);
		
		JLabel lblMyPaytmBalance = new JLabel("MY PAYTM BALANCE..!!");
		lblMyPaytmBalance.setFont(new Font("Segoe Script", Font.BOLD, 26));
		lblMyPaytmBalance.setBounds(36, 35, 455, 39);
		panel.add(lblMyPaytmBalance);
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mybalance frame = new Mybalance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection conn = null;
	/**
	 * Create the frame.
	 */
	public Mybalance() {
		

			}
}
