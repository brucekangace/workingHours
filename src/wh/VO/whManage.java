package wh.VO;

public class whManage {
	private int idwhmanage;//计数
	private String tecid;//工艺图号
	private String tecnum;//工序号
	private String tecname;//工件名称
	private float whquote;//单件工时
	public int getIdwhmanage() {
		return idwhmanage;
	}
	public void setIdwhmanage(int idwhmanage) {
		this.idwhmanage = idwhmanage;
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
	public String getTecname() {
		return tecname;
	}
	public void setTecname(String tecname) {
		this.tecname = tecname;
	}
	public float getWhquote() {
		return whquote;
	}
	public void setWhquote(float whquote) {
		this.whquote = whquote;
	}
}
