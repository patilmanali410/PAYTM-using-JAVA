package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Shopping extends JFrame {

	private JPanel contentPane;
	String uname;
	
	Shopping(String username)
	{
		uname=username;
		conn=DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/tshirt.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(38, 11, 141, 163);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/tshirt1.jpg")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(274, 11, 141, 163);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image img3=new ImageIcon(this.getClass().getResource("/shoes.jpg")).getImage();
		label_2.setIcon(new ImageIcon(img3));
		label_2.setBounds(508, 11, 141, 163);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		Image img4=new ImageIcon(this.getClass().getResource("/cloth.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img4));
		label_3.setBounds(38, 250, 141, 163);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/wshoes.jpg")).getImage();
		label_4.setIcon(new ImageIcon(img5));
		label_4.setBounds(274, 250, 141, 163);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		Image img6=new ImageIcon(this.getClass().getResource("/cloth1.jpg")).getImage();
		label_5.setIcon(new ImageIcon(img6));
		label_5.setBounds(508, 250, 141, 163);
		contentPane.add(label_5);
		
		JLabel lblPrice = new JLabel("Price:400/-");
		lblPrice.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice.setBounds(75, 173, 122, 14);
		contentPane.add(lblPrice);
		
		JButton btnBuyNow = new JButton("BUY ");
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-250 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnBuyNow.setBounds(78, 195, 68, 23);
		contentPane.add(btnBuyNow);
		
		JLabel lblPrice_1 = new JLabel("Price:900/-");
		lblPrice_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice_1.setBounds(302, 175, 122, 14);
		contentPane.add(lblPrice_1);
		
		JButton button = new JButton("BUY ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-900 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		button.setBounds(312, 195, 68, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("BUY ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-2000 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException g) {
					// TODO Auto-generated catch block
					g.printStackTrace();
				}
			}
		});
		button_1.setBounds(546, 195, 68, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("BUY ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-600 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
			}
		});
		button_2.setBounds(78, 441, 68, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("BUY ");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-1200 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException i) {
					// TODO Auto-generated catch block
					i.printStackTrace();
				}
			}
		});
		button_3.setBounds(312, 441, 68, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("BUY ");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Statement st = conn.createStatement();
					String q1="select balance from createaccount where username='"+uname+"'";
					ResultSet rs=st.executeQuery(q1);
					while(rs.next())
					{
						balance=rs.getInt(1);
					}
					String q2="update createaccount set balance=balance-800 where username='"+uname+"' ";
					if(balance>=250)
					{
						st.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Item Buyed and will be delivered soon..");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "LOW BALANCE..!!");
					}
				} 
				catch (SQLException j) {
					// TODO Auto-generated catch block
					j.printStackTrace();
				}
			}
		});
		button_4.setBounds(546, 441, 68, 23);
		contentPane.add(button_4);
		
		JLabel lblPrice_2 = new JLabel("Price:2000/-");
		lblPrice_2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice_2.setBounds(546, 173, 122, 14);
		contentPane.add(lblPrice_2);
		
		JLabel lblPrice_3 = new JLabel("Price:600/-");
		lblPrice_3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice_3.setBounds(75, 416, 122, 14);
		contentPane.add(lblPrice_3);
		
		JLabel lblPrice_4 = new JLabel("Price:1200/-");
		lblPrice_4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice_4.setBounds(302, 416, 122, 14);
		contentPane.add(lblPrice_4);
		
		JLabel lblPrice_5 = new JLabel("Price:800/-");
		lblPrice_5.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPrice_5.setBounds(535, 416, 122, 14);
		contentPane.add(lblPrice_5);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Content c= new Content(uname);
				c.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		btnHome.setBounds(676, 441, 68, 23);
		contentPane.add(btnHome);
	}
	/**
	 * @wbp.nonvisual location=162,-31
	 */
	private final JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shopping frame = new Shopping();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection conn=null;
     int balance;
	/**
	 * Create the frame.
	 */
	public Shopping() {
	

	}
}
