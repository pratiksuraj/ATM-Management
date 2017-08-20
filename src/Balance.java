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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import packmac.Employee;

public class Balance  extends JFrame implements ActionListener {
	
	//declration
	private static final long serialVersionUID = 1L;
	private JLabel globatm,details,lusername,lamount,gap,gap1,imageE,imageW;
	private JButton close;
	private JLabel username,amount;
	static int index1=0;
	private ArrayList<Bankdetails> al;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Container cont;
	Bankdetails e;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	public Balance(){
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
	
		details=new JLabel("This is your account details");
		details.setFont(new Font("Century Schoolbook", Font.BOLD, 20));

		lusername=new JLabel("USERNAME:-");
		lusername.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		lamount=new JLabel("AMOUNT:-     ");
		lamount.setFont(new Font("Century Schoolbook", Font.BOLD, 20));

		username=new JLabel("");
		username.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		username.setBackground(Color.white);
		amount=new JLabel("");
		amount.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		amount.setBackground(Color.white);
		gap=new JLabel("                 ");
		gap.setBackground(Color.orange);
		gap1=new JLabel("                 ");
		gap1.setBackground(Color.orange);
		
	
		close=new JButton("Close");
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
		p4.add(details);
		
		p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p5.add(lusername);
		p5.add(gap);
		p5.add(username);
		
		p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p6.add(lamount);
		p6.add(gap1);
		p6.add(amount);
		
		p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p7.add(close);
		
		//set action
		close.setActionCommand("b1");
		
		//set listener
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
		setTitle("BalanceEnquiry page");
		
		try
		{
			fis = new FileInputStream("userdetails.db");
			ois = new ObjectInputStream(fis);
			al= (ArrayList<Bankdetails>)ois.readObject();
		}
		catch(ClassNotFoundException | IOException ci)
		{
			ci.printStackTrace();
		}

		Userpage ups=new Userpage(20);
		index1=ups.getindex();
		e=al.get(index1);
		String sname=e.getusername();
		int samount=e.getamount();
		username.setText(sname);
		amount.setText(String.valueOf(samount));
	}
	
	public static void main(String[] args) {
		/*Balance b=new Balance();
		b.launchframe();*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String choice=e.getActionCommand();
		switch(choice){
		case "b1":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
			break;
		}	
	}
}

