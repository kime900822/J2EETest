package stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream("object.text"));
			Person per=new Person("孙悟空", 500);
			oos.writeObject(per);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (oos!=null) {
					oos.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
