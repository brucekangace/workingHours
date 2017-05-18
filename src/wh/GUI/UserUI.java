package wh.GUI;
//查询统计界面，通过工段与日期查询
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import wh.VO.CTable;
import wh.module.ExcelExporter;
import wh.module.GetCount;

public class UserUI extends JFrame{
	 JFrame jframe;
	 JPanel jpanel;
	 JPanel jpanel2;
	 JLabel la1=new JLabel("工段");
	 JLabel ladate=new JLabel("日期");
	 JLabel la2=new JLabel("年");
	 JLabel la3=new JLabel("月");
	 JLabel la4=new JLabel("日");
	 JLabel laline=new JLabel("--");
	 JLabel la2y=new JLabel("年");
	 JLabel la2m=new JLabel("月");
	 JLabel la2d=new JLabel("日");
	 JLabel ja=new JLabel("总计：");
	 JButton expt=new JButton("导出为Excel");
	private Choice wsc=new Choice();
	private Choice date1y=new Choice();
	private Choice date1m=new Choice();
	private Choice date1d=new Choice();
	
	private Choice date2y=new Choice();
	private Choice date2m=new Choice();
	private Choice date2d=new Choice();
	private JButton sButton=new JButton("搜索"); 
	
	JTable jt=new JTable();
	JScrollPane jsp=new JScrollPane(jt);
	 Vector v=new Vector();
	 String[] columnNames={"ID","图号","工序","名称","数量","总计","工段","日期"};
	public UserUI() throws ParseException{
		jframe =new JFrame();
		jpanel=new JPanel();
		jpanel2=new JPanel();
		
		la1.setBounds(50, 27, 50, 25);
		la1.setFont(new Font("宋体",Font.BOLD,20));
		
		int x=100;
		wsc.setBounds(x,25,70,25);
		wsc.setFont(new Font("宋体",Font.BOLD,20));
		wsc.setBackground(Color.white);
		wsc.setForeground(Color.black);
		wsc.add("全部");
		wsc.add("1");
		wsc.add("2");
		wsc.add("3");
		wsc.add("4");
		wsc.add("5");
		wsc.add("6");
		
		ladate.setBounds(x+67,28,45,25);
		ladate.setFont(new Font("宋体",Font.BOLD,20));
		date1y.setBounds(x+113, 25, 100, 25);
		date1y.setFont(new Font("宋体",Font.BOLD,20));
		date1y.setBackground(Color.white);
		date1y.setForeground(Color.black);
		
		la2.setBounds(x+213, 28, 30, 25);
		la2.setFont(new Font("宋体",Font.BOLD,20));
		
		date1m.setBounds(x+250,25,50,20);
		//date1m.setSize(200,25);
		date1m.setFont(new Font("宋体",Font.BOLD,20));
		date1m.setBackground(Color.white);
		date1m.setForeground(Color.black);
		
		la3.setBounds(x+310, 28, 30, 25);
		la3.setFont(new Font("宋体",Font.BOLD,20));
		//date1d.setSize(200, 25);
		date1d.setBounds(x+350,25,60,25);
		date1d.setFont(new Font("宋体",Font.BOLD,20));
		date1d.setBackground(Color.white);
		date1d.setForeground(Color.black);
		
		la4.setBounds(x+420, 28, 50, 25);
		la4.setFont(new Font("宋体",Font.BOLD,20));
		Calendar c=Calendar.getInstance();
		/*int year =c.get(Calendar.YEAR);
		int mon=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DATE);*/
		
		laline.setBounds(x+470, 28, 40, 25);
		laline.setFont(new Font("宋体",Font.BOLD,20));
		
		date2y.setBounds(x+510, 25, 100, 25);
		date2y.setFont(new Font("宋体",Font.BOLD,20));
		date2y.setBackground(Color.white);
		date2y.setForeground(Color.black);
		la2y.setBounds(x+615, 28, 30, 25);
		la2y.setFont(new Font("宋体",Font.BOLD,20));
		
		date2m.setBounds(x+660,25,60,25);
		date2m.setFont(new Font("宋体",Font.BOLD,20));
		date2m.setBackground(Color.white);
		date2m.setForeground(Color.black);
		la2m.setBounds(x+730, 28, 30, 25);
		la2m.setFont(new Font("宋体",Font.BOLD,20));
		
		date2d.setBounds(x+770,25,60,25);
		date2d.setFont(new Font("宋体",Font.BOLD,20));
		date2d.setBackground(Color.white);
		date2d.setForeground(Color.black);
		
		la4.setBounds(x+840, 28, 50, 25);
		la4.setFont(new Font("宋体",Font.BOLD,20));
		
		sButton.setBounds(x+900, 15, 100, 50);
		sButton.setFont(new Font("宋体",Font.BOLD,20));
		sButton.setBackground(Color.white);
		
		ja.setBounds(x+1080, 15, 300, 50);
		ja.setFont(new Font("宋体",Font.BOLD,20));
		
		expt.setBounds(x+1280, 15, 150, 50);
		expt.setBackground(Color.white);
		/*
		JTableHeader header=jt.getTableHeader();
		header.setFont(new Font("宋体",Font.BOLD,20));
		jsp.setViewportView(jt);*/
		for(int i=1949;i<=3000;i++){
			
			date1y.add(String.valueOf(i));
			date2y.add(String.valueOf(i));
		}
		
		
	
		for(int i=1;i<=12;i++){
			date1m.add(String.valueOf(i));
			date2m.add(String.valueOf(i));
		}
		
		for(int i=1;i<=31;i++){
			date1d.add(String.valueOf(i));
			date2d.add(String.valueOf(i));
		}
		
		date1m.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
					
			}
			
		});
		
		expt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				  
                 try {
                	 ExcelExporter exp = new ExcelExporter(); 
					exp.exportTable(jt, new File("results.xls"));
					JOptionPane.showMessageDialog(null,"导出成功","通知" , JOptionPane.INFORMATION_MESSAGE); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
			
		});
		
		sButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					String swh=null;
					
					String sd1y="2017";
					String sd1m="1";
					String sd1d="1";
					String sd2y="2017";
					String sd2m="1";
					String sd2d="1";
					swh=wsc.getSelectedItem();
					if(swh.equals("全部")){
						swh="%%";
					}
					sd1y=date1y.getSelectedItem();
					sd1m=date1m.getSelectedItem();
					sd1d=date1d.getSelectedItem();
					sd2y=date2y.getSelectedItem();
					sd2m=date2m.getSelectedItem();
					sd2d=date2d.getSelectedItem();
					
					int im1=0,id1=0;
					im1=Integer.parseInt(sd1m);
					id1=Integer.parseInt(sd1d);
					if(im1<10)
						sd1m="0"+sd1m;
					if(id1<10)
						sd1d="0"+sd1d;
					
					
					int  im2=0,id2=0;
					im2=Integer.parseInt(sd2m);
					id2=Integer.parseInt(sd2d);
					if(im2<10)
						sd2m="0"+sd2m;
					if(id2<10)
						sd2d="0"+sd2d;
					//将year month day连接
					String d1=sd1y+"-"+sd1m+"-"+sd1d;
					String d2=sd2y+"-"+sd2m+"-"+sd2d;
					SimpleDateFormat dstr=new SimpleDateFormat("yyyy-MM-dd");
					
					//string 转java.util.date
					java.util.Date ud1=dstr.parse(d1);
					java.util.Date ud2=dstr.parse(d2);
					//java.util.date 转java.sql.date
					java.sql.Date sd1,sd2;
					sd1=new java.sql.Date(ud1.getTime());
					sd2=new java.sql.Date(ud2.getTime());
					
					 
					 
					//DefaultTableModel model = new DefaultTableModel(content,columnNames);
					DefaultTableModel dtm = (DefaultTableModel)jt.getModel();
					 dtm.setColumnIdentifiers(columnNames);
					
					ArrayList<CTable> ct=new ArrayList<CTable>();
					GetCount gt=new GetCount();
					//v.clear();
					v.removeAllElements();
					dtm.setRowCount(0);
					//dtm.fireTableDataChanged() ;
					
					ct.addAll(gt.getcount(swh, sd1, sd2));
					System.out.println("ct size "+ct.size());
					Object[][] ooc; 
					
					float alltotal=0;
						
						for(CTable cc:ct){
							
							alltotal+=cc.getTotal();
							Object[] oc=null;
							String idc=null;
							String tecnum=null;
							String tecid=null;
							String tecname=null;
							String num=null;
							String total=null;
							String ws=null;
							String d;
							
							idc=Integer.toString(cc.getIdcount());
							tecnum=cc.getTecnum();
							tecid=cc.getTecid();
							tecname=cc.getTecname();
							num=Integer.toString(cc.getNum());
							total=String.valueOf(cc.getTotal());
							ws=cc.getWorksection();
							d=String.valueOf(cc.getDate());
							System.out.println("dtm "+dtm.getColumnCount());
							System.out.println("idcount"+cc.getIdcount());
							System.out.println("num"+cc.getNum());
							System.out.println("tecid"+cc.getTecid());
							System.out.println("tecname"+cc.getTecname());
							System.out.println("tecnum"+cc.getTecnum());
							System.out.println("total"+cc.getTotal());
							System.out.println("ws"+cc.getWorksection());
							System.out.println("date"+cc.getDate());
							System.out.println("-----------------------------");
							String[] row={idc,tecid,tecnum,tecname,num,total,ws,d};
							dtm.addRow(row);
							
						}
						String jall=String.valueOf(alltotal);
						ja.setText("总计："+jall);
						System.out.println("总计 "+alltotal);
						/*v.add(cct.getIdcount());
						v.add(cct.getTecnum());
						v.add(cct.getTecid());
						v.add(cct.getTecname());
						v.add(cct.getNum());
						v.add(cct.getTotal());
						v.add(cct.getWorksection());
						v.add(cct.getDate());*/
						/*System.out.println("vector "+v.get(0));
						System.out.println("dtm "+dtm.getColumnCount());
						System.out.println("idcount"+cct.getIdcount());
						System.out.println("num"+cct.getNum());
						System.out.println("tecid"+cct.getTecid());
						System.out.println("tecname"+cct.getTecname());
						System.out.println("tecnum"+cct.getTecnum());
						System.out.println("total"+cct.getTotal());
						System.out.println("ws"+cct.getWorksection());
						System.out.println("date"+cct.getDate());
						System.out.println("-----------------------------");
					}*/
				/*	for(CTable cc:ct){
						 
						int idc=0;
						String tecnum=null;
						String tecid=null;
						String tecname=null;
						int num=0;
						float total=0;
						String ws=null;
						Date d;
						Object[] oc = null;
						
						idc=cc.getIdcount();
						tecnum=cc.getTecnum();
						tecid=cc.getTecid();
						tecname=cc.getTecname();
						num=cc.getNum();
						total=cc.getTotal();
						ws=cc.getWorksection();
						d=cc.getDate();
						
						
							oc[0]=idc;
							oc[1]=tecnum;
							oc[2]=tecid;
							oc[3]=tecname;
							oc[4]=num;
							oc[5]=total;
							oc[6]=ws;
							oc[7]=d;
							
							
						
						v.add(cc.getIdcount());
						v.add(cc.getTecnum());
						v.add(cc.getTecid());
						v.add(cc.getTecname());
						v.add(cc.getNum());
						v.add(cc.getTotal());
						v.add(cc.getWorksection());
						v.add(cc.getDate());
						
						v.add(idc);
						v.add(tecnum);
						v.add(tecid);
						v.add(tecname);
						v.add(num);
						v.add(total);
						v.add(ws);
						v.add(d);
						//v.add(ct);
						//System.out.println("vector "+v.get(0));
						System.out.println("dtm "+dtm.getColumnCount());
						System.out.println("idcount"+cc.getIdcount());
						System.out.println("num"+cc.getNum());
						System.out.println("tecid"+cc.getTecid());
						System.out.println("tecname"+cc.getTecname());
						System.out.println("tecnum"+cc.getTecnum());
						System.out.println("total"+cc.getTotal());
						System.out.println("ws"+cc.getWorksection());
						System.out.println("date"+cc.getDate());
						System.out.println("-----------------------------");
						//v.clear();
						dtm.addRow(v);
						//v.removeAllElements();
						//v.clear();
					}*/
					
					System.out.println("jt "+jt.getSize());
					//jsp.add(jt);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			
		});
		
		
		
		
		
		
		
		
		
		
		Dimension sSize=Toolkit.getDefaultToolkit().getScreenSize();
		int jpwidth=0;
		jpwidth=(int) sSize.getWidth()-100;
		int jp2H=(int) sSize.getHeight()-150;
		
		jpanel.setLayout(null);
		jpanel.add(la1);
		jpanel.add(wsc);
		jpanel.add(ladate);
		jpanel.add(date1y);
		jpanel.add(la2);
		jpanel.add(date1m);
		jpanel.add(la3);
		jpanel.add(date1d);
		jpanel.add(la4);
		jpanel.add(laline);
		jpanel.add(date2y);
		jpanel.add(la2y);
		jpanel.add(date2m);
		jpanel.add(la2m);
		jpanel.add(date2d);
		jpanel.add(la2d);
		jpanel.add(sButton);
		jpanel.add(ja);
		jpanel.add(expt);
		jpanel.setBorder(new LineBorder(Color.black));
		 jpanel.setPreferredSize(new Dimension(jpwidth, 75));
		 
		 jsp.setBounds(10, 10, jpwidth-20, jp2H-20);
		 jt.setFont(new Font("宋体",Font.BOLD,20));
		 jt.setRowHeight(55);
		 jt.setBorder(new LineBorder(Color.blue));
		//jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		 //jsp.add(jt);
		 jpanel2.add(jsp);
		 jpanel2.setPreferredSize(new Dimension(jpwidth, jp2H));
		 jpanel2.setLayout(null);
		 jpanel2.setBorder(new LineBorder(Color.black));
		 
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(jpanel2,BorderLayout.SOUTH);
		// jframe.setBackground(Color.black);    
		jframe.getContentPane().setBackground(new Color(0,88,122)); 
		jframe.getContentPane().setVisible(true  );
		jframe.setVisible(true);
		jframe.setLayout(new FlowLayout());
		//jframe.setUndecorated(false);
		
		Rectangle bounds=new Rectangle(sSize);
		jpanel.setBounds(bounds);
		jframe.setBounds(bounds);
		//jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*la1.setText("工段选择:");
		la2.setText("前置日期:");
		la3.setText("后置日期:");*/
		//jpanel.add(la1);
		//jpanel.setLayout(null);
		
		
	}
	
	

	
	public static void main(String[] args){
		try {
			new UserUI();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
