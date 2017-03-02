package test;

public class Test01 {

	public static void main(String[] args) {

        try {
			Animal a = new Cat();//����ת��  
			a.eat();  
			
			Cat c = (Cat)a;//����ת��  
			c.catchMouse();


			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}  
        
	}

}


abstract class Animal  
{  
    abstract void eat() throws Exception;  
}  

class Cat extends Animal 
{  
    public void eat() throws Exception 
    {  
        System.out.println("����");  
    }  
    public void catchMouse() throws Exception  
    {  
        System.out.println("ץ����"); 
        
    }  
}  
  
class Dog extends Animal  
{  
    public void eat()  
    {  
        System.out.println("�Թ�ͷ");  
    }  
    public void kanJia()  
    {  
        System.out.println("����");  
    }  
}  