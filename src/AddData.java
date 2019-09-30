import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.TextField;

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class AddData extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Source;
	private JTextField DestinationPassport;
	private JTextField DestinationBank;
	private JTextField DestinationCountry;
	private JTextField AccountNumber;
	private JTextField Amount;
	boolean Name1 = false,Source1=false,
			DestinationPassport1=false
			 ,DestinationBank1=false
			 ,DestinationCountry1=false
			, AccountNumber1=false
			,Amount1=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddData frame = new AddData();
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
	public AddData() {
		

		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 418);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigibank = new JLabel("DIGIBANK");
		lblDigibank.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDigibank.setBounds(202, 11, 103, 14);
		contentPane.add(lblDigibank);
		final JLabel labelamount = new JLabel("");
		labelamount.setForeground(Color.RED);
		labelamount.setBounds(383, 266, 112, 14);
		contentPane.add(labelamount);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(34, 80, 46, 14);
		contentPane.add(lblName);
		final JLabel AccountError = new JLabel("");
		AccountError.setForeground(Color.RED);
		AccountError.setBounds(392, 235, 103, 14);
		contentPane.add(AccountError);
		Name = new JTextField();
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char match = arg0.getKeyChar();
				if(Character.isLetter(match)|| Character.isWhitespace(match)||Character.isISOControl(match)){
					Name.setEditable(true);
					Name1 = true;
				}else{
					Name.setEditable(false);
					Name1 = false;
				}
				
			}
		});
		Name.setBackground(Color.WHITE);
		Name.setForeground(Color.BLACK);
		Name.setBounds(179, 77, 202, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Source = new JTextField();
		Source.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char match = arg0.getKeyChar();
				if(Character.isLetter(match)|| Character.isDigit(match)||Character.isISOControl(match)){
					Source1= true;
					Source.setEditable(true);
				}else{
					Source.setEditable(false);
					Source1 = false;
				}
			}
		});
		Source.setColumns(10);
		Source.setBounds(179, 108, 202, 20);
		contentPane.add(Source);
		
		JLabel lblSourcepassport = new JLabel("Source Passport :");
		lblSourcepassport.setBounds(34, 111, 103, 14);
		contentPane.add(lblSourcepassport);
		
		DestinationPassport = new JTextField();
		DestinationPassport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char match = arg0.getKeyChar();
				if(Character.isLetter(match)|| Character.isDigit(match)||Character.isISOControl(match)){
					DestinationPassport1= true;
					DestinationPassport.setEditable(true);
				}else{
					DestinationPassport.setEditable(false);
					DestinationPassport1 = false;
				}
			}
		});
		DestinationPassport.setColumns(10);
		DestinationPassport.setBounds(179, 139, 202, 20);
		contentPane.add(DestinationPassport);
		
		JLabel lblDestinationPassport = new JLabel("Destination Passport : ");
		lblDestinationPassport.setBounds(34, 142, 135, 14);
		contentPane.add(lblDestinationPassport);
		
		DestinationBank = new JTextField();
		DestinationBank.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char match = arg0.getKeyChar();
				if(Character.isLetter(match)|| Character.isWhitespace(match)||Character.isISOControl(match)){
					DestinationBank1= true;
					DestinationBank.setEditable(true);
				}else{
					DestinationBank.setEditable(false);
					DestinationBank1 = false;
				}
			}
		});
		DestinationBank.setColumns(10);
		DestinationBank.setBounds(179, 170, 202, 20);
		contentPane.add(DestinationBank);
		
		JLabel lblDestinationBank = new JLabel("Destination Bank :");
		lblDestinationBank.setBounds(34, 173, 135, 14);
		contentPane.add(lblDestinationBank);
		
		DestinationCountry = new JTextField();
		DestinationCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				char match = arg0.getKeyChar();
				if(Character.isLetter(match)|| Character.isWhitespace(match)||Character.isISOControl(match)){
					DestinationCountry.setEditable(true);
					DestinationCountry1= true;
				}else{
					DestinationCountry.setEditable(false);
					DestinationCountry1=false;
				}
			}
		});
		DestinationCountry.setColumns(10);
		DestinationCountry.setBounds(179, 201, 202, 20);
		contentPane.add(DestinationCountry);
		
		JLabel lblDestinationCountry = new JLabel("Destination Country :");
		lblDestinationCountry.setBounds(34, 204, 135, 14);
		contentPane.add(lblDestinationCountry);
		
		AccountNumber = new JTextField();
		AccountNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				char match = arg0.getKeyChar();
				if(Character.isDigit(match)||Character.isISOControl(match)){
					AccountNumber.setEditable(true);
					AccountNumber1=true;
				}else{
					AccountNumber.setEditable(false);
					AccountNumber1= false;
				}
				
			}
		});
		AccountNumber.setColumns(10);
		AccountNumber.setBounds(179, 232, 202, 20);
		contentPane.add(AccountNumber);
		
		JLabel lblAccountNumber = new JLabel("Account Number : ");
		lblAccountNumber.setBounds(34, 235, 135, 14);
		contentPane.add(lblAccountNumber);
		
		Amount = new JTextField();
		Amount.setForeground(Color.BLACK);
		Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
		
				char match = arg0.getKeyChar();
				if(Character.isDigit(match)|| match== '.'||Character.isISOControl(match)){
					Amount.setEditable(true);
					Amount1= true;
				
				}else{
					Amount.setEditable(false);
					Amount1= false;
				}
			}
			
			
			
		});
		Amount.setColumns(10);
		Amount.setBounds(179, 263, 202, 20);
		contentPane.add(Amount);
		
		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setBounds(34, 266, 81, 14);
		contentPane.add(lblAmount);
		
		JButton Insertbtn = new JButton("Insert Data");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 if (Name1 == false && Source1== false && DestinationPassport1 == false &&DestinationBank1 == false&&DestinationCountry1== false&&AccountNumber1== false&& Amount1 == false)
				 {
					   JOptionPane.showMessageDialog(null, "Error All Data is Reqired");
				 }else{
					 try{
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adh401","root","");
						    Statement stmt = con.createStatement();
						    String sql = "insert into digibank (Name,SourcePassport,DestinationPassport,DestinationBank,DestinationCountry,AccountNumber,Amount) Values('"+Name.getText()+"','"+Source.getText()+"','"+DestinationPassport.getText()+"','"+DestinationBank.getText()+"','"+DestinationCountry.getText()+"','"+AccountNumber.getText()+"','"+Amount.getText()+"')";
							   int insert = stmt.executeUpdate(sql);
						   JOptionPane.showMessageDialog(null, insert + " Rows Inserted");
							
						}catch(Exception e){
							System.out.print(e);
						} 
				 }
					  
				 }
				
			
		});
		Insertbtn.setBounds(162, 333, 219, 23);
		contentPane.add(Insertbtn);
		
	
	}
}
