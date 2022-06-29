import javax.swing.*;
import java.awt.*;

public class DaysPanel extends JPanel {

	String DAYS[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	Cell timeDayCell;
	Cell dayCells[];

	public DaysPanel(){
		timeDayCell = new Cell("Day/Time");
		timeDayCell.setBackgroundColor(Color.RED);
		add(timeDayCell);
		dayCells = new Cell[7];
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for(int i = 0; i < 7; i++){
			dayCells[i] = new Cell(DAYS[i]);
			add(dayCells[i]);
		}
	}

}
