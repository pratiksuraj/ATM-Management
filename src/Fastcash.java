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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Fastcash extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Container cont;
	private JLabel globatm,gap,imageE,imageW;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton ok,cancel;
	private ButtonGroup bg;
	static int index1;
	static ArrayList<Bankdetails> al;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Bankdetails details;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	
	public Fastcash(){
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
		
		globatm=new JLabel("GLOBSYN Atm");
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		gap=new JLabel("     ");
	
		radio1=new JRadioButton("    500");
		radio1.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		radio2=new JRadioButton("1000    ");
		radio2.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		radio3=new JRadioButton("    2000");
		radio3.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		radio4=new JRadioButton("2500   ");
		radio4.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		ok=new JButton("CONTINUE");
		ok.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
	
		cancel=new JButton("CANCEL");
		cancel.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		bg=new ButtonGroup();
		cont.setLayout((LayoutManager)new GridLayout(12,1));
		
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
		
				bg.add(radio1);
				bg.add(radio2);
				bg.add(radio3);
				bg.add(radio4);
				
				p5.setLayout((LayoutManager)new GridLayout(1,2));
				p5.add(radio1);
				radio1.setHorizontalAlignment(JRadioButton.LEFT);
				p5.add(radio2);
				radio2.setHorizontalAlignment(JRadioButton.RIGHT);
				
				p7.setLayout((LayoutManager) new GridLayout(1,2));
				p7.add(radio3);
				radio3.setHorizontalAlignment(JRadioButton.LEFT);
				p7.add(radio4);
				radio4.setHorizontalAlignment(JRadioButton.RIGHT);
				
				p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
				p9.add(ok);
				
				p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
				p9.add(gap);
				
				p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
				p9.add(cancel);
				
				//set action
				ok.setActionCommand("b1");
				cancel.setActionCommand("b2");		
				//set listener
				ok.addActionListener(this);
				cancel.addActionListener(this);
				
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
			setTitle("collect withdrawal page");
	}
	public static void main(String[] args) {
		/*Fastcash fc=new Fastcash();
		fc.launchframe();*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String choice=e.getActionCommand();
		switch(choice){
		case "b1":
			if(radio1.isSelected()){
				int famount=500;
				fastwithdrawl(famount);
				dispose();
			}
			if(radio2.isSelected()){
				int famount=1000;
				fastwithdrawl(famount);
				dispose();
			}
			if(radio3.isSelected()){
				int famount=2000;
				fastwithdrawl(famount);
				dispose();
			}
			if(radio4.isSelected()){
				int famount=2500;
				fastwithdrawl(famount);
				dispose();
			}
			break;
		case "b2":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
			break;
		}
	}
	void fastwithdrawl(int cash){
		//loading
		try{
			fis=new FileInputStream("userdetails.db");
			ois=new ObjectInputStream(fis);
			al=(ArrayList<Bankdetails>)ois.readObject();
		}
		catch(ClassNotFoundException| IOException ci){
			ci.printStackTrace();
		}
		Userpage ups=new Userpage(20);
		index1=ups.getindex();
		details=al.get(index1);
		if(details.getamount()>=cash){
			SufBalance sf=new SufBalance();
			sf.launchframe();
			int newamount=details.getamount()-cash;
		
			String sname =details.getusername(),spassword=details.getpassword(),scardno = details.getcardno(),scontact = details.getcontactno();
			int samount =newamount;
			String status=details.getblockstatus();
			//modify
			al.set(index1,new Bankdetails(sname,spassword,scardno,samount,scontact,status));
			//saving
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
	InSufBalance call=new InSufBalance();
	call.launchframe();
}
	}
}

