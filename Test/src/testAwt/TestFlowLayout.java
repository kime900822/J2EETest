package testAwt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class TestFlowLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("���Դ���");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		for(int i=0;i<50;i++){
			f.add(new Button("��ť"+i));			
		}	
		//���ô���Ϊ��Ѵ�С
		f.pack();
		f.setVisible(true);
	}

}
