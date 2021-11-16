package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

public class StatusBar extends JPanel{
	
	public StatusBar(int width,String title) {
		
		 JPanel statusBar = new JPanel();
		 setLayout(new BorderLayout());
		 statusBar.setLayout(new BorderLayout());
		 add(statusBar);
	     statusBar.setBackground(Color.LIGHT_GRAY);
	     statusBar.setPreferredSize(new Dimension(width, 20));
	     
	     JLabel name = new JLabel(title);
	     statusBar.add(name,BorderLayout.WEST);
	     
	     JLabel dateTime = new JLabel();
	     statusBar.add(dateTime, BorderLayout.EAST);
	     Timer timee = new Timer(100, new ActionListener() {
	    	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Date date = Calendar.getInstance().getTime(); 
	                DateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy.");  
	                String strDate = dateFormat.format(date); 
	                dateTime.setText(strDate);
	            }
	        });
	     statusBar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
	     
	     timee.start();
	     setVisible(true);
	}
}
