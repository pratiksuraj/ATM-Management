package myproject;
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

import packmac.Employee;



public class Report extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lUserName,lPassword,lcardno,lamount,lcontact,lblock;
	private JButton close; 
	static ArrayList<Bankdetails> al;
	
	public Report(ArrayList<Bankdetails> al) {
		lUserName = new JLabel("USERNAME");
		lUserName.setForeground(Color.red);
		lUserName.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lcardno = new JLabel("CARD NO");
		lcardno.setForeground(Color.red);
		lcardno.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lPassword = new JLabel("PASSWORD");
		lPassword.setForeground(Color.red);
		lPassword.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lamount = new JLabel("AMOUNT");
		lamount.setForeground(Color.red);
		lamount.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lcontact = new JLabel("CONTACT NO");
		lcontact.setForeground(Color.red);
		lcontact.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblock = new JLabel("STATUS");
		lblock.setForeground(Color.red);
		lblock.setFont(new Font("Segoe Print", Font.BOLD, 15));
		
		close=new JButton("CLOSE");
		close.setForeground(Color.red);
		close.setFont(new Font("Segoe Print", Font.BOLD, 15));
		close.setPreferredSize(new Dimension(10,10));
		this.al=al;
		setLayout(new GridLayout(al.size()+2,6));
		add(new JLabel(""));
		add(new JLabel(""));
		add(close);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(lUserName);
		add(lcardno);
		add(lPassword);
		add(lamount);
		add(lcontact);
		add(lblock);
		for(Bankdetails e:al){
			add(new JLabel(e.getusername()));
			add(new JLabel(e.getcardno()));
			add(new JLabel(e.getpassword()));
			add(new JLabel(String.valueOf(e.getamount())));
			add(new JLabel(e.getcontactno()));
			add(new JLabel(e.getblockstatus()));
		}
		//set action command
		close.setActionCommand("b1");
		//set action listener
		close.addActionListener(this);
	}

	public void launchframe() {
				setSize(1000,1000);
				setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent choice) {
		String check=choice.getActionCommand();
		switch(check){
		case "b1":
			dispose();
			break;
		}
	}
}
