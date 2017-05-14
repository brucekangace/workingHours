package wh.module;
import java.sql.SQLException;
import java.util.Scanner;

import wh.DAO.fileDao;
public class login {
	fileDao dao=new fileDao();
	public int loginwh(String logname,String pwd) throws SQLException {
		//返回0则不匹配，返回1则登陆成功且为管理员，返回2登陆成功且为用户
		int flag=0;
		flag=dao.login(logname,pwd);
		return flag;
	}
/*	public static void main(String[] args) {
		
		try {
			System.out.println("请输入账号");
			Scanner sc1=new Scanner(System.in);
			String logname=null;
			logname=sc1.nextLine();
			System.out.println("请输入密码");
			Scanner sc2= new Scanner(System.in);
			String pwd=null;
			pwd=sc2.nextLine();
			int log=0;
			login lg=new login();
			log=lg.loginwh(logname,pwd);
			if(log==0)
				System.out.println("密码与用户名不匹配");
			else if(log==1)
				System.out.println("你好管理员");
			else if(log==2)
				System.out.println("你好用户");
			else System.out.println("???");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
