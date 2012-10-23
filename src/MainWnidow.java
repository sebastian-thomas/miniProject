
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JLabel;
//import javax.swing.JButton;

class MainWindow extends JFrame
{
	
	public MainWindow()
	{
		setTitle("Billing Application");
		JMenuBar menubar = new JMenuBar();
		JMenu product = new JMenu("Products");
		JMenu bill = new JMenu("Bill");
		
		JMenuItem  addproduct= new JMenuItem("Add Product");
		JMenuItem  viewproducts= new JMenuItem("View Products");
		JMenuItem  editproduct= new JMenuItem("Edit Product");
		
		JMenuItem newbill= new JMenuItem("New Bill");
		JMenuItem viewbill= new JMenuItem("View Bill");
		
		product.add(addproduct);
		product.add(viewproducts);
		product.add(editproduct);
		
		bill.add(newbill);
		bill.add(viewbill);
		
		menubar.add(product);
		menubar.add(bill);
		
		
		setJMenuBar(menubar);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}