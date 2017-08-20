package myproject;
import java.io.Serializable;

public class Bankdetails implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String vusername,vpassword,vcardno,vcontactno;
	private int vamount;
	private String vblock;
	public Bankdetails(){
	}
	public Bankdetails(String vpassword){
		this.vpassword=vpassword;
	}
	public Bankdetails (String vusername,String vpassword,String vcardno,int vamount,String vcontactno,String vblock)
	{
		this.vpassword=vpassword;
		this.vusername=vusername;
		this.vcardno=vcardno;
		this.vamount=vamount;
		this.vcontactno=vcontactno;
		this.vblock=vblock;
	}
	public String getusername()
	{
		return vusername;
	}
	public String getpassword()
	{
		return vpassword;
	}
	public String getcardno(){
		return vcardno;
	}
	public int getamount(){
		return vamount;
	}
	public String getcontactno(){
		return vcontactno;
	}
	public String getblockstatus(){
		return vblock;
	}
}
