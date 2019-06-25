package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class Movies extends JFrame {

	private JPanel contentPane;
	String uname;
	int balance;
	
	Movies(String username)
	{
		uname=username;

		conn=DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/images.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
	    label.setBounds(30, 11, 175, 206);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/padma.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(391, 11, 175, 206);
		contentPane.add(label_1);
		
		JLabel lblJudwa = new JLabel("JUDWA 2");
		lblJudwa.setForeground(new Color(0, 0, 139));
		lblJudwa.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblJudwa.setBounds(215, 11, 138, 25);
		contentPane.add(lblJudwa);
		
		JButton btnBookNow = new JButton("BOOK NOW");
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					Statement st = conn.createStatement();
					String q3="select balance from createaccount where username='"+uname+"' ";
					ResultSet rs=st.executeQuery(q3);
					while(rs.next())
					{
						 balance=rs.getInt(1);
					}
					String q1="Update createaccount set balance=balance-100 where username='"+uname+"'";
					if(balance>=100)
					{
					
					st.executeUpdate(q1);
					JOptionPane.showMessageDialog(null,"Ticket booked");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!!1");
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnBookNow.setBounds(222, 194, 100, 23);
		contentPane.add(btnBookNow);
		
		JButton button = new JButton("BOOK NOW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					Statement st = conn.createStatement();
					String q3="select balance from createaccount where username='"+uname+"' ";
					ResultSet rs=st.executeQuery(q3);
					while(rs.next())
					{
						 balance=rs.getInt(1);
					}
					String q1="Update createaccount set balance=balance-120 where username='"+uname+"'";
					if(balance>=120)
					{
					
					st.executeUpdate(q1);
					JOptionPane.showMessageDialog(null,"Ticket booked");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!!1");
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(576, 194, 100, 23);
		contentPane.add(button);
		
		JLabel lblPriceRs = new JLabel("Price:100 Rs.");
		lblPriceRs.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPriceRs.setBounds(222, 169, 100, 14);
		contentPane.add(lblPriceRs);
		
		JLabel label_2 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/ms.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		label_2.setBounds(30, 242, 175, 206);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/dan.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(391, 242, 175, 206);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("BOOK NOW");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Statement st = conn.createStatement();
					String q3="select balance from createaccount where username='"+uname+"' ";
					ResultSet rs=st.executeQuery(q3);
					while(rs.next())
					{
						 balance=rs.getInt(1);
					}
					String q1="Update createaccount set balance=balance-120 where username='"+uname+"'";
					if(balance>=100)
					{
					
					st.executeUpdate(q1);
					JOptionPane.showMessageDialog(null,"Ticket booked");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!!1");
					}
				}
				catch (SQLException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		button_1.setBounds(215, 425, 107, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("BOOK NOW");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Statement st = conn.createStatement();
					String q3="select balance from createaccount where username='"+uname+"' ";
					ResultSet rs=st.executeQuery(q3);
					while(rs.next())
					{
						 balance=rs.getInt(1);
					}
					String q1="Update createaccount set balance=balance-150 where username='"+uname+"'";
					if(balance>=100)
					{
					
					st.executeUpdate(q1);
					JOptionPane.showMessageDialog(null,"Ticket booked");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!!1");
					}
				}
				catch (SQLException g) {
					// TODO Auto-generated catch block
					g.printStackTrace();
				}
			}
		});
		button_2.setBounds(576, 425, 100, 23);
		contentPane.add(button_2);
		
		JLabel lblPadmavati = new JLabel("PADMAVATI");
		lblPadmavati.setForeground(new Color(0, 0, 139));
		lblPadmavati.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblPadmavati.setBounds(578, 11, 138, 25);
		contentPane.add(lblPadmavati);
		
		JLabel lblMsDhoni = new JLabel("MS.DHONI");
		lblMsDhoni.setForeground(new Color(0, 0, 139));
		lblMsDhoni.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblMsDhoni.setBounds(215, 242, 138, 25);
		contentPane.add(lblMsDhoni);
		
		JLabel lblDangal = new JLabel("DANGAL");
		lblDangal.setForeground(new Color(0, 0, 139));
		lblDangal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDangal.setBounds(576, 242, 138, 25);
		contentPane.add(lblDangal);
		
		JLabel lblPriceRs_3 = new JLabel("Price:120 Rs.");
		lblPriceRs_3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPriceRs_3.setBounds(576, 169, 100, 14);
		contentPane.add(lblPriceRs_3);
		
		JLabel lblPriceRs_1 = new JLabel("Price:120 Rs.");
		lblPriceRs_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPriceRs_1.setBounds(215, 400, 100, 14);
		contentPane.add(lblPriceRs_1);
		
		JLabel lblPriceRs_2 = new JLabel("Price:150 Rs.");
		lblPriceRs_2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPriceRs_2.setBounds(576, 400, 100, 14);
		contentPane.add(lblPriceRs_2);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Content c1= new Content(uname);
				c1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(686, 425, 67, 23);
		contentPane.add(btnNewButton);
				
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies frame = new Movies();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection conn=null;
	/**
	 * Create the frame.
	 */
	public Movies() {


				
	}
}
