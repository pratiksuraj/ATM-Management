package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	String sadminname,spassword;
	Container cont;
	JLabel globatm,ladminname,lpassword,lwarning,imageE,imageW;
	JTextField adminname;
	JPasswordField password;
	JButton login,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	
	public Admin(){
		cont=getContentPane();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		p13=new JPanel();
		
		globatm=new JLabel("GLOBSYN ATM");
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		ladminname=new JLabel("ADMIN NAME   ");
		ladminname.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		lpassword=new JLabel("PASSWORD      ");
		lpassword.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		lwarning=new JLabel("Don't disclose your password to anyone!!");
		lwarning.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		
		adminname=new JTextField(20);
		adminname.setPreferredSize(new Dimension(30,30));
		
		password=new JPasswordField(20);
		password.setPreferredSize(new Dimension(30,30));
		
		login=new JButton("LOGIN");
		login.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		clearall=new JButton("CLEAR ALL");
		clearall.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 13));

		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
		cont.setLayout((LayoutManager)new BorderLayout());
		
		//adding component
		cont.add(p13);
		p13.add(p1);
		p13.add(p2);
		p13.add(p3);
		p13.add(p4);
		p13.add(p5);
		p13.add(p6);
		p13.add(p7);
		p13.add(p8);
		p13.add(p9);
		p13.add(p10);
		p13.add(p11);
		p13.add(p12);
		
		p13.setLayout(new GridLayout(12,1));
		
		cont.add(p13,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		


		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);
		globatm.setForeground(Color.red);
		//globatm.setSize(getSize());
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(ladminname);
		p4.add(adminname);
		
		p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p5.add(lpassword);
		p5.add(password);
		
		p7.setLayout(new FlowLayout());
		p7.add(login);
		p7.add(clearall);
		p7.add(close);
		
		p12.setLayout(new FlowLayout());
		p12.add(lwarning);
		lwarning.setForeground(Color.RED);
		
		//set action command
		login.setActionCommand("b1");
		clearall.setActionCommand("b2");
		close.setActionCommand("b3");
		//set listener
		login.addActionListener(this);
		clearall.addActionListener(this);
		close.addActionListener(this);
	}	
		public void launchframe(){
			setTitle("GLOBSYN ATM");
			cont.setBackground(Color.orange);
			p1.setBackground(Color.orange);
			p2.setBackground(Color.orange);
			p3.setBackground(Color.orange);
			p4.setBackground(Color.orange);
			p5.setBackground(Color.orange);
			p6.setBackground(Color.orange);
			p7.setBackground(Color.orange);
			p8.setBackground(Color.orange);
			p9.setBackground(Color.orange);
			p10.setBackground(Color.orange);
			p11.setBackground(Color.orange);
			p12.setBackground(Color.orange);
			setVisible(true);
			setSize(1900,700);
	}
		
		public static void main(String[] args) {
			/*Admin ad=new Admin();
			ad.launchframe();*/
			
		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ac=ae.getActionCommand();
		String A="^[a-zA-z]";
		String B="^[a-zA-Z0-9]";
		String K="^[a-zA-Z0-9]";
		String C="^[0-9]";
		String D="^[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}";
		String E="^[0-9]";
		String F="^[a-zA-Z]";
		Scanner sc,sc1;
		switch(ac){
		 
		case("b1"):
			 
			 String result,result2;
			
			sadminname=adminname.getText();
			spassword=String.valueOf(password.getPassword());
			
			sc=new Scanner(sadminname);
			sc1=new Scanner(spassword);
			
			result=sc.findInLine(A);
			result2=sc1.findInLine(A);
		
			 if(adminname.getText().trim().equals("")){
					JOptionPane.showMessageDialog(this, "Admin name cannot be blank");
					clearall();
					adminname.requestFocus();
					return;
				}
				if(String.valueOf(password.getPassword()).trim().equals("")){
					JOptionPane.showMessageDialog(this, "Password cannot be blank");
					clearall();
					adminname.requestFocus();
					return;
				}					
				if(result==null)
				{
					JOptionPane.showMessageDialog(this, "Invalid admin name");
					clearall();
					adminname.requestFocus();
					break;
				}
				if(result2==null || spassword.length()!=5)
				{
					JOptionPane.showMessageDialog(this, "Enter a valid password");
					clearall();
					adminname.requestFocus();
					break;
				}
				else{
					if(adminname.getText().trim().equals("admin")&&String.valueOf(password.getPassword()).trim().toLowerCase().equals("admin"))
					{
						Admin1 ad1=new Admin1();
						ad1.launchframe();
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(this, "Wrong entry");
						clearall();
						}
					}
				break;
		 case "b2":
			 adminname.setText("");
			 password.setText("");
			 break;
		 case "b3":
			 Firstpage call=new Firstpage();
			 call.launchframe();
			 dispose();
		}
	}
	void clearall(){
		adminname.setText("");
		password.setText("");
	}
}