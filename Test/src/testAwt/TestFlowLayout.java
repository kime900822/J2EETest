package testAwt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class TestFlowLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("测试窗口");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		for(int i=0;i<50;i++){
			f.add(new Button("按钮"+i));			
		}	
		//设置窗口为最佳大小
		f.pack();
		f.setVisible(true);
	}

}
