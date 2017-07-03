package spring.watch;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import spring.watch.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		DefaultListableBeanFactory bdr=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(bdr);
		reader.loadBeanDefinitions(new ClassPathResource("spring/watch/beans3.xml"));
		
		Customer customer = (Customer)bdr.getBean("customer");	
			
		customer.buy();

	}

}
