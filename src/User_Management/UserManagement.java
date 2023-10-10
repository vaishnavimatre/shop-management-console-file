package User_Management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagement {
	static ArrayList<User> al= new ArrayList();
	static
	{
		try {
			loaddatafromusermanagementtofile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					}
	

	public static void userManagement() throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("***Welcome to the UserManagement****");
		
	    boolean	canIKeepRunninngTheProgram =true;
		while(canIKeepRunninngTheProgram==true) {
			System.out.println("1.Add User");
			System.out.println("2.Delete User");
			System.out.println("3.edit User");
			System.out.println("4.Search User");
			System.out.println("5.Quit");
			
			int optionselectedbyuser=sc.nextInt();
			 if(optionselectedbyuser==UserOptions.Quit) {
				 File file=new File("\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\ShopManagement3\\src\\User_Management\\User.csv");
				 FileWriter filewriter=new FileWriter(file);
				BufferedWriter bufferwriter=new BufferedWriter(filewriter);
			for(User u1 :al) {
				bufferwriter.write(u1.userName+","+u1.LoginName+","+u1.Password+","+u1.Userrole+"\n");
		         System.out.println("!!!program end");
		         canIKeepRunninngTheProgram  = false;
		         filewriter.close();
					bufferwriter.close();
		         
			}
			
			}
			 
			 else if(optionselectedbyuser==UserOptions.add_User) {
					addUser();
			}
			else if(optionselectedbyuser==UserOptions.Delete_user) {
				System.out.println("Enter UserName to Delete:");
				sc.nextLine();
				String du=sc.nextLine();
				DeleteUser(du);
			}
			else if(optionselectedbyuser==UserOptions.Edit_User) {
				System.out.println("Enter UserName to edit:");
				sc.nextLine();
				String eu=sc.nextLine();
				editUser(eu);
				
			}else if(optionselectedbyuser==UserOptions.Search_user) {
				System.out.println("Enter UserName to Search:");
				sc.nextLine();
				String sp=sc.nextLine();
				SearchUser(sp);
								
		}
		
	}
		for(User u1:al)
			System.out.println(u1.userName);

}
	public static void addUser() {
		Scanner sc=new Scanner(System.in);
	     User u1=new User();
		
		System.out.println("Enter UserName:");
		u1.userName=sc.nextLine();
		
		System.out.println("Enter loginName:");
		u1.LoginName=sc.nextLine();
		
		System.out.println("Enter Password:");
		u1.Password=sc.nextLine();
		
		System.out.println("Enter ConfirmPassword:");
		u1.Confirm_password=sc.nextLine();
		
		System.out.println("Enter userRole:");
         u1.Userrole=sc.nextLine();	
         
         
		System.out.println("Enter ProductName:"+u1.userName);
		System.out.println("Enter ProductId:"+u1.LoginName);
		System.out.println("Enter Price:"+u1.Password);
		System.out.println("Enter Quality:"+u1.Confirm_password);
		System.out.println("Enter Category:"+u1.Userrole);
		
		al.add(u1);
	}
	public static void DeleteUser(String username)
    {
		Iterator<User>u1iterator=al.iterator();
		while(u1iterator.hasNext()) {
			User u1=u1iterator.next();	
			if(u1.userName.equalsIgnoreCase(username))
				{
				u1iterator.remove();
				System.out.println("user:"+ username+ " has been deleted");
				break;
				}
				}
		System.out.println("User not found");
		}
	public static void editUser(String username) {
		Scanner sc=new Scanner(System.in);
    for(User user:al) {
    	if(user.userName.equalsIgnoreCase(username))
		{
    		System.out.println("Enter new UserName:");
    		user.userName=sc.nextLine();
    		
    		System.out.println("Enter new loginName:");
    		user.LoginName=sc.nextLine();
    		
    		System.out.println("Enter new Password:");
    		user.Password=sc.nextLine();
    		
    		System.out.println("Enter new Confirm_password:");
    		user.Confirm_password=sc.nextLine();
    		
    		System.out.println("Enter new userRole:");
             user.Userrole=sc.nextLine();	
            
             System.out.println("Enter userName:"+user.userName);
     		System.out.println("Enter LoginName:"+user.LoginName);
     		System.out.println("Enter passwoed:"+user.Password);
     		System.out.println("Enter confirm_password:"+user.Confirm_password);
     		System.out.println("Enter  userRole:"+user.Userrole);
     		al.add(user);
		}
    	
}
    System.out.println("User not found");
	}
	public static void SearchUser(String Username) {
		for(User user:al) {
	    	if(user.userName.equalsIgnoreCase(Username)) {
	    		  System.out.println("Enter userName:"+user.userName);
	       		System.out.println("Enter LoginName:"+user.LoginName);
	       		System.out.println("Enter passwoed:"+user.Password);
	       		System.out.println("Enter confirm_password:"+user.Confirm_password);
	       		System.out.println("Enter  userRole:"+user.Userrole);
	       		
	    	}
	}
		System.out.println("User not found");	
}
	public static void loaddatafromusermanagementtofile() throws IOException	{
			File file=new File("\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\ShopManagement3\\src\\User_Management\\User.csv");
		
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String Line="";
		while((Line=br.readLine())!=null) {
		User user=new User();
			String[] UserDataArray=Line.split(",");
			if(UserDataArray.length>3) {
			   user.userName=UserDataArray[0];
			   user.LoginName=UserDataArray[1];
			   user.Password=UserDataArray[2];
			   user.Userrole=UserDataArray[3];
	al.add(user);
			}
			
		}
		fr.close();
		br.close();
		file=null;
		}
		
		
		
	
public static boolean validateloginnameandpassword(String loginname,String password) {
	Iterator <User>u1iterator=al.iterator();
	while(u1iterator.hasNext()) {
		User u1=u1iterator.next();
		if(u1.userName.equalsIgnoreCase(loginname) &&u1.Password.equalsIgnoreCase(password)) {
		return true;
			
		}
		}
	return false;
	}
}