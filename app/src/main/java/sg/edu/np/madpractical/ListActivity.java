package sg.edu.np.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Attributes;


public class ListActivity extends AppCompatActivity {
    private final static String TAG = "ListActivity";
    ArrayList<User> myList = new ArrayList<>(); //making a list, defining that the list is a string

    RecyclerView recyclerView;
    ImageView imageView;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //adding random users into a list & creating objects
        for (int i = 0; i < 21; i++) {
            User newUser = new User("Name - " + randInt(), "Description " + randInt(), i, randInt() % 2 == 1);
            myList.add(newUser);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SimpleAdapter sAdapter = new SimpleAdapter(myList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
    }


    //generating random names & numbers + des
    private static int randInt() {
        Random n = new Random();
        return (n.nextInt());

    }

    private void userClick(){
        builder = new AlertDialog.Builder(this);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Random randNumber = new Random();
                        int ranValue = randNumber.nextInt();
                        Bundle bundle = new Bundle();
                        bundle.putInt("Random", ranValue);;
                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
                        intent.putExtras(bundle);
                        Log.v(TAG, "Random number is" + ranValue);

                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }

}