package Product_Management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement {
	static ArrayList<Product> al= new ArrayList();
	public static void productMnagement() throws IOException {
		loaddatafromproductmanagementtofile();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to the ProductManagement:");
		
	    boolean	canIKeepRunninngTheProgram =true;
		while(canIKeepRunninngTheProgram==true) {
			System.out.println("1.Add Product");
			System.out.println("2.Delete Product");
			System.out.println("3.edit Product");
			System.out.println("4.Search Product");
			System.out.println("5.Quit");
			
			int optionselectedbyuser=sc.nextInt();
			 if(optionselectedbyuser==ProductOptions.Quit) {
				 File file=new File("\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\ShopManagement3\\src\\Product_management\\Product.csv");
				 FileWriter filewriter=new FileWriter(file);
				BufferedWriter bufferwriter=new BufferedWriter(filewriter);
			for(Product p1 :al) {
				bufferwriter.write(p1.ProductName+","+p1.ProductId+","+p1.Price+","+p1.Category+","+p1.Category+"\n");
		         System.out.println("!!!program end");
		         canIKeepRunninngTheProgram  = false;
		         filewriter.close();
					bufferwriter.close();
		         
			}
			
			}
			 
			 else if(optionselectedbyuser==ProductOptions.Add_Product) {
					addProduct();
			}
			else if(optionselectedbyuser==ProductOptions.Delete_Product) {
				System.out.println("Enter ProductName to Delete:");
				sc.nextLine();
				String dp=sc.nextLine();
				DeleteProduct(dp);
			}
			else if(optionselectedbyuser==ProductOptions.edit_Product) {
				System.out.println("Enter ProductName to edit:");
				sc.nextLine();
				String ep=sc.nextLine();
				editProduct(ep);
				
			}else if(optionselectedbyuser==ProductOptions.Search_product) {
				System.out.println("Enter ProductName to Search:");
				sc.nextLine();
				String sp=sc.nextLine();
				SearchProduct(sp);
								
		}
		
	}
		for(Product p1:al)
			System.out.println(p1.ProductName);

}
	public static void addProduct() {
		Scanner sc=new Scanner(System.in);
		Product p1=new Product();
		
		System.out.println("Enter ProductName:");
		p1.ProductName=sc.nextLine();
		
		System.out.println("Enter ProductId:");
		p1.ProductId=sc.nextLine();
		
		System.out.println("Enter Price:");
		p1.Price=sc.nextLine();
		
		System.out.println("Enter Quality:");
		p1.Quality=sc.nextLine();
		
		System.out.println("Enter Category:");
         p1.Category=sc.nextLine();	
         
         
		System.out.println("Enter ProductName:"+p1.ProductName);
		System.out.println("Enter ProductId:"+p1.ProductId);
		System.out.println("Enter Price:"+p1.Price);
		System.out.println("Enter Quality:"+p1.Quality);
		System.out.println("Enter Category:"+p1.Category);
		
		al.add(p1);
	}
	public static void DeleteProduct(String productname)
    {
		Iterator<Product>p1iterator=al.iterator();
		while(p1iterator.hasNext()) {
			Product p1=p1iterator.next();	
			if(p1.ProductName.equalsIgnoreCase(productname))
				{
				p1iterator.remove();
				System.out.println("ProductName:"+productname+"has been deleted");
				break;
				}
				}
		System.out.println("Product not found");
		}
	public static void editProduct(String productname) {
		Scanner sc=new Scanner(System.in);
    for(Product product:al) {
    	if(product.ProductName.equalsIgnoreCase(productname))
		{
    		System.out.println("Enter new ProductName:");
    		product.ProductName=sc.nextLine();
    		
    		System.out.println("Enter new ProductId:");
    		product.ProductId=sc.nextLine();
    		
    		System.out.println("Enter new Price:");
    		product.Price=sc.nextLine();
    		
    		System.out.println("Enter new Quality:");
    		product.Quality=sc.nextLine();
    		
    		System.out.println("Enter new Category:");
             product.Category=sc.nextLine();	
            
             System.out.println("Enter new ProductName:"+product.ProductName);
     		System.out.println("Enter new ProductId:"+product.ProductId);
     		System.out.println("Enter new Price:"+product.Price);
     		System.out.println("Enter  new Quality:"+product.Quality);
     		System.out.println("Enter  new Category:"+product.Category);
     		al.add(product);
		}
    	
}
    System.out.println("Product not found");
	}
	public static void SearchProduct(String productname) {
		for(Product product:al) {
	    	if(product.ProductName.equalsIgnoreCase(productname)) {
	    		 System.out.println("Enter ProductName:"+product.ProductName);
	      		System.out.println("Enter ProductId:"+product.ProductId);
	      		System.out.println("Enter Price:"+product.Price);
	      		System.out.println("Enter Quality:"+product.Quality);
	      		System.out.println("Enter Category:"+product.Category);
	    	}
	}
		System.out.println("Product not found");	
}
	public static void loaddatafromproductmanagementtofile() throws IOException 	{
		File file=new File("\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\ShopManagement3\\src\\Product_management\\Product.csv");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line=br.readLine())!=null) {
			Product product = new Product();
			String[] productDataArray=Line.split(",");
			if(productDataArray.length>4) {
				product.ProductName=productDataArray[0];
				product.ProductId=productDataArray[1];
				product.Price=productDataArray[2];
				product.Category=productDataArray[3];
				product.Quality=productDataArray[4];
al.add(product);
			}
			
		}
	}
	}
