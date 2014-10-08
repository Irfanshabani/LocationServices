package com.example.locationservices;

import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements LocationListener {

	LocationManager locMgr;
	TextView txtLokacioniAktiv;
	TextView txtLokacioniFundit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtLokacioniAktiv = (TextView) findViewById(R.id.txtLokacioniAktiv);
        txtLokacioniFundit = (TextView) findViewById(R.id.txtLokacioniFundit);
        
        locMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location lokacioniFundit = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        
        if (lokacioniFundit != null) {
        		txtLokacioniFundit.setText("Latitude: " + lokacioniFundit.getLatitude() + " Longitude: " + lokacioniFundit.getLongitude());
        }
    }
    
    @Override
    protected void onPause() {
    		locMgr.removeUpdates(this);
    		super.onPause();
    }
    
    @Override
    protected void onResume() {
    		//requestLocationUpdates(provider, minTime, minDistance, listener)
    		locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    		super.onResume();
    }
    
    @Override
	public void onLocationChanged(Location location) {
    		txtLokacioniAktiv.setText("Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude());
    		
//    		currentLocation = location;
//    		final Location tmpCurrLoc = location;
//
//    		Collections.sort(mStoryList, new Comparator<Story>() {
//    			@Override
//    			public int compare(Story object1, Story object2) {
//    				Location loc = new Location("Minimum Distance");
//    				loc.setLatitude(object1.getLatitude());
//    				loc.setLongitude(object1.getLongitude());
//
//    				Location loc2 = new Location("Minimum Distance");
//    				loc2.setLatitude(object2.getLatitude());
//    				loc2.setLongitude(object2.getLongitude());
//
//    				if ((tmpCurrLoc.distanceTo(loc) < tmpCurrLoc.distanceTo(loc2))) {
//    					return -1;
//    				} else if ((tmpCurrLoc.distanceTo(loc) > tmpCurrLoc.distanceTo(loc2))) {
//    					return 1;
//    				}
//
//    				return 0;
//
//    			}
//    		});
//
//
//    		storyListAdapter.notifyDataSetChanged();
    		
//			ne Adapter
//    		Location loc = new Location("Map Location");
//    		loc.setLatitude(mStoryList.get(position).getLatitude());
//    		loc.setLongitude(mStoryList.get(position).getLongitude());
//
//    		float distanceInMeters = 0; 
//
//    		if(currentLocation != null) {
//    			distanceInMeters = currentLocation.distanceTo(loc);
//    		}
//
//    		Float flt = new Float(distanceInMeters);
//
//    		if (distanceInMeters < 1000) {
//    			viewHolder.getStorySubtitle().setText(flt.intValue()+"m");
//    		} else {
//    			viewHolder.getStorySubtitle().setText(Math.round(flt.intValue() * .001) +"km");
//    		}
	}


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
