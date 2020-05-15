package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar mySeekBar;
     ListView myListView;


   public void generateTable(int tableNo){
       ArrayList<String> myArray = new ArrayList<String>();
       for(int j =1;j<=30;j++)
       {
           myArray.add(Integer.toString(tableNo*j));
       }
       ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArray);
       myListView.setAdapter(myArrayAdapter);


   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);
        mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(5);
        generateTable(5);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               int min=1;
                int currentSeek;
                if(progress<min)
                {
                    currentSeek = min;
                    mySeekBar.setProgress(min);
                }
                else
                    currentSeek = progress;

               generateTable(currentSeek);
            //  Log.i("seeked value:",Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
