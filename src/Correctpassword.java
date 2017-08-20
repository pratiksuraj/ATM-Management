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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Correctpassword extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Container cont;
	private JLabel globatm,gap,imageE,imageW;
	private JRadioButton radio1,radio2,radio3,radio4,radio5;
	private JButton ok,close;
	private ButtonGroup bg;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	
	public Correctpassword(){
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
	
		radio1=new JRadioButton("Cash Withdrawl");
		radio1.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		radio2=new JRadioButton("Fastcash Withdrawl");
		radio2.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		radio3=new JRadioButton("Balance Enquiry");
		radio3.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		radio4=new JRadioButton("Change Pin");
		radio4.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		radio5=new JRadioButton("Cash Transfer");
		radio5.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		ok=new JButton("CONTINUE");
		ok.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
	
		close=new JButton("CLOSE");
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		bg=new ButtonGroup();
		
		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
		cont.setLayout((LayoutManager)new BorderLayout());
		p13.setLayout(new GridLayout(12,1));
		
		//adding component
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
		
		cont.add(p13,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		
		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);


		bg.add(radio1);
		bg.add(radio2);
		bg.add(radio3);
		bg.add(radio4);
		bg.add(radio5);
		
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
		
		p9.setLayout((LayoutManager) new GridLayout(1,2));
		p9.add(radio5);
		radio5.setHorizontalAlignment(JRadioButton.CENTER);
		
		
		p11.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p11.add(ok);
		
		p11.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p11.add(gap);
		
		p11.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p11.add(close);
		
		//set action
		ok.setActionCommand("b1");
		close.setActionCommand("b2");		
		//set listener
		ok.addActionListener(this);
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
		setTitle("Correct Password");
	}

	public static void main(String[] args) {
		Correctpassword cp=new Correctpassword();
		cp.launchframe();
	}

	@Override
	public void actionPerformed(ActionEvent choose) {
		String choice=choose.getActionCommand();
		switch(choice){
		case "b1":
			if(radio1.isSelected()){
				dispose();
				Current call=new Current();
				call.launchframe();
				break;
			}
			if(radio2.isSelected()){
				dispose();
				Fastcash call=new Fastcash();
				call.launchframe();
				break;
			}
			if(radio3.isSelected()){
				dispose();
				Balance call=new Balance();
				call.launchframe();
				break;
			}
			if(radio4.isSelected()){
				dispose();
				Changepin call=new Changepin();
				call.launchframe();
				break;
			}
			if(radio5.isSelected()){
				dispose();
				Transfer call=new Transfer();
				call.launchframe();
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please select any one option");
				break;
			}
		case "b2":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
		}
	}
}
