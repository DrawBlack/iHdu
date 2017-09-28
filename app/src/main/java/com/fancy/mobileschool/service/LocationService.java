package com.fancy.mobileschool.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/**
 * Created by Jackie on 2017/9/27.
 */

@SuppressWarnings("all")
public class LocationService {

    private Context context;

    private LocationManager locationManager;

    public LocationService(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    /**
     * first check GPS if not open GPS throw excetion
     * return latitude and longgitude
     * @return
     * @throws Exception
     */
    public double[] getLocation() throws Exception{
        checkGPS();
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return new double[]{location.getLatitude(), location.getLongitude()};
    }

    private void checkGPS() throws Exception{
        if(!locationManager.getProviders(true).contains(LocationManager.GPS_PROVIDER))
            throw new Exception();
    }


}
