package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Myapp {

	private JFrame frame;
	private JTextField name;
	private JTextField email;
	private JTextField phno;
	private int updateId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Myapp window = new Myapp();
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
	public Myapp() {
		initialize();
		connection();
		loaddata();
	}
	
	Connection cn = null;
	private JTable table;
	private JTextField did;
	public void connection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/16june","root","");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loaddata()
	{
		try {
			PreparedStatement ps = cn.prepareStatement("select * from sreg");
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 59, 263, 183);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(30, 24, 46, 14);
		panel.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(86, 21, 123, 20);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("email");
		lblNewLabel_1_1.setBounds(30, 54, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phno");
		lblNewLabel_1_2.setBounds(30, 87, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(86, 52, 123, 20);
		panel.add(email);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(86, 84, 123, 20);
		panel.add(phno);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				email.setText("");
				phno.setText("");
			}
		});
		btnNewButton.setBounds(86, 115, 123, 23);
		panel.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(updateId);
				String sname = name.getText();
				String semail = email.getText();
				String sphno = phno.getText();
				
				//System.out.print(sname+" "+semail+" "+sphno);
				
				try {
					
					if(updateId>0)
					{
						PreparedStatement ps = cn.prepareStatement("update sreg set name=?, email=?,phno=? where id=?");
						ps.setString(1, sname);
						ps.setString(2, semail);
						ps.setString(3, sphno);
						ps.setInt(4, updateId);
						
						int i=ps.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(frame,"Data Updated successfully");
							loaddata();
						}
					}
					else
					{
					PreparedStatement ps = cn.prepareStatement("insert into sreg values(?,?,?,?)");
					ps.setInt(1, 0);
					ps.setString(2, sname);
					ps.setString(3, semail);
					ps.setString(4, sphno);
					
					int i = ps.executeUpdate();
					
					if(i>0)
					{
						
						name.setText("");
						email.setText("");
						phno.setText("");
						JOptionPane.showMessageDialog(frame,"Data Inserted successfully");
						loaddata();
					}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSubmit.setBounds(86, 149, 123, 23);
		panel.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Student Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(222, 11, 180, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(307, 59, 283, 183);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 268, 564, 122);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setBounds(39, 44, 27, 14);
		panel_2.add(lblNewLabel_1_3);
		
		did = new JTextField();
		did.setColumns(10);
		did.setBounds(76, 31, 123, 40);
		panel_2.add(did);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(did.getText());
				try {
					PreparedStatement ps = cn.prepareStatement("delete from sreg where id=?");
					ps.setInt(1, id);
					int i = ps.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(frame, "Data deleted !!!");
						loaddata();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(222, 40, 123, 23);
		panel_2.add(btnDelete);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(did.getText());
				try {
					PreparedStatement ps = cn.prepareStatement("select * from sreg where id=?");
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						updateId = rs.getInt(1);
						name.setText(rs.getString(2));
						email.setText(rs.getString(3));
						phno.setText(rs.getString(4));
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Invalid id");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Invalid id");
				}
				
				
			}
		});
		btnNewButton_1_1.setBounds(376, 40, 123, 23);
		panel_2.add(btnNewButton_1_1);
	}
}
