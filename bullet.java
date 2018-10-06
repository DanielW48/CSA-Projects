import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class bullet {
	Image image;
	rect hitbox;
	int vY;
	bullet(Image imageIn, int xIn, int yIn, int vYIn){
		image = imageIn;
		hitbox = new rect(xIn, yIn, 30, 30);
		vY = vYIn;
	}
	public boolean update(){
		hitbox.y += vY;
		if(hitbox.y >= game.frameHeight) return false;
		return true;
	}
	public boolean doesHit(rect in){
		if((in.x <= hitbox.x + hitbox.width && in.y <= hitbox.y + hitbox.width) && (in.x + in.width >= hitbox.x && in.y + in.height >= hitbox.y)) return true;
		return false;
	}
	public void drawBullet(Graphics g, ImageObserver io){
		g.drawImage(image, hitbox.x, hitbox.y, io);
	}
}
