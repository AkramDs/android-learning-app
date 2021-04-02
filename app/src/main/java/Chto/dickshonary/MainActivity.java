package Chto.dickshonary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Button button = (Button) findViewById(v.getId());
        Intent intent;

        switch((String) button.getText()) {
            case "Play":
                intent = new Intent(this, PlayActivity.class);
                startActivity(intent);

                break;
            case "Dictionary":
                    intent = new Intent(this, DictionaryActivity.class);
                    startActivity(intent);

                break;
            case "Test":

                break;
        }
    }
}
