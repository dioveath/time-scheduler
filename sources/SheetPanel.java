import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SheetPanel extends JPanel implements Serializable {
	
	Cell timeCell;
	Cell subjectCells[];

	public SheetPanel(){
		timeCell = new Cell("Time");
		timeCell.setBackgroundColor(Color.YELLOW);
		add(timeCell);
		subjectCells = new Cell[7];
		for(int i = 0; i < subjectCells.length; i++){
			subjectCells[i] = new Cell("  N/A   ");
			add(subjectCells[i]);
		}		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void setTime(String time){
		timeCell.setLabel(time);
	}

	public void setSubject(String subject, int index){
		if(subject.equals("")){
			return;
		}
		System.out.println("Subject: " + subject);
		subjectCells[index].setLabel(subject);		
	}

}