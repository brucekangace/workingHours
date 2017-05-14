package wh.GUI;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import wh.module.login;

public class DrawImage { 
	JFrame jframe;
	JButton bt=new JButton();
	JTextField jlog=new JTextField();
	JPasswordField jpwd=new JPasswordField();
	String username=null;
	String pwd=null;
	
	public static JPanel imgPanel;
	
	public DrawImage(){ 
		initFrame();
	}
	//button �����¼�
	private class btHandler implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			
 			
 			
 			try {
 				username=jlog.getText();
 	 			pwd=String.valueOf(jpwd.getPassword());
 	 			login lg=new login();
 	 			int log=0;
 				log=lg.loginwh(username, pwd);
				if(log==0)
					JOptionPane.showMessageDialog(jframe,"�������û�����ƥ��");
					else if(log==1)
						JOptionPane.showMessageDialog(jframe,"����Ա���");
						else if(log==2)
							JOptionPane.showMessageDialog(jframe,"�û����");
							else
								JOptionPane.showMessageDialog(jframe,"δ֪����");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
 	}
	
	
	//frame 
	private void initFrame() {
		// TODO Auto-generated method stub
		// ����JPanel��ӱ���ͼƬ
        jframe = new JFrame();

        imgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {

            	//��ȡ��¼����bg,��Сλ��
            	String path = "./image/��¼.jpg";  
                ImageIcon icon = new ImageIcon(path);
                
                
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
                System.out.println("draw image size width:"+icon.getIconWidth()+"heigh"+icon.getIconHeight());
               
                
                
                int width=0,height=0;
                width=icon.getIconWidth();
                height=icon.getIconHeight();
                System.out.println("jdh:"+width+"heigh"+height);
                jframe.setSize(width, height);
                
                jframe.setLocationRelativeTo(null);
                
               
                
                }
        };
        //button ��ʽ
        
        ImageIcon btimg=new ImageIcon("./image/��¼bt1.png");
        bt.setBounds(330, 395, 220, 45);
        bt.setIcon(btimg);
        bt.addActionListener(new btHandler());
        //�������ʽ
        
       jlog.setBounds(260, 265, 380, 45);
       jlog.setFont(new Font("����",Font.PLAIN,28));
        
        jpwd.setBounds(260, 335, 380, 45);
        jpwd.setFont(new Font("����",Font.PLAIN,28));
        imgPanel.setLayout(null);
        
       
       
        imgPanel.add(bt);
        imgPanel.add(jlog);
        imgPanel.add(jpwd);
        
        jframe.add(imgPanel);
        jframe.setContentPane(imgPanel);
        jframe.setTitle("��¼");
        
       
       
        jframe.pack();
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
       
        
        
        
       
	}
	
	
	 	
	
	/*public static void main(String[] args){
		
		new DrawImage();
		
	}*/
}
