package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

public class Changepin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel globatm,lold,lnew,lconfirm,imageE,imageW;
	private JButton ok,close,clear;
	private JPasswordField old,newpin,confirm;
	Container cont;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	ArrayList<Bankdetails> al;
	static int index=0;
	static Bankdetails arraylist;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	public Changepin(){
		cont=getContentPane();
			//instantiate
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
	
			globatm=new JLabel("GLOBSYN Atm");
			globatm.setForeground(Color.red);
			globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
			
			lold=new JLabel("OLD PIN                   ");
			lold.setBackground(Color.orange);
			lold.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			lnew=new JLabel("NEW PIN                  ");
			lnew.setBackground(Color.orange);
			lnew.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			lconfirm=new JLabel("RE-TYPE NEW PIN ");
			lconfirm.setBackground(Color.orange);
			lconfirm.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			old=new JPasswordField(20);
			newpin=new JPasswordField(20);
			confirm=new JPasswordField(20);
			
			ok=new JButton("OK");
			ok.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			clear=new JButton("CLEAR");
			clear.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			close=new JButton("CLOSE");
			close.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		
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
			
			p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p4.add(lold);
			p4.add(old);
			
			p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p5.add(lnew);
			p5.add(newpin);
			
			p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p6.add(lconfirm);
			p6.add(confirm);
			
			p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p7.add(ok);
			
			p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p7.add(clear);
			
			p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
			p7.add(close);
			
			//set action
			ok.setActionCommand("b1");
			clear.setActionCommand("b2");
			close.setActionCommand("b3");
			
			//set listener
			ok.addActionListener(this);
			clear.addActionListener(this);
			close.addActionListener(this);
	}	
	public void launchframe(){
		
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
		setTitle("Account details");
}
		
	public static void main(String[] args) {
		/*Changepin c=new Changepin();
		c.launchframe();*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String choice=e.getActionCommand();
		String A="^[a-zA-z]";
		String B="^[a-zA-Z0-9]";
		String K="^[a-zA-Z0-9]";
		String C="^[0-9]";
		String spin,result1;
		Scanner sc1;
		switch(choice){
		case "b1":	
			spin=String.valueOf(newpin.getPassword());
			sc1=new Scanner(spin);
			result1=sc1.findInLine(C);
			if(result1==null||spin.length()!=4){
				JOptionPane.showMessageDialog(this, "Enter a valid pin of 4 digits");
				old.setText("");
				newpin.setText("");
				confirm.setText("");
				old.requestFocus();
				break;
			}
			try{
				fis=new FileInputStream("userdetails.db");
				ois=new ObjectInputStream(fis);
				al=(ArrayList<Bankdetails>)ois.readObject();
			}
			catch(ClassNotFoundException| IOException ci){
				ci.printStackTrace();
			}
			Userpage ups=new Userpage(20);
			index=ups.getindex();
			arraylist=al.get(index);
			
			if(String.valueOf(old.getPassword()).equals(arraylist.getpassword())){
				
				if(String.valueOf(newpin.getPassword()).equals(String.valueOf(confirm.getPassword()))){
					String sname =arraylist.getusername(),scardno = arraylist.getcardno();
					String scontact = arraylist.getcontactno();
					String status=arraylist.getblockstatus();
					int samount =arraylist.getamount();
					al.set(index,new Bankdetails(sname,String.valueOf(confirm.getPassword()),scardno,samount,scontact,status));
					try
					{
						fos = new FileOutputStream("userdetails.db");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(al);
						oos.flush();
						oos.close();
					}
					catch(IOException ie)
					{
						ie.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(this, "Both Password is not same");
					old.setText("");
					newpin.setText("");
					confirm.setText("");
					old.requestFocus();
					break;
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "old password is not same");
				old.setText("");
				newpin.setText("");
				confirm.setText("");
				old.requestFocus();
				break;
			}
			Changepassword cp=new Changepassword();
			cp.launchframe();
			dispose();
			break;
		case "b2":
			old.setText("");
			newpin.setText("");
			confirm.setText("");
			break;
		case "b3":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
			break;
		}
	}
}
