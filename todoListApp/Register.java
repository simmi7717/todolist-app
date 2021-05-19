package todoListApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;

	public Register() {}
    public Register(String s)
	{
	super(s);	
	l1=new JLabel("FirstName");
	t1=new JTextField();
	l2=new JLabel("LastName");
	t2=new JTextField();
	l3=new JLabel("Email:");
	t3=new JTextField();
	l4=new JLabel("username");
	t4=new JTextField();
	l5=new JLabel("Password");
	t5=new JTextField();
	b1=new JButton("Click");
	setLayout(null);
	l1.setBounds(50, 50, 100, 20);
	t1.setBounds(150,50,200, 20);
	l2.setBounds(50, 100, 100, 20);
	t2.setBounds(150, 100, 200, 20);
    l3.setBounds(50, 150, 100, 20);	
    t3.setBounds(150, 150, 200, 20);
    l4.setBounds(50, 200, 100, 20);
    t4.setBounds(150, 200, 200, 20);
    l5.setBounds(50, 250, 100, 20);
    t5.setBounds(150, 250, 200, 20);   
	b1.setBounds(160, 350, 80, 20);
	add(l1);
    add(l2);
    add(t1);
    add(t2);add(l3);add(t3);add(l4);add(t4);add(l5);add(t5);
    add(b1);
    b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	       JOptionPane.showMessageDialog(Register.this, "ok");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		    String url="jdbc:mysql:///ums";
		   	String password="simmi777";
		   	String user="root";
		   // establish the connection
		   	Connection con=DriverManager.getConnection(url,user,password);
		   	System.out.println("connection eatablished"); //database-ums, table Register
			PreparedStatement ps=con.prepareStatement
					("insert into Register(FirstName,Lastname,Email) values(?,?,?)");
			ps.setString(1, t1.getText());
			ps.setString(2, t2.getText());
			ps.setString(3, t3.getText());
			//ps.setString(4, t4.getText());
			//ps.setString(5, t5.getText());
		//	String username="simmi";
			//String user1=t4.getText();
			//String Password="abcde";
			
			//if(t4.equals(username) & t5.equals(Password))
			//if(username==user1)
			//{
				System.out.println("Correct username");
					TodoList jf2=new TodoList("TodoList");
					jf2.setVisible(true);
					jf2.setSize(600,400);
					jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//}
			//else
			//{
				System.out.println("wrong username");
			//}
			int x=ps.executeUpdate();
			if(x>0)
			{
				System.out.println("Registration done successfully!");
				System.out.println("Now you can execute query for required thing");
			}
			else
			{
				System.out.println("Registration failed!");

			}



		} catch (ClassNotFoundException e1) {
		      System.out.println(" Exc:  " + e1.getMessage());
		} catch (SQLException e1) {
			System.out.println("SQL exception: " + e1.getMessage());
		}

	
	}
	
	
	

}
