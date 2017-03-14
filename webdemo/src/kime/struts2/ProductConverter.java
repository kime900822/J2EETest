package kime.struts2;

import java.lang.reflect.Member;
import java.util.Map;

import ognl.DefaultTypeConverter;

public class ProductConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map context, Object target, Member member, String propertyName, Object value,
			Class toType) {
		
		if (toType==Product.class) {
			String[] param=(String[])value;
			Product product=new Product();
			String[] productValues=param[0].split(",");
			product.setName(productValues[0].trim());
			product.setPrice(Float.parseFloat(productValues[1].trim()));
			product.setCount(Integer.parseInt(productValues[2].trim()));
			
			return product;
						
			
		}
		else if (toType==String.class) {
			Product product=(Product)value;
			return product.getName()+","+product.getPrice()+","+product.getCount();
			
		}
		
		return null;
	}

	
	
}
