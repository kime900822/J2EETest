package thread;

import java.io.BufferedReader;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeCommunicationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PipedReader pr=null;
		PipedWriter pw=null;
		try {
			pw=new PipedWriter();
			pr=new PipedReader();
			
			//���ӹܵ��������������
			pw.connect(pr);
			
			new WriteThread(pw).start();
			new ReaderThread(pr).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


class ReaderThread extends Thread{
	private PipedReader pr;
	private BufferedReader br;
	public ReaderThread(){}
	public ReaderThread(PipedReader pr){
		this.pr=pr;
		this.br=new BufferedReader(pr);		
	}
	public void run(){
		String buf=null;
		try {
			while((buf=br.readLine())!=null){
				System.out.println(buf);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br!=null) {
					br.close();
					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
}

class WriteThread extends Thread{
	
	String[] books=new String[]{
			"Structs2Ȩ��ָ��",
			"ROR���ݿ���",
			"����J2EE��Ajax����",
			"������J2EE��ҵӦ��ָ��"		
	};
	
	private PipedWriter pw;
	public WriteThread(){}
	public WriteThread(PipedWriter pw){
		this.pw=pw;	
	}
	public void run(){
		String buf=null;
		try {
			for (int i = 0; i < 100; i++) {
				pw.write(books[i%4]+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pw!=null) {
					pw.close();
					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
}