
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.awt.BorderLayout;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

class Product
{
	JTextField pid ;
	JTextField pname;
	JTextField price;
	JTextField stock ;
	Product()
	{
		 pid = new JTextField();
	     pname = new JTextField();
		 price = new JTextField();
	     stock = new JTextField();
	}
	JPanel addProduct()
	{
		JPanel panel = new JPanel();
		panel.removeAll();
		
		JLabel title = new JLabel("Enter Product Details");
		JLabel pidl = new JLabel("Id ");
		JLabel pnamel = new JLabel("Name");
		JLabel pricel = new JLabel("Price");
		JLabel stockl = new JLabel("Stock");
		
		
		
		JButton save = new JButton("save");
		
		title.setBounds(100, 60, 200, 40);
		pidl.setBounds(100, 100, 80, 20);
		pid.setBounds(140, 100, 80, 20);
		pnamel.setBounds(100, 130, 80, 20);
		pname.setBounds(140, 130, 80, 20);
		pricel.setBounds(100, 160, 80, 20);
		price.setBounds(140, 160, 80, 20);
		stockl.setBounds(100, 190, 80, 20);
		stock.setBounds(140, 190, 80, 20);
		save.setBounds(100,240,80,20);
		
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				productinsert();
			}
		});
		
		panel.add(title);
		panel.add(pidl);
		panel.add(pid);
		panel.add(pnamel);
		panel.add(pname);
		panel.add(pricel);
		panel.add(price);
		panel.add(stockl);
		panel.add(stock);
		panel.add(save);
		
		return panel;
		
	}
	
	JPanel viewProducts()
	{
		String s="select * from product";
		//DBcon d = new DBcon();
		
		JPanel j = new JPanel();
		ResultSetMetaData md= null;
		int columncount=4;
		String columns[] ={"id","name","price", "stock"};
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
			rs = st.executeQuery("select count(*) from product");
			rs.next();
			int rowcount =Integer.parseInt(rs.getString(1));
			
			rs = st.executeQuery("select * from product");
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
		JLabel jl = new JLabel("All Products");
		jl.setBounds(50, 50, 100, 40);
		j.add(jl);
		JScrollPane spTable = new JScrollPane(table);
		spTable.setBounds(50, 80, 400, 500);
		j.add(spTable);
		
		return j;
	}
	
	void editProduct()
	{
		
	}
	
	void productinsert()
	{
		int id = Integer.parseInt(pid.getText());
		String nam = pname.getText();
		float pr = Float.parseFloat(price.getText());
		int st= Integer.parseInt(stock.getText());
		
		String s="insert into product values ("+id+",'"+nam+"',"+pr+","+st+")";
		
		DBcon d= new DBcon();
		ResultSet rs = null;
		rs=d.dbquery(s);
		JOptionPane.showMessageDialog(null,"Save Succesfull");
	}
}