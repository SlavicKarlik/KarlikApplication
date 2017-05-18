package michal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_text);

        final EditText inputText = (EditText) findViewById(R.id.editText);
        final TextView textview = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.buttonChangeText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast;
                if(inputText.getText().toString().trim().length() == 0) {
                    textview.setText(getString(R.string.TextViewChangeText));
                    toast = Toast.makeText(getApplicationContext(), "Your input text was empty!", Toast.LENGTH_SHORT);
                } else {
                    textview.setText(inputText.getText().toString());
                    toast = Toast.makeText(getApplicationContext(), "Text has change!", Toast.LENGTH_SHORT);
                }
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();

            }
        });
    }
}
