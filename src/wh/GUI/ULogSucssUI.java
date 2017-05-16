package wh.GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.*;
import wh.module.login;

public class ULogSucssUI {
	JFrame jf=new JFrame("菜单");
	private FlowLayout fl=new FlowLayout();
	JButton jbadd=new JButton("添加工时");//添加工时
	JButton jblist=new JButton("查看工时清单");//查看工时清单
	JButton jbs=new JButton("查看工时统计");//查询工时
	String path = "./image/menu.jpg"; 
	//获取登录窗口bg,大小位置
	ImageIcon icon = new ImageIcon(path);
	
	public static JPanel jp;
	
    
    private class jbaddHandler implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			
 			
 			
 			try {
 				WhaddUI whadd=new WhaddUI();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
 	}
    
    
    private class jblistHandler implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			
 			
 			
 			try {
 				ExamineWhUI exam=new ExamineWhUI();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
 	}
    
    
    private class jbsHandler implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			
 			
 			
 			try {
 				UserUI uui=new UserUI();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
 	}
    
    public ULogSucssUI(){
    	
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
    	 jbadd.setBounds(icon.getIconWidth()/2-110, icon.getIconHeight()/5, 220, 45);
    	 jbadd.setFont(new Font("宋体",Font.BOLD,20));
         jbadd.addActionListener(new jbaddHandler());
    	
         jblist.setBounds(icon.getIconWidth()/2-110, icon.getIconHeight()/5+100, 220, 45);
    	 jblist.setFont(new Font("宋体",Font.BOLD,20));
         jblist.addActionListener(new jblistHandler());
    	
         jbs.setBounds(icon.getIconWidth()/2-110, icon.getIconHeight()/5+200, 220, 45);
    	 jbs.setFont(new Font("宋体",Font.BOLD,20));
         jbs.addActionListener(new jbsHandler());
    	
         jp.add(jbadd);
         jp.add(jblist);
         jp.add(jbs);
         
    	jf.add(jp);
    	jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ULogSucssUI();
	}*/

}
