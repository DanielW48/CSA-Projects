import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;

public class Story extends JComponent implements MouseListener {
//	public boolean angeredOldLady;
	public static void main(String[] args) {
		JFrame frame = new JFrame(nameOfApp);
		frame.getDefaultCloseOperation();
		frame.add(new Story());
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.lightGray);
	}
	
	public static String nameOfApp = "Your Story";
	int screen = 0;
	boolean angeredOldLady;
	boolean roofCollapse = false;
	Color deadRed = new Color(131, 3, 3);
	Color successYellow = new Color(255, 230, 50);
	public int random(int range){return (int)(range * Math.random()) + 1;}
	int ranHonk;
	int ranWakeUp;
	int[] lotteryNumbers = new int[3];
	int numsPicked; int firstIndexPicked; int secondIndexPicked;
	int[] lotteryDisplay = new int[3];
	int[] lotteryInput = new int[3];
	
	public Story(){
		addMouseListener(this);
	}
	public void paint(Graphics g){
		g.setFont(getFont().deriveFont(1, 20));
		if(screen == 0) startScreen(g);
		if(screen == 1) publix(g);
		if(screen == 2) bed(g);
		if(screen == 3) miniVan(g);
		if(screen == 4) crossFire(g);
		if(screen == 5) honk(g);
		if(screen == 6) swerve(g);
		if(screen == 7) race(g);
		if(screen == 8) driveSlowly(g);
		if(screen == 9) give5(g);
		if(screen == 10) walkPast(g);
		if(screen == 11) setAlarm(g);
		if(screen == 12) goStraightToBed(g);
		if(screen == 13) walmart(g);
		if(screen == 14) chipotle(g);
		if(screen == 15) wonLottery(g);
		if(screen == 16) lostLottery(g);
		if(screen == 17) donateToPublix(g);
		if(screen == 18) buildMoonHouse(g);
		if(screen == 19) keepForSelf(g);
	}
	public void startScreen(Graphics g){
		angeredOldLady = false;
		ranHonk = random(5);
		ranWakeUp = random(8);
		int outsideNum = random(100);
		lotteryNumbers[0] = outsideNum;
		lotteryNumbers[1] = random(100);
		lotteryNumbers[2] = outsideNum;
		numsPicked  = 0; firstIndexPicked = -1; secondIndexPicked = -1;
		int randomDisplayIndex = random(3);
		lotteryDisplay[randomDisplayIndex - 1] = lotteryNumbers[1];
		for(int i = 0; i < 3; i++) if(i != randomDisplayIndex - 1) lotteryDisplay[i] = outsideNum;
		System.out.println("lotteryNumbers = "+lotteryNumbers[0]+", "+lotteryNumbers[1]+", "+lotteryNumbers[2]);
		g.setColor(Color.white);
		g.drawString("You wake up to your friend standing over you asking if you", 10, 40);
		g.drawString("want to go to Publix. What do you do?", 100, 80);
		g.drawString("Go to Publix!", 80, 160);
		g.drawString("Stay in bed", 380, 160);
	}
	public void publix(Graphics g){
		backGround(g, new Color(0, 150, 0));
		g.drawString("Your friend arrives and you go to the drawer to get your", 20, 40);
		g.drawString("keys. Which keys do you take?", 135, 80);
		g.drawString("Mini Van Keys", 80, 160);
		g.drawString("Crossfire Keys", 350, 160);
	}
	public void bed(Graphics g){
		backGround(g, new Color(0, 51, 204));
		g.drawString("Your friend leaves, and you roll over in your bed.", 60, 40);
		g.drawString("Set an alarm for 6", 65, 120);
		g.drawString("Go straight to sleep", 330, 120);
	}
	public void miniVan(Graphics g){
		backGround(g, Color.white);
		g.drawString("You drive out of the neighborhood, and pull up to a light.", 15, 40);
		g.drawString("A man in a yellow Corvette pulls up and revs his engine.", 25, 80);
		g.drawString("Race him!", 90, 160);
		g.drawString("Drive off slowly", 330, 160);
	}
	public void crossFire(Graphics g){
		backGround(g, new Color(179, 0, 0));
		g.drawString("You get in the car and drive off. When you reach the main", 15, 40);
		g.drawString("road, an old lady pulls out in front of you, going 7 mph.", 25, 80);
		g.drawString("Honk at her", 80, 160);
		g.drawString("Swerve around her", 330, 160);
	}
	public void honk(Graphics g){
		if(ranHonk == 1){
			angeredOldLady = true;
			backGround(g, deadRed);
			g.drawString("The old lady stops her car, pulls out a gun, and shoots", 30, 40);
			g.drawString("you and your friend.", 195, 80);
			g.drawString("You died. Play Again!", 190, 160);
		}
		else{
			backGround(g, successYellow);
			g.drawString("The old lady realizes that she is going too slow, and", 45, 40);
			g.drawString("pulls off the road. You realize that it is actually your", 45, 80);
			g.drawString("grandma, and she takes you home and bakes you cookies.",  15, 120);
			g.drawString("Success! Play Again!", 190, 200);
		}
	}
	public void swerve(Graphics g){
		backGround(g, deadRed);
		g.drawString("You are turning into the other lane when your car suddenly", 10, 40);
		g.drawString("explodes.", 240, 80);
		g.drawString("You died. Play Again!", 190, 160);
	}
	public void race(Graphics g){
		backGround(g, new Color(255, 90, 0));
		g.drawString("The corvette stalls, and you speed through the light. You", 20, 40);
		g.drawString("get to the Publix,", 20, 80);
		if(!roofCollapse){
			g.drawString("and walk up to the store. A man asks if", 186, 80);
			g.drawString("you want to donate to the Salvation Army.", 80, 120);
			g.drawString("Give him $5", 90, 200);
			g.drawString("Walk past him", 330, 200);
		}
		else{
			g.drawString("but it is too late. the roof has collapsed,", 186, 80);
			g.drawString("destroying the building and everyone inside.", 76, 120);
			g.drawString("Go to Walmart", 80, 200);
			g.drawString("Go to Chipotle", 370, 200);
		}
	}
	public void driveSlowly(Graphics g){
		backGround(g, deadRed);
		g.drawString("You start to accelerate, but your car runs out of gas on", 25, 40);
		g.drawString("a stretch of train tracks. The train comes and totals you.", 25, 80);
		g.drawString("You died. Play Again!", 190, 160);
	}
	public void give5(Graphics g){
		backGround(g, deadRed);
		roofCollapse = true;
		g.drawString("You are pulling $5 out of your wallet when the roof", 45, 40);
		g.drawString("collapses on both of you.", 175, 80);
		g.drawString("You died. Play Again!", 190, 160);
	}
	public void walkPast(Graphics g){
		backGround(g, successYellow);
		roofCollapse = true;
		g.drawString("You walk past him while avoiding eye contact. Right as you", 15, 40);
		g.drawString("enter the store, the roof starts to collapse. You dash back", 15, 80);
		g.drawString("to safety, but the man dies in the incident. You then spend", 15, 120);
		g.drawString("the rest of your life as an architectual engineer to improve", 15, 160);
		g.drawString("building safety.", 215, 200);
		g.drawString("Success! Play Again!", 190, 280);
	}
	public void setAlarm(Graphics g){
		backGround(g, deadRed);
		g.drawString("Your alarm goes off, and you have a heart attack.", 50, 40);
		g.drawString("You died. Play Again!", 190, 120);
	}
	public void goStraightToBed(Graphics g){
		if(ranWakeUp == 1){
			backGround(g, deadRed);
			g.drawString("You fall back alseep, but you never wake up.", 80, 40);
			g.drawString("You died. Play Again!", 190, 120);
		}
		else{
			backGround(g, new Color(255, 208, 51));
			g.drawString("You wake up just in time for dinner. You eat some leftover", 20, 40);
			g.drawString("tacos, and come across a lottery webpage on your laptop.", 20, 80);
			g.drawString("You sit down, and start filling in numbers.", 90, 120);
			g.fillRect(240, 215, 120, 35);
			for(int i = 0; i < 3; i++){
				if(i != firstIndexPicked && i != secondIndexPicked && numsPicked != 3){
					g.setColor(Color.white);
					g.fillRect(245 + (40 * i), 140, 30, 25);
					g.setColor(Color.black);
					g.drawString(lotteryDisplay[i] + "", 250 + (40 * i), 160);
				}
				g.setColor(Color.black);
				if(numsPicked >= 1) g.drawString(lotteryDisplay[firstIndexPicked] + "", 250, 240);
				if(numsPicked >= 2) g.drawString(lotteryDisplay[secondIndexPicked] + "", 290, 240);
				if(numsPicked >= 3) g.drawString(lotteryDisplay[3-(firstIndexPicked+secondIndexPicked)] + "", 330, 240);
			}
			if(numsPicked == 3){g.setColor(Color.white);g.drawString("Show me the money!", 200, 400);}
		}
	}
	public void walmart(Graphics g){
		backGround(g, successYellow);
		g.drawString("You get to Walmart and walk through the doors. A man in a", 14, 40);
		g.drawString("suit approaches you. He turns out to be the hiring manager,", 11, 80);
		g.drawString("and he offers you an interview. You accept, and they hire", 14, 120);
		g.drawString("you on the spot. You work at Walmart as a flower specialist", 10, 160);
		g.drawString(" for the rest of your life.", 180, 200);
		g.drawString("Success! Play Again!", 200, 280);
	}
	public void chipotle(Graphics g){
		backGround(g, deadRed);
		g.drawString("You go to Chipolte, and see Homei at the counter. You start", 10, 40);
		g.drawString("to order a burrito, and catch up with Homei. While you are", 18, 80);
		g.drawString("talking, Homei accidentally mistakes the black beans for rat", 13, 120);
		g.drawString("poison. When you bite into your burrito, you fall to the floor", 10, 160);
		g.drawString("and die.", 250, 200);
		g.drawString("You died! Play Again!", 190, 280);
	}
	public void wonLottery(Graphics g){
		backGround(g, new Color(33, 108, 42));
		g.drawString("Congratulations! You won the lottery! You now have 20", 20, 40);
		g.drawString("trillion dollars of extra money.", 160, 80);
		if(roofCollapse) g.drawString("Donate to Publix", 70, 160);
		else g.drawString("Build a moon house", 50, 160);
		g.drawString("Keep it for yourself", 320, 160);
	}
	public void lostLottery(Graphics g){
		backGround(g, deadRed);
		g.drawString("You lost the lottery, and begin to slip into a state of", 40, 40);
		g.drawString("crippling depression. You are so crippled that you need", 22, 80);
		g.drawString("to use a wheelchair for the next few months, and end up", 20, 120);
		g.drawString("accidentally rolling off of a cliff.", 150, 160);
		g.drawString("You died! Play Again!", 190, 240);
	}
	public void donateToPublix(Graphics g){
		backGround(g, successYellow);
		roofCollapse = false;
		g.drawString("You give all of your extra money to publix, and they", 40, 40);
		g.drawString("repair their collapsed roof. and you go down as a", 48, 80);
		g.drawString("legend in all of Publix history.", 160, 120);
		g.drawString("Success! Play Again!", 190, 200);		
	}
	public void buildMoonHouse(Graphics g){
		backGround(g, successYellow);
		g.drawString("You call NASA, and they agree to build the moon house. You", 5, 40);
		g.drawString("pack all the food for the trip and build yourself a rocket.", 22, 80);
		g.drawString("NASA launches you to the moon, where you live forever.", 22, 120);
		g.drawString("Success! Play Again!", 190, 200);
	}
	public void keepForSelf(Graphics g){
		backGround(g, deadRed);
		g.drawString("You go to the bank and make the 20 trillion dollar", 55, 40);
		g.drawString("withdrawl. Later that night, all of your neighbors show", 30, 80);
		g.drawString("up at your house, steal all your money, and impale you.", 27, 120);
		g.drawString("You died! Play Again!", 190, 200);
	}
	public void mouseClicked(MouseEvent e) {
//		System.out.println(e.getX() + ", " + e.getY());
		if(screen == 0 && e.getX() > 80 && e.getX() < 195 && e.getY() > 135 && e.getY() < 175) screen = 1;
		else if(screen == 0 && e.getX() > 380 && e.getX() < 490 && e.getY() > 135 && e.getY() < 175) screen = 2;
		else if(screen == 1 && e.getX() > 80 && e.getX() < 220 && e.getY() > 135 && e.getY() < 175) screen = 3;
		else if(screen == 1 && e.getX() > 350 && e.getX() < 490 && e.getY() > 135 && e.getY() < 175) screen = 4;
		else if(screen == 4 && e.getX() > 80 && e.getX() < 220 && e.getY() > 135 && e.getY() < 175) screen = 5;
		else if(screen == 4 && e.getX() > 330 && e.getX() < 520 && e.getY() > 135 && e.getY() < 175) screen = 6;
		else if(screen == 6 && e.getX() > 190 && e.getX() < 410 && e.getY() > 140 && e.getY() < 180) screen = 0;
		else if(screen == 3 && e.getX() > 90 && e.getX() < 190 && e.getY() > 140 && e.getY() < 180) screen = 7;
		else if(screen == 3 && e.getX() > 330 && e.getX() < 480 && e.getY() > 140 && e.getY() < 180) screen = 8;
		else if(screen == 8 && e.getX() > 190 && e.getX() < 410 && e.getY() > 140 && e.getY() < 180) screen = 0;
		else if(screen == 7){
			if(!roofCollapse){
				if(e.getX() > 90 && e.getX() < 190 && e.getY() > 180 && e.getY() < 220){screen = 9; roofCollapse = true;}
				else if(e.getX() > 330 && e.getX() < 520 && e.getY() > 180 && e.getY() < 220) screen = 10;
			}
			else{
				if(e.getX() > 75 && e.getX() < 220 && e.getY() > 180 && e.getY() < 210) screen = 13;
				else if(e.getX() > 365 && e.getX() < 510 && e.getY() > 180 && e.getY() < 210) screen = 14;
			}
		}
		else if(screen == 9 && e.getX() > 190 && e.getX() < 410 && e.getY() > 140 && e.getY() < 180) screen = 0;
		else if(screen == 10 && e.getX() > 190 && e.getX() < 410 && e.getY() > 265 && e.getY() < 295) screen = 0;
		else if(screen == 2 && e.getX() > 65 && e.getX() < 235 && e.getY() > 100 && e.getY() < 140) screen = 11;
		else if(screen == 2 && e.getX() > 330 && e.getX() < 480 && e.getY() > 100 && e.getY() < 140) screen = 12;
		else if(screen == 11 && e.getX() > 190 && e.getX() < 410 && e.getY() > 100 && e.getY() < 140) screen = 0;
		else if(screen == 12) {
			if(ranWakeUp == 1 && e.getX() > 190 && e.getX() < 410 && e.getY() > 100 && e.getY() < 140) screen = 0;
			else if(numsPicked != 3 && e.getY() > 140 && e.getY() < 165){
				if(e.getX() > 245 && e.getX() < 275){
					if(numsPicked == 0){numsPicked++;firstIndexPicked = 0;}
					else if(numsPicked == 1 && firstIndexPicked != 0){numsPicked++;secondIndexPicked = 0;}
					else if(numsPicked == 2 && firstIndexPicked != 0) numsPicked++;
				}
				else if(e.getX() > 285 && e.getX() < 315){
					if(numsPicked == 0){numsPicked++;firstIndexPicked = 1;}
					else if(numsPicked == 1 && firstIndexPicked != 1){numsPicked++;secondIndexPicked = 1;}
					else if(numsPicked == 2 && firstIndexPicked != 1) numsPicked++;
				}
				else if(e.getX() > 325 && e.getX() < 355){
					if(numsPicked == 0){numsPicked++;firstIndexPicked = 2;}
					else if(numsPicked == 1 && firstIndexPicked != 2){numsPicked++;secondIndexPicked = 2;}
					else if(numsPicked == 2 && firstIndexPicked != 2) numsPicked++;
				}
			}
			else if(numsPicked == 3 && e.getX() > 200 && e.getX() < 400 && e.getY() > 375 && e.getY() < 405){
				if(lotteryDisplay[secondIndexPicked] == lotteryNumbers[1]) screen = 15;
				else screen = 16;
			}
		}
		else if(screen == 5){
			if(angeredOldLady && e.getX() > 190 && e.getX() < 410 && e.getY() > 140 && e.getY() < 180) screen = 0;
			else if(!angeredOldLady && e.getX() > 200 && e.getX() < 400 && e.getY() > 185 && e.getY() < 215) screen = 0;
		}
		else if(screen == 13 && e.getX() > 200 && e.getX() < 400 && e.getY() > 265 && e.getY() < 295) screen = 0;
		else if(screen == 14 && e.getX() > 190 && e.getX() < 410 && e.getY() > 265 && e.getY() < 295) screen = 0;
		else if(screen == 15){
			if(roofCollapse && e.getX() > 45 && e.getX() < 240 && e.getY() > 145 && e.getY() < 175) screen = 17;
			else if(!roofCollapse && e.getX() > 45 && e.getX() < 240 && e.getY() > 145 && e.getY() < 175) screen = 18;
			else if(e.getX() > 320 && e.getX() < 580 && e.getY() > 145 && e.getY() < 175) screen = 19;
		}
		else if(screen == 16 && e.getX() > 190 && e.getX() < 410 && e.getY() > 225 && e.getY() < 255) screen = 0;
		else if(screen == 17 && e.getX() > 200 && e.getX() < 400 && e.getY() > 185 && e.getY() < 215) screen = 0;
		else if(screen == 18 && e.getX() > 200 && e.getX() < 400 && e.getY() > 185 && e.getY() < 215) screen = 0;
		else if(screen == 19 && e.getX() > 200 && e.getX() < 400 && e.getY() > 185 && e.getY() < 215) screen = 0;
		repaint();
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void backGround(Graphics g, Color c){
		g.setColor(c);
		g.fillRect(0, 0, 600, 600);
		if(c != Color.white) g.setColor(Color.white);
		else g.setColor(Color.black);
	}
}
