/*package packmac;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myproject.Bankdetails;
import myproject.Firstpage;
import myproject.Userpage;

public class Savings extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	String famount;
	Container cont;
	JLabel globatm,lamount;
	JTextField amount;
	JButton ok,clearall,close;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
	static int index=0;
	private ArrayList<Bankdetails> al;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Bankdetails detail;

	
	public Savings(){
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
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		
		globatm=new JLabel("GLOBSYN ATM");
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		lamount=new JLabel("Enter the amount             ");
		lamount.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		amount=new JTextField(20);
		amount.setPreferredSize(new Dimension(35,35));
		ok=new JButton("Ok");
		clearall=new JButton("Clear");
		close=new JButton("Close");

		cont.setLayout((LayoutManager)new GridLayout(12,1));
		
		//addition of components
		cont.add(p1);
		cont.add(p2);
		cont.add(p3);
		cont.add(p4);
		cont.add(p5);
		cont.add(p6);
		cont.add(p7);
		cont.add(p8);
		cont.add(p9);
		cont.add(p10);
		cont.add(p11);
		cont.add(p12);
		
		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);
		//globatm.setSize(getSize());
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(lamount);
		//lamount.setHorizontalAlignment(JLabel.CENTER);
		p4.add(amount);
		//amount.setHorizontalAlignment(JLabel.LEFT);
		
		p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p7.add(ok);
		p8.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p8.add(clearall);
		p8.add(close);
			
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
			setTitle("GLOBSYN ATM");
			cont.setBackground(Color.white);
			p1.setBackground(Color.lightGray);
			p2.setBackground(Color.lightGray);
			p3.setBackground(Color.lightGray);
			p4.setBackground(Color.lightGray);
			p5.setBackground(Color.lightGray);
			p6.setBackground(Color.lightGray);
			p7.setBackground(Color.lightGray);
			p8.setBackground(Color.lightGray);
			
			setTitle("Savings Account");
			setVisible(true);
			setSize(700,700);
		}

	public static void main(String[] args) {
		Savings fp1=new Savings();
		fp1.launchframe();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac=e.getActionCommand();
		switch(ac)
		{
		case("b1"):
			if(amount.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "amount cannot be blank");
				clearall();
				return;
			}
			else{
				famount=amount.getText();
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
				index=ups.getindex();
				detail=al.get(index);
				dispose();
				break;
			}
		case "b2":
			amount.setText("");
			break;
			
		case "b3":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
		}
	}
	void clearall()
	{
		amount.setText("");
	}
}

*/