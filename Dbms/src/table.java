
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class table{


JFrame frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;

public void createt(ResultSet rs,ResultSetMetaData rsmd,int coun) {
	
	
	
	try { 
Object[][] values= new Object[coun][rsmd.getColumnCount()];
		  Object[] cnames=new Object[rsmd.getColumnCount()];
		frame1 = new JFrame("Database Search Result");
	frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame1.setSize(600,600);
	frame1.setLayout(new BorderLayout());
    //DefaultTableModel model = new DefaultTableModel(new Object[] {names},10);
    //model.addColumn(names);
	//int z=1;
	rs.next();
	System.out.println("No of rcoeds:"+coun+"number of col:"+rsmd.getColumnCount());
	//while(z==1){   
		System.out.println("if check: "+rs.getRow());
		//if(rs.getRow()<=coun) {
		
		//if (z==0) {rs.beforeFirst();z++;}
	for(int z=0;z<rsmd.getColumnCount();z++)
		{cnames[z]=rsmd.getColumnLabel(z+1);}
	
	for (int i=rs.getRow();i<=coun&&i!=0;i++)
	{	System.out.println(i);
	
	
	for(int j=0;j<rsmd.getColumnCount();j++)
		{System.out.println(rs.getString(j+1));
		values[i-1][j]=rs.getString(j+1);
		
	    
		}
	rs.next();
		}
	
	JTable table=new JTable(values,cnames);
	table.setPreferredScrollableViewportSize(new Dimension(400,400));
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	JScrollPane scroll = new JScrollPane(table);
	scroll.setHorizontalScrollBarPolicy(
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	frame1.setVisible(true);
	frame1.add(table);
		  
	}catch(Exception e){System.out.println(e+"4567");}
	//model.addRow(new Object[]{"roll"," name, cl, sec});\
	//model.addColumn();
}




}
