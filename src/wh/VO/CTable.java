package wh.VO;

import java.sql.Date;

public class CTable {
	private int idcount;
	private String tecid;
	private String tecnum;
	private int num;
	private float total;
	private String worksection;
	private Date date;
	private String tecname;
	public int getIdcount() {
		return idcount;
	}
	public void setIdcount(int idcount) {
		this.idcount = idcount;
	}
	public String getTecid() {
		return tecid;
	}
	public void setTecid(String tecid) {
		this.tecid = tecid;
	}
	public String getTecnum() {
		return tecnum;
	}
	public void setTecnum(String tecnum) {
		this.tecnum = tecnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getWorksection() {
		return worksection;
	}
	public void setWorksection(String worksection) {
		this.worksection = worksection;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTecname() {
		return tecname;
	}
	public void setTecname(String tecname) {
		this.tecname = tecname;
	}
}
