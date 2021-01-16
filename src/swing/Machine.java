package swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import state.Context;
import state.State;

public class Machine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField order;
	private JLabel outputStream;

	public static final Color VERY_LIGHT_GRAY = new Color(37,37,37,35);
	public static final Color SMOOTH_LIGHT_GRAY = new Color(88,87,92,100);

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Machine frame = new Machine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Start the Machine.
	 */
	public Machine() {

		Context automat = new Context();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() / 2.5) - (getWidth() / 2));
	    int y = (int) ((dimension.getHeight() - getHeight()) / 4);
	    setLocation(x, y);
		
        setSize(496,873);
        setResizable(false);
        setTitle("Snackautomat by Kevin & Lukas");

        JLabel background=new JLabel(new ImageIcon("vending-machine.png"));
        background.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(SMOOTH_LIGHT_GRAY);
		panel1.setBounds(405, 180, 70, 180);
		panel1.setLayout(new GridLayout(5, 1, 0, 0));
        
        JLabel text1=new JLabel(" Choose");
        text1.setForeground(Color.WHITE);
        panel1.add(text1);
        
        JLabel text2 = new JLabel(" your Snack");
        text2.setForeground(Color.WHITE);
        panel1.add(text2);
        
        JPanel spacer = new JPanel();
        spacer.setBackground(SMOOTH_LIGHT_GRAY);
        panel1.add(spacer);
        
        order = new JTextField();
        order.setFont(new Font("Tahoma", Font.PLAIN, 14));
        order.setForeground(Color.WHITE);
        order.setBackground(SMOOTH_LIGHT_GRAY);
        panel1.add(order);
        order.setColumns(15);
        
        
        JButton submit=new JButton("Order");
        submit.setForeground(Color.BLACK);
        
        
        submit.setBackground(Color.LIGHT_GRAY);
        panel1.add(submit);
       
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(VERY_LIGHT_GRAY);
        panel2.setBounds(115, 575, 180, 50);
        panel2.setLayout(new GridLayout(1, 1, 0, 0));
        
        background.add(panel1);
        background.add(panel2);
        
        outputStream = new JLabel("");
        panel2.add(outputStream);
        getContentPane().add(background);
        
        
        submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		String output = "";

        		try {
            		Integer item = Integer.parseInt(order.getText());
            		output = "You've got "+automat.getItem(item);
        		}catch(NumberFormatException num) {
        			output = "Wrong Input Format";
        		}catch(NullPointerException nul) {
        			output = "Cant read Input";
        		}catch(IllegalStateException state) {
        			output = "Item not found";
        		}
        		
        		JOptionPane.showMessageDialog(outputStream, output, "Warenausgabe", JOptionPane.INFORMATION_MESSAGE);
        		//outputStream.setText("HELLO");
        		//System.out.println(output);
        	}
        });
            
	}
}
