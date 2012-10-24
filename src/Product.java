
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

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
	
	void viewProducts()
	{
		
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