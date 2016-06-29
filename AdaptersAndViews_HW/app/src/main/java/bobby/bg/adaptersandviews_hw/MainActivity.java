package bobby.bg.adaptersandviews_hw;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recView = (RecyclerView) findViewById(R.id.recView);
        assert recView != null;
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(new MyRecAdapter());
    }
}
