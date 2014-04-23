package com.example.ghosthunter;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MapObject extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {

	private GoogleMap mMap;
	private UiSettings mUiSettings;
	private LocationClient mLocationClient;
	
	private LatLng currentLocation = new LatLng(38.031616, -79.510703);
	
	private CameraPosition cameraPosition;
	
	private ArrayList<GroundOverlayOptions> groundOverlays = new ArrayList<GroundOverlayOptions>();
	
	//Things to draw
	private ArrayList<Ghost> ghosts;
	private Human human;
	private GroundOverlayOptions overlayOptions;
	
	public MapObject() {
		setUpMap();
	}
	
	private void setUpMap() {
		if (mMap == null) {
    		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
    	}
//    	if (mMap != null) {
//    		mMap.setMyLocationEnabled(true);
//    		mMap.setMapType(4);
//    		
//    		setUpCamera();
//	    	
//    		setUpUi();
//	    	
//    		setUpGroundOverlays();
//	    	
//	    	addGroundOverlays();
//    	}
	}
	
	private void setUpCamera() {
    	cameraPosition = new CameraPosition.Builder()
		.target(currentLocation)
		.zoom(18)
		.bearing(0)
		.tilt(0)
		.build();
    	mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}
	
	private void setUpUi() {
		mUiSettings = mMap.getUiSettings();
    	mUiSettings.setZoomControlsEnabled(false);
    	mUiSettings.setTiltGesturesEnabled(false);
    	mUiSettings.setScrollGesturesEnabled(true);
    	mUiSettings.setCompassEnabled(false);
    	mUiSettings.setRotateGesturesEnabled(false);
    	mUiSettings.setMyLocationButtonEnabled(true);
    	mUiSettings.setZoomGesturesEnabled(false);
	}
	
	private void setUpGroundOverlays() {
    	GroundOverlayOptions player = new GroundOverlayOptions()
			.image(BitmapDescriptorFactory.fromResource(R.drawable.player))
			.position(new LatLng(currentLocation.latitude, currentLocation.longitude), 14, 26);
    	groundOverlays.add(player);
    	
    	GroundOverlayOptions pinky = new GroundOverlayOptions()
			.image(BitmapDescriptorFactory.fromResource(R.drawable.pinky))
			.position(new LatLng(currentLocation.latitude + .0005, currentLocation.longitude + .0004), 14, 13);
    	groundOverlays.add(pinky);
    	
    	GroundOverlayOptions inky = new GroundOverlayOptions()
			.image(BitmapDescriptorFactory.fromResource(R.drawable.pinky))
			.position(new LatLng(currentLocation.latitude - .0009, currentLocation.longitude + .001), 14, 13);
    	groundOverlays.add(inky);
    	
    	GroundOverlayOptions blinky = new GroundOverlayOptions()
			.image(BitmapDescriptorFactory.fromResource(R.drawable.pinky))
			.position(new LatLng(currentLocation.latitude + .0003, currentLocation.longitude + .0009), 14, 13);
    	groundOverlays.add(blinky);
    	
    	GroundOverlayOptions clyde = new GroundOverlayOptions()
			.image(BitmapDescriptorFactory.fromResource(R.drawable.pinky))
			.position(new LatLng(currentLocation.latitude + .0012, currentLocation.longitude - .0009), 14, 13);
    	groundOverlays.add(clyde);
	}
	
	private void addGroundOverlays() {
		for(GroundOverlayOptions o : groundOverlays)
			mMap.addGroundOverlay(o);
	}

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
