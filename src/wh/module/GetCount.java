package wh.module;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import wh.DAO.fileDao;
import wh.VO.CTable;
import wh.VO.user;

public class GetCount {
	
	private static StringBuffer sbdq;


	//ͨ����ʱ���������ڲ�ѯcount��
	public ArrayList<CTable> getcount(String ws,Date date1,Date date2) throws SQLException{
		fileDao dao=new fileDao();
		ArrayList<CTable> gt=null;
	
		gt = dao.getcount(ws,date1,date2);
	
		return gt;
		
	}
	
	
	
	/*public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String ws="2";
		
		//��������
		int iy=2017,im=05,id=07;
		//��������תString
		String sty=Integer.toString(iy);
		String sstm=Integer.toString(im);
		String sstd=Integer.toString(id);
		System.out.println("sty"+sty);
		System.out.println("stm"+sstm);
		System.out.println("std"+sstd);
		String stm=null;
		String std=null;
		if(im<10||id<10){
			stm="0"+sstm;
			std="0"+sstd;
		}	else{
			stm=sstm;
			std=sstd;
		}
		//��year month day����
		SimpleDateFormat dstr=new SimpleDateFormat("yyyy-MM-dd");
		
		//String תStringBuffer
		StringBuffer sbdy=new StringBuffer(sty);
		StringBuffer sbdm=new StringBuffer(stm);
		StringBuffer sbdd=new StringBuffer(std);
		System.out.println("sbdy"+sbdy);
		System.out.println("sbdm"+sbdm);
		System.out.println("sbdd"+sbdd);
		StringBuffer sbdq =new StringBuffer("");
		sbdq.append(sbdy);
		sbdq.append("-");
		sbdq.append(sbdm);
		sbdq.append("-");
		sbdq.append(sbdd);
		//StringBuffer ת String
		String d1=sbdq.toString();
		
		
		
		//String d1=sty+"-"+stm+"-"+std;
		System.out.println("dstr"+dstr);
		System.out.println("d1"+d1);
		//string תjava.util.date
		java.util.Date ud=dstr.parse(d1);
		System.out.println("util date"+ud);
		//java.util.date תjava.sql.date
		java.sql.Date sd;
		sd=new java.sql.Date(ud.getTime());
		System.out.println("sql date"+sd);
		
		
		
		//System.out.println(ds);
		ArrayList<CTable> c=new ArrayList<CTable>();
		GetCount gt=new GetCount();
		
		//System.out.println(ds);
		
		try {
			System.out.println(ws);
			c.addAll(gt.getcount(ws, sd, sd));
			System.out.println("c.addall");
			for(CTable cc:c){
				System.out.println("idcount"+cc.getIdcount());
				System.out.println("num"+cc.getNum());
				System.out.println("tecid"+cc.getTecid());
				System.out.println("tecname"+cc.getTecname());
				System.out.println("tecnum"+cc.getTecnum());
				System.out.println("total"+cc.getTotal());
				System.out.println("ws"+cc.getWorksection());
				System.out.println("date"+cc.getDate());
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/

}
