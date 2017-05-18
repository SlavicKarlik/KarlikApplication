package michal.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class FlipACoin extends AppCompatActivity {

    TextView flipTotal;
    TextView flipTail;
    TextView flipHead;
    TextView flipResult;
    int totalCount = 0;
    int headCount = 0;
    int tailCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_acoin);

        Button flipButton = (Button) findViewById(R.id.buttonFlipACoin);

        flipResult = (TextView) findViewById(R.id.textViewFlipACoinResult);
        flipHead = (TextView) findViewById(R.id.textViewFlipACoinHead);
        flipTail = (TextView) findViewById(R.id.textViewFlipACoinTail);
        flipTotal = (TextView) findViewById(R.id.textViewFlipACoinTotal);

        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random Randomizer = new Random();

                String[] coin ={"Head","Tail"};

                String flipACoinResult = coin[Randomizer.nextInt(coin.length)];

                if(flipACoinResult.equals("Head")) {
                    headCount++;
                } else {
                    tailCount++;
                }
                totalCount++;

                flipTotal.setText(getString(R.string.FlipACoinTotal, totalCount));
                flipHead.setText(getString(R.string.FlipACoinHead, headCount));
                flipTail.setText(getString(R.string.FlipACoinTail, tailCount));
                flipResult.setText(flipACoinResult);
            }
        });

    }
}
