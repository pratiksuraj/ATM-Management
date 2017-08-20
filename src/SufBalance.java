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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SufBalance extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Container cont;
	JLabel globatm,msg,imageE,imageW;
	JButton close;
	JPanel p1,p2,p3,p4,p5,p6,p7;
	
	
	public SufBalance()
	{
		cont=getContentPane();
		
		//Instantiation
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		
		
		
		globatm=new JLabel("GLOBSYN ATM");
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 39));
		
		msg=new JLabel("Please Collect the Cash");
		msg.setFont(new Font("Century Schoolbook", Font.BOLD, 35));
		
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 20));

		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
cont.setLayout((LayoutManager)new BorderLayout());
		
		//addition of components
		cont.add(p7);
		p7.add(p1);
		p7.add(p2);
		p7.add(p3);
		p7.add(p4);
		p7.add(p5);
		p7.add(p6);
		

		p7.setLayout(new GridLayout(6,1));
		
		cont.add(p7,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		

		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);
		//globatm.setSize(getSize());
		
		p3.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p3.add(msg);
		//lamount.setHorizontalAlignment(JLabel.CENTER);
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(close);
		
		//set action command
		close.setActionCommand("b1");
		
		//set listener
		close.addActionListener(this);
	}

	public void launchframe()
	{
		setTitle("GLOBSYN ATM");
		cont.setBackground(Color.orange);
		p1.setBackground(Color.orange);
		p2.setBackground(Color.orange);
		p3.setBackground(Color.orange);
		p4.setBackground(Color.orange);
		p5.setBackground(Color.orange);
		p6.setBackground(Color.orange);
		setTitle("Sufficient_Balance");
		setSize(1900,700);
		setVisible(true);
	}

public static void main(String[] args) {
		/*SufBalance sf=new SufBalance();
		sf.launchframe();*/
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String ac=e.getActionCommand();
		switch(ac)
		{
		case("b1"):
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
			break;
		}
	}
}

