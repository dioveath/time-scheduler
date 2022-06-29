import java.awt.*;
import javax.swing.*;

public class Cell extends JPanel {

	public JLabel label;

	public Cell() {
		this.label = new JLabel("");
		add(label);
		setBackground(Color.GREEN);
		setSize(40, 20);
	}

	public Cell(String label){
		this();
		this.label.setText(label);
	}

	public void setLabel(String label){
		this.label.setText(label);
	}	
		
	public void setBackgroundColor(Color color){
		setBackground(color);	
	}

}