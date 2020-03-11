package queues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerApp extends JFrame {

	private JPanel contentPane;
	private JTextField guestName;
	private JTextField partySize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerApp frame = new CustomerApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerApp() {
		
		Queue custQue = new Queue(5);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][]", "[][][][][][][][][][]"));
		
		JLabel lblHostManagementPro = new JLabel("Host Management Pro");
		lblHostManagementPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblHostManagementPro.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblHostManagementPro, "cell 0 0 5 1,alignx center");
		
		JLabel lblGuestName = new JLabel("Guest Name");
		contentPane.add(lblGuestName, "cell 0 1");
		
		JLabel lblNextCustomer = new JLabel("Next Customer");
		contentPane.add(lblNextCustomer, "cell 1 1");
		
		guestName = new JTextField();
		contentPane.add(guestName, "cell 0 2,alignx left");
		guestName.setColumns(10);
		
		JLabel nextCustomer = new JLabel("No Customers Yet");
		nextCustomer.setForeground(Color.RED);
		contentPane.add(nextCustomer, "cell 1 2");
		
		JLabel lblPartySize = new JLabel("Party Size");
		contentPane.add(lblPartySize, "cell 0 3");
		
		partySize = new JTextField();
		contentPane.add(partySize, "cell 0 4,alignx left");
		partySize.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(custQue.getMaxSize());
		progressBar.setValue(custQue.getnItems());
		contentPane.add(progressBar, "cell 0 7");
		
		JLabel customersWaiting = new JLabel("0 Customers Waiting");
		contentPane.add(customersWaiting, "cell 0 8");
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = guestName.getText();
				int size = Integer.parseInt(partySize.getText());
				custQue.insert(new Customer(name, size));
				//System.out.println(custQue.peekFront().toString());
				progressBar.setValue(custQue.getnItems());
				nextCustomer.setText(custQue.peekFront().toString());
				guestName.setText("");
				partySize.setText("");
				customersWaiting.setText(custQue.getnItems() + " Customers Waiting");
			}
		});
		contentPane.add(btnEnter, "cell 0 6");
		
		JButton btnSkip = new JButton("Skip");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custQue.skip();
				if(!custQue.isEmpty()) {
					nextCustomer.setText(custQue.peekFront().toString());	
				}
				else {
					nextCustomer.setText("Line is Empty");
				}
			}
		});
		contentPane.add(btnSkip, "flowx,cell 1 6");
		
		JButton btnSeat = new JButton("Seat");
		btnSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!custQue.isEmpty()) {
					custQue.remove();			
					progressBar.setValue(custQue.getnItems());
					customersWaiting.setText(custQue.getnItems() + " Customers Waiting");
				}
				if(!custQue.isEmpty()) {
					nextCustomer.setText(custQue.peekFront().toString());	
				}
				else {
					nextCustomer.setText("Line is Empty");
				}
				
			}
		});
		contentPane.add(btnSeat, "cell 1 6");
		
		JLabel lblbeTheHostess = new JLabel("*Be the Hostess with the Mostess!");
		lblbeTheHostess.setFont(new Font("Tahoma", Font.ITALIC, 10));
		contentPane.add(lblbeTheHostess, "cell 1 9");
	}

}
