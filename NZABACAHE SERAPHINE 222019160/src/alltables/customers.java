package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class customers extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final JLabel passtxf = null;
	private JPanel contentPane;
	private JTextField cidtxf;
	private JTextField cntxf;
	private JTextField phontxf;
	private JTextField emtxf;
	private JLabel usnlb;
	private JTextField usntxf;
	private JLabel passlb;
	private JPasswordField passwordtxf;
	protected JLabel idtxf;
	protected JLabel nmtxf;
	protected JLabel teltxf;
	protected JLabel saltxf;
	protected JLabel postxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customers frame = new customers();
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
	public customers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER");
		lblNewLabel.setBounds(307, 11, 163, 44);
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		cidtxf = new JTextField();
		cidtxf.setBounds(194, 61, 494, 34);
		contentPane.add(cidtxf);
		cidtxf.setColumns(10);
		
		JLabel cidlb = new JLabel("customer_id");
		cidlb.setBounds(0, 65, 140, 44);
		cidlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(cidlb);
		
		JLabel cnlb = new JLabel("customer_name");
		cnlb.setBounds(0, 120, 154, 27);
		cnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(cnlb);
		
		cntxf = new JTextField();
		cntxf.setBounds(191, 106, 497, 30);
		contentPane.add(cntxf);
		cntxf.setColumns(10);
		
		JLabel phonlb = new JLabel("phone nbr");
		phonlb.setBounds(0, 158, 130, 27);
		phonlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(phonlb);
		
		JLabel emlb = new JLabel("email");
		emlb.setBounds(0, 196, 96, 27);
		emlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(emlb);
		
		phontxf = new JTextField();
		phontxf.setBounds(191, 161, 497, 26);
		contentPane.add(phontxf);
		phontxf.setColumns(10);
		
		emtxf = new JTextField();
		emtxf.setBounds(191, 209, 497, 27);
		contentPane.add(emtxf);
		emtxf.setColumns(10);
		
		usnlb = new JLabel("user name");
		usnlb.setBounds(0, 245, 140, 34);
		usnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(usnlb);
		
		usntxf = new JTextField();
		usntxf.setBounds(191, 252, 497, 27);
		contentPane.add(usntxf);
		usntxf.setColumns(10);
		
		passlb = new JLabel("password");
		passlb.setBounds(0, 290, 106, 36);
		passlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(passlb);
		
		JButton btnsave = new JButton("save");
btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/seraphine_nzabacahe_mms","222019160","222019160");
					String query="INSERT INTO customers VALUES (?,?,?,?,?,?)";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(cidtxf.getText()));
				    ps.setString(2, cntxf.getText());
					ps.setString(3, phontxf.getText());
					ps.setString(4, (emtxf .getText()));
					ps.setString(5,usntxf.getText());
					ps.setString(6,passwordtxf.getText());
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnsave,"customer Saved Successfully");
					ps.close();
					connection.close();
					
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					
				}
				
			}
		});
		btnsave.setBounds(194, 378, 89, 34);
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnsave);
		
		JButton btnupdate = new JButton("update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mushroommanagementsystem","root","");
					String query="UPDATE customers SET customer_name=? ,phone=?, email=? , username=?,password=? WHERE customer_id=?";
					PreparedStatement stm=connection.prepareStatement(query);
					stm.setString(1, cntxf.getText());	
					stm.setString(2, phontxf.getText());
					stm.setString(3, emtxf.getText());
					stm.setString(4, usntxf.getText());
					stm.setString(5, passtxf.getText());
					JOptionPane.showMessageDialog(btnupdate,"updated wonderfull!!!!!!!!!!!!");
					stm.executeUpdate();
					stm.close();
					connection.close();
					
				} catch (Exception e2) {
					
				}
				
			}
		});
			
				
					
				 
		btnupdate.setBounds(306, 378, 89, 34);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnupdate);
		
		JButton btncancel = new JButton("cancel");
btncancel.addActionListener((ActionListener) new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cidtxf.setText(null);
				cntxf.setText(null);
				phontxf.setText(null);
				emtxf.setText(null);
				usntxf.setText(null);
				passtxf.setText(null);
				
			}
		});
		btncancel.setBounds(443, 378, 89, 34);
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btncancel);
		
		passwordtxf = new JPasswordField();
		passwordtxf.setBounds(191, 299, 494, 27);
		contentPane.add(passwordtxf);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alltablessystem all= new alltablessystem();
				all.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(194, 425, 89, 34);
		contentPane.add(btnNewButton);
				}
				}
				
				
