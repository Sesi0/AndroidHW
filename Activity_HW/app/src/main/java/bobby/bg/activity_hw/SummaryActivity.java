package bobby.bg.activity_hw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView infotv;
    Button showadressbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        infotv = (TextView) findViewById(R.id.infotv);
        String name = getIntent().getStringExtra("name");
        String years = getIntent().getStringExtra("years");
        final String city = getIntent().getStringExtra("city");
        final String adress = getIntent().getStringExtra("adress");
        String date = getIntent().getStringExtra("date");
        String fullInfo = name + ", " + years + ", " + city + ", " + adress + ", " + date;
        infotv.setText(fullInfo);
        showadressbtn = (Button) findViewById(R.id.showadressbtn);
        showadressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.co.in/maps?q=" + city + " " + adress));
                startActivity(mapIntent);
            }
        });
    }
}