package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Global Variables
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method that checks if appropriate RadioButton is chosen
     * increments the points variable
     * @Params No parameter
     */

    // 1st Question
    public void questionOne() {

        RadioButton rb1 = (RadioButton) findViewById(R.id.reaper_radio_button);

        if ( rb1.isChecked() ) {

            points++;
            Log.v( "MainActivity", "Current points: " + points );
        }
    }

    // 2nd Question
    public void questionTwo() {

        RadioButton rb2 = ( RadioButton ) findViewById( R.id.tracer_radio_button );

        if ( rb2.isChecked() ) {

            points++;
        }
    }

    /**
     * Switch Case statement to scan for different cases of CheckBoxes being selected
     * @params view
     * Remember, a CheckBox is a boolean, true/false
     */
    // 3rd Question
    public void questionThree( View view ) {

        boolean tankCheckBox = ( (CheckBox) view).isChecked();

        //Switch case to scan which box is checked

        switch ( view.getId() ) {

            case R.id.bastion_checkbox:
                if ( tankCheckBox ) {
                    break;
                }
            case R.id.reinhardt_checkbox:
                if ( tankCheckBox ) {
                    points++;
                    break;
                }
            case R.id.winston_checkbox:
                if ( tankCheckBox ) {
                    points++;
                    break;
                }
            case R.id.kunal_checkbox:
                if ( tankCheckBox ) {
                    break;
                }
        }
    }

    /**
     * getText().toString() chained methods utilized here
     * 2 point question
     * 'equalsIgnoreCase' to ignore case
     */
    //4th Question
    public void questionFour() {

        EditText reinhardtEditText = findViewById( R.id.text_response_field_view );
        String response = reinhardtEditText.getText().toString();

        if ( response.equalsIgnoreCase( "reinhardt" ) ) {
            points = points + 2;
        }

    }
    // 5th Question
    public void questionFive() {

        RadioButton rb3 = ( RadioButton ) findViewById( R.id.soldier76_radio_button );

        if ( rb3.isChecked() ) {
            points++;
        }
    }

    // 6th Question
    public void questionSix() {

        EditText brigitteText = findViewById( R.id.text2_response_field_view );
        String response2 = brigitteText.getText().toString();

        if ( response2.equalsIgnoreCase( "brigitte" )) {
            points = points + 2;
        }
        else if ( response2.equalsIgnoreCase( "brigette" ) ) {
            points = points + 2;
        }
    }

    // 7th question
    public void questionSeven() {

        RadioButton rb4 = ( RadioButton ) findViewById( R.id.mei_radio_button );

        if ( rb4.isChecked() ) {
            points++;
        }
    }


    // Calculate Points
    public void calculatePoints() {

        questionOne();
        questionTwo();
        questionFour();
        questionFive();
        questionSix();
        questionSeven();

    }

    public void submitScore( View view ) {

        // Get userName
        EditText nameEditText = ( EditText ) findViewById( R.id.userName_field_view );
        String userName = nameEditText.getText().toString();

        //Calculate Total Points
        calculatePoints();
        String result = "Out of a maximum score of 10, agent " + userName + " scored " + points
                + "/10 points";
        Toast.makeText( this, result, Toast.LENGTH_LONG ).show();

        // Clear layout
        points = 0;
        // ( (LinearLayout) findViewById( R.id.main_layout_view ) ).setVisibility( View.GONE );

    }
}