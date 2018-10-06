import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class tree extends Applet implements MouseListener {
	public double size;
	public boolean paintExtras = false;
	
	public void init(){
		setSize(1200, 1000);
		setBackground(Color.cyan);
		this.addMouseListener(this);
		size = 1;
	}
	public void paint(Graphics g){
		//Palm Tree
		int width = (int) (size * 54);
		int height = (int) (size * 220);
		int x = 600;
		int y = 750 - height;
		g.setColor(new Color(220, 170, 0));
		g.fillRect(x - (width / 2), y, width, height);
		g.setColor(Color.cyan);
		width = (int) (size * 30);
		height = (int) (size * 226);
		y = 759 - height;
		int xOffset = (int) (size * 27);
		g.fillOval(x - ((width / 2) + xOffset), y - (int) (size * 4), width, height + 9);
		g.fillOval(x - ((width / 2) - xOffset), y - (int) (size * 4), width, height + 9);
		g.setColor(new Color(0, 100, 20));
		width = (int) (size * 100);
		height = (int) (size * 80);
		y -= height / 2;
		g.fillOval(x, y, width, height);
		g.fillOval(x - (width), y, width, height);
		y += height / 2;
		g.setColor(new Color(220, 170, 0));
		width = (int) (size * 54);
		g.fillRect(x - (width / 2), y, width, 80);
		g.setColor(Color.cyan);
		width = (int) (size * 86);
		height = (int) (size * 40);
		y -= height / 2;
		xOffset = (int) (size * 20);
		g.fillOval(x + xOffset, y, width, height);
		g.fillOval(x - (xOffset + width), y, width, height);
		y += height / 2;
		g.fillRect(x + xOffset, y, width, height);
		g.fillRect(x - (xOffset + width), y, width, height);
		width = (int) (size * 30);
		height = (int) (size * 226);
		y = 759 - height;
		xOffset = (int) (size * 23);
		g.fillOval(x - ((width / 2) + xOffset), y - (int) (size * 4), width, height + 9);
		g.fillOval(x - ((width / 2) - xOffset), y - (int) (size * 4), width, height + 9);
		if(paintExtras){
			g.setColor(new Color(120, 60, 0));
			g.fillOval(580, y - 15, 40, 40);
			g.fillOval(540, y - 25, 40, 40);
			g.fillOval(620, y - 25, 40, 40);
		}
		
		
		//Grass
		g.setColor(Color.green);
		g.fillRect(0, 750, 1200, 250);
		
		
		//Daniel
		g.setColor(new Color(170, 90, 0));
		g.fillRect(220 - (int)(size*20), 750 - (int)(size*200), (int)(size*40), (int)(size*200));
		g.setColor(new Color(0, 160, 0));
		g.fillOval(220 - (int)(size*60), (750 - (int)(size*200)) - (int)(size*60), (int)(size*120), (int)(size*120));
		if(paintExtras){
			g.setColor(new Color(235, 0, 0));
			g.fillOval(220 - (int)(size * 26), 750 - (int)(size*180), 30, 30);
			g.fillOval(220 - (int)(size * 11), 750 - (int)(size*240), 30, 30);
			g.fillOval(220 + (int)(size * 27), 750 - (int)(size*210), 30, 30);
		}
		
		
		//Andrew
		g.setColor(new Color(120, 60, 0));
		g.fillRect(980 - (int)(size*24), 750 - (int)(size*200), (int)(size*48), (int)(size*200));
		g.setColor(new Color(0, 110, 0));
		g.fillOval(980 - (int)(size*70), (750 - (int)(size*200)) - (int)(size*70), (int)(size*140), (int)(size*140));
		if(paintExtras){
			g.setColor(Color.BLACK);
			g.fillOval(960, 520, 40, 60);
		}		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(size <= 2){
			size += .25;
		}
		else{
			paintExtras = true;
		}
		repaint();
		//System.out.println("(" + e.getX() + ", " + e.getY() + ")");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		size = size - .25;
		paintExtras = false;
		repaint ();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}

//Old Code (Easier)

//Left Tree
//width = (int) (size * 40);
//height = (int) (size * 200);
//x = 220;
//y = 750 - height;
//g.fillRect(x - (width / 2), y, width, height);
//width = (int) (size * 120);
//g.fillOval(x - (width / 2), y - (width / 2), width, width);

//Right Tree
//width = (int) (size * 47);
//height = (int) (size * 200);
//x = 980; 
//y = 750 - height;
//g.fillRect(x - (width / 2), y, width, height);
//width = (int) (size * 140);
//g.fillOval(x-(width / 2), y-(width / 2), width, width);
//width = 34;
//g.fillOval(x - (width / 2), 520, width, 50);
