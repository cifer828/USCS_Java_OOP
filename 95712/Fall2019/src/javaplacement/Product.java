// Name: Qiuchen Zhang
// Andrew-ID: qiuchenz
package javaplacement;

import java.util.List;

public class Product implements Comparable<Product>{
	public String productCode;
	public List<String> nutrients;
	public Product(String productCode){
		this.productCode = productCode;
	}
	@Override
	public int compareTo(Product p) {
		// TODO Auto-generated method stub
		return this.productCode.compareTo(p.productCode);
	}
	
}
