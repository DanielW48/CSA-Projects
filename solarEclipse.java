import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

//Daniel and Homei
//8/28
public class solarEclipse extends Applet implements Runnable {
	
	double counter;
	double radians;
	int R = 0;
	int G = 204;
	int B = 255;
	int xRotation;
	int yRotation;
	int radius;
	int xCenter;
	int yCenter;
	int size;
	int xCenter2;
	int yCenter2;
	int size2;
	
	public void init(){
		Thread t = new Thread(this);
		t.start();
		counter = 180;
		radians = Math.PI;
		xRotation = 500;
		yRotation = 1100;
		radius = 750;
		xCenter = xRotation + (int) (radius * Math.cos(radians));
		yCenter = yRotation + (int) (radius * Math.sin(radians));
		size = 110;
		xCenter2 = 500;
		yCenter2 = 350;
		size2 = 110;
		setSize(800, 800);
		setBackground(new Color(R, G, B));
	}
	public void paint(Graphics g){
		double d = Math.abs(Math.sqrt(Math.pow(xCenter - xCenter2, 2) + Math.pow(yCenter - yCenter2, 2)));
		if(d > (size / 2) + (size2 / 2)){
			d = (size / 2) + (size2 / 2);
		}
		double ratio = d / ((size / 2) + (size2 / 2));
//		System.out.println(ratio);
		int normR = 0;
		int newR = 224;
		int normG = 204;
		int newG = 120;
		int normB = 255;
		int newB = 0;
		R = newR+(int)(ratio*(normR-newR));
		G = newG+(int)(ratio*(normG-newG));
		B = newB+(int)(ratio*(normB-newB));
		g.setColor(new Color(R, G, B));
		g.fillRect(0, 0, 800, 800);
		normR = 230;
		newR = 250;
		normG = 210;
		newG = 230;
		normB = 0;
		newB = 20;
		g.setColor(new Color(newR+(int)(ratio*(normR-newR)), newG+(int)(ratio*(normG-newG)), newB+(int)(ratio*(normB-newB))));
		g.fillOval(xCenter2 - (size2 / 2), yCenter2 - (size2 / 2), size2, size2);
		normR = 200;
		newR = 50;
		normG = 200;
		newG = 50;
		normB = 200;
		newB = 50;
		g.setColor(new Color(newR+(int)(ratio*(normR-newR)), newG+(int)(ratio*(normG-newG)), newB+(int)(ratio*(normB-newB))));
		g.fillOval(xCenter - (size / 2), yCenter - (size / 2), size, size);
		normR = 0;
		newR = 100;
		normG = 128;
		newG = 121;
		normB = 43;
		newB = 81;
		g.setColor(new Color(newR+(int)(ratio*(normR-newR)), newG+(int)(ratio*(normG-newG)), newB+(int)(ratio*(normB-newB))));
		int size3 = 3100;
		g.fillOval(500 - (size3 / 2), 2200 - (size3 / 2), size3, size3);
	}
	public void run() {
		while(true){
			counter += .1;
			radians = Math.toRadians(counter);
			xCenter = xRotation + (int) (radius * Math.cos(radians));
			yCenter = yRotation + (int) (radius * Math.sin(radians));
			try {
				Thread.sleep(18);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}
