package com.example.ghosthunter;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.os.Build;
import android.provider.Settings;
//ActionBarActivity
public class MainActivity extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
	
	private GoogleMap mMap;
	private UiSettings mUiSettings;
	//private LocationClient mLocationClient;
	
	private LocationManager service;
	private String provider;
	
	// Location Info
	private Location currentLocation;
	private double lat;
	private double lng;
	
	// Map things
	private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
	private Human player;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.menu);	

    	/**
    	//Location service code
    	service = (LocationManager) getSystemService(LOCATION_SERVICE);
    	Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    	//startActivity(intent);
    	provider = service.getBestProvider(new Criteria(), false);
    	currentLocation = service.getLastKnownLocation(provider);
    	lat = currentLocation.getLatitude();
    	lng = currentLocation.getLongitude();
    	
    	
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	//mLocationClient = new LocationClient(this, this, this);
    	//LocationManager locationManager = 
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //mapObject = new MapObject();
        
        setUpMap();
        
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
//        while(true) {
//        	for(Ghost g: ghosts) {
//        		g.move();
//        	}
//        	mMap.clear();
//        	drawGhosts();
//        }
        **/
    }

	public void play(View v)
	{
		Intent i=new Intent(this, Game.class);
		startActivity(i);
	}
	
	public void setting(View v)
	{
		Intent i=new Intent(this, SplashScreen.class);
		startActivity(i);
	}
	
	public void exit(View v)
	{
		System.exit(0);
	}
    
    private void setUpMap() {
    	
    	if (mMap == null) {
    		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
    	}
    	if (mMap != null) {
    		mMap.setMyLocationEnabled(true);
    		
	    	CameraPosition position = new CameraPosition.Builder()
	    			.target(new LatLng(lat, lng))
	    			.zoom(18)
	    			.bearing(0)
	    			.tilt(0)
	    			.build();
	    	mMap.setMapType(4);
	    	mMap.moveCamera(CameraUpdateFactory.newCameraPosition(position));
	    	
	    	mUiSettings = mMap.getUiSettings();
	    	mUiSettings.setZoomControlsEnabled(false);
	    	mUiSettings.setTiltGesturesEnabled(false);
	    	mUiSettings.setScrollGesturesEnabled(true);
	    	mUiSettings.setCompassEnabled(false);
	    	mUiSettings.setRotateGesturesEnabled(false);
	    	mUiSettings.setMyLocationButtonEnabled(true);
	    	mUiSettings.setZoomGesturesEnabled(false);
	    	
	    	generateGhosts();
	    	
	    	drawGhosts();
	    	
//	    	GroundOverlayOptions player = new GroundOverlayOptions()
//    			.image(BitmapDescriptorFactory.fromResource(R.drawable.player))
//    			.position(new LatLng(lat, lng), 14, 26);
//	    	mMap.addGroundOverlay(player);
	    	
    	}
    }

    private void generateGhosts() {
    	double x, y;
    	while (ghosts.size() < 6) {
    		ghosts.add(new Ghost(currentLocation));
    		mMap.clear();
    		drawGhosts();
    	}
    }
    
    private void drawGhosts() {
    	for (Ghost g : ghosts) {
    		mMap.addGroundOverlay(new GroundOverlayOptions()
    				.image(BitmapDescriptorFactory.fromResource(R.drawable.pinky))
    				.position(g.getLatLng(), 14, 13));
    	}
    }
    
    //Autogenerated Google Map methods
	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	


	 

}
