import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;


class Bill
{
	JTextField pid ;
	JTextField bid;
	JTextField qty;
	JPanel jl;
	Bill()
	{
		 pid = new JTextField();
	     bid = new JTextField();
		 qty = new JTextField();
	     
	}
	JPanel newBill()
	{
		JPanel j =new JPanel();
		
		JLabel title = new JLabel("Enter Bill Details");
		JLabel bidl = new JLabel("Bill id");
		JLabel pidl = new JLabel("Product id");
		JLabel qtyl = new JLabel("Quantity");
		JButton add = new JButton("ADD");
		JButton viewb = new JButton("View Bill");
		
		title.setBounds(100, 60, 200, 40);
		bidl.setBounds(100, 100, 80, 20);
		bid.setBounds(190, 100, 80, 20);
		pidl.setBounds(100, 130, 80, 20);
		pid.setBounds(190, 130, 80, 20);
		qtyl.setBounds(100, 160, 80, 20);
		qty.setBounds(190, 160, 80, 20);
		add.setBounds(100,240,80,20);
		viewb.setBounds(200,240,80,20);
		
		viewb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				jl = new JPanel();
				jl= viewBill(Integer.parseInt(bid.getText()));
			}
		});
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				billadd();
			}
		});
		
		j.add(title);
		j.add(bidl);
		j.add(bid);
		j.add(pidl);
		j.add(pid);
		j.add(qtyl);
		j.add(qty);
		j.add(add);
		j.add(viewb);
		if(jl==null)
		    return j;
		else
			return jl;
	}
	
	JPanel formatBill(int dl)
	{
		String s="select * from billpro";
		//DBcon d = new DBcon();
		
		JPanel j = new JPanel();
		ResultSetMetaData md= null;
		int columncount=3;
		String columns[] ={"billno","pid","qty"};
		Vector <String>row;
		//rs = d.dbquery(s);
		
		Connection con = null;
		ResultSet rs = null;
		String [][]d= null;
		try
		{
			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			//select ora_database_name from dual;
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "seb","password" );
			Statement st = con.createStatement();
			rs = st.executeQuery("select count(*) from billpro where billno ="+dl);
			rs.next();
			int rowcount =Integer.parseInt(rs.getString(1));
			
			rs = st.executeQuery("select * from billpro where billno = "+dl);
			d= new String[rowcount][4];
			int jr=0;
			while(rs.next())
			{
				
				for(int i=1; i<=columncount;++i)
				{
					d[jr][i-1] = rs.getString(i);
				}
				++jr;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		//j.setLayout(new BorderLayout());
		j.setLayout(null);
		JTable table = new JTable(d, columns);
		JLabel jl = new JLabel("All Bill");
		jl.setBounds(50, 50, 100, 40);
		j.add(jl);
		JScrollPane spTable = new JScrollPane(table);
		spTable.setBounds(50, 80, 400, 500);
		j.add(spTable);
		
		return j;
	}
	
	
	JPanel viewBill(int id) 
	{
		jl =new JPanel();
		if(id==-1)
		{
			JLabel bidl = new JLabel("Bill id");
			bidl.setBounds(100, 100, 80, 20);
			bid.setBounds(140, 100, 80, 20);
			JButton viewbl = new JButton("View Bill");
			viewbl.setBounds(200,240,120,20);
			jl.add(bidl);
			jl.add(bid);
			jl.add(viewbl);
			
			viewbl.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					jl= viewBill(Integer.parseInt(bid.getText()));
				}
			});
		}
		else
		{
			jl=formatBill(id);
		}
		return jl;
	}
	
	void billadd()
	{
		int pidv = Integer.parseInt(pid.getText());
		int bidv = Integer.parseInt(bid.getText());
		int qtyv = Integer.parseInt(qty.getText());
		
		String s="insert into billpro values ("+bidv+","+pidv+","+qtyv+")";
		
		DBcon d= new DBcon();
		ResultSet rs = null;
		rs=d.dbquery(s);
		JOptionPane.showMessageDialog(null,"Save Succesfull");
	}
}