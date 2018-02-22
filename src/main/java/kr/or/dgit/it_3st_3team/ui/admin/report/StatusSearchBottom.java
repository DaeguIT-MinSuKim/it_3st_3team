package kr.or.dgit.it_3st_3team.ui.admin.report;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class StatusSearchBottom extends JPanel {
	private JTextField textField;

	
	public StatusSearchBottom() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 325, 51);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 5, 30, 21);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(98, 5, 30, 21);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(133, 5, 30, 21);
		panel_2.add(comboBox_2);
		
		JPanel pCalendar = new JPanel();
		pCalendar.setBounds(331, 0, 552, 51);
		panel_1.add(pCalendar);
		pCalendar.setLayout(new BoxLayout(pCalendar, BoxLayout.X_AXIS));
		
		JPanel pStartdate = new JPanel();
		pCalendar.add(pStartdate);
		
		UtilDateModel model = new UtilDateModel();
		Properties pro1 = new Properties();
		pro1.put("text.today", "Today");
		pro1.put("text.month", "Month");
		pro1.put("text.year", "Year");

		JDatePanelImpl datePanel = new JDatePanelImpl(model, pro1);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH,
				datePicker);
		pStartdate.add(datePicker);
		
		JPanel pEnddate = new JPanel();
		pCalendar.add(pEnddate);
		
		UtilDateModel model2 = new UtilDateModel();
		Properties pro2 = new Properties();
		pro2.put("text.today", "Today");
		pro2.put("text.month", "Month");
		pro2.put("text.year", "Year");

		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, pro2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout2 = (SpringLayout) datePicker2.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.NORTH,
				datePicker2);
		pEnddate.add(datePicker2);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("                                                    ");
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("거래명세서");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("보고서");
		panel.add(btnNewButton_2);
	}

}

class DateLabelFormatter extends AbstractFormatter {

	private String datePattern = "yyyy-MM-dd";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	@Override
	public Object stringToValue(String text) throws ParseException {
		return dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		if (value != null) {
			Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());
		}

		return "";
	}

}