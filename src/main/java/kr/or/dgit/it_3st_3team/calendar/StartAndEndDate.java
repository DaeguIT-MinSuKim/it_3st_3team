package kr.or.dgit.it_3st_3team.calendar;

import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



public class StartAndEndDate extends JPanel {

	
	public StartAndEndDate() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel pStartdate = new JPanel();
		add(pStartdate);
		
		UtilDateModel model = new UtilDateModel();
		Properties pro1 = new Properties();
		pro1.put("text.today", "Today");
		pro1.put("text.month", "Month");
		pro1.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, pro1);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker);
		pStartdate.add(datePicker);
		
		JPanel pEnddate = new JPanel();
		add(pEnddate);
		
		UtilDateModel model2 = new UtilDateModel();
		Properties pro2 = new Properties();
		pro2.put("text.today", "Today");
		pro2.put("text.month", "Month");
		pro2.put("text.year", "Year");
		
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, pro2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout2 = (SpringLayout) datePicker2.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker2);
		pEnddate.add(datePicker2);
	}

}
