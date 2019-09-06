import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;

public class Tank {
	public static final int Xspeed = 5;
	public static final int Yspeed = 5;

	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	private boolean live = true;

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	TankClient tc;

	private boolean good;
	
	
	public boolean isGood() {
		return good;
	}

	private int x, y;
	private int OldX, OldY;
	
	private static Random r = new Random();

	private boolean bL = false, bU = false, bR = false, bD = false;

	enum Direction {
		L, LU, U, RU, R, RD, D, LD, STOP
	}

	private Direction dir = Direction.STOP;
	private Direction ptdir = Direction.D;
	
	private int step = r.nextInt(12) + 3;

	public Tank(int x, int y,boolean good) {
		this.x = x;
		this.y = y;
		this.good = good;
	}

	public Tank(int x, int y,boolean good,Direction  dir, TankClient tc) {
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if(!live) {
			if(!good) {
				tc.tanks.remove(this);
			}
		return;
		}
		
		Color c = g.getColor();
		if( good)g.setColor(Color.RED);
		else g.setColor(Color.blue);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);

		switch (ptdir) {
		case L:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT / 2);
			break;
		case LU:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);
			break;
		case U:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH/2, y);
			break;
		case RU:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
			break;
		case R:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
			break;
		case RD:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT);
			break;
		case D:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + Tank.HEIGHT);
			break;
		case LD:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT);
			break;
		}

		move();
	}

	void move() {
		
		this.OldX = x;
		this.OldY = y;
		
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
		case STOP:
			break;
		}
		if (this.dir != Direction.STOP) {
			this.ptdir = this.dir;
		}
		if(x < 0)x = 0;
		if(y < 30)y = 30;
		if(x + Tank.WIDTH > TankClient.GAME_WIDTH)x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if(y + Tank.HEIGHT > TankClient.GAME_HEIGHT)y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
	
		if(!good) {
			Direction[] dirs = Direction.values();
			if(step == 0) {
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
			dir = dirs[rn];
			}
			step--;
			
			if(r.nextInt(40) > 35) {
				 this.fire();
			}
		}
	}
	
	private void stay() {
		x = OldX;
		y = OldY;
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
			dir = Direction.L;
		else if (bL && bU && !bR && !bD)
			dir = Direction.LU;
		else if (!bL && bU && !bR && !bD)
			dir = Direction.U;
		else if (!bL && bU && bR && !bD)
			dir = Direction.RU;
		else if (!bL && !bU && bR && !bD)
			dir = Direction.R;
		else if (!bL && !bU && bR && bD)
			dir = Direction.RD;
		else if (!bL && !bU && !bR && bD)
			dir = Direction.D;
		else if (bL && !bU && !bR && bD)
			dir = Direction.LD;
		else if (!bL && !bU && !bR && !bD)
			dir = Direction.STOP;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_CONTROL:
			fire();
			break;
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
		case KeyEvent.VK_A:
			superFire();
		}
		locateDirection();

	}

	public Missile fire() {
		if(! live)return null;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, good, ptdir, this.tc);
		tc.missiles.add(m);
		return m;

	}
	
	public Missile fire(Direction dir) {
		if(! live)return null;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, good, dir, this.tc);
		tc.missiles.add(m);
		return m;
		
	}
	
	public Rectangle getRect() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public boolean colidesWithWall(Wall w) {
		if(this.live && this.getRect().intersects(w.getRect())) {
			this.dir = Direction.STOP;
			this.stay();
			return true;
		}
		return false;
	}
	
	public boolean colidesWithTanks(java.util.List<Tank> tanks) {
		for(int i = 0;i < tanks.size(); i++) {
			Tank t = tanks.get(i);
				if(this != t) {
					if(this.live && t.isLive() && this.getRect().intersects(t.getRect())) {
					this.dir = Direction.STOP;
					this.stay();
					t.stay();
					return true;
				  }
			}
		}
		return false;
	}
	
	private void superFire() {
		Direction[] dirs = Direction.values();
		for(int i = 0;i<8;i++) {
			fire(dirs[i]);
		}
	}
}
