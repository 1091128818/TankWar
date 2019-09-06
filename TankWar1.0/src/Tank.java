import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	public static final int Xspeed = 5;
	public static final int Yspeed = 5;
	int x, y;

	private boolean bL = false, bU = false, bR = false, bD = false;

	enum Driection {
		L, LU, U, RU, R, RD, D, LD, STOP
	}

	private Driection dir = Driection.STOP;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);

		move();
	}

	void move() {
		switch (dir) {
		case L:
			x -= Xspeed;
			break;
		case LU:
			x -= Xspeed;
			y -= Yspeed;
			break;
		case U:
			y += Yspeed;
			break;
		case RU:
			x += Xspeed;
			y -= Yspeed;
			break;
		case R:
			x += Xspeed;
			break;
		case RD:
			x += Xspeed;
			y += Yspeed;
			break;
		case D:
			y += Yspeed;
			break;
		case LD:
			x -= Xspeed;
			y += Yspeed;
			break;
		case STOP:
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		}
		locateDirection();
	}

	void locateDirection() {
		if (bL && !bU && !bR && !bD)
			dir = Driection.L;
		else if (bL && bU && !bR && !bD)
			dir = Driection.LU;
		else if (!bL && bU && !bR && !bD)
			dir = Driection.U;
		else if (!bL && bU && bR && !bD)
			dir = Driection.RU;
		else if (!bL && !bU && bR && !bD)
			dir = Driection.R;
		else if (!bL && !bU && bR && bD)
			dir = Driection.RD;
		else if (!bL && !bU && !bR && bD)
			dir = Driection.D;
		else if (bL && !bU && !bR && bD)
			dir = Driection.LD;
		else if (!bL && !bU && !bR && !bD)
			dir = Driection.STOP;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		}
		locateDirection();
		
	}
}
