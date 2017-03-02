package testAwt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

public class TestScrollPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("²âÊÔ´°¿Ú");
		ScrollPane sp=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		
		sp.add(new TextField(20));
		sp.add(new Button("µã»÷ÎÒ"));
		f.add(sp);
		f.setBounds(30,30,250,120);
		f.setVisible(true);
	}

}
