package test;

public class Test01 {

	public static void main(String[] args) {

        try {
			Animal a = new Cat();//向上转型  
			a.eat();  
			
			Cat c = (Cat)a;//向下转型  
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
        System.out.println("吃鱼");  
    }  
    public void catchMouse() throws Exception  
    {  
        System.out.println("抓老鼠"); 
        
    }  
}  
  
class Dog extends Animal  
{  
    public void eat()  
    {  
        System.out.println("吃骨头");  
    }  
    public void kanJia()  
    {  
        System.out.println("看家");  
    }  
}  