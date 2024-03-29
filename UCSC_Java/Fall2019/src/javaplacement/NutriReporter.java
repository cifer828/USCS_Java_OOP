// Name: Qiuchen Zhang
// Andrew-ID: qiuchenz
package javaplacement;

import java.util.List;
import java.util.Map;

//Reads Nutrients.csv to produce reports about products and nutrients.
public class NutriReporter {
	
	//DO NOT change member variables defined below. You can define new variables, if needed
	
	DataModel dataModel;  //reads data from NUTRIENT_FILE and loads it in its recordList
	List<Product> productList;   //list of product objects
	List<Nutrient> nutrientList;  //list of nutrient objects
	Map<String, Product> productMap ;  //map that has product code as key and product object as its value
	Map<String, Nutrient> nutrientMap; //map that has nutrient code as key and nutrient object as its value

	
	//DO NOT change this method
	public static void main(String[] args) {
		NutriReporter nutriReporter = new NutriReporter();
		nutriReporter.dataModel = new DataModel();
		nutriReporter.dataModel.readFile();

		nutriReporter.buildProductList();
		nutriReporter.printProductListReport();

		nutriReporter.buildNutrientList();
		nutriReporter.printNutrientListReport();

		nutriReporter.buildProductMap();
		nutriReporter.printProductMapReport();
		
		nutriReporter.buildNutrientMap();
		nutriReporter.printNutrientMapReport();
	}

	
	//loads data from dataModel's recordList into productList
	void buildProductList() {
		//write your code here
		int l = this.dataModel.recordList.size();
		for(int i=0;i<l;i++){
			Record r = this.dataModel.recordList.get(i);
			this.productList.add(new Product(r.productCode));
		}
	}

	//prints productList report in sorted order of product code
	void printProductListReport() {
		//write your code here
		System.out.printf("There are total %d products.", this.productList.size());
	}


	//loads data from dataModel's recordList into nutrientList 
	void buildNutrientList() {
		//write your code here
		
	}

	//prints nutrient report in sorted order of nutrient code
	void printNutrientListReport() {
		//write your code here
	}

	//loads data from dataModel's recordList into productMap 
	void buildProductMap() {
		//write your code here
	}

	//prints product-map report 
	void printProductMapReport() {
		//write your code here
	}
	

	//loads data from dataModel's recordList into nutrientMap 
	void buildNutrientMap() {
		//write your code here
	}

	//prints nutrient-map report
	void printNutrientMapReport() {
		//write your code here
	}
}
