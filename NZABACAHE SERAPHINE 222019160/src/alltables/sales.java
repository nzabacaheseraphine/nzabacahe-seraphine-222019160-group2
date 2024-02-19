package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class sales {

	 JFrame frame;
	private JTextField saidtxf;
	private JTextField snametxf;
	private JTextField qtytxf;
	private JTextField totaltxf;
	private JTextField mushtxf;
	private JTextField custxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales window = new sales();
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
	public sales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		frame.setBounds(100, 100, 440, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SALES");
		lblNewLabel.setBounds(10, 11, 414, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel sidld = new JLabel("sale_id");
		sidld.setBounds(20, 40, 121, 22);
		sidld.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sidld.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(sidld);
		
		JLabel salnumbelb = new JLabel("sale_name");
		salnumbelb.setBounds(20, 73, 121, 22);
		salnumbelb.setHorizontalAlignment(SwingConstants.CENTER);
		salnumbelb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(salnumbelb);
		
		JLabel totlb = new JLabel("total price");
		totlb.setBounds(20, 143, 121, 22);
		totlb.setHorizontalAlignment(SwingConstants.CENTER);
		totlb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(totlb);
		
		JLabel custolb = new JLabel("customer_id");
		custolb.setBounds(20, 179, 121, 22);
		custolb.setHorizontalAlignment(SwingConstants.CENTER);
		custolb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(custolb);
		
		JLabel mushlb = new JLabel("mushroom_id");
		mushlb.setBounds(20, 212, 121, 22);
		mushlb.setHorizontalAlignment(SwingConstants.CENTER);
		mushlb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(mushlb);
		
		JLabel quanlb = new JLabel("quantity");
		quanlb.setBounds(20, 110, 121, 22);
		quanlb.setHorizontalAlignment(SwingConstants.CENTER);
		quanlb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(quanlb);
		
		saidtxf = new JTextField();
		saidtxf.setBounds(220, 51, 121, 20);
		saidtxf.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(saidtxf);
		saidtxf.setColumns(10);
		
		snametxf = new JTextField();
		snametxf.setBounds(220, 82, 121, 22);
		frame.getContentPane().add(snametxf);
		snametxf.setColumns(10);
		
		qtytxf = new JTextField();
		qtytxf.setBounds(220, 115, 121, 22);
		frame.getContentPane().add(qtytxf);
		qtytxf.setColumns(10);
		
		totaltxf = new JTextField();
		totaltxf.setBounds(220, 149, 121, 20);
		frame.getContentPane().add(totaltxf);
		totaltxf.setColumns(10);
		
		mushtxf = new JTextField();
		mushtxf.setBounds(224, 212, 117, 22);
		frame.getContentPane().add(mushtxf);
		mushtxf.setColumns(10);
		custxf = new JTextField();
		custxf.setBounds(220, 181, 117, 20);
		frame.getContentPane().add(custxf);
		custxf.setColumns(10);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(158, 261, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saidtxf.setText("");
				snametxf.setText("");
				qtytxf.setText("");
				totaltxf.setText("");
				mushtxf.setText("");
				custxf.setText("");
			}
		});
		frame.getContentPane().add(btnCancel);
		JButton addbtn = new JButton("ADD");
		addbtn.setBounds(20, 261, 89, 23);
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/seraphine_nzabacahe_mms","222019160","222019160");
					String query="INSERT INTO sales VALUES(?,?,?,?,?,?)";
					PreparedStatement stm=con.prepareStatement(query);
					stm.setInt(1, Integer.parseInt(saidtxf.getText()));
					stm.setString(2, snametxf.getText());
					stm.setInt(3, Integer.parseInt(qtytxf.getText()));
					stm.setInt(4, Integer.parseInt(totaltxf.getText()));
					stm.setInt(5, Integer.parseInt(mushtxf.getText()));
					stm.setInt(6, Integer.parseInt(custxf.getText()));
					stm.executeUpdate();
					JOptionPane.showMessageDialog(addbtn, "sales successfully!!!!!!!");
					stm.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		frame.getContentPane().add(addbtn);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				alltablessystem all= new alltablessystem();
			all.frame.setVisible(true);
			frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(278, 261, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
