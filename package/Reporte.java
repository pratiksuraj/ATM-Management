package packmac;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import myproject.Bankdetails;



public class Reporte extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel lUserName,lPassword,lcardno,lamount,lcontact;
	static ArrayList<Bankdetails> al;
	public Reporte(ArrayList<Bankdetails> al) {
		lUserName = new JLabel("USERNAME");
		lcardno = new JLabel("CARD NO");
		lPassword = new JLabel("PASSWORD");
		lamount = new JLabel("AMOUNT");
		lcontact = new JLabel("CONTACT NO");
		this.al=al;
		setLayout(new GridLayout(al.size()+1,6));
		add(lUserName);
		add(lcardno);
		add(lPassword);
		add(lamount);
		add(lcontact);
	
		for(Bankdetails e:al){
			add(new JTextField(e.getusername()));
			add(new JTextField(e.getcardno()));
			add(new JTextField(e.getpassword()));
			add(new JTextField(String.valueOf(e.getamount())));
			add(new JTextField(e.getcontactno()));
		}
		
	}

	public void launchFrame() {
				setSize(600,700);
				setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
