package ppublicplacecrimes;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class GUI extends JFrame {


	private ArrayList<Crime> dataList = new ArrayList<Crime>();
	private Worker worker = new Worker();	
	private UrbanArea ua;
	private Record r;
	private int index = 0;
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Main_Data;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Index", "Area Code", "Area Name", "Victims", "Population at Mid 2015", "Rate Per 10,000 Population", "NZ Average Rate", "Urban Area Code", "Urban Area Lable", "Urban Area Type", "Territorial Code", "Territorial Lable", "Region Code", "Region Lable"
			}
		);
	
	
	private JPanel panel_1;
	private JRadioButton Region;
	private JRadioButton Victims;
	private JLabel lblNewLabel;
	private JRadioButton Terratory;
	private final ButtonGroup bgSort = new ButtonGroup();
	private JButton btnSort;
	private JRadioButton Area;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JTextField searchValue;
	private JButton btnSearch;
	private JRadioButton schAreaLocation;
	private JRadioButton schTerratory;
	private final ButtonGroup bgSearch = new ButtonGroup();
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JPanel panel_4;
	private JRadioButton rbMin;
	private JRadioButton rbMax;
	private final ButtonGroup bgMaxMin = new ButtonGroup();
	private JButton btnMaxMin;
	private JPanel Records;
	private JButton btnNextRecord;
	private JButton btnPrevousRecord;
	private JButton btnFirstRecord;
	private JButton btnLastRecord;
	private JTextField FindThisRecord;
	private JButton btnFindRecord;
	private JTextArea taRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Crime Stats");
	
		worker.readFile(dataList);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1848, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 84, 1800, 654);
		contentPane.add(tabbedPane);
		
		Main_Data = new JPanel();
		tabbedPane.addTab("Main Data ", null, Main_Data, null);
		Main_Data.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 5, 1780, 420);
		Main_Data.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(4).setPreferredWidth(176);
		table.getColumnModel().getColumn(5).setPreferredWidth(204);
		table.getColumnModel().getColumn(6).setPreferredWidth(132);
		table.getColumnModel().getColumn(7).setPreferredWidth(135);
		table.getColumnModel().getColumn(8).setPreferredWidth(133);
		table.getColumnModel().getColumn(9).setPreferredWidth(139);
		table.getColumnModel().getColumn(10).setPreferredWidth(123);
		table.getColumnModel().getColumn(11).setPreferredWidth(129);
		table.getColumnModel().getColumn(12).setPreferredWidth(102);
		table.getColumnModel().getColumn(13).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBounds(1372, 438, 338, 183);
		Main_Data.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setBounds(145, 5, 47, 20);
		panel_2.add(lblNewLabel_1);
		
		searchValue = new JTextField();
		searchValue.setBounds(66, 78, 208, 41);
		panel_2.add(searchValue);
		searchValue.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		btnSearch.setBounds(106, 138, 115, 29);
		panel_2.add(btnSearch);
		
		schAreaLocation = new JRadioButton("Area Location");
		bgSearch.add(schAreaLocation);
		schAreaLocation.setBounds(37, 37, 155, 29);
		panel_2.add(schAreaLocation);
		
		schTerratory = new JRadioButton("Terratory");
		bgSearch.add(schTerratory);
		schTerratory.setBounds(193, 37, 155, 29);
		panel_2.add(schTerratory);
		
		panel_1 = new JPanel();
		panel_1.setBounds(101, 438, 137, 182);
		Main_Data.add(panel_1);
		
		lblNewLabel = new JLabel("Sort By:");
		panel_1.add(lblNewLabel);
		
		Region = new JRadioButton("Region");
		bgSort.add(Region);
		panel_1.add(Region);
		
		Victims = new JRadioButton("Victims");
		bgSort.add(Victims);
		panel_1.add(Victims);
		
		Terratory = new JRadioButton("Terratory");
		bgSort.add(Terratory);
		panel_1.add(Terratory);
		
		Area = new JRadioButton("Area");
		bgSort.add(Area);
		panel_1.add(Area);
		
		panel_4 = new JPanel();
		panel_4.setBounds(697, 493, 228, 98);
		Main_Data.add(panel_4);
		panel_4.setLayout(null);
		
		rbMax = new JRadioButton("Show Max");
		rbMax.setBounds(8, 5, 105, 29);
		bgMaxMin.add(rbMax);
		panel_4.add(rbMax);
		
		rbMin = new JRadioButton("Show Min");
		rbMin.setBounds(118, 5, 101, 29);
		bgMaxMin.add(rbMin);
		panel_4.add(rbMin);
		
		btnMaxMin = new JButton("Go");
		btnMaxMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxMin();
			}
		});
		btnMaxMin.setBounds(52, 56, 115, 29);
		panel_4.add(btnMaxMin);
		
		btnSort = new JButton("Sort");
		btnSort.setBounds(253, 507, 115, 29);
		Main_Data.add(btnSort);
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sort();
			}
		});
		
		Records = new JPanel();
		tabbedPane.addTab("Records", null, Records, null);
		Records.setLayout(null);
		
		//button action that sets the recored to the next record.
		btnNextRecord = new JButton("Next");
		btnNextRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = Record.NEXT;
				swapRecord();
			}
		});
		btnNextRecord.setBounds(43, 104, 115, 29);
		Records.add(btnNextRecord);
		
		//button action that sets the record to the prevous record
		btnPrevousRecord = new JButton("Prevous");
		btnPrevousRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = Record.PREVOUS;
				swapRecord();
			}
		});
		btnPrevousRecord.setBounds(422, 104, 115, 29);
		Records.add(btnPrevousRecord);
		
		//button action to set the record to the first record
		btnFirstRecord = new JButton("First ");
		btnFirstRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = Record.FIRST;
				swapRecord();
			}
		});
		btnFirstRecord.setBounds(43, 237, 115, 29);
		Records.add(btnFirstRecord);
		
		//button action to set the record to the last record
		btnLastRecord = new JButton("Last");
		btnLastRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = Record.LAST;
				swapRecord();
			}
		});
		btnLastRecord.setBounds(422, 237, 115, 29);
		Records.add(btnLastRecord);
		
		FindThisRecord = new JTextField();
		FindThisRecord.setBounds(121, 415, 146, 26);
		Records.add(FindThisRecord);
		FindThisRecord.setColumns(10);
		
		//buttion action to find the desired record.
		btnFindRecord = new JButton("Find Index");
		btnFindRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = Record.SEARCH;
				swapRecord();
			}
		});
		btnFindRecord.setBounds(359, 414, 115, 29);
		Records.add(btnFindRecord);
		
		taRecord = new JTextArea();
		taRecord.setBounds(662, 59, 463, 353);
		Records.add(taRecord);
		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 1810, 77);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Crimes In Public Places In 2015");
		lblNewLabel_2.setBounds(521, 5, 768, 67);
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 55));
		panel_3.add(lblNewLabel_2);
		drawTable(dataList);
		createPieGraph();
	}
	//draws my table from a arraylist fed into it
	public void drawTable(ArrayList<Crime> table) {
		tm.setRowCount(0);
		Object[] object = new Object[14];
		
		for (Crime crime: table) {
			object[0] = crime.getIndex();
			object[1] = crime.getAreaCode();
			object[2] = crime.getAreaLocation();
			object[3] = crime.getVictims();
			object[4] = crime.getPopAtMid2015();
			object[5] = crime.getRatePer10000();
			object[6] = crime.getNzAdvrage();
			object[7] = crime.getUrbanAreaCode();
			object[8] = crime.getUrbanAreaName();
			object[9] = crime.getUrbanAreaType();
			object[10] = crime.getTerritorialCode();
			object[11] = crime.getTerritorialName();
			object[12] = crime.getRegionCode();
			object[13] = crime.getTerritorialName();
			tm.addRow(object);
		}
		
	}
	
