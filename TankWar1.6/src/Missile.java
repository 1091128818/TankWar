import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Missile {
	public static final int Xspeed = 10;
	public static final int Yspeed = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	int x, y;
	  Tank.Direction dir;
	  
	  private boolean live = true;
	private TankClient tc;

	public boolean isLive() {
		return live;
	}

	public Missile(int x, int y, Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Missile(int x,int y,Tank.Direction dir,TankClient tc) {
		this(x,y,dir);
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(!live) {
			tc.missiles.remove(this);
			return;
		}
		
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillRect(x, y,WIDTH, HEIGHT);
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
			y -= Yspeed;
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
		}
		if(x<0||y<0||x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGHT) {
			live = false;
		}

	}
	
	public Rectangle getRect() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public boolean hitTank(Tank t){
		if(this.getRect().intersects(t.getRect()) && t.isLive()) {
			t.setLive(false);
			this.live  = false;
			return true;
		}
		return false;
	}
	
}
