package edu.cvtc.solson163.pokemonquiz;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.cvtc.solson163.pokemonquiz.R;

public class MainActivity extends AppCompatActivity {


    Database myDB;


    private static final String TAG = "solson163.edu.cvtc.pokemonquiz";
    public static final String NAME_MESSAGE = TAG + ".NAME_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new Database(this);


    } // end of on create

    @Override
    protected void onStart(){
        super.onStart();

        Button btnDB = findViewById(R.id.btnDB);

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

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cursor variable being set to reference the getAllData() method from DatabaseHelper class
                Cursor res = myDB.getAllData();


                if (res.getCount() == 0) {
                    showMessage("Error", "No trainers saved.");
                    return;
                }


                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append(res.getString(1) + " is a " + res.getString(2) + " trainer.\n");
                }


                showMessage("Trainers", buffer.toString());

            }
        });
    } // end of onstart

    // builds the alert box
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}