import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.sql.*;
import java.util.*;

public class c5 extends JFrame
{
  
   static JLabel l0,l1,l2,l3,l4,l5;
   static JTextField t1,t2,t3,t4,t5;
   static JButton b1,b2,b3,b4,b5;
   static Connection con1;

    c5(Connection con) //constructor
   {this.con1=con;
   }

  void AddItems()
{
    l0=new JLabel("RATING DETAILS");
    l1=new JLabel("Delivery ID");
    l2=new JLabel("Courier ID");
    l3=new JLabel("Name");
    t1=new JTextField();
    t2=new JTextField(); 
    t3=new JTextField(); 
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
    t1.setBounds(250,50,160,28);
    t2.setBounds(250,80,160,28);
    t3.setBounds(250,110,160,28);
    b1.setBounds(90,180,135,45);
    b2.setBounds(240,180,135,45);
    b3.setBounds(90,230,135,45);
    b4.setBounds(240,230,135,45);
    b5.setBounds(170,280,135,45);

    add(l0);add(l1);add(l2);add(l3);
    add(t1);add(t2);add(t3);
    add(b1);add(b2);add(b3);add(b4);add(b5);
}


public static void create(c5 d)

    {
       //c5 frm=new c5(con);
    
    d.AddItems();
    d.setVisible(true);
    d.setSize(500,400);
    d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try{
	/*Class.forName("oracle.jdbc.OracleDriver");//reg drivers
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","SEETHA","SEETHA");
	Statement stmt=con.createStatement();//creating statement
	*/
        //INSERTION
	b1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String query ="insert into rating values(?,?,?)";
		try{
			PreparedStatement ps=con1.prepareStatement(query);
			BigDecimal x= new BigDecimal(t1.getText());
			ps.setBigDecimal(1,x);
			BigDecimal y= new BigDecimal(t2.getText());
			ps.setBigDecimal(2,y);
			String z=t3.getText();
			ps.setString(3,z);
			int n= ps.executeUpdate();
			if(n==1){t1.setText(null);
			t2.setText(null);
			t3.setText(null);
					
			JOptionPane.showMessageDialog(d,"Record Inserted");}
		   }catch(Exception e){JOptionPane.showMessageDialog(d,"Record NOT Inserted"+e);} 
	   }
	});

	//UPDATION
	b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent g)
          {
		try{
			String query1= "update rating=? where cour_id_upd=?";
			PreparedStatement prest1 = con1.prepareStatement(query1);
			String x=t2.getText();
			prest1.setString(1,x);
			System.out.println("input: "+x);
			BigDecimal cour_id_upd= new BigDecimal(t1.getText());
			prest1.setBigDecimal(2, cour_id_upd);
			JOptionPane.showMessageDialog(d,"Record updated"+cour_id_upd); 
 			prest1.executeUpdate();
			System.out.println("Updated query");
		   }catch(Exception e){JOptionPane.showMessageDialog(d,"Record NOT updated"+e);} 
	  }
        });


	//DELETION	
	b3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String sql = "DELETE FROM rating where cour_id_del = ?";
		try{    
			PreparedStatement prest = con1.prepareStatement(sql);
			BigDecimal cour_id_del= new BigDecimal(t2.getText());
			prest.setBigDecimal(1, cour_id_del);
    			int del = prest.executeUpdate();
    			JOptionPane.showMessageDialog(d,"Record Deleted"+cour_id_del);
		   }catch(Exception e){JOptionPane.showMessageDialog(d,"Record NOT Deleted"+e);} 
	  }
	});

//display
b4.addActionListener(new ActionListener()
{
       public void actionPerformed(ActionEvent f)
       {//display	
 

String sql = "select * from rating";
String coun="SELECT count(*) from rating";
try{    
PreparedStatement prest = con1.prepareStatement(sql);
PreparedStatement prest1 =con1.prepareStatement(coun);

ResultSet rscoun= prest1.executeQuery();
rscoun.next();
System.out.println(rscoun.getString(1));
int x = rscoun.getInt(1);
System.out.println(x);

ResultSet rs = prest.executeQuery();
//while(rs.next()) {
	try{ //for(int i=1;i<=5;i++) {
       
        //String columnValue = rs.getString(i);
        //System.out.print(columnValue);
        ResultSetMetaData rsmd = rs.getMetaData();
        /*int columnsNumber = rsmd.getColumnCount();
        System.out.println(columnsNumber);*/
        Object names[] = new Object[rsmd.getColumnCount()];
        for (int j = 1; j <= 5; j++) {
        	//names[j]=
        	names[j-1]=rsmd.getColumnName(j);
        		System.out.println(names[j-1]);
        		
        }
        table t=new table();
        t.createt(rs,rsmd,x);
        
	
    System.out.println("");
    // }
	}catch(NumberFormatException e){
       System.out.println("not a number");}
	
	}catch(Exception e){System.out.println(e);} 

}});
b5.addActionListener(new ActionListener()
{
       public void actionPerformed(ActionEvent f)
       {
    	   d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       }
});


    }catch(Exception e){System.out.println(e);} 
    }
}
