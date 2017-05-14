package wh.DAO;
import wh.DAO.baseDao;
import wh.VO.CTable;
import wh.VO.user;
import wh.VO.whManage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class fileDao extends baseDao{
	public int login(String logname, String pwd) throws SQLException {
		/*
		 * 返回1	:admin管理员
			2：user普通用户
			3：都没有查到即登录失败
		 * */
		int flag=0;
		start();
		String sql="select * from login where (logname=? or idlogin=?) and pwd=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, logname);
		ps.setString(2, logname);
		ps.setString(3, pwd);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			user u=new user();
			u.setRole(rs.getString("role"));
			String getrole=u.getRole();
			if(getrole.equals("admin"))
				flag=1;
			else if(getrole.equals("user"))
				flag=2;
			else flag=0;
			
		}
		
		close();
		return flag;
	}

	public ArrayList<whManage> checkwhmanage(String tecid,String tecnum) throws SQLException {
		// 获取count表的信息
		ArrayList<whManage> list=new ArrayList<whManage>();
		start();
		String sql="select * from whmanage where tecid like ? and tecnum like ?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+tecid+"%");
		ps.setString(2, "%"+tecnum+"%");
		rs=ps.executeQuery();
		
		while(rs.next()){
			whManage wm=new whManage();
			wm.setIdwhmanage(rs.getInt("idwhmanage"));
			wm.setTecid(rs.getString("tecid"));
			wm.setTecname(rs.getString("tecname"));
			wm.setTecnum(rs.getString("tecnum"));
			wm.setWhquote(rs.getFloat("whquota"));
			list.add(wm);
			
			
		}
		
		close();
		return list;
	}

	public boolean add(String tecid, String tecnum, int number, String workSection,float total,String tecname) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		int idcount=0;
		idcount=this.getcount()+1;
		start();
		String sql="insert into count values(?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,idcount );
		ps.setString(2, tecid);
		ps.setString(3, tecnum);
		ps.setString(4, tecname);
		ps.setFloat(5, number);
		ps.setFloat(6, total);
		ps.setString(7, workSection);
		ps.setDate(8, new Date(System.currentTimeMillis()));
		int count=ps.executeUpdate();
		while(count!=0){
			flag=true;
		}
		close();
		return flag;
	}
	
	
	
	
	public int getcount() throws SQLException{
		int count=0;
		start();
		String sql="select count(*) from count";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			count=rs.getInt("count(*)");
		}
		close();
		return count;
	}
	
	
	
	public float getquota(String tecid, String tecnum) throws SQLException {
		// TODO Auto-generated method stub
		float whquota = 0;
		start();
		String sql="select whquota from whmanage where tecid=? and tecnum=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1,tecid);
		ps.setString(2, tecnum);
		rs=ps.executeQuery();
		while(rs.next()){
			whquota=rs.getFloat("whquota");
		}
		
		close();
		return whquota;
	}

	public String getName(String tecid) throws SQLException {
		// TODO Auto-generated method stub
		String name=null;
		start();
		String sql="select * from whmanage where tecid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1,tecid);
		rs=ps.executeQuery();
		while(rs.next()){
			name=rs.getString("tecname");
		}
		close();
		return name;
	}

	public ArrayList<CTable> getcount(String ws, Date date1,Date date2) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("dao.date d1"+date1+" d2"+date2);
		ArrayList<CTable> al=new ArrayList<CTable>();
		start();
		String sql="select * from count where worksection like ? and (date between ? and ?)";
		System.out.println("dao.ws"+ws);
		ps=conn.prepareStatement(sql);
		ps.setString(1, ws);
		ps.setDate(2, date1);
		ps.setDate(3, date2);
		rs=ps.executeQuery();
		while(rs.next()){
			CTable c=new CTable();
			c.setIdcount(rs.getInt("idcount"));
			c.setTecid(rs.getString("tecid"));
			c.setNum(rs.getInt("number"));
			c.setTotal(rs.getFloat("total"));
			c.setWorksection(rs.getString("worksection"));
			c.setDate(rs.getDate("date"));
			c.setTecname(rs.getString("tecname"));
			c.setTecnum(rs.getString("tecnum"));
			al.add(c);
			
		}
		close();
		return al;
	}
}
