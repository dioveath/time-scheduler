import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimeTableWindow extends JFrame {

	TimeTablePanel timeTablePanel;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem addMenuItem;
	JMenuItem removeMenuItem;
	JFrame instance;

	public TimeTableWindow(){
		instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setUpMenu();
		timeTablePanel = new TimeTablePanel();
		addWindowListener(new MyWindowAdapter());
		add(timeTablePanel, BorderLayout.CENTER);
		setJMenuBar(menuBar);			
		setResizable(false);	
		setVisible(true);
	}
	
	public void setUpMenu(){
		menuBar = new JMenuBar();
		menu = new JMenu("TimeTable");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		addMenuItem = new JMenuItem("Add TimeTable");
		addMenuItem.addActionListener(new AddTimeTableListener());
		removeMenuItem = new JMenuItem("Remove TimeTable");
		removeMenuItem.addActionListener(new RemoveTimeTableListener());
		menu.add(addMenuItem);
		menu.add(removeMenuItem);
	}

	public class MyWindowAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e){
			timeTablePanel.saveTimeTables();
		}
	}

	public class AddTimeTableListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent){
			JTextField time = new JTextField();
			JTextField sunday = new JTextField();
			JTextField monday = new JTextField();
			JTextField tuesday = new JTextField();
			JTextField wednesday = new JTextField();
			JTextField thursday= new JTextField();
			JTextField friday = new JTextField();
			JTextField saturday = new JTextField();

			final JComponent[] inputs = new JComponent[]{
			new JLabel("Time"), time,
			new JLabel("Sunday"), sunday,
			new JLabel("Monday"), monday,
			new JLabel("Tuesday"), tuesday,
			new JLabel("Wednesday"), wednesday,
			new JLabel("Thursday"), thursday,
			new JLabel("Friday"), friday,
			new JLabel("Saturday"), saturday};
			

			int result = JOptionPane.showConfirmDialog(null, inputs, "ADD", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.OK_OPTION){
				SheetPanel sheetPanel = new SheetPanel();
				sheetPanel.setTime(time.getText());
				sheetPanel.setSubject(sunday.getText(), 0);
				sheetPanel.setSubject(monday.getText(), 1);
				sheetPanel.setSubject(tuesday.getText(), 2);
				sheetPanel.setSubject(wednesday.getText(), 3);
				sheetPanel.setSubject(thursday.getText(), 4);
				sheetPanel.setSubject(friday.getText(), 5);
				sheetPanel.setSubject(saturday.getText(), 6);
				timeTablePanel.addTimeTable(sheetPanel);
				revalidate();
			}
		}
	}

	public class RemoveTimeTableListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			JTextField indexToDeleteTextField = new JTextField();
			final JComponent[] inputs = new JComponent[] {
				new JLabel("Index of TimeTable"), indexToDeleteTextField
			};

				int result = JOptionPane.showConfirmDialog(null, inputs, "DELETE", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.OK_OPTION){
					timeTablePanel.removeSheetPanel(Integer.parseInt(indexToDeleteTextField.getText()));
					revalidate();
				}
		}
	}
}