package ppublicplacecrimes;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
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

public class GUI extends JFrame {


	private ArrayList<Crime> dataList = new ArrayList<Crime>();
	private Worker worker = new Worker();	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Area Code", "Area Name", "Victims", "Population at Mid 2015", "Rate Per 10,000 Population", "NZ Average Rate", "Urban Area Code", "Urban Area Lable", "Urban Area Type", "Territorial Code", "Territorial Lable", "Region Code", "Region Lable"
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
	
		dataList = worker.readFile(dataList);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1847, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 84, 1778, 456);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Main Data ", null, panel, null);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 5, 1743, 420);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		table.getColumnModel().getColumn(0).setPreferredWidth(86);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(174);
		table.getColumnModel().getColumn(4).setPreferredWidth(208);
		table.getColumnModel().getColumn(5).setPreferredWidth(136);
		table.getColumnModel().getColumn(6).setPreferredWidth(132);
		table.getColumnModel().getColumn(7).setPreferredWidth(135);
		table.getColumnModel().getColumn(8).setPreferredWidth(133);
		table.getColumnModel().getColumn(9).setPreferredWidth(122);
		table.getColumnModel().getColumn(10).setPreferredWidth(123);
		table.getColumnModel().getColumn(11).setPreferredWidth(102);
		table.getColumnModel().getColumn(12).setPreferredWidth(102);
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		panel_1.setBounds(114, 540, 137, 182);
		contentPane.add(panel_1);
		
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
		
		btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sort();
			}
		});
		btnSort.setBounds(266, 603, 115, 29);
		contentPane.add(btnSort);
		
		panel_2 = new JPanel();
		panel_2.setBounds(1359, 540, 338, 183);
		contentPane.add(panel_2);
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
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 1810, 77);
		contentPane.add(panel_3);
		
		lblNewLabel_2 = new JLabel("Crimes In Public Places In 2015");
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 55));
		panel_3.add(lblNewLabel_2);
		
		panel_4 = new JPanel();
		panel_4.setBounds(591, 566, 228, 98);
		contentPane.add(panel_4);
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
		drawTable(dataList);
	}
	//draws my table from a arraylist fed into it
	public void drawTable(ArrayList<Crime> table) {
		tm.setRowCount(0);
		Object[] object = new Object[13];
		
		for (Crime crime: table) {
			object[0] = crime.getAreaCode();
			object[1] = crime.getAreaLocation();
			object[2] = crime.getVictims();
			object[3] = crime.getPopAtMid2015();
			object[4] = crime.getRatePer10000();
			object[5] = crime.getNzAdvrage();
			object[6] = crime.getUrbanAreaCode();
			object[7] = crime.getUrbanAreaName();
			object[8] = crime.getUrbanAreaType();
			object[9] = crime.getTerritorialCode();
			object[10] = crime.getTerritorialName();
			object[11] = crime.getRegionCode();
			object[12] = crime.getTerritorialName();
			tm.addRow(object);
		}
		
	}
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
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
