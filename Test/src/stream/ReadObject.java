package stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {

	public static void main(String[] args) {
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream("object.text"));
			Person per=(Person)ois.readObject();
			System.out.println("����Ϊ��" +per.getName()+"  ����Ϊ��"+per.getAge());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (ois!=null) {
					ois.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
