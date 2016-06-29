package bobby.bg.savedata_p1_hw;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.HashSet;
        import java.util.Map;
        import java.util.Set;

public class RegisterActivity extends AppCompatActivity {
    EditText edit_txt_username;
    EditText edit_txt_password;
    EditText edit_txt_confirmPass;
    Button btn_create;
    Button btn_cancel;
    static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit_txt_username= (EditText) findViewById(R.id.edit_txt_username);
        edit_txt_password= (EditText) findViewById(R.id.edit_txt_password);
        edit_txt_confirmPass= (EditText) findViewById(R.id.edit_txt_confirmPass);
        btn_create= (Button) findViewById(R.id.btn_create);
        btn_cancel= (Button) findViewById(R.id.btn_cancel);
        sp= this.getPreferences(MODE_PRIVATE);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= edit_txt_username.getText().toString();
                String password = edit_txt_password.getText().toString();
                String cPassword= edit_txt_confirmPass.getText().toString();
                if(!sp.contains(username) && password.equals(cPassword)){
                    sp.edit().putString(username,password).apply();
                    Toast.makeText(RegisterActivity.this,"Registration done!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Wrong information!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
