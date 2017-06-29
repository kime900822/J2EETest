package kime.shweb.control;

public class ServiceFactory {
	public static ProductService getServiceInstance(){
		return new ProductServiceImpl();
	}
}
