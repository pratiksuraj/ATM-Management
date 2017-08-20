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

public class Changepassword extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel globatm,details,imageE,imageW;
	private JButton close;
	Container cont;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	public Changepassword()
	{
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
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 35));
	
		details=new JLabel("Your Pin is changed");
		details.setBackground(Color.orange);
		details.setFont(new Font("Century Schoolbook", Font.BOLD, 29));
		
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
		setTitle("change password page");
}
	public static void main(String[] args) {
		
		/*Changepassword cp=new Changepassword();
		cp.launchframe();*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ans=e.getActionCommand();
		
		switch(ans){
		case "b1":
			Firstpage fp=new Firstpage();
			fp.launchframe();
			dispose();
			break;
		}
			
		
	}

}
