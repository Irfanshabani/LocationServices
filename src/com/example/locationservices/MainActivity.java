package com.example.locationservices;

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
