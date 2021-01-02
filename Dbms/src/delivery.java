import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class delivery extends JFrame
{
  
  static JLabel l0,l1,l2,l3,l4,l5;
  static JTextField t1,t2,t3,t4,t5;
  static JButton b1,b2,b3,b4,b5;
  static Connection con1;
    delivery(Connection con)
   {
    delivery.con1=con;
   }

  void AddItems()
{
    l0=new JLabel("DELIVERY AGENT DETAILS");
    l1=new JLabel("Delivery ID");
    l2=new JLabel("Courier ID");
    l3=new JLabel("Name");
    l4=new JLabel("Phone Number");
    l5=new JLabel("Health Condition");
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
    l5.setBounds(50,160,100,40);
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


public static void create(delivery da)
{    //System.out.println("SAI");
      // demodelivery_agent frm=new demodelivery_agent(con);
    da.setTitle("Delivery Agent");
    da.AddItems();
    da.setVisible(true);
    da.setSize(500,400);
    da.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    b5.addActionListener(new ActionListener()
    {
           public void actionPerformed(ActionEvent f)
           {
        	   da.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
           }
    });
}   

}