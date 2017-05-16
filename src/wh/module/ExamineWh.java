package wh.module;

import java.sql.SQLException;
import java.util.ArrayList;

import wh.DAO.fileDao;
import wh.VO.whManage;
//获取工时清单
public class ExamineWh {
	
	public ArrayList<whManage> getwhm() throws SQLException{
		fileDao dao=new fileDao();
		ArrayList<whManage> arr=null;
	
			arr=dao.getwhm();
			
		return arr;
		
	}
	/*public static void main(String[] args){
		
		try {
			//arr=null;
			ArrayList<whManage> arr=new ArrayList<whManage>();
			ExamineWh ew=new ExamineWh();
			if(ew.getwhm()!=null)
			arr.addAll(ew.getwhm());
			else
				
			System.out.println("getwhm null");
			
			for(whManage ww:arr){
			System.out.println("tecid"+ww.getTecid());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
