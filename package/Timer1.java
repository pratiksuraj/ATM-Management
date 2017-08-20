package packmac;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import myproject.Firstpage;


public class Timer1 extends JFrame{
	Toolkit toolkit;
	 Timer timer;
	 static boolean set=false;
	public Timer1(int seconds)
	{
		toolkit=Toolkit.getDefaultToolkit();
		timer=new Timer();
		timer.schedule(new RemindTask(),seconds*10);
	}
	
	class RemindTask extends TimerTask{
		@Override
		public void run() {
			Firstpage call=new Firstpage();
			toolkit.beep();
		}
		
	}
	public static void main(String args[])
	{
		new Timer1(90);
	}
}
