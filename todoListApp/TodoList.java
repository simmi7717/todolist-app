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
import javax.swing.JTextArea;

public class TodoList  extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextArea a1, a2;
	JButton b1;
	public TodoList() {}
	public TodoList(String s1)
	{
		super(s1);
	
	l1=new JLabel("Important Task");
	l2=new JLabel("other");
	a1=new JTextArea();
	a2=new JTextArea();
	b1=new JButton("Submit");
	setLayout(null);
	l1.setBounds(80, 50, 100, 20);
	l2.setBounds(350,50, 80, 20);
	a1.setBounds(50,80,200, 200);
	a2.setBounds(300, 80, 200, 200);
	b1.setBounds(200, 320, 100, 20);
	add(l1);
    add(l2);
    add(a1);
    add(a2);
    add(b1);
    b1.addActionListener(this);
     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	       JOptionPane.showMessageDialog(TodoList.this, "ok");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded");
			    String url="jdbc:mysql:///ums";
			   	String password="simmi777";
			   	String user="root";
			       // establish the connection
			   	Connection con=DriverManager.getConnection(url,user,password);
			   	System.out.println("connection eatablished"); //database-ums, table todolist
				PreparedStatement ps=con.prepareStatement("insert into todolist(Important_task, Other) values(?,?)");
				ps.setString(1, a1.getText());
				ps.setString(2, a2.getText());
				int x=ps.executeUpdate();
				if(x>0)
				{
					System.out.println("Task has been added!");
					System.out.println("Now you can execute query for tasks");
				}
				else
				{
					System.out.println("Task does not specified correctly.");

				}
			} catch (ClassNotFoundException e1) {
			      System.out.println(" Exc:  " + e1.getMessage());
			} catch (SQLException e1) {
				System.out.println("SQL exception: " + e1.getMessage());
			}

	}
}

