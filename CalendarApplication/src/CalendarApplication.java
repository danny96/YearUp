import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import javax.swing.JTable;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;




public class CalendarApplication {

	private DefaultTableModel m_defTblModel = null;
	private int m_realMonth = -1;
	private int m_realYear = -1;
	private int m_realDay = -1;
	private int m_currentMonth = -1;
	private int m_currentYear = -1;
	
	private JButton btnPrevious= null;
	private JButton btnNext= null;
	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblChangeYear;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarApplication window = new CalendarApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public CalendarApplication() {
		
		GregorianCalendar cal = new GregorianCalendar();
		m_realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
		m_realMonth = cal.get(GregorianCalendar.MONTH);
		m_realYear = cal.get(GregorianCalendar.YEAR);
		m_currentMonth = m_realMonth; 
		m_currentYear = m_realYear;
		
		initialize();
	}
	/**
	 * Create the application.
	 */
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (m_currentMonth == 11) { //Back one year
					m_currentMonth = 0;
					m_currentYear += 1;
				}
				else { //Back one month
					m_currentMonth += 1;
				}
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		btnNext.setBounds(180, 35, 78, 23);
		panel.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					if (m_currentMonth == 0) { //Back one year
						m_currentMonth = 11;
						m_currentYear -= 1;
					}
					else { //Back one month
						m_currentMonth -= 1;
					}
					refreshCalendar(m_currentMonth, m_currentYear);
				}
		});
		btnPrevious.setBounds(10, 35, 89, 23);
		panel.add(btnPrevious);
		
		lblNewLabel = new JLabel("Change Year:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);;
		lblNewLabel.setBounds(100, 35, 83, 23);
		panel.add(lblNewLabel);

		comboBox = new JComboBox();
		for (int i = m_realYear-100; i<=m_realYear+100; i++) {
			   comboBox.addItem(String.valueOf(i));
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != null) {
					String b = comboBox.getSelectedItem().toString();
					m_currentYear = Integer.parseInt(b); //Get the numeric value
					refreshCalendar(m_currentMonth, m_currentYear); //Refresh
				}
			}
		});
		comboBox.setBounds(386, 35, 60, 20);
		panel.add(comboBox);
		
		lblChangeYear = new JLabel("Change Year:");
		lblChangeYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeYear.setBounds(276, 35, 83, 23);
		panel.add(lblChangeYear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 452, 227);
		panel.add(scrollPane);
		
		table = new JTable(m_defTblModel);
		scrollPane.setViewportView(table);
		m_defTblModel = new DefaultTableModel();
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i = 0; i<7; i++)
		{
		   m_defTblModel.addColumn(headers[i]);
		}
		
		
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Set row/column count
		table.setRowHeight(38);
		m_defTblModel.setColumnCount(7);
		m_defTblModel.setRowCount(6);

		table.getParent().setBackground(table.getBackground());
		refreshCalendar(m_realMonth, m_realYear);
		refreshCalendar(m_currentMonth, m_currentYear);
	}

	public void refreshCalendar(int monthIndex, int year) {
	
		String[] monthsList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numberOfDays= -1;  //Number Of Days
		int startOfMonth = -1; //Start Of Month

		btnPrevious.setEnabled(true); //Enable buttons at first
		btnNext.setEnabled(true);


		if ((monthIndex == 0) && (year <= m_realYear - 100)) {
			//A month before January 100 years ago cannot be reached
			btnPrevious.setEnabled(false);
		}

		if ((monthIndex == 11) && (year >= m_realYear + 100))
		{
			//A month after December 100 years later cannot be reached
			btnNext.setEnabled(false);
		}
		lblNewLabel.setText(monthsList[monthIndex]); //Refresh the month label (at the top)
		comboBox.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

		GregorianCalendar cal = new GregorianCalendar(year, monthIndex, 1);
		numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);

//Clear table
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++) {
				m_defTblModel.setValueAt(null, i, j);
			}
		}

		for (int i=1; i<=numberOfDays; i++) {
			int row = new Integer((i+startOfMonth-2)/7);
			int column  =  (i+startOfMonth-2)%7;
			m_defTblModel.setValueAt(i, row, column);
		}	
	}
}
