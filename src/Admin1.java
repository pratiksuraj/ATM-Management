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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import packmac.Employee;

public class Admin1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static int searchcounter;
	static ArrayList<Bankdetails>al;
	private JLabel globatm,lusername,lcardno,lpassword,lamount,lcontactno,ladduser,laddcard,imageE,imageW,lblock;
	private JTextField username,cardno,amount,tsearch,contactno,tsearchcard;
	private static String scard; 
	private String [] q={"Working","Block",""};
	private JComboBox<String> status;
	private JPasswordField password;
	private JButton add,remove,modify,report,search,load,clearall,close;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
	Container cont;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public Admin1(){
		al = new ArrayList<Bankdetails>();
		cont=getContentPane();
		globatm=new JLabel("GLOBSYN ATM  ");
		lusername=new JLabel("USERNAME     ");
		lcardno=new JLabel("CARD NO         ");
		lpassword=new JLabel("PIN                   ");
		lamount=new JLabel("AMOUNT          ");
		lcontactno=new JLabel("CONTACT NO   ");
		ladduser=new JLabel("ENTER USER NAME   ");
		laddcard=new JLabel("ENTER CARD NO.        ");
		lblock=new JLabel("BLOCK STATUS        ");
		tsearch=new JTextField(20);
		tsearchcard=new JTextField(20);
		username=new JTextField(20);
		cardno=new JTextField(20);
		password=new JPasswordField(20);
		amount=new JTextField(20);
		contactno=new JTextField(20);
		status=new JComboBox<String>(q);
		add=new JButton("ADD");
		remove=new JButton("CLOSE ACCOUNT");
		modify=new JButton("MODIFY");
		report=new JButton("REPORT");
		search=new JButton("SEARCH");
		load=new JButton("LOAD");
		clearall=new JButton("CLEAR ALL");
		close=new JButton("CLOSE");
		
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
		
		globatm.setForeground(Color.red);
		globatm.setFont(new Font("Segoe Print", Font.BOLD, 29));
		
		lusername.setBackground(Color.lightGray);
		lusername.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		lcardno.setBackground(Color.lightGray);
		lcardno.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		
		lamount.setBackground(Color.lightGray);
		lamount.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
	
		lblock.setBackground(Color.lightGray);
		lblock.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
	
		lpassword.setBackground(Color.lightGray);
		lpassword.setFont(new Font("Century Schoolbook", Font.BOLD, 20));

		lcontactno.setBackground(Color.lightGray);
		lcontactno.setFont(new Font("Century Schoolbook", Font.BOLD, 19));

		ladduser.setBackground(Color.lightGray);
		ladduser.setFont(new Font("Century Schoolbook", Font.BOLD, 19));

		laddcard.setBackground(Color.lightGray);
		laddcard.setFont(new Font("Century Schoolbook", Font.BOLD, 19));
		
		load.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		add.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		remove.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		modify.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		report.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		clearall.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		search.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		close.setFont(new Font("Century Schoolbook", Font.BOLD, 13));

		imageE=new JLabel(new ImageIcon("0.jpg"));
		imageW=new JLabel(new ImageIcon("1.PNG"));
		
cont.setLayout((LayoutManager)new BorderLayout());
		
		//adding component
		cont.add(p14);
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
		p13.setLayout(new GridLayout(13,1));
		
		cont.add(p14,BorderLayout.CENTER);
		cont.add(imageE,BorderLayout.EAST);
		cont.add(imageW,BorderLayout.WEST);
		
		p2.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p2.add(globatm);
		
		p3.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p3.add(lusername);
		p3.add(username);
		
		p4.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p4.add(lcardno);
		p4.add(cardno);
		
		p5.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p5.add(lpassword);
		p5.add(password);
		
		p6.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p6.add(lamount);
		p6.add(amount);
		
		p7.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p7.add(lcontactno);
		p7.add(contactno);
		
		p8.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p8.add(lblock);
		p8.add(status);
		
		p9.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p9.add(load);
		p9.add(add);
		p9.add(remove);
		p9.add(modify);
		p9.add(report);
		p10.add(clearall);
		p10.add(close);
		p11.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p11.add(ladduser);
		p11.add(tsearch);
		
	
		p12.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p12.add(laddcard);
		p12.add(tsearchcard);
		
		p13.setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		p13.add(search);
	
		//set action command
		load.setActionCommand("b1");
		add.setActionCommand("b2");
		remove.setActionCommand("b3");
		modify.setActionCommand("b4");
		report.setActionCommand("b5");
		search.setActionCommand("b6");
		clearall.setActionCommand("b7");
		close.setActionCommand("b8");
		//set action listener
		load.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		modify.addActionListener(this);
		report.addActionListener(this);
		search.addActionListener(this);
		clearall.addActionListener(this);
		close.addActionListener(this);
}
	public void launchframe(){
		setTitle("ADMIN PAGE");
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
		setVisible(true);
		setSize(1900,700);
}
	public static void main(String[] args) {
		/*Admin1 ac=new Admin1();
		ac.launchframe();*/
	}
	private void clearall()
	{
		username.setText("");
		password.setText("");
		amount.setText("");
		cardno.setText("");
		contactno.setText("");
		status.setSelectedIndex(2);
	}
	private void displayRecord(int sindex2)
	{
		if(al.size()==0)
		{
			JOptionPane.showMessageDialog(this,"NO RECORDS EXISTS..");
			return;
		}
		Bankdetails e = al.get(sindex2);
		username.setText(e.getusername());
		password.setText(e.getpassword());
		amount.setText(String.valueOf(e.getamount()));
		cardno.setText(e.getcardno());
		contactno.setText(e.getcontactno());
		status.setSelectedItem(e.getblockstatus());
	}
	@Override
	public void actionPerformed(ActionEvent event){
		String choice=event.getActionCommand();
		String A="^[a-zA-z]";
		String B="^[a-zA-Z0-9]";
		String K="^[a-zA-Z0-9]";
		String C="^[0-9]";
		
		Scanner sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10;
	
		switch(choice){
			case "b1":
				try{
					fis=new FileInputStream("userdetails.db");
					ois=new ObjectInputStream(fis);
					al=(ArrayList<Bankdetails>)ois.readObject();
					JOptionPane.showMessageDialog(this, "Record loaded");
					}
					catch(ClassNotFoundException| IOException ci){
						JOptionPane.showMessageDialog(this, ci.getMessage());
					}
					break;
				case "b2":
					boolean checkit = false;
					String suser,scards,spin,samount,scontact,result1,result2,result3,result4,result5;
					
					suser=username.getText().trim();
					scards=cardno.getText().trim();
					spin=String.valueOf(password.getPassword());
					samount=amount.getText().trim();
					scontact=contactno.getText().trim();
					
					sc1=new Scanner(suser);
					result1=sc1.findInLine(A);
					sc2=new Scanner(scards);
					result2=sc2.findInLine(C);
					spin=String.valueOf(password.getPassword());
					sc3=new Scanner(spin);
					result3=sc3.findInLine(C);
					sc4=new Scanner(samount);
					result4=sc4.findInLine(C);
					sc5=new Scanner(scontact);
					result5=sc5.findInLine(C);
					if(username.getText().equals("")||password.getPassword().equals("")||amount.getText().equals("")||cardno.getText().equals("")||contactno.getText().equals("")||amount.getText().equals("")||status.getSelectedItem().toString().equals(""))
					{								
						JOptionPane.showMessageDialog(this, "INPUT IS MANDATORY");
						clearall();
						username.requestFocus();
						break;
					}
					if(result1==null){
						JOptionPane.showMessageDialog(this, "USERNAME ONLY CONSIST OF ALBHABETS");
						clearall();
						username.requestFocus();
						break;
					}
					if(result2==null||scards.length()!=16){
						JOptionPane.showMessageDialog(this, "PLEASE ENTER  CARD NO. OF LENGHT OF 16 DIGITS ");
						clearall();
						username.requestFocus();
						break;
					}
					for(Bankdetails check:al){
						if(check.getcardno().equals(scards)){
							JOptionPane.showMessageDialog(this, "Records already saved");
							clearall();
							checkit=true;
							username.requestFocus();
							break;
						}
					}
					if(result3==null || spin.length()!=4)
					{
						JOptionPane.showMessageDialog(this, "Enter a valid pin of 4 digits");
						clearall();
						username.requestFocus();
						break;
					}
					try{
						if(result4==null||Integer.parseInt(amount.getText().trim())>500000){
							JOptionPane.showMessageDialog(this, "PLEASE ENTER AMOUNT UNDER 500000");
							clearall();
							username.requestFocus();
							break;
						}
					}
					catch(NumberFormatException ci){
						JOptionPane.showMessageDialog(this, ci.getMessage()+"THIS AMOUNT LENGHT IS NOT APPLICABLE");
					}
					if(result5==null||scontact.length()!=10){
						JOptionPane.showMessageDialog(this, "PLEASE ENTER PROPER CONTACT NO. OF 10 DIGITS");
						clearall();
						username.requestFocus();
						break;
					}
					if(checkit==false){
							al.add(new Bankdetails(username.getText().trim(),String.valueOf(password.getPassword()),cardno.getText().trim(),Integer.parseInt(amount.getText().trim()),contactno.getText().trim(),status.getSelectedItem().toString()));
							try
							{
								fos = new FileOutputStream("userdetails.db");
								oos = new ObjectOutputStream(fos);
								oos.writeObject(al);
								oos.flush();
								oos.close();
								JOptionPane.showMessageDialog(this, "records saved");
							}
							catch(IOException ie)
							{
								ie.printStackTrace();
							}
							clearall();
						}
					break;
				case "b3":
					if(username.getText().equals("")||String.valueOf(password.getPassword()).equals("")||cardno.getText().equals("")||contactno.getText().equals("")||amount.getText().equals("")||status.getSelectedItem().toString().equals("")){
						JOptionPane.showMessageDialog(this, "EMPTY FIELD CANNOT BE REMOVED");
					}
					else{
						al.remove(searchcounter);
						JOptionPane.showMessageDialog(this, "RECORDS DELETED SUCCESSFULLY");
						try
						{
							fos = new FileOutputStream("userdetails.db");
							oos = new ObjectOutputStream(fos);
							oos.writeObject(al);
							oos.flush();
							oos.close();
							JOptionPane.showMessageDialog(this, "RECORDS SAVED");
						}
						catch(IOException ie)
						{
							ie.printStackTrace();
						}
					}
					clearall();
					break;
				case "b4":
					boolean checkit1=false;
					String suser1,scards1,spin1,samount1,scontact1,result10,result20,result30,result40,result50;
					
					suser1=username.getText().trim();
					scards1=cardno.getText().trim();
					spin1=String.valueOf(password.getPassword());
					samount1=amount.getText().trim();
					scontact1=contactno.getText().trim();
					if(username.getText().equals("")||String.valueOf(password.getPassword()).equals("")||cardno.getText().equals("")||contactno.getText().equals("")||amount.getText().equals("")||status.getSelectedItem().toString().equals("")){
						JOptionPane.showMessageDialog(this, "EMPTY FIELD CANNOT BE MODIFIED");
					}
					sc6=new Scanner(suser1);
					result10=sc6.findInLine(A);
					sc7=new Scanner(scards1);
					result20=sc7.findInLine(C);
					spin=String.valueOf(password.getPassword());
					sc8=new Scanner(spin1);
					result30=sc8.findInLine(C);
					sc9=new Scanner(samount1);
					result40=sc9.findInLine(C);
					sc10=new Scanner(scontact1);
					result50=sc10.findInLine(C);
					if(username.getText().equals("")||password.getPassword().equals("")||amount.getText().equals("")||cardno.getText().equals("")||contactno.getText().equals("")||amount.getText().equals("")||status.getSelectedItem().toString().equals(""))
					{								
						JOptionPane.showMessageDialog(this, "INPUT IS MANDATORY");
						clearall();
						username.requestFocus();
						break;
					}
					if(result10==null){
						JOptionPane.showMessageDialog(this, "USERNAME ONLY CONSIST OF ALBHABETS");
						clearall();
						username.requestFocus();
						break;
					}
					if(result20==null||scards1.length()!=16){
						JOptionPane.showMessageDialog(this, "PLEASE ENTER  CARD NO. OF LENGHT OF 16 DIGITS ");
						clearall();
						username.requestFocus();
						break;
					}
					if(result30==null || spin1.length()!=4)
					{
						JOptionPane.showMessageDialog(this, "Enter a valid pin of 4 digits");
						clearall();
						username.requestFocus();
						break;
					}
					try{
						if(result40==null||Integer.parseInt(amount.getText().trim())>500000){
							JOptionPane.showMessageDialog(this, "PLEASE ENTER AMOUNT UNDER 500000");
							clearall();
							username.requestFocus();
							break;
						}
					}
					catch(NumberFormatException ci){
						JOptionPane.showMessageDialog(this, ci.getMessage()+"THIS AMOUNT LENGHT IS NOT APPLICABLE");
					}
					if(result50==null||scontact1.length()!=10){
						JOptionPane.showMessageDialog(this, "PLEASE ENTER PROPER CONTACT NO. OF 10 DIGITS");
						clearall();
						username.requestFocus();
						break;
					}
					else{
						al.remove(searchcounter);
						al.add(searchcounter,new Bankdetails(username.getText().trim(),String.valueOf(password.getPassword()),cardno.getText().trim(),Integer.parseInt(amount.getText().trim()),contactno.getText().trim(),status.getSelectedItem().toString()));
						Bankdetails bd;
						bd=al.get(searchcounter);
						if(!bd.getcardno().equals(scard)){
							JOptionPane.showMessageDialog(this, "CARD NO. CAN NOT MODIFIED");
							clearall();
							break;
						}
						try
							{
								fos = new FileOutputStream("userdetails.db");
								oos = new ObjectOutputStream(fos);
								oos.writeObject(al);
								oos.flush();
								oos.close();
								JOptionPane.showMessageDialog(this, "records saved");
							}
							catch(IOException ie)
							{
								ie.printStackTrace();
							}
							clearall();
					}
					break;
				case "b5":
					try{
						fis=new FileInputStream("userdetails.db");
						ois=new ObjectInputStream(fis);
						al=(ArrayList<Bankdetails>)ois.readObject();
						JOptionPane.showMessageDialog(this, "Record loaded");
					}
					catch(ClassNotFoundException| IOException ci){
						ci.printStackTrace();
					}
					Report call1=new Report(al);
					call1.launchframe();
					break;
				case "b6":
					boolean found = false;
					searchcounter = 0;
					for(Bankdetails se:al)
					{
						if(se.getusername().trim().equals(tsearch.getText().trim())&&se.getcardno().trim().equals(tsearchcard.getText().trim())){
							found = true;
							JOptionPane.showMessageDialog(this,"RECORD FOUND");
							displayRecord(searchcounter);
							scard=cardno.getText();
							break;
						}
						searchcounter++;
					}
					if(!found)
					{
						JOptionPane.showMessageDialog(this,"RECORD NOT FOUND..");
					}
					tsearch.setText("");
					tsearchcard.setText("");
					break;
				case "b7":
					username.setText("");
					password.setText("");
					amount.setText("");
					cardno.setText("");
					contactno.setText("");
					status.setSelectedIndex(2);
					break;
				case "b8":
					Firstpage call=new Firstpage();
					call.launchframe();
					dispose();
			}
	}
}
