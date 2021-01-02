import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.sql.*;

class dc6 extends JFrame
{
  
   static JLabel l0,l1,l2,l3,l4,l5;
   static JTextField t1,t2,t3,t4,t5;
   static JButton b1,b2,b3,b4,b5;
   static Connection con1;
    dc6(Connection con)
   {
    	dc6.con1=con;
   }

  void AddItems()
{
    l0=new JLabel("CUSTOMER REGISTERATION");
    l1=new JLabel("Customer id");
    l2=new JLabel("Customer name");
    l3=new JLabel("Email id");
    l4=new JLabel("Phone number");
    l5=new JLabel("Address");
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
}


public static void create(dc6 dc)

    {
       //dc6 frm=new dc6("CUSTOMER INSERTION");
       
    dc.setTitle("CUSTOMER INSERTION");
    dc.AddItems();
    dc.setVisible(true);
    dc.setSize(500,400);
    dc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
try{
Class.forName("oracle.jdbc.OracleDriver");//reg drivers

Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","sai","Sai123");

b1.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent f)
                     {
			
                        //insertion
String query ="insert into customer values(?,?,?,?,?)";
try{
PreparedStatement ps=con1.prepareStatement(query);
BigDecimal x= new BigDecimal(t1.getText());
ps.setBigDecimal(1,x);
String y=t2.getText();
ps.setString(2,y);
String z=t3.getText();
ps.setString(3,z);
BigDecimal a= new BigDecimal(t4.getText());
ps.setBigDecimal(4,a);
String b=t5.getText();
ps.setString(5,b);

int n= ps.executeUpdate();
if(n==1){
	t1.setText(null);
	t2.setText(null);
	t3.setText(null);
	t4.setText(null);
	t5.setText("");
System.out.println("Record Inserted");

JOptionPane.showMessageDialog(dc,"Record Inserted");}
else
System.out.println("Record Not Inserted");
}catch(Exception e){System.out.println(e);} 
}
});	
b3.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent f)
                     {//delete


String sql = "DELETE FROM customer where c_id = ?";
try{    
PreparedStatement prest = con1.prepareStatement(sql);
BigDecimal c_id_del= new BigDecimal(t1.getText());
prest.setBigDecimal(1, c_id_del);
    int del = prest.executeUpdate();
    System.out.println("Number of deleted records: " + del);
}catch(Exception e){System.out.println(e);} 
}
});


//update
b2.addActionListener(new ActionListener()
              {
                     public void actionPerformed(ActionEvent g)
                     {//update



try{
String query1= "update customer set c_id=? where phone_no=?";
PreparedStatement prest1 = con1.prepareStatement(query1);
BigDecimal c_id_upd= new BigDecimal(t1.getText());
prest1.setBigDecimal(1, c_id_upd);
System.out.println("input: "+c_id_upd);
BigDecimal p_no_upd= new BigDecimal(t4.getText());
prest1.setBigDecimal(2, p_no_upd);
System.out.println("input: "+p_no_upd);
 
	prest1.executeUpdate();
System.out.println("Updated query");
}catch(Exception e){System.out.println(e);} 
}
});

b4.addActionListener(new ActionListener()
{
       public void actionPerformed(ActionEvent f)
       {//delete	
 

String sql = "select * from customer";
String coun="SELECT count(*) from customer";
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
        String names[] = new String[rsmd.getColumnCount()];
        for (int j = 1; j <= 5; j++) {
        	//names[j]=
        		System.out.println(rsmd.getColumnName(j));
        		names[j-1]=rsmd.getColumnName(j);
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
    	   dc.dispose(); 
       }
});


}catch(Exception e){System.out.println(e);} 




}   

}