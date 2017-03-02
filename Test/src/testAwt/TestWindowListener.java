package testAwt;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindowListener {

	private Frame f=new Frame("����");
	private TextArea ta=new TextArea("����");
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
			ta.append("���ڱ�����\r\n");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("���ڱ��ɹ��ر�\r\n");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("���ڹرմ���\r\n");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("����ʧȥ����\r\n");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("���ڱ��ָ�\r\n");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("������С��\r\n");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			ta.append("���ڵ�һ�α���\r\n");
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestWindowListener().init();
	}

}
