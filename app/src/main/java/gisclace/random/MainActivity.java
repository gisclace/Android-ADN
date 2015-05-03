package gisclace.random;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {
    Random random = new Random();
    private static final String _CHAR = "ATGC "; //lettres implmentées en aléatoire


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.Gadn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView text_Random = (TextView) findViewById(R.id.adn); //génération random
                text_Random.setText(getRandomString()); //export sur textview
            }
        });
        Button btn2 = (Button) findViewById(R.id.convert); //bouton de vonvertion
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView convert = (TextView) findViewById(R.id.adn);
                TextView arn = (TextView) findViewById(R.id.arn);
                String source = convert.getText().toString();
                String newValue = source.replace("A", "U");
                newValue = newValue.replace("T", "A");
                newValue = newValue.replace("G", "K"); //le G est bouclé sur le K pour éviter une reconvertion du C en G
                newValue = newValue.replace("C", "G");
                newValue = newValue.replace("K", "C");
                arn.setText(String.valueOf(newValue)); //export de la string convertie
            }
        });
    }

    public String getRandomString(){
        TextView input = (TextView) findViewById(R.id.input);
        float v = Float.parseFloat(input.getText().toString());
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < v; i++) {
            int number = getRandomNumber();
            char ch = _CHAR.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

         private int getRandomNumber() {
        int randomInt = 0;
        randomInt = random.nextInt(_CHAR.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;

       }
    }


}



