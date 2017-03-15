package kime.struts2;

import java.util.Map;

import javax.print.attribute.ResolutionSyntax;

import org.apache.struts2.util.StrutsTypeConverter;

//继承StrutsTypeConverter的类型转换
public class StrutsProductConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if (arg1.length>1) {
			Product[] products=new Product[arg1.length];
			for(int i=0;i<arg1.length;i++){
				Product product=new Product();
				String[] productVlaues=arg1[i].split(",");
				product.setName(productVlaues[0].trim());
				product.setPrice(Float.parseFloat(productVlaues[1].trim()));
				product.setCount(Integer.parseInt(productVlaues[2].trim()));
				products[i]=product;
			}
			return products;
			
		}else{
			Product product=new Product();
			String[] productVlaues=arg1[0].split(",");
			product.setName(productVlaues[0].trim());
			product.setPrice(Float.parseFloat(productVlaues[1].trim()));
			product.setCount(Integer.parseInt(productVlaues[2].trim()));
			return product;
		}
		
		
		
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		
		if (arg1 instanceof Product) {
			Product product=(Product)arg1;
			return(product.getName()+","+product.getPrice()+","+product.getCount());		
		}else if (arg1 instanceof Product[]) {
			String result="";
			Product[] products=(Product[])arg1;
			for (Product product : products) {
				result+="["+product.getName()+","+product.getPrice()+","+product.getCount()+"]";
			}
			return result;
		}
		else {
			return "";
		}
		
		
	}

}
