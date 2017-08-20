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

public class Transfer extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Container cont;
	private static ArrayList<Bankdetails> al;
	JLabel globatm,lsentto,lamount,imageE,imageW;
	JTextField sentto,amount;
	JButton ok,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	 static int counter1,famount,index1;
	 int newamount1,newamount;
	 
	 public Transfer(int n){
		 
	 }
	
	public Transfer(){
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
		lsentto=new JLabel("CARD NUMBER (To transfer)");		
		lsentto.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		lamount=new JLabel("ENTER AMOUNT (To Transfer)");
		lamount.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		sentto=new JTextField(20);
		sentto.setPreferredSize(new Dimension(20,20));
		amount=new JTextField(20);
		amount.setPreferredSize(new Dimension(20,20));
		ok=new JButton("CONTINUE TRANSFER");
		ok.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		clearall=new JButton("CLEAR ALL");
		clearall.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 18));

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
		p4.add(lsentto);
		p4.add(sentto);
		
		p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p6.add(lamount);
		p6.add(amount);
		
		p8.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p8.add(ok);
		p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p9.add(clearall);
		p9.add(close);
		
		//set action command
		ok.setActionCommand("b1");
		clearall.setActionCommand("b2");
		close.setActionCommand("b3");
		//set listener
		ok.addActionListener(this);
		clearall.addActionListener(this);
		close.addActionListener(this);
	}	
		public void launchframe(){
			setTitle("transfer cash");
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
			/*Transfer ad=new Transfer();
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
		Bankdetails details,details2;
		boolean set=false;
		switch(ac){
		 case("b1"):
			 String result,result2,scard,samount;				
		 	famount=Integer.parseInt(amount.getText().trim());
		 	
		 	scard=sentto.getText().trim();
			samount=amount.getText().trim();
			
			sc=new Scanner(scard);
			sc1=new Scanner(samount);
			
			result=sc.findInLine(C);
			result2=sc1.findInLine(C);
			
			 if(sentto.getText().trim().equals("")){
					JOptionPane.showMessageDialog(this, "PLEASE ENTER CARD NO.");
					clearall();
					sentto.requestFocus();
					return;
			}
			if(amount.getText().trim().equals("")){
					JOptionPane.showMessageDialog(this, "PLEASE ENTER AMOUNT");
					clearall();
					sentto.requestFocus();
					return;
			}					
			if(result==null||scard.length()!=16)
			{
				JOptionPane.showMessageDialog(this, "PLEASE ENTER VALID CARD NO. OF 16 DIGITS");
				clearall();
				sentto.requestFocus();
				break;
			}
			if(result2==null ||famount>20000)
			{
				JOptionPane.showMessageDialog(this, "ENTER CASH OF LESS THAN 20,000");
				clearall();
				sentto.requestFocus();
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
				index1=ups.getindex();
				details=al.get(index1);
				if(scard.equals(details.getcardno())){
					JOptionPane.showMessageDialog(this, "SAME ACCOUNT TRANSFER IS NOT POSSIBLE");
					clearall();
					break;
				}
				counter1=0;
				for(Bankdetails db:al){
					if(sentto.getText().equals(db.getcardno())&&!db.getblockstatus().equals("Block")){
						set=true;
						break;
					}
					counter1=counter1+1;
				}
				if(set==false){
					JOptionPane.showMessageDialog(this, "CARD NO. IS NOT VALID");
					clearall();
					break;
				}
				details2=al.get(counter1);
				if(details.getamount()>=famount){
					newamount=details.getamount()-famount;
					newamount1=details2.getamount()+famount;
					String sname=details.getusername(),spassword=details.getpassword(),scardno = details.getcardno(),scontact = details.getcontactno();
			
					String status=details.getblockstatus();
					String sname1=details2.getusername(),spassword1=details2.getpassword(),scardno1 = details2.getcardno(),scontact1 = details2.getcontactno();

					String status1=details2.getblockstatus();
					
					//modify
					al.set(index1,new Bankdetails(sname,spassword,scardno,newamount,scontact,status));
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
					//modify
					al.set(counter1,new Bankdetails(sname1,spassword1,scardno1,newamount1,scontact1,status1));
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
					Toprint call=new Toprint();
					call.launchframe();
					clearall();
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(this, "LOW ACCOUNT BALANCE");
					clearall();	
				}
			}
			break;
		 case "b2":
			 sentto.setText("");
			 amount.setText("");
			 break;
		 case "b3":
			 Firstpage call=new Firstpage();
			 call.launchframe();
			 dispose();
			break;
		}
	}
	public void clearall(){
		sentto.setText("");
		amount.setText("");
	}
	public int print1(){
		return index1;
	}
	public int print2(){
		return famount;
	}
	public int print3(){
		return counter1;
	}
}
