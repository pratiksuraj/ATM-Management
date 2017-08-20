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
import javax.swing.JRadioButton;

public class Toprint extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	String user,card,amountleft,amountreceived,user1,card1,amountleft1;
	Container cont;
	private JLabel imageE,imageW,labela,labelb,labelc,labeld,labela1,labelb1,labelc1,labeld1;
	private JButton close;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
	private ArrayList<Bankdetails> al;
	private JLabel globatm,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public Toprint(){
		Bankdetails bd;
		try{
			fis=new FileInputStream("userdetails.db");
			ois=new ObjectInputStream(fis);
			al=(ArrayList<Bankdetails>)ois.readObject();
		}
		catch(ClassNotFoundException| IOException ci){
			ci.printStackTrace();
		}
		Transfer call=new Transfer(20);
		int username1= call.print1();
		int username2=call.print3();
		int amounttransfer=call.print2();
	
		bd=al.get(username1);
		user=bd.getusername();
		card=bd.getcardno();
		amountleft=String.valueOf(bd.getamount());
		amountreceived=String.valueOf(amounttransfer);
		
		bd=al.get(username2);
		user1=bd.getusername();
		card1=bd.getcardno();
		amountleft1=String.valueOf(bd.getamount());
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
		p14=new JPanel();
		p15=new JPanel();
		globatm=new JLabel("GLOBSYN Atm");
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		label1=new JLabel("FROM");
		label1.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		label1.setForeground(Color.BLUE);
		label2=new JLabel("USERNAME:-");
		label2.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label3=new JLabel("CARD NO:-");
		label3.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label4=new JLabel("AMOUNT TRANSFERED:-");
		label4.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label5=new JLabel("AMOUNT AVAILABLE:-");
		label5.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label6=new JLabel("TO");
		label6.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
		label6.setForeground(Color.BLUE);
		
		label7=new JLabel("USERNAME:-");
		label7.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label8=new JLabel("CARD NO. :-");
		label8.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label9=new JLabel("AMOUNT RECEIVED:-");
		label9.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		label10=new JLabel("CURRENT BALANCE:-");
		label10.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labela=new JLabel(user);
		labela.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labelb=new JLabel(card);
		labelb.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labelc=new JLabel(amountreceived);
		labelc.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labeld=new JLabel(amountleft);
		labeld.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labela1=new JLabel(user1);
		labela1.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labelb1=new JLabel(card1);
		labelb1.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labelc1=new JLabel(amountreceived);
		labelc1.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		labeld1=new JLabel(amountleft1);
		labeld1.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
		cont.setLayout((LayoutManager)new BorderLayout());
		//adding component
		p14.add(p1);
		p14.add(p2);
		p14.add(p3);
		p14.add(p4);
		p14.add(p5);
		p14.add(p6);
		p14.add(p7);
		p14.add(p8);
		p14.add(p9);
		p14.add(p10);
		p14.add(p11);
		p14.add(p12);
		p14.add(p13);
		p14.add(p15);
		cont.add(p14,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		p14.setLayout(new GridLayout(15,1));
		
		p1.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p1.add(globatm);
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(label1);
		p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p5.add(label2);
		p5.add(labela);
		p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p6.add(label3);
		p6.add(labelb);
		p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p7.add(label4);
		p7.add(labelc);
		p8.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p8.add(label5);
		p8.add(labeld);
		p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p9.add(label6);
		p10.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p10.add(label7);
		p10.add(labela1);
		p11.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p11.add(label8);
		p11.add(labelb1);
		p12.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p12.add(label9);
		p12.add(labelc1);
		p13.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p13.add(label10);
		p13.add(labeld1);
		
		p14.add(close);
		
		//set action command
		close.setActionCommand("b1");
		//set action listener
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
		p13.setBackground(Color.orange);
		p14.setBackground(Color.orange);
		p15.setBackground(Color.orange);
		setVisible(true);
		setSize(1900,700);
		setTitle("succesfull transfer");
	}

	public static void main(String[] args) {
	/*	Toprint call=new Toprint();
		call.launchframe();*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String choice=e.getActionCommand();
		switch(choice){
			case"b1":
				Firstpage call=new Firstpage();
				call.launchframe();
				dispose();
				break;
		}
	}

}
