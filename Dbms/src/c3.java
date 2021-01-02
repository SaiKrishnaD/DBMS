import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.sql.*;
import java.util.*;


class c3 extends JFrame
{
  
   static JLabel l0,l1,l2,l3,l4;
   static JTextField t1,t2,t3,t4;
   static JButton b1,b2,b3,b4,b5;
   static Connection con1;
    c3(Connection con)//constructor
   {
    c3.con1=con;
   }

  void AddItems()
{
    l0=new JLabel("SHIPMENT DETAILS");
    l1=new JLabel("Courier ID");
    l2=new JLabel("From City");
    l3=new JLabel("To City");
    l4=new JLabel("Status");
    t1=new JTextField();
    t2=new JTextField(); 
    t3=new JTextField(); 
    t4=new JTextField(); 
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
    t1.setBounds(250,50,160,28);
    t2.setBounds(250,80,160,28);
    t3.setBounds(250,110,160,28);
    t4.setBounds(250,140,160,28);
    b1.setBounds(90,210,135,45);
    b2.setBounds(240,210,135,45);
    b3.setBounds(90,260,135,45);
    b4.setBounds(240,260,135,45);
    b5.setBounds(170,310,135,45);

    add(l0);add(l1);add(l2);add(l3);add(l4);
    add(t1);add(t2);add(t3);add(t4);
    add(b1);add(b2);add(b3);add(b4);add(b5);
}


public static void create(c3 ccc)

    {
      
    ccc.setTitle("SHIPMENT INSERTION");
    ccc.AddItems();
    ccc.setVisible(true);
    ccc.setSize(500,400);
    ccc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    try{
	/*Class.forName("oracle.jdbc.OracleDriver");//reg drivers
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","SEETHA","SEETHA");
	//Statement stmt=con.createStatement();//creating statement*/
	
        //INSERTION
	b1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String query ="insert into shipment values(?,?,?,?)";
		try{
			PreparedStatement ps=con1.prepareStatement(query);
			BigDecimal x= new BigDecimal(t1.getText());
			ps.setBigDecimal(4,x);
			String y=t2.getText();
			ps.setString(1,y);
			String z=t3.getText();
			ps.setString(2,z);
			String b=t4.getText();
			ps.setString(3,b);
		
			int n= ps.executeUpdate();
			if(n==1){ t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			t4.setText(null);
			
			
			JOptionPane.showMessageDialog(ccc,"Record Inserted");}
		   }catch(Exception e){JOptionPane.showMessageDialog(ccc,"Record NOT Inserted"+e);} 
	   }
	});

	//UPDATION
	b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent g)
          {
		try{
			String query1= "update shipment tocity=? where cour_id=?";
			PreparedStatement prest1 = con1.prepareStatement(query1);
			String x=t3.getText();
			prest1.setString(1,x);
			System.out.println("input: "+x);
			BigDecimal cour_id= new BigDecimal(t1.getText());
			prest1.setBigDecimal(2, cour_id);
			JOptionPane.showMessageDialog(ccc,"Record updated"+cour_id); 
 			prest1.executeUpdate();
			System.out.println("Updated query");
		   }catch(Exception e){JOptionPane.showMessageDialog(ccc,"Record NOT updated"+e);} 
	  }
        });


	//DELETION	
	b3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent f)
          {
		String sql = "DELETE FROM shipment  where cour_id_del= ?";
		try{    
			PreparedStatement prest = con1.prepareStatement(sql);
			BigDecimal cour_id_del= new BigDecimal(t1.getText());
			prest.setBigDecimal(1, cour_id_del);
    			int del = prest.executeUpdate();
    			JOptionPane.showMessageDialog(ccc,"Record Deleted"+del);
		   }catch(Exception e){JOptionPane.showMessageDialog(ccc,"Record NOT Deleted"+e);} 
	  }
	});
	
	b5.addActionListener(new ActionListener()
	{
	       public void actionPerformed(ActionEvent f)
	       {
	    	   ccc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	       }
	});


	
	}catch(Exception e){System.out.println(e);} 

}   

}