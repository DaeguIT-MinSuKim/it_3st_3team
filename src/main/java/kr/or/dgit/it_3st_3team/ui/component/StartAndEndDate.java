package kr.or.dgit.it_3st_3team.ui.component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.Color;

@SuppressWarnings("serial")
public class StartAndEndDate extends JPanel {

	public StartAndEndDate() {

		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel pStartdate = new JPanel();
		pStartdate.setBackground(new Color(255, 255, 255));
		add(pStartdate);

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
		pEnddate.setBackground(new Color(255, 255, 255));
		add(pEnddate);

		UtilDateModel model2 = new UtilDateModel();
		Properties pro2 = new Properties();
		pro2.put("text.today", "Today");
		pro2.put("text.month", "Month");
		pro2.put("text.year", "Year");

		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, pro2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout2 = (SpringLayout) datePicker2.getLayout();
		springLayout2.putConstraint(SpringLayout.NORTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.NORTH,
				datePicker2);
		pEnddate.add(datePicker2);
	}

}

@SuppressWarnings("serial")
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
