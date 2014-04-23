package com.example.ghosthunter;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

import android.graphics.Rect;
import android.location.Location;


public class Ghost {
	
	private double x;
	private double y; 
	private int dx;
	private int dy;
	private Rect hitbox;
	private double msGhost;
	private Human human;
	private LatLng loc;
	private final double WIDTH = 28;
	private final double HEIGHT = 26;
	
	private double pLat;
	private double pLng;
	private double lat;
	private double lng;
	
	public Ghost(Location currentLocation) {
		pLat = currentLocation.getLatitude();
		pLng = currentLocation.getLongitude();
		
		int sX = 1, sY = 1;
		if(Math.random() < .5) sX = -1;
		if(Math.random() < .5) sY = -1;
		lng = pLng + (Math.random() * .0010 + .0008) * sX;
		lat = pLat + (Math.random() * .0018 + .0008) * sY;
		hitbox = new Rect((int)x + 30, (int)y + 30, 50, 80);
		msGhost = 10; 
	}
	
//	public void moveGhost(float elapsedTime, ArrayList<Ghost> ghosts) {
//		if(human.getX() > this.getX()) {
//			x = (x+msGhost*elapsedTime);
//			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
//		} else if(human.getX() < this.getX()) {
//			x = (x-msGhost*elapsedTime);
//			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));
//		}
//	
//		if(human.getY() > this.getY()) {
//			y = (y+msGhost*elapsedTime);
//			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));			
//		} else if(human.getY() < this.getY()) {
//			y = (y-msGhost*elapsedTime);	
//			hitbox.set((int)(x - .5 * WIDTH), (int)(y + .5 * HEIGHT), (int)(x + .5 * WIDTH), (int)(y - .5 * HEIGHT));			
//		}
//
//}

//	public boolean hitsGhost(Ghost g) {
//		return this.hitbox.intersect(g.getHitbox());
//	}

	
	
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLng() {
		return lng;
	}
	
	public LatLng getLatLng() {
		return new LatLng(lat, lng);
	}
	
	public void move() {
		lat -= .00001;
		lng -= .00001;
	}
	
	


}