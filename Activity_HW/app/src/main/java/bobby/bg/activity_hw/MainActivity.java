package bobby.bg.activity_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText names;
    Button enterNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = (EditText) findViewById(R.id.namesEditText);
        enterNames = (Button) findViewById(R.id.enterButton);

        enterNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (names.getText().toString().matches("")){
                    names.setError("Грешни данни!");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("name", names.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
