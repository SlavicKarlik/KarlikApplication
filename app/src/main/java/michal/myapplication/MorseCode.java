package michal.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MorseCode extends AppCompatActivity {

    String result = "";
    Map<String, String> MorseCode = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse_code);


        final TextView MorseCodeOutput = (TextView) findViewById(R.id.textViewMorseCodeOutput);
        final EditText MorseCodeInput = (EditText) findViewById(R.id.editTextMorseCodeInput);
        Button MorseCodebutton = (Button) findViewById(R.id.buttonMorseCode);



        MorseCode.put("a","• —");
        MorseCode.put("b", "— • • •");
        MorseCode.put("c","— • — •");
        MorseCode.put("d","— • •");
        MorseCode.put("e","•");
        MorseCode.put("f","• • — •");
        MorseCode.put("g","— — •");
        MorseCode.put("h","• • • •");
        MorseCode.put("i","• •");
        MorseCode.put("j","• — — —");
        MorseCode.put("k","— • —");
        MorseCode.put("l","• — • •");
        MorseCode.put("m","— —");
        MorseCode.put("n","— •");
        MorseCode.put("o","— — —");
        MorseCode.put("p","• — — •");
        MorseCode.put("q","— — • —");
        MorseCode.put("r","• — •");
        MorseCode.put("s","• • •");
        MorseCode.put("t","—");
        MorseCode.put("u","• • —");
        MorseCode.put("v","• • • —");
        MorseCode.put("w","• — —");
        MorseCode.put("x","— • • —");
        MorseCode.put("y","— • — —");
        MorseCode.put("z","— — • •");
        MorseCode.put("1","• — — — —");
        MorseCode.put("2","• • — — —");
        MorseCode.put("3","• • • — —");
        MorseCode.put("4","• • • • —");
        MorseCode.put("5","• • • • •");
        MorseCode.put("6","— • • • •	");
        MorseCode.put("7","— — • • •");
        MorseCode.put("8","— — — • •");
        MorseCode.put("9","— — — — •	");
        MorseCode.put("0","— — — — —	");
        MorseCode.put("ą","• — • —•");
        MorseCode.put("ć","— • — • •");
        MorseCode.put("ę","• • — • •");
        MorseCode.put("ł","• — • • —");
        MorseCode.put("ń","— — • — —");
        MorseCode.put("ó","— — — •");
        MorseCode.put("ś","• • • — • • •");
        MorseCode.put("ż","— — • • — •");
        MorseCode.put("ź","— — • • —");
        MorseCode.put(" "," ");

        MorseCodebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = "";
                Toast toast;
                String source = String.valueOf(MorseCodeInput.getText());
                if(source.length() == 0) {
                    toast = Toast.makeText(getApplicationContext(), "Your input text was empty!", Toast.LENGTH_SHORT);
                } else{
                    source.toLowerCase();
                    char[] charArray = source.toCharArray();

                    createMorseCode(charArray);
                    MorseCodeOutput.setText(result);
                    toast = Toast.makeText(getApplicationContext(), "Your text was translated!", Toast.LENGTH_SHORT);
                }
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }
        });
    }

    protected void createMorseCode(char[] word) {
        String letter;
        for (char aWord : word) {
            letter = String.valueOf(aWord);
            result = result + MorseCode.get(letter);
        }
    }

}
