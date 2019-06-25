package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Content extends JFrame {
String passuname;
	private JPanel contentPane;
Content(String uname)
{
	passuname=uname;
	System.out.println("content"+passuname);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 730, 446);
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.activeCaption);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.control);
	panel.setBorder(new LineBorder(Color.DARK_GRAY, 8));
	panel.setBounds(39, 96, 280, 273);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblTransction = new JLabel("Transaction.");
	lblTransction.setForeground(new Color(0, 0, 128));
	lblTransction.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblTransction.setBounds(25, 25, 164, 30);
	panel.add(lblTransction);
	
	JButton btnTransfeer = new JButton("PAYTM TRANSFER");
	btnTransfeer.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	btnTransfeer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Transfer t = new Transfer(passuname);
			t.setVisible(true);
		}
	});
	btnTransfeer.setBounds(44, 75, 189, 30);
	panel.add(btnTransfeer);
	
	JButton btnCredit = new JButton("ADD MONEY");
	btnCredit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	btnCredit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			AddMoney am = new AddMoney(passuname);
			am.setVisible(true);
		}
	});
	btnCredit.setBounds(44, 131, 189, 30);
	panel.add(btnCredit);
	
	JButton btnMyBalnace = new JButton("MY BALANCE");
	btnMyBalnace.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	btnMyBalnace.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Mybalance m=new Mybalance(passuname);
			m.setVisible(true);
		}
	});
	btnMyBalnace.setBounds(44, 188, 189, 30);
	panel.add(btnMyBalnace);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(SystemColor.control);
	panel_1.setLayout(null);
	panel_1.setBorder(new LineBorder(Color.DARK_GRAY, 8));
	panel_1.setBounds(380, 96, 280, 273);
	contentPane.add(panel_1);
	
	JButton btnMovies = new JButton("MOVIES");
	btnMovies.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	btnMovies.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Movies m= new Movies(passuname);
			m.setVisible(true);
		}
	});
	btnMovies.setBounds(69, 94, 146, 30);
	panel_1.add(btnMovies);
	
	JButton btnShopping = new JButton("SHOPPING");
	btnShopping.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Shopping s= new Shopping(passuname);
			s.setVisible(true);
		}
	});
	btnShopping.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	btnShopping.setBounds(69, 163, 146, 30);
	panel_1.add(btnShopping);
	
	JLabel lblEntertainment = new JLabel("Entertainment.");
	lblEntertainment.setForeground(new Color(0, 0, 128));
	lblEntertainment.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
	lblEntertainment.setBounds(21, 26, 212, 30);
	panel_1.add(lblEntertainment);
	
	JLabel lblPleaseSelectThe = new JLabel("PLEASE SELECT THE REQUIRED OPTIONS");
	lblPleaseSelectThe.setForeground(SystemColor.controlText);
	lblPleaseSelectThe.setFont(new Font("Segoe Print", Font.BOLD, 26));
	lblPleaseSelectThe.setBounds(39, 38, 603, 30);
	contentPane.add(lblPleaseSelectThe);
	

}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("inside run of content");
					Content frame = new Content();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Content() {

		

		
					}
}
