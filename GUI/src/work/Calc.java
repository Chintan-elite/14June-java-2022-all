package work;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Calc {

	private JFrame frame;
	private JTextField n1;
	private JTextField n2;
	private JTextField r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
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
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 500, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("number 1");
		lblNewLabel.setBounds(121, 46, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		n1 = new JTextField();
		n1.setForeground(Color.ORANGE);
		n1.setBackground(Color.BLACK);
		n1.setBounds(178, 43, 193, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number 2");
		lblNewLabel_1.setBounds(121, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		n2 = new JTextField();
		n2.setForeground(Color.ORANGE);
		n2.setBackground(Color.BLACK);
		n2.setBounds(178, 84, 193, 20);
		frame.getContentPane().add(n2);
		n2.setColumns(10);
		
		r = new JTextField();
		r.setForeground(Color.GREEN);
		r.setBackground(Color.BLACK);
		r.setColumns(10);
		r.setBounds(178, 122, 193, 20);
		frame.getContentPane().add(r);
		
		JLabel lblNewLabel_1_1 = new JLabel("Result");
		lblNewLabel_1_1.setBounds(121, 125, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(new Color(255, 200, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(n1.getText());
				int b = Integer.parseInt(n2.getText());
				int c = a+b;
				r.setText(c+"");
				
			}
		});
		btnNewButton.setBounds(175, 159, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSub = new JButton("Sub");
		btnSub.setForeground(Color.ORANGE);
		btnSub.setBackground(Color.BLACK);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int a = Integer.parseInt(n1.getText());
				int b = Integer.parseInt(n2.getText());
				int c = a-b;
				r.setText(c+"");
			}
		});
		btnSub.setBounds(282, 159, 89, 23);
		frame.getContentPane().add(btnSub);
		
		JButton btnDiv = new JButton("Div");
		btnDiv.setForeground(Color.ORANGE);
		btnDiv.setBackground(Color.BLACK);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int a = Integer.parseInt(n1.getText());
				int b = Integer.parseInt(n2.getText());
				int c = a/b;
				r.setText(c+"");
			}
		});
		btnDiv.setBounds(175, 193, 92, 23);
		frame.getContentPane().add(btnDiv);
		
		JButton btnMul = new JButton("Mul");
		btnMul.setForeground(Color.ORANGE);
		btnMul.setBackground(Color.BLACK);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int a = Integer.parseInt(n1.getText());
				int b = Integer.parseInt(n2.getText());
				int c = a*b;
				r.setText(c+"");
			}
		});
		btnMul.setBounds(282, 193, 89, 23);
		frame.getContentPane().add(btnMul);
	}
}
