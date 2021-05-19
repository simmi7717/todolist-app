
package todoListApp;

import javax.swing.JFrame;

public class MainClass {
	public static void main(String[] args)
	{
		Register jf=new Register("Registration");
		jf.setVisible(true);
		jf.setSize(400,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*TodoList jf2=new TodoList("TodoList");
		jf2.setVisible(true);
		jf2.setSize(600,400);
		jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}


}
