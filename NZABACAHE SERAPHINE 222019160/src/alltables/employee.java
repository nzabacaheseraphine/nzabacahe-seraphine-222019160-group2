package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class employee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtxf;
	private JTextField nmtxf;
	private JTextField teltxf;
	private JTextField emtxf;
	private JTextField saltxf;
	private JTextField textField_5;
	private JTextField postxf;
	private JButton savebtn;
	protected JLabel cidtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
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
	public employee() {
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(0, 0, 255));
		setTitle("EMPLOYEE FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idlb = new JLabel("ID");
		idlb.setBounds(10, 34, 145, 40);
		idlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(idlb);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE FORM");
		lblNewLabel.setBounds(339, 10, 186, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		idtxf = new JTextField();
		idtxf.setBounds(332, 50, 206, 33);
		contentPane.add(idtxf);
		idtxf.setColumns(10);
		
		nmtxf = new JTextField();
		nmtxf.setBounds(332, 103, 206, 33);
		nmtxf.setColumns(10);
		contentPane.add(nmtxf);
		
		teltxf = new JTextField();
		teltxf.setBounds(332, 152, 206, 33);
		teltxf.setColumns(10);
		contentPane.add(teltxf);
		
		emtxf = new JTextField();
		emtxf.setBounds(332, 205, 206, 33);
		emtxf.setColumns(10);
		contentPane.add(emtxf);
		
		saltxf = new JTextField();
		saltxf.setBounds(332, 267, 206, 33);
		saltxf.setColumns(10);
		contentPane.add(saltxf);
		
		textField_5 = new JTextField();
		textField_5.setBounds(332, 267, 206, 33);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		postxf = new JTextField();
		postxf.setBounds(332, 323, 206, 33);
		postxf.setColumns(10);
		contentPane.add(postxf);
		
		JButton addbtn = new JButton("save");
		addbtn.setBounds(98, 430, 104, 40);
		savebtn=new JButton("save");
		addbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/seraphine_nzabacahe_mms","222019160","222019160");
					String query="INSERT INTO employee VALUES (?,?,?,?,?,?)";
					PreparedStatement ps=connection.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(idtxf.getText()));
				    ps.setString(2, nmtxf.getText());
					ps.setString(3, emtxf.getText());
					ps.setString(4, (teltxf.getText()));
					ps.setInt(5, Integer.parseInt(saltxf.getText()));
					ps.setString(6, (postxf.getText()));
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(savebtn,"employee Saved Successfully");
					ps.close();
					connection.close();
					
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					
				}
				
			}
		});
		contentPane.add(addbtn);
		
		JButton updatebtn = new JButton("UPDATE");
	updatebtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mushroommanagementsystem","root","");
				String query="UPDATE customer SET employee_name=? ,telephone=?, email=?,salary=?,position=? WHERE employee_id=?";
				PreparedStatement stm=connection.prepareStatement(query);
				stm.setString(1, nmtxf.getText());	
				stm.setString(2, emtxf.getText());
				stm.setString(3, teltxf.getText());
				stm.setString(4, saltxf.getText());
				stm.setString(5, postxf.getText());
				JOptionPane.showMessageDialog(updatebtn,"updated wonderfull!!!!!!!!!!!!");
				stm.executeUpdate();
				stm.close();
				connection.close();
				
			} catch (Exception e2) {
				
			}
			
		}
	});
		
		updatebtn.setBounds(249, 430, 104, 40);
		contentPane.add(updatebtn);
		
		JButton resetbtn = new JButton("RESET");
		resetbtn.setBounds(380, 430, 104, 40);
		resetbtn.addActionListener((ActionListener) new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				idtxf.setText(null);
				nmtxf.setText(null);
				teltxf.setText(null);
				emtxf.setText(null);
				saltxf.setText(null);
				postxf.setText(null);
				
			}
		});
		contentPane.add(resetbtn);
		
		JLabel nmlb = new JLabel("NAME");
		nmlb.setBounds(10, 96, 145, 40);
		nmlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(nmlb);
		
		JLabel tellb = new JLabel("TELEPNONE");
		tellb.setBounds(10, 161, 145, 40);
		tellb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(tellb);
		
		JLabel emlb = new JLabel("EMAIL");
		emlb.setBounds(0, 214, 145, 40);
		emlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(emlb);
		
		JLabel sallb = new JLabel("SALARY");
		sallb.setBounds(0, 260, 145, 40);
		sallb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(sallb);
		
		JLabel poslb = new JLabel("POSITION");
		poslb.setBounds(0, 316, 145, 40);
		poslb.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(poslb);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alltablessystem all= new alltablessystem();
				all.frame.setVisible(true);
				dispose();
			}
		});
		btnback.setBounds(505, 439, 89, 23);
		contentPane.add(btnback);
	}
}
