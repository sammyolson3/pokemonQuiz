package edu.cvtc.solson163.pokemonquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final Intent intentional = this.getIntent();

        final String nameValue = intentional.getStringExtra(QuestionFiveActivity.NAME_MESSAGE);
        int fireCounter = intentional.getIntExtra("fireCounter", 0);
        int electricCounter = intentional.getIntExtra("electricCounter", 0);
        int waterCounter = intentional.getIntExtra("waterCounter", 0);
        int bugCounter = intentional.getIntExtra("bugCounter", 0);

        //populate user input for trainer name
        final TextView trainerTextView = findViewById(R.id.textViewName);
        trainerTextView.setText(nameValue);

        final TextView resultTextView = findViewById(R.id.textViewResult);

        int highestResult = Math.max(fireCounter, Math.max(electricCounter, Math.max(waterCounter, bugCounter)));

        if (highestResult == fireCounter){
            resultTextView.setText("Fire Type Pokemon");
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else if (highestResult == electricCounter){
            resultTextView.setText("Electric Type Pokemon");
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        } else if (highestResult == waterCounter){
            resultTextView.setText("Water Type Pokemon");
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        } else {
            resultTextView.setText("Bug Type Pokemon");
        }


    }

    @Override
    protected void onStart(){
        super.onStart();
        Button restartBtn = findViewById(R.id.btnRestart);

        restartBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }));

    }
}
