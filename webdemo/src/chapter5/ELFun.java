package chapter5;

public class ELFun {

	
	//EL函数
	public static String processStr(String s){
		s=s.replace("<", "&lt;");
		s=s.replace(">", "&gt;");
		s=s.replace(" ", "&nbsp;");
		return s;		
		
	}
}
