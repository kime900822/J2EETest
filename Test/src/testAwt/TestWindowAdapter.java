package testAwt;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowAdapter {

	
	private Frame f=new Frame("测试");
	private TextArea ta=new TextArea("测试");
	
	public void init(){
		
		f.addWindowListener(new Mylistener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	class Mylistener extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口被成功关闭\r\n");
			System.exit(0);
		}

		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestWindowAdapter().init();
	}

}
