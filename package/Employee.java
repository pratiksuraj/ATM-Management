package packmac;
import java.io.Serializable;

public class Employee implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String vUserName,vPassword,vQualification,vAddress;
	private boolean gender;
	private int age;
	public Employee(String vUserName,String vPassword,String vQualification,String vAddress,boolean gender,int age)
	{
		this.vPassword=vPassword;
		this.vUserName=vUserName;
		this.vQualification=vQualification;
		this.gender=gender;
		this.age=age;
		this.vAddress=vAddress;
	}
	public String getUserName()
	{
		return vUserName;
	}
	public String getPassword()
	{
		return vPassword;
	}
	public String getQualification()
	{
		return vQualification;
	}
	public boolean getGender()
	{
		return gender;
	}
	public int getAge()
	{
		return age;
	}
	public String getAddresss()
	{
		
		return vAddress;
	}
	
}
