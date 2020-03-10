package edu.cvtc.solson163.pokemonquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionOneActivity extends AppCompatActivity {

    private static final String TAG = "solson163.edu.cvtc.pokemonquiz";
    public static final String NAME_MESSAGE = TAG + ".NAME_MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

    }

    @Override
    protected void onStart(){
        super.onStart();



        final Intent intentional = this.getIntent();
        final String nameValue = intentional.getStringExtra(MainActivity.NAME_MESSAGE);


        Button q1b1 = findViewById(R.id.q1b1);
        Button q1b2 = findViewById(R.id.q1b2);
        Button q1b3 = findViewById(R.id.q1b3);
        Button q1b4 = findViewById(R.id.q1b4);

        q1b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                //final answer counter
                int fireCounter = 0;
                int waterCounter = 0;
                int electricCounter = 0;
                int bugCounter = 0;

                bugCounter += 1;

                Intent intent = new Intent(view.getContext(), QuestionTwoActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

                Toast.makeText(QuestionOneActivity.this, "Bug Counter is " + bugCounter, Toast.LENGTH_SHORT).show();
            }
        });

        q1b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //final answer counter
                int fireCounter = 0;
                int waterCounter = 0;
                int electricCounter = 0;
                int bugCounter = 0;

                waterCounter += 1;

                Intent intent = new Intent(view.getContext(), QuestionTwoActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

            }
        });

        q1b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //final answer counter
                int fireCounter = 0;
                int waterCounter = 0;
                int electricCounter = 0;
                int bugCounter = 0;

                fireCounter += 1;

                Intent intent = new Intent(view.getContext(), QuestionTwoActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

            }
        });

        q1b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //final answer counter
                int fireCounter = 0;
                int waterCounter = 0;
                int electricCounter = 0;
                int bugCounter = 0;

                electricCounter += 1;

                Intent intent = new Intent(view.getContext(), QuestionTwoActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

            }
        });
    }
}
