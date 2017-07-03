package spring.before;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class CustomerMain {

	public static void main(String[] args) {
//		ClassPathResource resource=new ClassPathResource("spring/before/beans1.xml");
//		BeanFactory factory=new XmlBeanFactory(resource);
//		Customer customer = (Customer)factory.getBean("customer");	
	
		DefaultListableBeanFactory bdr=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(bdr);
		reader.loadBeanDefinitions(new ClassPathResource("spring/before/beans1.xml"));
		
		Customer customer = (Customer)bdr.getBean("customer");	
			
		customer.buy();
	}

}
