package sen.tec.dk.threeactivities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity1 extends ActionBarActivity {

    Intent intent;
    TextView textView_TextFromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        textView_TextFromMain = (TextView)findViewById(R.id.activity1_textView_TextFromMain);

        intent = getIntent();
        textView_TextFromMain.setText(intent.getStringExtra("text") + " elsker kage");
    }
}
