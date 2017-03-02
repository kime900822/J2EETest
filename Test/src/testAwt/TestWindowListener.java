package testAwt;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindowListener {

	private Frame f=new Frame("测试");
	private TextArea ta=new TextArea("测试");
	public void init(){
	
		f.addWindowListener(new Mylistener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	class Mylistener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口被激活\r\n");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口被成功关闭\r\n");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("正在关闭窗口\r\n");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口失去焦点\r\n");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口被恢复\r\n");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口最小化\r\n");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("窗口第一次被打开\r\n");
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestWindowListener().init();
	}

}
