package edu.cvtc.solson163.pokemonquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionFiveActivity extends AppCompatActivity {

    private static final String TAG = "solson163.edu.cvtc.pokemonquiz";
    public static final String NAME_MESSAGE = TAG + ".NAME_MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

    }

    @Override
    protected void onStart(){
        super.onStart();

        final Intent intentional = this.getIntent();
        final String nameValue = intentional.getStringExtra(QuestionTwoActivity.NAME_MESSAGE);


        Button q5b1 = findViewById(R.id.q5b1);
        Button q5b2 = findViewById(R.id.q5b2);
        Button q5b3 = findViewById(R.id.q5b3);
        Button q5b4 = findViewById(R.id.q5b4);

        q5b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int fireCounter = intentional.getIntExtra("fireCounter", 0);
                int electricCounter = intentional.getIntExtra("electricCounter", 0);
                int waterCounter = intentional.getIntExtra("waterCounter", 0);
                int bugCounter = intentional.getIntExtra("bugCounter", 0);

                fireCounter += 1;

                Intent intent = new Intent(view.getContext(), ResultActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

                Log.d(TAG, String.valueOf(bugCounter));
            }
        });

        q5b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int fireCounter = intentional.getIntExtra("fireCounter", 0);
                int electricCounter = intentional.getIntExtra("electricCounter", 0);
                int waterCounter = intentional.getIntExtra("waterCounter", 0);
                int bugCounter = intentional.getIntExtra("bugCounter", 0);

                electricCounter += 1;

                Intent intent = new Intent(view.getContext(), ResultActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

            }
        });

        q5b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int fireCounter = intentional.getIntExtra("fireCounter", 0);
                int electricCounter = intentional.getIntExtra("electricCounter", 0);
                int waterCounter = intentional.getIntExtra("waterCounter", 0);
                int bugCounter = intentional.getIntExtra("bugCounter", 0);


                waterCounter += 1;

                Intent intent = new Intent(view.getContext(), ResultActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);


            }
        });

        q5b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int fireCounter = intentional.getIntExtra("fireCounter", 0);
                int electricCounter = intentional.getIntExtra("electricCounter", 0);
                int waterCounter = intentional.getIntExtra("waterCounter", 0);
                int bugCounter = intentional.getIntExtra("bugCounter", 0);


                bugCounter += 1;

                Intent intent = new Intent(view.getContext(), ResultActivity.class);

                intent.putExtra(NAME_MESSAGE, nameValue);
                intent.putExtra("fireCounter", fireCounter);
                intent.putExtra("waterCounter", waterCounter);
                intent.putExtra("electricCounter", electricCounter);
                intent.putExtra("bugCounter", bugCounter);

                view.getContext().startActivity(intent);

                Toast.makeText(QuestionFiveActivity.this, "Bug Counter is " + bugCounter, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
