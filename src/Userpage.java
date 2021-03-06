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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextField;

import packmac.Employee;

public class Userpage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	String susername,scardno;
	public static int index=0;
	ArrayList<Bankdetails> al;
	Container cont;
	JLabel globatm,lUsername,lcardno,lwarning,imageE,imageW;
	JTextField username,cardno;
	JButton login,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public Userpage(){
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
		lUsername=new JLabel("USERNAME              ");
		lUsername.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		lcardno=new JLabel("CARD NUMBER      ");
		lcardno.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		lwarning=new JLabel("Don't disclose your password to anyone!!");
		lwarning.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		username=new JTextField(20);
		username.setPreferredSize(new Dimension(30,30));
		cardno=new JTextField(20);
		cardno.setPreferredSize(new Dimension(30,30));
		login=new JButton("LOGIN");
		login.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		clearall=new JButton("CLEAR ALL");
		clearall.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.PLAIN, 20));
		
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
		p4.add(lUsername);
		//lUsername.setHorizontalAlignment(JLabel.CENTER);
		p4.add(username);
		//username.setHorizontalAlignment(JLabel.LEFT);
		p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p5.add(lcardno);
		//lcardno.setHorizontalAlignment(JLabel.CENTER);
		p5.add(cardno);
		//cardno.setHorizontalAlignment(JTextField.LEFT);
		
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
		
		
	public Userpage(int n){
	}

	public static void main(String[] args) {
		/*Userpage fp1=new Userpage();
		fp1.launchframe();*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		String A="^[a-zA-z]";
		String B="^[a-zA-Z0-9]";
		String K="^[a-zA-Z0-9]";
		String C="^[0-9]";
		String D="^[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}";
		String E="^[0-9]";
		String F="^[a-zA-Z]";
		
		Scanner sc,sc1;
		
		boolean sfound=false,sfound1=false;
		switch(ac){
		case("b1"):
			
		String result,result2;
		
		susername=username.getText();
		scardno=cardno.getText();
		
		sc=new Scanner(susername);
		sc1=new Scanner(scardno);
		
		result=sc.findInLine(A);
		result2=sc1.findInLine(C);
		
		if(username.getText().trim().equals("")){
			JOptionPane.showMessageDialog(this, "Username cannot be blank");
			clearall();
			username.requestFocus();
			return;
		}
		if(cardno.getText().trim().equals("")){
			JOptionPane.showMessageDialog(this, "Card no cannot be blank");
			clearall();
			username.requestFocus();
			return;
		}					
		
		if(result==null)
		{
			JOptionPane.showMessageDialog(this, "Enter a valid username");
			clearall();
			username.requestFocus();
			break;
		}
		
		if(result2==null || scardno.length()!=16)
		{
			JOptionPane.showMessageDialog(this, "Enter a valid card number of 16 digits");
			clearall();
			username.requestFocus();
			break;
		}
		else{
			susername=username.getText();
			scardno=cardno.getText();
			try{
					fis=new FileInputStream("userdetails.db");
					ois=new ObjectInputStream(fis);
					al=(ArrayList<Bankdetails>)ois.readObject();
				}
			catch(ClassNotFoundException| IOException ci){
					ci.printStackTrace();
			}
			index = 0;
			for(Bankdetails bd: al){
				if(bd.getusername().equals(susername)&&bd.getcardno().equals(scardno)){
					//sfound=true;
					//set=al.get(index);
					
					if(bd.getblockstatus().equals("Block")){
						sfound1=true;
						JOptionPane.showMessageDialog(this, "YOUR ACCOUNT IS BLOCKED PLEASE CONTACT ADMIN");
						break;
					}
					else{
						sfound=true;
						Password ps=new Password();	
						ps.launchframe();
						break;
					}
				}
				index=index+1;
			}
			if(sfound==false&&sfound1==true){
				clearall();
				username.requestFocus();
				break;
			}
			if(sfound==false&&sfound1==false){
				JOptionPane.showMessageDialog(this, "WRONG ENTRY");
				clearall();
				username.requestFocus();
				break;
			}
			else{
				dispose();
			}
		}
		break;
		case "b2":
			username.setText("");
			cardno.setText("");
			break;
		case "b3":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
		}
		
	}
	void clearall(){
		username.setText("");
		cardno.setText("");
	}
	int getindex(){
		return index;
	}
}
