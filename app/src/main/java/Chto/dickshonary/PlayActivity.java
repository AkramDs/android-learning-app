package Chto.dickshonary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int countAnswer = 6;

    private String realAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        startActivity();
    }

    private void startActivity() {
        SQLiteDatabase db = openOrCreateDatabase("OLEG", MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM summary", null);

        TextView countWords = (TextView) findViewById(R.id.countWords);
        countWords.setText(cursor.getCount());

        cursor = db.rawQuery("SELECT * FROM summary WHERE progress_rating > 9", null);

        TextView countLearnedWords = (TextView) findViewById(R.id.learnedWords);
        countLearnedWords.setText(cursor.getCount());

        cursor = db.rawQuery(
                "SELECT * FROM summary WHERE 0 ORDER BY RANDOM() LIMIT " + countAnswer,
                null);
        cursor.moveToFirst();

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);

        Button button;
        for(int i = 0; i < countAnswer; i++) {
            button = new Button(getBaseContext());
            button.setText(cursor.getString(2));
            button.setOnClickListener(this::onClick);

            layout.addView(button);
            cursor.moveToNext();

        }

        Random random = new Random();
        cursor.moveToPosition(random.nextInt(countAnswer));

        realAnswer = cursor.getString(1);

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        if(button.getText().equals("Пропустить")) {
            startActivity();

        } else {
            SQLiteDatabase db = openOrCreateDatabase("OLEG", MODE_PRIVATE, null);

            Cursor cursor = db.rawQuery("SELECT * FROM summary WHERE word = \"" + realAnswer + "\"", null);
            cursor.moveToFirst();

            if(button.getText().equals(realAnswer)) {

            }

        }
    }
}
