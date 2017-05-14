package wh.VO;

public class user {
	private int idlog;
	private String logname;
	private String pwd;
	private String role;//½ÇÉ«admin/user
	public int getIdlog() {
		return idlog;
	}
	public void setIdlog(int idlog) {
		this.idlog = idlog;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
