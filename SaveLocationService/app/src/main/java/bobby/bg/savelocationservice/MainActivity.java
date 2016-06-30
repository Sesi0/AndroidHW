package bobby.bg.savelocationservice;

        import android.Manifest;
        import android.annotation.TargetApi;
        import android.app.ListActivity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.pm.PackageManager;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.AsyncTask;
        import android.os.Build;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.provider.Settings;
        import android.support.annotation.NonNull;
        import android.support.v4.app.ActivityCompat;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private Button button;
    private TextView textView;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private static ArrayList locations= new ArrayList();

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locations));

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                locations.add( "\n" + location.getLatitude() + " " + location.getLongitude());
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
            }, 10);
            return;
        }else{
            configureButton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        locationManager.requestLocationUpdates("gps",10000, 0, locationListener);

    }

    @Override
    protected void onStop() {
        String locsSting="";
        for (int i=0;i<locations.size();i++){
            locsSting+=locations.get(i)+ "\n";
        }
        super.onStop();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("locations", locsSting).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        String locsString=prefs.getString("locations","");
//        locations.add(locsString);
        findLoc findloc = new findLoc();
        findloc.doInBackground();
    }

    private class findLoc extends AsyncTask<String,Void,Void>{


        @Override
        protected Void doInBackground(String... params) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            String locsString=prefs.getString("locations","");
            locations.add(locsString);
            return null;
        }
    }
}

