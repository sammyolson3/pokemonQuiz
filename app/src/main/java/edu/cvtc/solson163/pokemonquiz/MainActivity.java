package edu.cvtc.solson163.pokemonquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.cvtc.solson163.pokemonquiz.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "solson163.edu.cvtc.pokemonquiz";
    public static final String NAME_MESSAGE = TAG + ".NAME_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editName = ((View) view.getParent()).findViewById(R.id.editName);
                String name = editName.getText().toString();

                Intent intent = new Intent(view.getContext(), QuestionOneActivity.class);

                intent.putExtra(NAME_MESSAGE, name);

                view.getContext().startActivity(intent);

            }
        });
    }
}