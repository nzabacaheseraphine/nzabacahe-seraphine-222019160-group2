package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Harvest {

	 JFrame frame;
	private JTextField idtxf;
	private JTextField nmtxf;
	private JTextField qtytxf;
	private JTextField uptxf;
	private JTextField tptxf;
	private JTextField midtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Harvest window = new Harvest();
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
	public Harvest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setBounds(100, 100, 464, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HARVEST");
		lblNewLabel.setBounds(10, 11, 428, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel idlb = new JLabel("ID");
		idlb.setBounds(10, 57, 141, 25);
		idlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(idlb);
		
		JLabel qtylb = new JLabel("QUANTITY");
		qtylb.setBounds(10, 129, 141, 25);
		qtylb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(qtylb);
		
		JLabel nmlb = new JLabel("NAMES");
		nmlb.setBounds(10, 93, 141, 25);
		nmlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(nmlb);
		
		JLabel uplb = new JLabel("UNIT PRICE");
		uplb.setBounds(10, 165, 141, 25);
		uplb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(uplb);
		
		JLabel tplb = new JLabel("TOTAL PRICE");
		tplb.setBounds(10, 205, 141, 25);
		tplb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(tplb);
		
		JLabel midlb = new JLabel("MUSHROOM_ID");
		midlb.setBounds(10, 244, 141, 25);
		midlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(midlb);
		
		idtxf = new JTextField();
		idtxf.setBounds(166, 61, 207, 20);
		frame.getContentPane().add(idtxf);
		idtxf.setColumns(10);
		
		nmtxf = new JTextField();
		nmtxf.setBounds(166, 97, 207, 20);
		nmtxf.setColumns(10);
		frame.getContentPane().add(nmtxf);
		
		qtytxf = new JTextField();
		qtytxf.setBounds(166, 133, 207, 20);
		qtytxf.setColumns(10);
		frame.getContentPane().add(qtytxf);
		
		uptxf = new JTextField();
		uptxf.setBounds(166, 169, 207, 20);
		uptxf.setColumns(10);
		frame.getContentPane().add(uptxf);
		
		tptxf = new JTextField();
		tptxf.setBounds(166, 209, 207, 20);
		tptxf.setColumns(10);
		frame.getContentPane().add(tptxf);
		
		midtxf = new JTextField();
		midtxf.setBounds(166, 248, 207, 20);
		midtxf.setColumns(10);
		frame.getContentPane().add(midtxf);
		
		JButton savebtn = new JButton("SEND");
		savebtn.setBounds(57, 312, 89, 23);
		savebtn.addActionListener(new ActionListener() {
																																								public void actionPerformed(ActionEvent e) {
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mushroommanagementsystem","root","");
					String query="INSERT INTO harvest VALUES (?,?,?,?,?,?)";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(idtxf.getText()));
				    ps.setString(2, nmtxf.getText());
					ps.setInt(3,Integer.parseInt(qtytxf.getText()));
					ps.setInt(4, Integer.parseInt(uptxf.getText()));
					ps.setInt(5, Integer.parseInt(tptxf.getText()));
					ps.setInt(6, Integer.parseInt(midtxf.getText()));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(savebtn,"Harvest Saved Successfully");
					ps.close();
					connection.close();
					
					
				} catch (Exception e2) {
					
				}
				}
				
			
			
			});
		frame.getContentPane().add(savebtn);
		
		JButton cancelbtn = new JButton("CANCEL");
		cancelbtn.setBounds(180, 312, 89, 23);
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idtxf.setText("");
				nmtxf.setText("");
				qtytxf.setText("");
				uptxf.setText("");
				tptxf.setText("");
				midtxf.setText("");
				
			}
		});
		frame.getContentPane().add(cancelbtn);
		
		JButton btnback = new JButton("BACK");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alltablessystem all= new alltablessystem();
				all.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnback.setBounds(302, 312, 89, 23);
		frame.getContentPane().add(btnback);
	}

}
