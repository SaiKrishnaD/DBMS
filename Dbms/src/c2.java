import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

class c2 extends JFrame
{
  
   static JLabel l0,l1,l2,l3,l4,l5;
   static JTextField t1,t2,t3,t4,t5;
   static JButton b1,b2,b3,b4,b5;
   static Connection con1;
    c2(Connection con)//constructor
   {
    c2.con1=con;
   }

  void AddItems()
  {
    l0=new JLabel("COURIER DETAILS");
    l1=new JLabel("Courier id");
    l2=new JLabel("Customer id");
    l3=new JLabel("Product name");
    l4=new JLabel("Type");
    l5=new JLabel("Booked Date");
    t1=new JTextField();
    t2=new JTextField(); 
    t3=new JTextField(); 
    t4=new JTextField(); 
    t5=new JTextField();
    b1=new JButton("Insert");
    b2=new JButton("Update");
    b3=new JButton("Delete");
    b4=new JButton("Display");
    b5=new JButton("Back");
    setLayout(null);
    l0.setBounds(150,-20,300,100);
    l1.setBounds(50,40,80,40);
    l2.setBounds(50,70,120,40);
    l3.setBounds(50,100,80,40);
    l4.setBounds(50,130,120,40);
    l5.setBounds(50,160,80,40);
    t1.setBounds(250,50,160,28);
    t2.setBounds(250,80,160,28);
    t3.setBounds(250,110,160,28);
    t4.setBounds(250,140,160,28);
    t5.setBounds(250,170,160,28);
    b1.setBounds(90,210,135,45);
    b2.setBounds(240,210,135,45);
    b3.setBounds(90,260,135,45);
    b4.setBounds(240,260,135,45);
    b5.setBounds(170,310,135,45);

    add(l0);add(l1);add(l2);add(l3);add(l4);add(l5);
    add(t1);add(t2);add(t3);add(t4);add(t5);
    add(b1);add(b2);add(b3);add(b4);add(b5);
    }//end of function

public static void create(c2 cc)
{
    cc.setTitle("COURIER INSERTION");
    cc.AddItems();
    cc.setVisible(true);
    cc.setSize(500,400);
    cc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try{
	/*Class.forName("oracle.jdbc.OracleDriver");//reg drivers
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sai","Sai123");
	//Statement stmt=con.createStatement();//creating statement
	*/
        //INSERTION
	b1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String query ="insert into courier values(?,?,?,?,?)";
		try{
			PreparedStatement ps=con1.prepareStatement(query);
			BigDecimal x= new BigDecimal(t1.getText());
			ps.setBigDecimal(1,x);
			BigDecimal y= new BigDecimal(t2.getText());
			ps.setBigDecimal(5,y);
			String z=t3.getText();
			ps.setString(2,z);
			String b=t4.getText();
			ps.setString(3,b);
                        String sdate1=t5.getText();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
                        java.util.Date date = sdf1.parse(sdate1);
                        @SuppressWarnings("deprecation")
						java.sql.Date a = new java.sql.Date(date.getDate());
                        ps.setDate(4,a);
			int n= ps.executeUpdate();
			if(n==1){t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			t4.setText(null);
			t5.setText("");
			JOptionPane.showMessageDialog(cc,"Record Inserted");}
		   }catch(Exception e){JOptionPane.showMessageDialog(cc,"Record NOT Inserted"+e);} 
	   }
	});

	//UPDATION
	b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent g)
          {
		try{
			String query1= "update courier set product_name=? where courier_id=?";
			PreparedStatement prest1 = con1.prepareStatement(query1);
			String x=t2.getText();
			prest1.setString(1,x);
			System.out.println("input: "+x);
			BigDecimal cour_id= new BigDecimal(t1.getText());
			prest1.setBigDecimal(2, cour_id);
			JOptionPane.showMessageDialog(cc,"Record updated"+cour_id); 
 			prest1.executeUpdate();
			System.out.println("Updated query");
		   }catch(Exception e){JOptionPane.showMessageDialog(cc,"Record NOT updated"+e);} 
	  }
        });


	//DELETION	
	b3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String sql = "DELETE FROM customer where cour_id = ?";
		try{    
			PreparedStatement prest = con1.prepareStatement(sql);
			BigDecimal cour_id_del= new BigDecimal(t2.getText());
			prest.setBigDecimal(1, cour_id_del);
    			int del = prest.executeUpdate();
    			JOptionPane.showMessageDialog(cc,"Record Deleted"+del);
		   }catch(Exception e){JOptionPane.showMessageDialog(cc,"Record NOT Deleted"+e);} 
	  }
	});
	
	b4.addActionListener(new ActionListener()
	{
	       public void actionPerformed(ActionEvent f)
	       {//delete	
	 

	String sql = "select * from courier";
	String coun="SELECT count(*) from courier";
	try{    
	PreparedStatement prest = con1.prepareStatement(sql);
	PreparedStatement prest1 =con1.prepareStatement(coun);

	ResultSet rscoun= prest1.executeQuery();
	rscoun.next();
	System.out.println(rscoun.getString(1));
	int x = rscoun.getInt(1);

	ResultSet rs = prest.executeQuery();
	//while(rs.next()) {
		try{ //for(int i=1;i<=5;i++) {
	       
	        //String columnValue = rs.getString(i);
	        //System.out.print(columnValue);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        /*int columnsNumber = rsmd.getColumnCount();
	        System.out.println(columnsNumber);*/
	        int n = rsmd.getColumnCount();
	        for (int j = 1; j <= n; j++) {
	        	//names[j]=
	        		System.out.println(rsmd.getColumnName(j));
	        		
	        }
	        table t=new table();
	        t.createt(rs,rsmd,x);
	        
		
	    System.out.println("");
	    // }
		}catch(NumberFormatException e){
	       System.out.println("not a number"); }
		
	//}
	}catch(Exception e){System.out.println(e);} 
	}
	       
	});
	b5.addActionListener(new ActionListener()
	{
	       public void actionPerformed(ActionEvent f)
	       {
	    	   cc.dispose();
	       }
	});

	
	}catch(Exception e){System.out.println(e);} 
}//end of main   
}//end of class