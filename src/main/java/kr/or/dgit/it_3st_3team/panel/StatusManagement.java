package kr.or.dgit.it_3st_3team.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import kr.or.dgit.it_3st_3team.ui.table.StatusManagementLists;

public class StatusManagement extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JButton btn1;
	private String [] option1 = {"상호명","재밌는 게임방","좋은 게임방","친구게임방","충청남도교육청","대전광역시교육청","아산시스템"};
	private String [] option2 = {"분류","게임","사무","그래픽"};
	private String [] option3 = {"관리자","영업1팀","영업2팀","영업3팀","영업4팀","영업5팀"};
	private JButton btnSearch;
	
	
	public StatusManagement() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(5, 5, 883, 91);
		add(p1);
		p1.setLayout(null);
		
		JComboBox cmbOption1 = new JComboBox(option1);
		cmbOption1.setBounds(0, 18, 137, 21);
		p1.add(cmbOption1);
		
		JComboBox cmbOption2 = new JComboBox(option2);
		cmbOption2.setBounds(151, 18, 125, 21);
		p1.add(cmbOption2);
		
		JComboBox cmbOption3 = new JComboBox(option3);
		cmbOption3.setBounds(288, 18, 137, 21);
		p1.add(cmbOption3);
		
		//////////////////////////////////
		JPanel pStartDate = new JPanel();
		pStartDate.setBounds(425, 10, 230, 33);
		p1.add(pStartDate);
		
		UtilDateModel model = new UtilDateModel();
		Properties pro1 = new Properties();
		pro1.put("text.today", "Today");
		pro1.put("text.month", "Month");
		pro1.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model, pro1);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker);
		pStartDate.add(datePicker);
		
		JPanel pEndDate = new JPanel();
		pEndDate.setBounds(653, 10, 230, 33);
		p1.add(pEndDate);
		
		UtilDateModel model2 = new UtilDateModel();
		Properties pro2 = new Properties();
		pro2.put("text.today", "Today");
		pro2.put("text.month", "Month");
		pro2.put("text.year", "Year");
		
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, pro2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		SpringLayout springLayout2 = (SpringLayout) datePicker2.getLayout();
		springLayout.putConstraint(SpringLayout.NORTH, datePicker2.getJFormattedTextField(), 0, SpringLayout.NORTH, datePicker2);
		pEndDate.add(datePicker2);
		
		
		
		
		
		tfSearch = new JTextField();
		tfSearch.setBounds(0, 60, 425, 21);
		p1.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(440, 59, 60, 23);
		p1.add(btnSearch);
		
		JButton btnReceipt = new JButton("거래명세서");
		btnReceipt.setBounds(653, 59, 105, 23);
		p1.add(btnReceipt);
		
		JButton btnReport = new JButton("보고서");
		btnReport.setBounds(766, 59, 105, 23);
		p1.add(btnReport);
		
		JPanel p2 = new JPanel();
		p2.setBounds(5, 106, 883, 389);
		add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		StatusManagementLists pTable = new StatusManagementLists();
		//pTable.setBounds(5, 5, 866, 358);
		p2.add(pTable, BorderLayout.CENTER);
		//pTable.setLayout(new BorderLayout(0, 0));
		
		JPanel pPaging = new JPanel();
		p2.add(pPaging, BorderLayout.SOUTH);
		pPaging.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn1 = new JButton("<");
		pPaging.add(btn1);
		
		JButton btn2 = new JButton("1");
		pPaging.add(btn2);
		
		JButton btn3 = new JButton("2");
		
		pPaging.add(btn3);
		
		JButton btn4 = new JButton("3");
		pPaging.add(btn4);
		
		JButton btn5 = new JButton(">");
	
		pPaging.add(btn5);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			actionPerformedBtnSearch(arg0);
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent arg0) {
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
