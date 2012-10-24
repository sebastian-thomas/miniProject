
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JLabel;
import javax.swing.JButton;

class MainWindow extends JFrame
{
	JPanel panel, panel1 ;
	public MainWindow()
	{
		setTitle("Billing Application");
		
		panel = new JPanel();
		
		JMenuBar menubar = new JMenuBar();
		JMenu product = new JMenu("Products");
		JMenu bill = new JMenu("Bill");
		
		JMenuItem  addproduct= new JMenuItem("Add Product");
		JMenuItem  viewproducts= new JMenuItem("View Products");
		JMenuItem  editproduct= new JMenuItem("Edit Product");
		
		JMenuItem newbill= new JMenuItem("New Bill");
		JMenuItem viewbill= new JMenuItem("View Bill");
		
		addproduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//panel.removeAll();
				Product p = new Product();
				panel1 = p.addProduct();
				changePanel(panel1);

			}
		});
		viewproducts.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//panel.removeAll();
				Product p = new Product();
				panel1 = p.viewProducts();
				changePanel(panel1);

			}
		});
		
		product.add(addproduct);
		product.add(viewproducts);
		product.add(editproduct);
		
		bill.add(newbill);
		bill.add(viewbill);
		
		menubar.add(product);
		menubar.add(bill);
		//JButton b= new JButton("simple");
		//b.setBounds(300, 200, 40, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		//panel.add(b);
		setJMenuBar(menubar);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	private void changePanel(JPanel panel) {
	    getContentPane().removeAll();
	    getContentPane().add(panel);
	    getContentPane().doLayout();
	    update(getGraphics());
	}

	
}