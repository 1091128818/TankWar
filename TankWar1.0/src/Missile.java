import java.awt.Color;
import java.awt.Graphics;

public class Missile {
	public static final int Xspeed = 10;
	public static final int Yspeed = 10;
	
	int x, y;
	Tank.Driection dir;

	public Missile(int x, int y, Tank.Driection dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 10, 10);
		g.setColor(c);

		move();
	}

	private void move() {
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
}
