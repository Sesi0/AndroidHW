package bobby.bg.activity_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {
    EditText yearset;
    EditText adresset;
    EditText cityet;
    EditText birthdayet;
    Button continuebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        yearset = (EditText) findViewById(R.id.yearsEditText);
        adresset = (EditText) findViewById(R.id.adressEditText);
        cityet = (EditText) findViewById(R.id.cityEditText);
        birthdayet = (EditText) findViewById(R.id.birthDayEditText);
        continuebtn = (Button) findViewById(R.id.continueButton);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getIntent().getStringExtra("name");
                String sYears = yearset.getText().toString();
                String sAdress = adresset.getText().toString();
                String sCity = cityet.getText().toString();
                String sDate = birthdayet.getText().toString();
                if (sYears.matches("")) {
                    yearset.setError("Грешни данни!");
                } else if (sAdress.matches("")) {
                    adresset.setError("Грешни данни!");
                } else if (sCity.matches("")) {
                    cityet.setError("Грешни данни!");
                } else if (sDate.matches("")) {
                    birthdayet.setError("Грешни данни!");
                } else {
                    Intent intent = new Intent(DetailsActivity.this, SummaryActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("years", yearset.getText().toString());
                    intent.putExtra("adress", adresset.getText().toString());
                    intent.putExtra("city", cityet.getText().toString());
                    intent.putExtra("date", birthdayet.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}



