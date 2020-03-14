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

    Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        myDB = new Database(this);


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
            //getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else if (highestResult == electricCounter){
            resultTextView.setText("Electric Type Pokemon");
            //getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        } else if (highestResult == waterCounter){
            resultTextView.setText("Water Type Pokemon");
            //getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        } else {
            resultTextView.setText("Bug Type Pokemon");
        }


    }

    @Override
    protected void onStart(){
        super.onStart();
        Button restartBtn = findViewById(R.id.btnRestart);

        final Intent intentional = this.getIntent();
        final String nameValue = intentional.getStringExtra(QuestionFiveActivity.NAME_MESSAGE);
        int fireCounter = intentional.getIntExtra("fireCounter", 0);
        int electricCounter = intentional.getIntExtra("electricCounter", 0);
        int waterCounter = intentional.getIntExtra("waterCounter", 0);
        int bugCounter = intentional.getIntExtra("bugCounter", 0);



        int highestResult = Math.max(fireCounter, Math.max(electricCounter, Math.max(waterCounter, bugCounter)));

        final String trainer;

        if (highestResult == fireCounter){
            trainer = "Fire Type Pokemon";
            //getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else if (highestResult == electricCounter){
            trainer = "Electric Type Pokemon";
            //getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        } else if (highestResult == waterCounter){
            trainer = "Water Type Pokemon";
            //getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        } else {
            trainer = "Bug Type Pokemon";
        }


        restartBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDB.insertData(nameValue,
                        trainer);

                if (isInserted) {
                    Toast.makeText(view.getContext(), "Data inserted.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext(), "Data not inserted.", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }));

    }
}