//	public void drawTable(ArrayList<Crime> table) {
//		tm.setRowCount(0);
//		Object[] object = new Object[13];
//		
//		for (Crime crime: table) {
//			object[0] = crime.getAreaCode();
//			object[1] = crime.getAreaLocation();
//			object[2] = crime.getVictims();
//			object[3] = crime.getPopAtMid2015();
//			object[4] = crime.getRatePer10000();
//			object[5] = crime.getNzAdvrage();
//			object[6] = crime.getUrbanAreaCode();
//			object[7] = crime.getUrbanAreaName();
//			object[8] = crime.getUrbanAreaType();
//			object[9] = crime.getTerritorialCode();
//			object[10] = crime.getTerritorialName();
//			object[11] = crime.getRegionCode();
//			object[12] = crime.getTerritorialName();
//			tm.addRow(object);
//		}
//		
//	}
	
	
	//runs a sort method based on what radio button was pressed
	public void sort() {
		if (Region.isSelected()) {worker.sortByregion(dataList);}
		else if (Victims.isSelected()) {worker.sortByVictims(dataList);}
		else if (Terratory.isSelected()) {worker.sortByTerratory(dataList);}
		else if (Area.isSelected()) {worker.sortByArea(dataList);}
		
		drawTable(dataList);
	}

	//runs one of the two searches depending on what radio button was presented
	public void search() {
		ArrayList<Crime> selected = new ArrayList<Crime>();
		
		if (schAreaLocation.isSelected()) {
			worker.areaSearch(dataList, searchValue.getText(), selected);
		}
		else if (schTerratory.isSelected()) {
			worker.territorySearch(dataList, searchValue.getText(), selected);
		}
		drawTable(selected);
	}
	
	//Shows the min or max value in the table
	public void maxMin(){
		ArrayList<Crime> selected = new ArrayList<Crime>();
		if (rbMax.isSelected()) {
			worker.getMax(dataList, selected);
		}
		else if(rbMin.isSelected()) {
			worker.getMin(dataList, selected);
		}
		worker.sortByArea(selected);
		drawTable(selected);
	}
	//creates the pie chart
	public void createPieGraph() {
		DefaultPieDataset data = new DefaultPieDataset();
		int main = 0, secondary = 0, rural = 0;
		
		for (Crime crime : dataList) {
			switch (crime.getUrbanAreaType()){
				case MAIN_URBAN_AREA:
					main = main + crime.getVictims();
					break;
				case SECONDARY_URBAN_AREA:
					secondary = secondary + crime.getVictims();
					break;
				case RURAL_AREA:
					rural = rural + crime.getVictims();
					break;
			}
		}
		data.setValue(ua.MAIN_URBAN_AREA, main);
		data.setValue(ua.SECONDARY_URBAN_AREA, secondary);
		data.setValue(ua.RURAL_AREA, rural);
		
		JFreeChart chart = ChartFactory.createPieChart("Urban Area Crimes", data, true, true, Locale.ENGLISH);		
		ChartPanel pieChart = new ChartPanel(chart);
		pieChart.setVisible(true);
				
		tabbedPane.add("Urban Area Crimes Pie Graph", pieChart);
	}
	public void swapRecord() {	
		
		switch(r) {
		case NEXT:
			if (index != dataList.size() - 1) {
				index++;
			}	
			break;
		case PREVOUS:
			if (index != 0) {
				index--;
			}
			break;
		case FIRST:
			index = 0;
			break;
		case LAST:
			index = (dataList.size() - 1);
			break;
		case SEARCH:
			index = Integer.parseInt(FindThisRecord.getText())- 1;
			break;

		}

		taRecord.setText(dataList.get(index).toString());
			
	}
	

	
}
