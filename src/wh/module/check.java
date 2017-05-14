package wh.module;

import java.sql.SQLException;
import java.util.ArrayList;
import wh.DAO.fileDao;
import wh.VO.*;
public class check {
	fileDao dao=new fileDao();
	public ArrayList<whManage> checkwhmanage(String tecid,String tecnum) throws SQLException{
		
		ArrayList<whManage> list=new ArrayList<whManage>();
		list=dao.checkwhmanage(tecid, tecnum);
		return list;
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("«Î ‰»ÎÕº∫≈");
			Scanner sc1=new Scanner(System.in);
			String tecid=null;
			tecid=sc1.nextLine();
			
			System.out.println("«Î ‰»Îπ§–Ú");
			Scanner sc2=new Scanner(System.in);
			String tecnum=null;
			tecnum=sc1.nextLine();
			
			check c=new check();
			
			ArrayList<whManage> wh=new ArrayList<whManage>();
			c.checkwhmanage(tecid, tecnum);
			wh.addAll(c.checkwhmanage(tecid, tecnum));
			//System.out.println(c.checkwhmanage(tecid, tecnum));
			for(whManage w:wh){
					System.out.println();
		            System.out.print(w.getIdwhmanage());
		            System.out.print(w.getTecid());
		            System.out.print(w.getTecname());
		            System.out.print(w.getTecnum());
		           
		        }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}




















