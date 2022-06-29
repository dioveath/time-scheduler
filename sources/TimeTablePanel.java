import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TimeTablePanel extends JPanel {
	
	ArrayList<SheetPanel> allPanels;
	File saveFile = new File("time.save");
	DaysPanel daysPanel;

	public TimeTablePanel(){
		daysPanel = new DaysPanel();
		add(daysPanel);
		loadTimeTables();
		if(allPanels != null){
			for(int i = 0; i< allPanels.size(); i++){
				add(allPanels.get(i));
			}
		} else {
			allPanels = new ArrayList<SheetPanel>();
		}
	}
	

	public void loadTimeTables(){
		try {
			FileInputStream fileStream = new FileInputStream(saveFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
			allPanels = (ArrayList<SheetPanel>)objectInputStream.readObject();
		}catch(FileNotFoundException fnfe){
			System.out.println("File Not Found");
		} catch(IOException ioe){
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		} 
	}

	public void saveTimeTables(){
		try {
			FileOutputStream fileStream = new FileOutputStream(saveFile);	
			ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
			outputStream.writeObject(allPanels);
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public void reload(){
		add(allPanels.get(allPanels.size() -1 ));
		invalidate();
	}

	public void addTimeTable(SheetPanel sheetPanel){
		allPanels.add(sheetPanel);
		reload();
	}
	
	public void removeSheetPanel(int index){
		if(index >= 0 && index <= allPanels.size() -1){
			remove(allPanels.get(index));
			allPanels.remove(index);
		} else {
			JOptionPane.showMessageDialog(this, "Please Enter valid index of time table to delete");
		}
		invalidate();
		repaint();
	}

}