package wh.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import wh.VO.whManage;
import wh.module.ExamineWh;

public class ExamineWhUI {

	JFrame jf=new JFrame();
	JPanel jp=new JPanel();
	JTable jt=new JTable();
	JScrollPane jsp=new JScrollPane(jt);
	JLabel jl=new JLabel("²éÕÒ");
	JButton jb=new JButton("ËÑË÷");
	public ExamineWhUI() throws SQLException{
	String[] columnNames={"Í¼ºÅ","Ãû³Æ","¹¤ÐòºÅ","¹¤Ê±"};
	DefaultTableModel dtm = (DefaultTableModel)jt.getModel();
	 dtm.setColumnIdentifiers(columnNames);
	 dtm.setRowCount(0);
	
	
	
	ArrayList<whManage> arr=new ArrayList<whManage>();
	ExamineWh ew=new ExamineWh();
	arr.addAll(ew.getwhm());
	
	
	for(whManage ww:arr){
	String sq=String.valueOf(ww.getWhquote());
	String tid=ww.getTecid();
	String tname=ww.getTecname();
	String tnum=ww.getTecnum();
	String[] row={tid,tname,tnum,sq};
	dtm.addRow(row);
	}
	
	jb.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}
		
	});
	
	jt.setEnabled(false);
	jsp.setBounds(0, 0, 400, 800);
	jp.setLayout(null);
	jp.setPreferredSize(new Dimension(400, 800));
	jp.setBorder(new LineBorder(Color.black));
	jf.setSize(400, 800);
	
	jp.add(jsp);
	jf.add(jp);
	 jf.setVisible(true);
     //jf.setResizable(false);
    // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			new ExamineWhUI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
