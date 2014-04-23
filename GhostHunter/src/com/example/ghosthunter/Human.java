package com.example.ghosthunter;

import android.graphics.Rect;


public class Human {
	
	private double x; 
	private double y;
	public double targetX;
	public double targetY;
	//private int numBombs;
	private Rect hitbox;
	private int msHuman;
	//TODO Fix width/height
	private final double WIDTH = 40;
	private final double HEIGHT = 40;
	
	public Human() {
		x = y = 300; 
		hitbox = new Rect((int)x + 10, (int)y + 10, 40, 40);	
		msHuman = 20;
	}
	
	public void moveHuman(float elapsedTime) {
	
		if(targetX > this.getX()) {
			x = (x+msHuman*elapsedTime);
			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
		} else if(targetX < this.getX()) {
			x = (x-msHuman*elapsedTime);
			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
		}	
		
		if(targetY > this.getY()) {
			y = (y+msHuman*elapsedTime);
			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
		} else if(targetY < this.getY()) {
			y = (y-msHuman*elapsedTime);
			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
		}
		
	}
	
	public double getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public double getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}

//	public boolean hitsZombie(Ghost g) {
//		return hitbox.intersect(g.getHitbox()); 
//	}

	public double getX() {
		return x;
	}
	
	public void increasemsHuman() {
		msHuman += 20; 
	}

//	public boolean hitsMushroom(Mushroom m) {
//		return hitbox.intersects(m.getHitbox());
//	}
	
	public int getMsHuman() {
		return msHuman;
	}

	public void setMsHuman(int msHuman) {
		this.msHuman = msHuman;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

//	public int getMoveSpeed() {
//		return moveSpeed;
//	}
//
//	public void setMoveSpeed(int moveSpeed) {
//		this.moveSpeed = moveSpeed;
//	}

//	public int getNumBombs() {
//		return numBombs;
//	}
//
//	public void setNumBombs(int numBombs) {
//		this.numBombs = numBombs;
//	}

	public Rect getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rect hitbox) {
		this.hitbox = hitbox;
	}

}
