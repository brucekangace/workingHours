package wh.module;
import java.sql.SQLException;
import java.util.Scanner;

import wh.DAO.fileDao;
public class login {
	fileDao dao=new fileDao();
	public int loginwh(String logname,String pwd) throws SQLException {
		//����0��ƥ�䣬����1���½�ɹ���Ϊ����Ա������2��½�ɹ���Ϊ�û�
		int flag=0;
		flag=dao.login(logname,pwd);
		return flag;
	}
/*	public static void main(String[] args) {
		
		try {
			System.out.println("�������˺�");
			Scanner sc1=new Scanner(System.in);
			String logname=null;
			logname=sc1.nextLine();
			System.out.println("����������");
			Scanner sc2= new Scanner(System.in);
			String pwd=null;
			pwd=sc2.nextLine();
			int log=0;
			login lg=new login();
			log=lg.loginwh(logname,pwd);
			if(log==0)
				System.out.println("�������û�����ƥ��");
			else if(log==1)
				System.out.println("��ù���Ա");
			else if(log==2)
				System.out.println("����û�");
			else System.out.println("???");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
