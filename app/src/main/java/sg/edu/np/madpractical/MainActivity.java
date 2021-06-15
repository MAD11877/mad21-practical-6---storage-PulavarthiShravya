package sg.edu.np.madpractical;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends AppCompatActivity {


    //creating 20 users
    User newUser = new User("Shravya", "Hello I'm Shravya", 1, false);

    private final static String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Main Activity Created");

        Intent receivedData = getIntent();
        int randNumber = receivedData.getIntExtra("Random", 0);


        TextView name = findViewById(R.id.textView);
        TextView description = findViewById(R.id.textView2);

        //randomise
        name.setText(newUser.getName() + " " + randNumber);
        description.setText(newUser.getDescription());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (newUser.isFollowed() == false){
                    button.setText("Unfollow");
                    newUser.setFollowed(true);
                    //toast message
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_LONG).show();
                }
                else{
                    button.setText("Follow");
                    newUser.setFollowed(false);
                    //toast message
                    Toast.makeText(MainActivity.this, "Unfollwed", Toast.LENGTH_LONG).show();
                }

                //toast message
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


}