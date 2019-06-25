package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;


public class Transfer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String debituname;
	private JTextField textField_1;
Transfer(String username)
{
	debituname=username;
	 conn=DbConnection.dbConnector();                        //calling dbConnection class in DbConnection class
	    
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 689, 446);
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.activeCaption);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("EASY TRANSFER....!!!!!");
	lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 26));
	lblNewLabel.setBounds(10, 11, 357, 39);
	contentPane.add(lblNewLabel);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.inactiveCaption);
	panel.setBorder(new LineBorder(Color.DARK_GRAY, 8));
	panel.setBounds(20, 71, 617, 304);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblTransferTo = new JLabel("Transfer To:");
	lblTransferTo.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblTransferTo.setBounds(48, 60, 160, 29);
	panel.add(lblTransferTo);
	
	textField = new JTextField();
	textField.setBounds(204, 58, 249, 35);
	panel.add(textField);
	textField.setColumns(10);
	
	JLabel lblAmount = new JLabel("Amount:");
	lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 24));
	lblAmount.setBounds(48, 114, 160, 29);
	panel.add(lblAmount);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(204, 108, 249, 35);
	panel.add(textField_1);
	
	JButton btnTransfer = new JButton("TRANSFER");
	btnTransfer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
			String payTo = textField.getText();
			int amount=Integer.parseInt(textField_1.getText());
		    String q1=" update createaccount set balance=balance+'"+amount+"' where username='"+payTo+"'";
		    String q3="select balance from createaccount where username='"+debituname+"' ";
		    String q2="update createaccount set balance=balance-'"+amount+"'where username='"+debituname+"' ";
		    
		    Statement ps=conn.createStatement();
		   
		    ResultSet rs=ps.executeQuery(q3);
		    int balance=0;
		    while(rs.next())
		    {
		    balance=rs.getInt(1);
		    System.out.println("balance is"+balance);
		    }if(balance>=amount)
		    {
		    ps.execute(q1);
		    ps.execute(q2);
		    JOptionPane.showMessageDialog(null, "Amount has been succesfully transfered to "+payTo);
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null,"Sorry...!!!! LOW BALANCE" );
		    }
		    
		    
		    
		    PaytmLogin pl=new PaytmLogin();
		    
		    }
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(null, e);
			}
			
			
		}
	});
	btnTransfer.setBounds(244, 191, 108, 23);
	panel.add(btnTransfer);
	
	JButton btnHome = new JButton("HOME");
	btnHome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Content con = new Content(debituname);
			con.setVisible(true);
		}
	});
	btnHome.setBounds(524, 259, 71, 23);
	panel.add(btnHome);
}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Connection conn = null;
     String username1;
	/**
	 * Create the frame.
	 */

     
     
     public Transfer() {



    				}
   
}
