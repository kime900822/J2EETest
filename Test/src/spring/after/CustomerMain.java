package spring.after;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import spring.after.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		DefaultListableBeanFactory bdr=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(bdr);
		reader.loadBeanDefinitions(new ClassPathResource("spring/after/beans2.xml"));
		
		Customer customer = (Customer)bdr.getBean("customer");	
			
		customer.buy();
	}

}
