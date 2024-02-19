
	package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class accountcreation {

	 JFrame frame;
	private JTextField idtxf;
	private JTextField fnmtxf;
	private JTextField addtxf;
	private JTextField emailtxf;
	private JTextField agetxf;
	private JTextField usernmtxf;
	private JTextField usetytxf;
	private JPasswordField psstxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accountcreation window = new accountcreation();
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
	public accountcreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 531, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE YOUR ACCOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 495, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel idlb = new JLabel("ID");
		idlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		idlb.setBounds(10, 69, 120, 26);
		frame.getContentPane().add(idlb);
		
		JLabel nmlb = new JLabel("FULL NAME");
		nmlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nmlb.setBounds(10, 118, 120, 26);
		frame.getContentPane().add(nmlb);
		
		JLabel addlb = new JLabel("ADDRESS");
		addlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		addlb.setBounds(10, 166, 120, 26);
		frame.getContentPane().add(addlb);
		
		JLabel emaillb = new JLabel("EMAIL");
		emaillb.setFont(new Font("Tahoma", Font.BOLD, 15));
		emaillb.setBounds(10, 219, 120, 26);
		frame.getContentPane().add(emaillb);
		
		JLabel aglb = new JLabel("AGE");
		aglb.setFont(new Font("Tahoma", Font.BOLD, 15));
		aglb.setBounds(10, 275, 120, 26);
		frame.getContentPane().add(aglb);
		
		JLabel usernnlb = new JLabel("USERNAME");
		usernnlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernnlb.setBounds(10, 317, 120, 26);
		frame.getContentPane().add(usernnlb);
		
		JLabel usetylb = new JLabel("USERTYPE");
		usetylb.setFont(new Font("Tahoma", Font.BOLD, 15));
		usetylb.setBounds(10, 367, 120, 26);
		frame.getContentPane().add(usetylb);
		
		JLabel psslb = new JLabel("PASSWORD");
		psslb.setFont(new Font("Tahoma", Font.BOLD, 15));
		psslb.setBounds(10, 405, 120, 26);
		frame.getContentPane().add(psslb);
		
		JButton creatbtn = new JButton("CREATE");
		creatbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/seraphine_nzabacahe_mms","222019160","222019160");
					String query="INSERT INTO accountcreation VALUES(?,?,?,?,?,?,?,?)";
					PreparedStatement ps= connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(idtxf.getText()));
					ps.setString(2, fnmtxf.getText());
					ps.setString(3, addtxf.getText());
					ps.setString(4, emailtxf.getText());
					ps.setInt(5, Integer.parseInt(agetxf.getText()));
					ps.setString(6, usernmtxf.getText());
					ps.setString(7, usetytxf.getText());
					ps.setString(8, psstxf.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(creatbtn, "CREATED SUCCESSFULLY!!!!!!!!!!!!");
					LOGINFORM log=new LOGINFORM();
					log.frame.setVisible(true);
					frame.dispose();
					ps.close();
					connection.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		creatbtn.setBounds(87, 454, 102, 38);
		frame.getContentPane().add(creatbtn);
		
		JButton cancelbtn = new JButton("CANCEL");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtxf.setText(null);
				fnmtxf.setText("");
				addtxf.setText(null);
				emailtxf.setText(null);
				agetxf.setText(null);
				usernmtxf.setText(null);
				usetytxf.setText(null);
				psstxf.setText(null);
			}
		});
		cancelbtn.setBounds(235, 454, 102, 38);
		frame.getContentPane().add(cancelbtn);
		
		idtxf = new JTextField();
		idtxf.setBounds(213, 74, 247, 20);
		frame.getContentPane().add(idtxf);
		idtxf.setColumns(10);
		
		fnmtxf = new JTextField();
		fnmtxf.setColumns(10);
		fnmtxf.setBounds(213, 123, 247, 20);
		frame.getContentPane().add(fnmtxf);
		
		addtxf = new JTextField();
		addtxf.setColumns(10);
		addtxf.setBounds(213, 171, 247, 20);
		frame.getContentPane().add(addtxf);
		
		emailtxf = new JTextField();
		emailtxf.setColumns(10);
		emailtxf.setBounds(213, 224, 247, 20);
		frame.getContentPane().add(emailtxf);
		
		agetxf = new JTextField();
		agetxf.setColumns(10);
		agetxf.setBounds(213, 280, 247, 20);
		frame.getContentPane().add(agetxf);
		
		usernmtxf = new JTextField();
		usernmtxf.setColumns(10);
		usernmtxf.setBounds(213, 322, 247, 20);
		frame.getContentPane().add(usernmtxf);
		
		usetytxf = new JTextField();
		usetytxf.setColumns(10);
		usetytxf.setBounds(213, 372, 247, 20);
		frame.getContentPane().add(usetytxf);
		
		psstxf = new JPasswordField();
		psstxf.setBounds(213, 410, 247, 20);
		frame.getContentPane().add(psstxf);
	}
}