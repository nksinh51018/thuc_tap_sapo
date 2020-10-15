package com.sapo.edu.demo;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private WareHouseService wareHouseService;
//
//	@Autowired
//	private WareHouseCommon wareHouseCommon;
//
//	@Autowired
//	private CategoryCommon categoryCommon;
//
//	@Autowired
//	private ProductCommon productCommon;
//
//	public final int NUM_CASE = 18;
//	private Scanner scanner = new Scanner(System.in);
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		//showAll();
//		int c = -1;
//		while (c!=0){
//			renderUI();
//			do {
//				c= StringCommon.enterTheNumber("Enter the number: ","Re-enter the number: ");
//			}
//			while (c < 0 || c> NUM_CASE);
//			renderMessageUI(c);
//			switch (c){
//				case 0:
//					System.exit(0);
//				case 1:
//					onGetAllCategories();
//					break;
//				case 2:
//					onGetAllCategoriesByName();
//					break;
//				case 3:
//					onGetCategoryById();
//					break;
//				case 4:
//					onInsertCategory();
//					break;
//				case 5:
//					onUpdateCategory();
//					break;
//				case 6:
//					onDeleteCategory();
//					break;
//				case 7:
//					onGetAllWarehouses();
//					break;
//				case 8:
//					onGetAllWarehousesByName();
//					break;
//				case 9:
//					onGetWarehouseById();
//					break;
//				case 10:
//					onInsertWarehouse();
//					break;
//				case 11:
//					onUpdateWarehouse();
//					break;
//				case 12:
//					onDeleteWarehouse();
//					break;
//				case 13:
//					onGetAllProducts();
//					break;
//				case 14:
//					onGetAllProductsByName();
//					break;
//				case 15:
//					onGetProductById();
//					break;
//				case 16:
//					onInsertProduct();
//					break;
//				case 17:
//					onUpdateProduct();
//					break;
//				case 18:
//					onDeleteProduct();
//					break;
//				default:
//					System.out.println("No message!!!");
//					break;
//			}
//			renderEndUI();
//		}
//
//	}
//
//	private void renderEndUI(){
//		System.out.println("Press Enter to continue!!!");
//		scanner.nextLine();
//	}
//
//	private void renderUI(){
//		int t= 0;
//		System.out.println(t++ + ". Exit");
//		System.out.println("Category");
//		System.out.println(t++ + ". Get all categories");
//		System.out.println(t++ + ". Get all categories by name");
//		System.out.println(t++ + ". Get category by id");
//		System.out.println(t++ + ". Insert category");
//		System.out.println(t++ + ". Update category");
//		System.out.println(t++ + ". Delete category");
//		System.out.println("Warehouse");
//		System.out.println(t++ + ". Get all warehouses");
//		System.out.println(t++ + ". Get all warehouses by name");
//		System.out.println(t++ + ". Get warehouse by id");
//		System.out.println(t++ + ". Insert warehouse");
//		System.out.println(t++ + ". Update warehouse");
//		System.out.println(t++ + ". Delete warehouse");
//		System.out.println("Products");
//		System.out.println(t++ + ". Get all products");
//		System.out.println(t++ + ". Get all products by name");
//		System.out.println(t++ + ". Get product by id");
//		System.out.println(t++ + ". Insert product");
//		System.out.println(t++ + ". Update product");
//		System.out.println(t++ + ". Delete product");
//	}
//
//	private void renderMessageUI(int c){
//		switch (c){
//			case 0:
//				System.out.println("Exit");
//			case 1:
//				System.out.println("Get all categories");
//				break;
//			case 2:
//				System.out.println("Get all categories by name");
//				break;
//			case 3:
//				System.out.println("Get category by id");
//				break;
//			case 4:
//				System.out.println("Insert category");
//				break;
//			case 5:
//				System.out.println("Update category");
//				break;
//			case 6:
//				System.out.println("Delete category");
//				break;
//			case 7:
//				System.out.println("Get all warehouses");
//				break;
//			case 8:
//				System.out.println("Get all warehouses by name");
//				break;
//			case 9:
//				System.out.println("Get warehouse by id");
//				break;
//			case 10:
//				System.out.println("Insert warehouse");
//				break;
//			case 11:
//				System.out.println("Update warehouse");
//				break;
//			case 12:
//				System.out.println("Delete warehouse");
//				break;
//			case 13:
//				System.out.println("Get all products");
//				break;
//			case 14:
//				System.out.println("Get all products by name");
//				break;
//			case 15:
//				System.out.println("Get product by id");
//				break;
//			case 16:
//				System.out.println("Insert product");
//				break;
//			case 17:
//				System.out.println("Update product");
//				break;
//			case 18:
//				System.out.println("Delete product");
//				break;
//			default:
//				System.out.println("No message!!!");
//				break;
//		}
//	}
//
//	private void onGetAllCategories(){
//		categoryCommon.getAllCategories();
//	}
//
//	private void onGetAllCategoriesByName(){
//		categoryCommon.getAllCategoriesByName();
//	}
//
//	private void onInsertCategory(){
//		categoryCommon.insertCategory();
//	}
//
//	private void onGetCategoryById(){
//		categoryCommon.getCategoryById();
//	}
//
//	private void onUpdateCategory(){
//		categoryCommon.updateCategory();
//	}
//
//	private void onDeleteCategory(){
//		categoryCommon.deleteCategory();
//	}
//
//	private void onGetAllWarehouses(){
//		wareHouseCommon.getAllWarehouses();
//	}
//
//	private void onGetAllWarehousesByName(){
//		wareHouseCommon.getAllWarehousesByName();
//	}
//
//	private void onInsertWarehouse(){
//		wareHouseCommon.insertWarehouse();
//	}
//
//	private void onGetWarehouseById(){
//		wareHouseCommon.getWarehouseById();
//	}
//
//	private void onUpdateWarehouse(){
//		wareHouseCommon.updateWarehouse();
//	}
//
//	private void onDeleteWarehouse(){
//		wareHouseCommon.deleteWarehouse();
//	}
//
//	private void onGetAllProducts(){
//		productCommon.getAllProducts();
//	}
//
//	private void onGetAllProductsByName(){
//		productCommon.getAllProductsByName();
//	}
//
//	private void onInsertProduct(){
//		productCommon.insertProduct();
//	}
//
//	private void onGetProductById(){
//		productCommon.getProductById();
//	}
//
//	private void onUpdateProduct(){
//		productCommon.updateProduct();
//	}
//
//	private void onDeleteProduct(){
//		productCommon.deleteProduct();
//	}
//

}
