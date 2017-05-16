package wh.GUI;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import wh.DAO.fileDao;
import wh.module.add;
//添加工时界面
public class WhaddUI {
	JFrame jf=new JFrame("添加工时");
	JPanel jp;
	JLabel jltid=new JLabel("工艺图号");
	JTextField jtftid=new JTextField();
	JLabel jltnum=new JLabel("工序");
	JTextField jtftnum=new JTextField();
	JLabel jlnum=new JLabel("数量");
	JTextField jtfnum=new JTextField();
	JLabel jlws=new JLabel("工段");
	Choice cws=new Choice();
	JButton jbadd=new JButton();
	String path = "./image/addwh.jpg"; 
	//获取登录窗口bg,大小位置
	ImageIcon icon = new ImageIcon(path);
	public WhaddUI(){
	jp=new JPanel(){
		protected void paintComponent(Graphics g) {

        	
        	 
			
            
			 Image img = icon.getImage();
           
            g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
            System.out.println("draw image size width:"+icon.getIconWidth()+"heigh"+icon.getIconHeight());
           
            
            
            int width=0,height=0;
            width=icon.getIconWidth();
            height=icon.getIconHeight();
            System.out.println("jdh:"+width+"heigh"+height);
            jf.setSize(width, height);
           
            jf.setLocationRelativeTo(null);
            
           
            
            }
    };	
    jp.setLayout(null);
    	int jlwidth=100,height=25,jtwidth=200;
    jltid.setFont(new Font("宋体",Font.BOLD,20));
    jltid.setForeground(Color.white);
    jltid.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6, jlwidth, height);
    	
    jtftid.setFont(new Font("宋体",Font.BOLD,20));
    jtftid.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+height, jtwidth, height);
    
    
    jltnum.setFont(new Font("宋体",Font.BOLD,20));
    jltnum.setForeground(Color.white);
    jltnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*2), jlwidth, height);
    
    jtftnum.setFont(new Font("宋体",Font.BOLD,20));
    jtftnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*3), jtwidth, height);
    
    jlnum.setFont(new Font("宋体",Font.BOLD,20));
    jlnum.setForeground(Color.white);
    jlnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*4), jlwidth, height);
    
    jtfnum.setFont(new Font("宋体",Font.BOLD,20));
    jtfnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*5), jtwidth, height);
    
    jlws.setFont(new Font("宋体",Font.BOLD,20));
    jlws.setForeground(Color.white);
    jlws.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*6), jlwidth, height);
    
    cws.setFont(new Font("宋体",Font.BOLD,20));
    cws.setBackground(Color.white);
	cws.setForeground(Color.black);
    cws.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*7), jtwidth, height);
    cws.add("1");
    cws.add("2");
    cws.add("3");
    cws.add("4");
    cws.add("5");
    cws.add("6");
    
    jbadd.setFont(new Font("宋体",Font.BOLD,20));
    jbadd.setText("添加");
    jbadd.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*9), jtwidth, height);
    System.out.println("Action");  
    
	
	
	String ws=cws.getSelectedItem();
	
	add ad=new add();
	boolean flag=false;
	/*jtftid.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String tid=jtftid.getText();
			try {
				if(notfind(tid)==true){
					JOptionPane.showMessageDialog(null,"图号有误","警告" , JOptionPane.INFORMATION_MESSAGE); 
					}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	
	
	jtftnum.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String tid=jtftid.getText();
			String tnum=jtftnum.getText();
			try {
				if(match(tid,tnum)!=true){
					
					JOptionPane.showMessageDialog(null, "图中没有此工序，请添加","警告" , JOptionPane.INFORMATION_MESSAGE);

				
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	
	jtfnum.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String snum=jtfnum.getText();
			int num=0;
			if(isNumeric(snum)!=true){
				JOptionPane.showMessageDialog(null, "请确数量是否正确", "警告", JOptionPane.INFORMATION_MESSAGE);
		
			}else{
				num=Integer.valueOf(snum);
			}
		}
		
	});
	
	

		
		
		
    jbadd.addActionListener(new ActionListener() {  
        
        public void actionPerformed(ActionEvent e) {  
        	String tid=jtftid.getText();
			String tnum=jtftnum.getText();	
        	String snum=jtfnum.getText();
        	int num=Integer.valueOf(snum);
    			ad.addcount(tid, tnum, num, ws); 
				//JOptionPane.showMessageDialog(null, "成功", "添加成功！", JOptionPane.INFORMATION_MESSAGE); 
				System.out.println("add 失败？-------------------------------"+flag);
			
        }  
    }); */ 
    jbadd.addActionListener(new ActionListener(){
    	//添加事件
		 public void actionPerformed(ActionEvent e){
				
					String tid=jtftid.getText();
					String tnum=jtftnum.getText();
					String snum=jtfnum.getText();
					String ws=cws.getSelectedItem();
					int num=0;
					add ad=new add();
					boolean flag=false;
					try {
						if(notfind(tid)==true){
							//在管理表中找不到输入的图号
						JOptionPane.showMessageDialog(null,"图号有误","警告" , JOptionPane.INFORMATION_MESSAGE); 
						}else if(match(tid,tnum)!=true){
							//图号中没有此工序
							JOptionPane.showMessageDialog(null, "图中没有此工序，请添加","警告" , JOptionPane.INFORMATION_MESSAGE);
						}else if(isNumeric(snum)==false){
							JOptionPane.showMessageDialog(null, "请输入数量","警告" , JOptionPane.INFORMATION_MESSAGE);
						}else if(isNumeric(snum)==true&&notfind(tid)==false&&match(tid,tnum)==true){
							//输入全部正确
							if(snum.equals("")){
								snum="0";
							}
								num=Integer.valueOf(snum);
							System.out.println("num+++++++++++"+num);
							flag=ad.addcount(tid, tnum, num, ws);
							String str="图号"+tid+"工序"+tnum+"数量"+snum+"工段"+ws;
							JOptionPane.showMessageDialog(null, str, "添加成功", JOptionPane.INFORMATION_MESSAGE); 
							jtftid.setText(null);
							jtftnum.setText(null);
							jtfnum.setText(null);
							
							
						}else {
							JOptionPane.showMessageDialog(null, "请核对输入数据", "警告", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
    });

		
		
    	
    
    	jp.add(jltid);
    	jp.add(jtftid);
    	jp.add(jltnum);
    	jp.add(jtftnum);
    	jp.add(jlnum);
    	jp.add(jtfnum);
    	jp.add(jlws);
    	jp.add(cws);
    	jp.add(jbadd);
		jf.add(jp);
		jf.setVisible(true);
        jf.setResizable(false);
       // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    
	}
	
	
	protected boolean match(String tid, String tnum) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		fileDao dao=new fileDao();
		flag=dao.match(tid,tnum);
		return flag;
	}


	protected boolean notfind(String tid) throws SQLException {
		// TODO Auto-generated method stub
		fileDao dao=new fileDao();
		boolean flag=true;
		flag=dao.notfind(tid);
		return flag;
	}


	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
	
	
	/*public static void main(String[] args){
		new WhaddUI();
	}*/
}
