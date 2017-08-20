package packmac;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;



public class Timer2 {
	Toolkit toolkit;
	 Timer timer;
	 public static boolean set=false;
	 static int count=0;
	public Timer2(int seconds)
	{
		toolkit=Toolkit.getDefaultToolkit();
		timer=new Timer();
		timer.schedule(new RemindTask(),seconds*10);
	}
	
	class RemindTask extends TimerTask{

		@Override
		public void run() {
			toolkit.beep();
		}
		
	}
	public static void main(String args[])
	{
		new Timer1(90);
	}
}
