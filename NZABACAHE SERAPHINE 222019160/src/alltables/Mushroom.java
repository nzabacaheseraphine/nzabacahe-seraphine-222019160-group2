package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;

public class Mushroom {

	JFrame frame;
	private JTextField idtxf;
	private JTextField nmtxf;
	private JTextField destxf;
	private JTextField qtytxf;
	private JTextField uptxf;
	private JTextField tptxf;
	private JButton addbtn;
	private JButton btnExit;
	protected JTextComponent qrytxf;
	protected JTextComponent untytxf;
	protected Object tottxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mushroom window = new Mushroom();
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
	public Mushroom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setBounds(100, 100, 450, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		idtxf = new JTextField();
		idtxf.setBounds(177, 63, 201, 20);
		frame.getContentPane().add(idtxf);
		idtxf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("MUSHROOM");
		lblNewLabel.setBounds(10, 11, 414, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel idlb = new JLabel("ID");
		idlb.setBounds(10, 59, 134, 25);
		idlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(idlb);
		
		JLabel nmlb = new JLabel("NAME");
		nmlb.setBounds(10, 91, 134, 25);
		nmlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(nmlb);
		
		JLabel deslb = new JLabel("DESCRIPTION");
		deslb.setBounds(10, 137, 134, 25);
		deslb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(deslb);
		
		JLabel qtylb = new JLabel("QUANTITY");
		qtylb.setBounds(10, 179, 134, 25);
		qtylb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(qtylb);
		
		JLabel uplb = new JLabel("UNIT PRICE");
		uplb.setBounds(10, 228, 134, 25);
		uplb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(uplb);
		
		JLabel tplb = new JLabel("TOTAL PRICE");
		tplb.setBounds(10, 265, 134, 25);
		tplb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(tplb);
		
		nmtxf = new JTextField();
		nmtxf.setBounds(177, 94, 201, 20);
		nmtxf.setColumns(10);
		frame.getContentPane().add(nmtxf);
		
		destxf = new JTextField();
		destxf.setBounds(177, 141, 201, 20);
		destxf.setColumns(10);
		frame.getContentPane().add(destxf);
		
		qtytxf = new JTextField();
		qtytxf.setBounds(177, 183, 201, 20);
		qtytxf.setColumns(10);
		frame.getContentPane().add(qtytxf);
		
		uptxf = new JTextField();
		uptxf.setBounds(177, 232, 201, 20);
		uptxf.setColumns(10);
		frame.getContentPane().add(uptxf);
		
		tptxf = new JTextField();
		tptxf.setBounds(177, 269, 201, 20);
		tptxf.setColumns(10);
		frame.getContentPane().add(tptxf);
		
		addbtn = new JButton("ADD");
		addbtn.setBounds(56, 328, 89, 23);
		addbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/seraphine_nzabacahe_mms","222019160","222019160");
					String query ="INSERT INTO mushroom VALUES(?,?,?,?,?,?)";
					PreparedStatement pStatement =connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(idtxf.getText()));
					pStatement.setString(2, nmtxf.getText());
					pStatement.setString(3, destxf.getText());
					pStatement.setInt(4,Integer.parseInt(qtytxf.getText()));
					pStatement.setInt(5,Integer.parseInt(uptxf.getText()));
					pStatement.setInt(6,Integer.parseInt(tptxf.getText()));
					
		pStatement.executeUpdate();
		JOptionPane.showMessageDialog(addbtn,"mushroom added successfully");
		pStatement.close();
		connection.close();
		
		
		
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				
				}
				
			}
		});
		frame.getContentPane().add(addbtn);
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(162, 328, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idtxf.setText(null);
				nmtxf.setText(null);
				destxf.setText(null);
				qtytxf.setText(null);
				uptxf.setText(null);
				tptxf.setText(null);

				
			}
		});
		frame.getContentPane().add(btnExit);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alltablessystem all= new alltablessystem();
				all.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnback.setBounds(274, 328, 89, 23);
		frame.getContentPane().add(btnback);
	}
}
