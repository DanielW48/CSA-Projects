import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class ship {
	Image image;
	int shift;
	rect hitbox;
	ship(Image imageIn, int xIn, int yIn){
		image = imageIn;
		hitbox = new rect(xIn, yIn, 60, 60);
		shift = 14;
	}
	ship(){
		
	}
	public void moveLeft(){
		if(hitbox.x - shift >= 0) hitbox.x -= shift;
	}
	public void moveRight(){
		if(hitbox.x + hitbox.width + shift < game.frameWidth) hitbox.x += shift;
	}
	public void shoot(){
		game.playerBullets.add(new bullet(game.theBullet, hitbox.x + 15, hitbox.y, -16));
	}
	public boolean doesHit(bullet in){
		if(in.doesHit(hitbox)) return true;
		return false;
	}
	public void drawShip(Graphics g, ImageObserver io){
		g.drawImage(image, hitbox.x, hitbox.y, io);
	}
}
