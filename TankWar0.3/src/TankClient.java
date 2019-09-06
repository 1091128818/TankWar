import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame {

	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 35, 30, 30);
	}

	public void lauchFrame() {
		this.setLocation(400,300);
		this.setSize(800,600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() {
			
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TankClient  tc = new TankClient();
		tc.lauchFrame();
		
		

	}

}
