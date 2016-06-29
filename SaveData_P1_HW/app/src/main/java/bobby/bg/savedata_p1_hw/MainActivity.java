package bobby.bg.savedata_p1_hw;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit_txt_user;
    EditText edit_txt_pass;
    Button btn_signin;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_txt_user = (EditText) findViewById(R.id.edit_txt_user);
        edit_txt_pass= (EditText) findViewById(R.id.edit_txt_pass);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signup= (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername=edit_txt_user.getText().toString();
                String inputPassword=edit_txt_pass.getText().toString();
                if(RegisterActivity.sp!=null && RegisterActivity.sp.contains(inputUsername) && RegisterActivity.sp.getString(inputUsername,"none").equals(inputPassword)){
                    Intent intent = new Intent(MainActivity.this,LoggedActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Wrong information",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
