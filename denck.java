import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class denck {
	Image image;
	rect hitbox;
	double vX;
	double vY;
	public denck(Image i, int startX, int startY, double startVX, double startVY){
		image = i;
		hitbox = new rect(startX, startY, 50, 50);
		vX = startVX;
		vY = startVY;
	}
	public void update(int leftBorder, int rightBorder){
		if(leftBorder <= 0 || rightBorder + vX >= game.frameWidth){
			vX *= -1;
			hitbox.y += hitbox.height;
		}
		hitbox.x += vX;
	}
	public void shoot(){
		game.denckBullets.add(new bullet(game.theBullet, hitbox.x + 10, hitbox.y + hitbox.height, 8));
	}
	public boolean doesHit(bullet in){
		if(in.doesHit(hitbox)) return true;
		return false;
	}
	public void drawDenck(Graphics g, ImageObserver io){
		g.drawImage(image, hitbox.x, hitbox.y, io);
	}
}
