import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.math.BigDecimal;
import java.sql.*;
class HOME_PAGE extends JFrame
{
  
   JLabel l0;
   static JButton b1,b2;
   static JButton b3;
   static JButton b4;
   static JButton b5;

    HOME_PAGE(String s)
   {
    super(s);
   }

  void AddItems()
  {
    l0=new JLabel("COURIER MANAGEMENT SYSTEM");
    b1=new JButton("CUSTOMER REGISTERATION");
    b2=new JButton("COURIER PAGE");
    b3=new JButton("SHIPMENT PAGE");
    b4=new JButton("DELIVERY AGENT PAGE");
    b5=new JButton("RATING");
   
    setLayout(null);
    
    l0.setBounds(160,-20,300,100);
    b1.setBounds(30,80,210,45);
    b2.setBounds(270,80,200,45);
    b3.setBounds(270,160,200,45);
    b4.setBounds(30,160,210,45);
    b5.setBounds(170,230,170,45);

    add(l0);
    add(b1);add(b2);add(b3);add(b4);add(b5);
  	}


public static void main(String arg[])
{
       HOME_PAGE frm=new HOME_PAGE("COURIER MANAGEMENT SYSTEM");
       try{
    	   Class.forName("oracle.jdbc.OracleDriver");//reg drivers

    	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","sai","Sai123");
      
    frm.AddItems();
    frm.setVisible(true);
    frm.setSize(500,400);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    b4.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   delivery da = new delivery(con);
        	   da.create(da);
           }
    });
    
    b5.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   c5 d = new c5(con);
        	   c5.create(d);
           }
    });

    b1.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   dc6 dc = new dc6(con);
        	   dc6.create(dc);
           }
    });
    
    b2.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   c2 cc = new c2(con);
        	   c2.create(cc);
           }
    });
    
    

    b3.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   c3 ccc = new c3(con);
        	   c3.create(ccc);
           }
    });
    
       }catch(Exception e){System.out.println(e);}
}}    