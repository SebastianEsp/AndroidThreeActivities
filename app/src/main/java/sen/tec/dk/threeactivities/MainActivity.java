package sen.tec.dk.threeactivities;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button button_GoToActivity1;
    Button button_GoToActivity2;
    EditText editText_Activity1Input;
    EditText editText_Activity2Input;
    ImageView imageView_cake;

    static final int REQ_ACTIVITY2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_GoToActivity1 = (Button)findViewById(R.id.main_button_GoToActivity1);
        button_GoToActivity2 = (Button)findViewById(R.id.main_button_GoToActivity2);
        editText_Activity1Input = (EditText)findViewById(R.id.main_editText_Activity1Input);
        editText_Activity2Input = (EditText)findViewById(R.id.main_editText_Activity2Input);
        imageView_cake = (ImageView)findViewById(R.id.main_imageView_Cake);

        button_GoToActivity1.setOnClickListener(this);
        button_GoToActivity2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String name = editText_Activity1Input.getText().toString();

        switch (v.getId())
        {
            case R.id.main_button_GoToActivity1:
                if (name .equals("Jan"))
                {
                    Intent intent_Activity1 = new Intent(this, Activity1.class);
                    intent_Activity1.putExtra("text", editText_Activity1Input.getText().toString());
                    editText_Activity1Input.setText("");
                    this.startActivity(intent_Activity1);
                }
                else
                {
                    Toast.makeText(this, name + " elsker ikke kage", Toast.LENGTH_LONG).show();
                }
            break;

            case R.id.main_button_GoToActivity2:
                Intent intent_Activity2 = new Intent(this, Activity2.class);
                intent_Activity2.putExtra("text", editText_Activity2Input.getText().toString());
                editText_Activity2Input.setText("");
                startActivityForResult(intent_Activity2, REQ_ACTIVITY2);
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQ_ACTIVITY2 && resultCode == Activity.RESULT_OK)
        {
            imageView_cake.setImageResource(R.drawable.cake);
        }
        else
        {
            imageView_cake.setImageResource(0);
            Toast.makeText(this, "Dirty heathen you choose to not have picture of delicious cake!", Toast.LENGTH_LONG).show();
        }
    }
}
