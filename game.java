import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class game extends JComponent implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	static ArrayList<denck> dencks = new ArrayList<denck>();
	static ArrayList<bullet> playerBullets = new ArrayList<bullet>(), denckBullets = new ArrayList<bullet>();
	static ship player = new ship();
	public static Image theDenck = Toolkit.getDefaultToolkit().getImage("theDenck.jpg");
	public static Image theShip = Toolkit.getDefaultToolkit().getImage("theShip.jpg");
	public static Image theBullet = Toolkit.getDefaultToolkit().getImage("theBullet.jpg");
	static boolean weGood = false, alive = true;
	public static int leftBorder, rightBorder, denckWidth = 50, denckHeight = 50, playerWidth = 60, playerHeight = 60, bulletWidth = 30, bulletHeight = 30, frameWidth, frameHeight;
	public static int lives, score, playerFreq, currPlayer, denckFreq, currDenck;
	public static String livesDisplay;

	public game(){
		Thread t = new Thread(this);
		t.start();
		addKeyListener(this);
		setFocusable(true);
	}
	public void paint(Graphics g) {
		player.drawShip(g, this);
		for(denck tempDenck : dencks) tempDenck.drawDenck(g, this);
		for(bullet tempBullet : playerBullets) tempBullet.drawBullet(g, this);
		for(bullet tempBullet : denckBullets) tempBullet.drawBullet(g, this);
		g.setFont(g.getFont().deriveFont(1, 40));
		g.setColor(Color.white);
		g.drawString(livesDisplay, frameWidth - 210, 50);
		if(!alive){
			g.setColor(new Color(100, 100, 100, 127));
			g.drawRect(0, 0, frameWidth, frameHeight);
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dencker is better thaN EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWidth = 800;
		frameHeight = 800;
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.add(new game());
		frame.getContentPane().setBackground(Color.black);
		int numDencksInCollumn = 3, numDenckCollumns = 5, spacing = 10;
		for(int i = 0; i < numDencksInCollumn * numDenckCollumns; i++){
			int x = 10 + ((i / numDencksInCollumn) * (denckWidth + spacing));
			int y = 140 + ((i % numDencksInCollumn) * (denckHeight + spacing));
			double ranVX = 3, ranVY = 0;
			dencks.add(new denck(theDenck, x, y, ranVX, ranVY));
		}
		player = new ship(theShip, (frameWidth / 2) - (playerWidth / 2), frameHeight - 120);
		lives = 3;
		livesDisplay = "Lives: " + lives;
		playerFreq = 10;
		denckFreq = 50;
		currPlayer = 0;
		currDenck = 0;
		weGood = true;
	}
	public void run() {
		while(weGood){
			weGood = false;
			currPlayer++;
			currDenck++;
			
			for(int i = 0; i < playerBullets.size(); i++){
				if(!playerBullets.get(i).update()){
					playerBullets.remove(i);
					i--;
				}
			}
			
			
			leftBorder = dencks.get(0).hitbox.x;
			rightBorder = dencks.get(dencks.size() - 1).hitbox.x + denckWidth;
			int ranIndex = (int) (Math.random() * dencks.size());
			for(int i = 0; i < dencks.size(); i++){
				denck tempDenck = dencks.get(i);
				tempDenck.update(leftBorder, rightBorder);
				if(ranIndex == i && currDenck >= denckFreq){
					currDenck = 0;
					tempDenck.shoot();
				}
				for(int j = 0; j < playerBullets.size(); j++){
					if(playerBullets.get(j).doesHit(tempDenck.hitbox)){
						playerBullets.remove(j);
						j--;
						dencks.remove(i);
						i--;
					}
				}
			}
			
			
			for(int i = 0; i < denckBullets.size(); i++){
				bullet tempBullet = denckBullets.get(i);
				if(!tempBullet.update()){
					denckBullets.remove(i);
					i--;
				}
				else if(tempBullet.doesHit(player.hitbox)){
					denckBullets.remove(i);
					i--;
					lives--;
					livesDisplay = "Lives: " + lives;
					if(lives == 0) alive = false;
				}
			}
			
			
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			weGood = true;
		}
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
//		System.out.println(key);
		if(key == 37) player.moveLeft();
		else if(key == 39) player.moveRight();
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == 38 && currPlayer >= playerFreq){
			currPlayer = 0;
			player.shoot();
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}
}
