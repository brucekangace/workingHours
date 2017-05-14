package wh.module;

import java.sql.SQLException;
import wh.DAO.fileDao;

public class add {
	//往count表添加数据，并计算出总工时
	public boolean addcount(String tecid,String tecnum,int number,String workSection){
		boolean flag=false;
		fileDao dao=new fileDao();
		//用户增加工序转移单
		try {
			
			
			String tecname=dao.getName(tecid);
			float whquota=dao.getquota(tecid,tecnum);//根据图号、工序号，获取定额表中的单个工时
			
			
			float total=0;
			total=this.total(whquota, number);//根据得到总工时
			
			
			
			flag=dao.add(tecid,tecnum,number, workSection,total, tecname);//往用户工时单增加项
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	
	public float total(float whquota,float number){
		float totalquota=0;
		 totalquota=whquota*number;
		return totalquota;
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		add ad=new add();
		System.out.println("请输入图号");
		Scanner sc1=new Scanner(System.in);
		String tecid=null;
		tecid=sc1.nextLine();
		
		System.out.println("请输入工序号");
		Scanner sc2=new Scanner(System.in);
		String tecnum=null;
		tecnum=sc2.nextLine();
		
		System.out.println("请输入数量");
		Scanner sc3=new Scanner(System.in);
		String num=null;
		num=sc3.nextLine();
		int number=0;
		try {
		    number = Integer.parseInt(num);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		System.out.println("请输入工段");
		Scanner sc4=new Scanner(System.in);
		String workSection=null;
		workSection=sc4.nextLine();
		
		ad.addcount(tecid, tecnum, number, workSection);
		
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		System.out.println("add seccess");
		
	}*/

}
