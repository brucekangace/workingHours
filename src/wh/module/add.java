package wh.module;

import java.sql.SQLException;
import wh.DAO.fileDao;

public class add {
	//��count��������ݣ���������ܹ�ʱ
	public boolean addcount(String tecid,String tecnum,int number,String workSection){
		boolean flag=false;
		fileDao dao=new fileDao();
		//�û����ӹ���ת�Ƶ�
		try {
			
			
			String tecname=dao.getName(tecid);
			float whquota=dao.getquota(tecid,tecnum);//����ͼ�š�����ţ���ȡ������еĵ�����ʱ
			
			
			float total=0;
			total=this.total(whquota, number);//���ݵõ��ܹ�ʱ
			
			
			
			flag=dao.add(tecid,tecnum,number, workSection,total, tecname);//���û���ʱ��������
			
			
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
		System.out.println("������ͼ��");
		Scanner sc1=new Scanner(System.in);
		String tecid=null;
		tecid=sc1.nextLine();
		
		System.out.println("�����빤���");
		Scanner sc2=new Scanner(System.in);
		String tecnum=null;
		tecnum=sc2.nextLine();
		
		System.out.println("����������");
		Scanner sc3=new Scanner(System.in);
		String num=null;
		num=sc3.nextLine();
		int number=0;
		try {
		    number = Integer.parseInt(num);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		System.out.println("�����빤��");
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
