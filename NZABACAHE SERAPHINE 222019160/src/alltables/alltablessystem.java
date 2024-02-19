package alltables;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class alltablessystem {

	JFrame frame;
	protected LOGINFORM LOGINFORM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alltablessystem window = new alltablessystem();
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
	public alltablessystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 852, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALL TABLES IN SYSTEM");
		lblNewLabel.setBounds(173, 11, 401, 39);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnMushroom = new JButton("mushroom");
		btnMushroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mushroom st=new Mushroom();
				st.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnMushroom.setBounds(63, 185, 211, 52);
		btnMushroom.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(btnMushroom);
		
		JButton btnEmployee = new JButton("employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee st=new employee();
				st.setVisible(true);
				frame.dispose();
			}
		});
		btnEmployee.setBounds(50, 274, 211, 52);
		btnEmployee.setBackground(new Color(226, 226, 226));
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(btnEmployee);
		
		JButton btnCustomer = new JButton("customers");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers st=new customers();
				st.setVisible(true);
				frame.dispose();
			}
		});
		btnCustomer.setBounds(75, 92, 211, 52);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(btnCustomer);
		
		JButton btnHarvest = new JButton("harvest");
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Harvest st=new Harvest();
				st.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnHarvest.setBounds(339, 92, 211, 52);
		btnHarvest.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(btnHarvest);
		
		JButton btnSales = new JButton("sales");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales st=new sales();
				st.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnSales.setBounds(339, 185, 211, 52);
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(btnSales);
		
		JButton btnlogout = new JButton("log out");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGINFORM nm =new LOGINFORM();
				nm.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnlogout.setForeground(new Color(255, 0, 0));
		btnlogout.setBounds(739, 11, 89, 39);
		frame.getContentPane().add(btnlogout);
	}
}
