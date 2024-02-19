package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.mysql.cj.xdevapi.Statement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class LOGINFORM {

JFrame frame;
	private JTextField usntxf;
	private JTextField usttxf;
	private JTextField passtxf;
	protected Object con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGINFORM window = new LOGINFORM();
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
	public LOGINFORM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 682, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN  FORM");
		lblNewLabel.setBounds(275, 24, 190, 54);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel usnlb = new JLabel("username");
		usnlb.setFont(new Font("Tahoma", Font.BOLD, 19));
		usnlb.setBounds(41, 93, 155, 44);
		frame.getContentPane().add(usnlb);
		
		JLabel ustlb = new JLabel("usertype");
		ustlb.setFont(new Font("Tahoma", Font.BOLD, 19));
		ustlb.setBounds(40, 163, 116, 37);
		frame.getContentPane().add(ustlb);
		
		JLabel passlb = new JLabel("password");
		passlb.setFont(new Font("Tahoma", Font.BOLD, 19));
		passlb.setBounds(33, 233, 104, 37);
		frame.getContentPane().add(passlb);
		
		JButton btnlogin = new JButton("login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mushroommanagementsystem","root","");
					java.sql.Statement stm=connection.createStatement();
					String query="select * from accountcreation where username='"+usntxf.getText()+"' and password='"+passtxf.getText().toString()+"'";
					Resultset rs=(Resultset) stm.executeQuery(query);
					if (((ResultSet) rs).next()) {
						JOptionPane.showMessageDialog(btnlogin, "login successfully!!!");
						alltablessystem all=new alltablessystem();
						all.frame.setVisible(true);
						frame.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "username or password incorrect!!");
					}

				} catch (Exception e2) {
					
				}
			}
		});
		btnlogin.setForeground(new Color(0, 0, 255));
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnlogin.setBounds(94, 301, 133, 54);
		frame.getContentPane().add(btnlogin);
		
		JButton btnsignup = new JButton("sign up");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountcreation acc=new accountcreation();
				acc.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnsignup.setForeground(new Color(128, 128, 255));
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnsignup.setBounds(278, 302, 126, 52);
		frame.getContentPane().add(btnsignup);
		
		JButton btncancel = new JButton("cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usntxf.setText(null);
				usttxf.setText(null);
				passtxf.setText(null);
			}
		});
		btncancel.setForeground(new Color(255, 0, 0));
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btncancel.setBounds(446, 302, 167, 52);
		frame.getContentPane().add(btncancel);
		
		usntxf = new JTextField();
		usntxf.setBounds(305, 87, 308, 37);
		frame.getContentPane().add(usntxf);
		usntxf.setColumns(10);
		
		usttxf = new JTextField();
		usttxf.setBounds(305, 156, 308, 44);
		frame.getContentPane().add(usttxf);
		usttxf.setColumns(10);
		
		passtxf = new JTextField();
		passtxf.setBounds(305, 233, 308, 44);
		frame.getContentPane().add(passtxf);
		passtxf.setColumns(10);
	}
}
