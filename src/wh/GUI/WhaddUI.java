package wh.GUI;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhaddUI {
	JFrame jf=new JFrame("��ӹ�ʱ");
	JPanel jp;
	JLabel jltid=new JLabel("����ͼ��");
	JTextField jtftid=new JTextField();
	JLabel jltnum=new JLabel("����");
	JTextField jtftnum=new JTextField();
	JLabel jlnum=new JLabel("����");
	JTextField jtfnum=new JTextField();
	JLabel jlws=new JLabel("����");
	Choice cws=new Choice();
	JButton jbadd=new JButton();
	String path = "./image/addwh.jpg"; 
	//��ȡ��¼����bg,��Сλ��
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
    jltid.setFont(new Font("����",Font.BOLD,20));
    jltid.setForeground(Color.white);
    jltid.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6, jlwidth, height);
    	
    jtftid.setFont(new Font("����",Font.BOLD,20));
    jtftid.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+height, jtwidth, height);
    
    
    jltnum.setFont(new Font("����",Font.BOLD,20));
    jltnum.setForeground(Color.white);
    jltnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*2), jlwidth, height);
    
    jtftnum.setFont(new Font("����",Font.BOLD,20));
    jtftnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*3), jtwidth, height);
    
    jlnum.setFont(new Font("����",Font.BOLD,20));
    jlnum.setForeground(Color.white);
    jlnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*4), jlwidth, height);
    
    jtfnum.setFont(new Font("����",Font.BOLD,20));
    jtfnum.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*5), jtwidth, height);
    
    jlws.setFont(new Font("����",Font.BOLD,20));
    jlws.setForeground(Color.white);
    jlws.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*6), jlwidth, height);
    
    cws.setFont(new Font("����",Font.BOLD,20));
    cws.setBackground(Color.white);
	cws.setForeground(Color.black);
    cws.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*7), jtwidth, height);
    cws.add("1");
    cws.add("2");
    cws.add("3");
    cws.add("4");
    cws.add("5");
    cws.add("6");
    
    jbadd.setFont(new Font("����",Font.BOLD,20));
    jbadd.setText("���");
    jbadd.setBounds(icon.getIconWidth()/2, icon.getIconHeight()/6+(height*9), jtwidth, height);
    jbadd.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//����¼�
			String tid=jtftid.getText();
			String tnum=jtftnum.getText();
			String snum=jtfnum.getText();
			String ws=cws.getSelectedItem();
			JOptionPane.showMessageDialog(null, ws, "alert", JOptionPane.ERROR_MESSAGE); 
			
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
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    
	}
	public static void main(String[] args){
		new WhaddUI();
	}
}
