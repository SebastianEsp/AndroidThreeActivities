package sen.tec.dk.threeactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Activity2 extends ActionBarActivity implements View.OnClickListener {

    Intent intent;
    TextView textView_TextFromMain;
    Button button_Return;
    RadioGroup radioGroup_YesNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        textView_TextFromMain = (TextView)findViewById(R.id.activity2_textView_TextFromMain);
        button_Return = (Button)findViewById(R.id.activity2_button_Return);
        radioGroup_YesNo = (RadioGroup)findViewById(R.id.activity2_radioGroup_YesNo);

        intent = getIntent();
        textView_TextFromMain.setText("Du bruger størelse " + getIntent().getStringExtra("text") + " i sko");

        button_Return.setOnClickListener(this);
    }

    private void getRadioChoice()
    {
        switch (radioGroup_YesNo.getCheckedRadioButtonId())
        {
            case R.id.activity2_radioGroup_Yes:
                setResult(Activity.RESULT_OK);
            break;

            case R.id.activity2_radioGroup_No:
                setResult(Activity.RESULT_CANCELED);
            break;
        }
        finish();
    }

    @Override
    public void onClick(View v)
    {
        getRadioChoice();
    }

    @Override
    public void onVisibleBehindCanceled()
    {
        getRadioChoice();
    }
}
