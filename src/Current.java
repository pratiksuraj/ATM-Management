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
import javax.swing.JTextField;

public class Current extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	static int famount,newamount;
	
	Container cont;
	JLabel globatm,lamount,imageE,imageW;
	JTextField amount;
	JButton ok,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	static int index1;
	static ArrayList<Bankdetails> al;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Bankdetails details;
	
	public Current(){
		cont=getContentPane();
		
		//instantiation
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		
		globatm=new JLabel("GLOBSYN ATM");
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		lamount=new JLabel("Enter the amount             ");
		lamount.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		amount=new JTextField(20);
		amount.setPreferredSize(new Dimension(35,35));
		
		ok=new JButton("OK");
		ok.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		clearall=new JButton("CLEAR");
		clearall.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		cont.setLayout((LayoutManager)new GridLayout(8,1));
		
		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
cont.setLayout((LayoutManager)new BorderLayout());
		
		//adding component
		cont.add(p9);
		p9.add(p1);
		p9.add(p2);
		p9.add(p3);
		p9.add(p4);
		p9.add(p5);
		p9.add(p6);
		p9.add(p7);
		p9.add(p8);
		
		
		p9.setLayout(new GridLayout(8,1));
		
		cont.add(p9,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		
		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(lamount);
		p4.add(amount);
		
		p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p6.add(ok);
		p6.add(clearall);
		p6.add(close);
			
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
			
			cont.setBackground(Color.orange);
			p1.setBackground(Color.orange);
			p2.setBackground(Color.orange);
			p3.setBackground(Color.orange);
			p4.setBackground(Color.orange);
			p5.setBackground(Color.orange);
			p6.setBackground(Color.orange);
			p7.setBackground(Color.orange);
			p8.setBackground(Color.orange);
			
			setTitle("Current Account");
			setVisible(true);
			setSize(1900,700);
		}

	public static void main(String[] args) {
		Current fp1=new Current();
		fp1.launchframe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac=e.getActionCommand();
		String A="^[a-zA-z]";
		String B="^[a-zA-Z0-9]";
		String K="^[a-zA-Z0-9]";
		String C="^[0-9]";
		
		switch(ac)
		{
		case("b1"):
			String samount1,result;
			Scanner sc1;
			samount1=amount.getText().trim();
			sc1=new Scanner(samount1);
			result=sc1.findInLine(C);
			
			if(result==null){
					JOptionPane.showMessageDialog(this, "PLEASE ENTER 	VALID AMOUNT");
					clearall();
					amount.requestFocus();
					break;
			}
			
			if(amount.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Amount cannot be blank");
				clearall();
				amount.requestFocus();
				break;
			}
			try{
			if(Integer.parseInt(amount.getText().trim())<=0){
				JOptionPane.showMessageDialog(this, "Amount cannot be negative");
				amount.setText("");
				amount.requestFocus();
				break;
			}
			}
			catch(NumberFormatException ci){
				JOptionPane.showMessageDialog(this, ci.getMessage()+"THIS AMOUNT LENGHT IS NOT APPLICABLE");
				amount.setText("");
				amount.requestFocus();
			}
			if(Integer.parseInt(amount.getText().trim())>20000){
				JOptionPane.showMessageDialog(this, "Amount should be under 20,000");
				amount.setText("");
				amount.requestFocus();
				break;
			}
			else
			{
				int famount=Integer.parseInt(amount.getText().trim());
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
				if(details.getamount()>=famount){
					SufBalance sf=new SufBalance();
					sf.launchframe();
					newamount=details.getamount()-famount;
				
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
					SufBalance call=new SufBalance();
					call.launchframe();
				}
				else{
					InSufBalance call=new InSufBalance();
					call.launchframe();
				}
				dispose();
			}
			break;
		case "b2":
			amount.setText("");
			amount.requestFocus();
			break;
			
		case "b3":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
		}
	}
	void clearall(){
		amount.setText("");
	}
}

