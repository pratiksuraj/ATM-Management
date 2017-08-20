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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

import packmac.Employee;

public class Password extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Container cont;
	JLabel globatm,lpassword,lwarning,imageE,imageW;
	JPasswordField password;
	JButton login,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	int index2=0;
	static private ArrayList<Bankdetails> al;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	
	public Password(){
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
		
		
		al = new ArrayList<Bankdetails>();
		
		globatm=new JLabel("GLOBSYN ATM");
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		lpassword=new JLabel("ENTER PIN   ");
		lpassword.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		lwarning=new JLabel("Don't disclose your password to anyone!!");
		lwarning.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
	
		password=new JPasswordField(20);
		password.setPreferredSize(new Dimension(30,30));
	
		login=new JButton("LOGIN");
		login.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		clearall=new JButton("CLEAR ALL");
		clearall.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		
		cont.setLayout((LayoutManager)new GridLayout(12,1));
		
		//adding components
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
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(lpassword);
		p4.add(password);
		
		p6.setLayout(new FlowLayout());
		p6.add(login);
		p6.add(clearall);
		p6.add(close);
		
		p12.setLayout(new FlowLayout());
		p12.add(lwarning);
		lwarning.setForeground(Color.RED);
		
		//set action command
		login.setActionCommand("b1");
		clearall.setActionCommand("b2");
		close.setActionCommand("b3");
		
		//set action listener
		login.addActionListener(this);
		clearall.addActionListener(this);
		close.addActionListener(this);
	}	
		public void launchframe(){
			setTitle("PIN FIELD");
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
		/*Password p1=new Password();
		p1.launchframe();*/
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String ac = event.getActionCommand();
		
		String C="^[0-9]";
		
		switch(ac){
			case"b1":
				String spassword;
				Scanner sc;
				String result;
				
				spassword=String.valueOf(password.getPassword());
				sc=new Scanner(spassword);
				result=sc.findInLine(C);
				
				if(spassword.equals("")){
					JOptionPane.showMessageDialog(this,"Please enter the pin");
					password.requestFocus();
					break;
				}
				if(result==null || spassword.length()!=4)
				{
					JOptionPane.showMessageDialog(this, "Enter a valid pin of 4 digits");
					clearall();
					password.requestFocus();
					break;
				}
				
				
				else{
					try{
						fis=new FileInputStream("userdetails.db");
						ois=new ObjectInputStream(fis);
						al=(ArrayList<Bankdetails>)ois.readObject();
					}
					catch(ClassNotFoundException| IOException ci){
						ci.printStackTrace();
					}
					Userpage ups=new Userpage(20);
					index2=ups.getindex();

					Bankdetails e=new Bankdetails();
					e=al.get(index2);
					if(e.getpassword().equals(spassword)){
						Correctpassword call=new Correctpassword();
						call.launchframe();
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(this, "Wrong pin");
						clearall();
						password.requestFocus();
					}
				}
				break;
			case "b2":
				password.setText("");
				break;
			case "b3":
				Firstpage redirect=new Firstpage();
				redirect.launchframe();
				break;
		}		
	}
		void clearall(){
		password.setText("");
	}
}
