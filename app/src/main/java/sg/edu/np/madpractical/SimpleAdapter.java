package sg.edu.np.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;


public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
    ArrayList<User> data;
    Context context;

    public SimpleAdapter(ArrayList<User> input){
        data = input;
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0)
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview,parent,false);
        }
        else
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplerecyclerview2,parent,false);
        }
        return new SimpleViewHolder(item);
    }


    public void onBindViewHolder(SimpleViewHolder holder, int position){//put data inside
        User info = data.get(position); //at which position of the array
        holder.txt.setText(info.getName());
        holder.txt1.setText((info.getDescription()));
        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Profile");
                builder.setMessage(info.getName());
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Bundle bundle = new Bundle();
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });

                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            }
        });
    }

    public int getItemCount(){
        return data.size();
    }

    @Override
    public int getItemViewType(int position){
        String name = data.get(position).getName();
        int id = Integer.parseInt(name.substring(name.length() - 1));
        if(id == 7)
        {
            return 0;
        }
        return 1;
    }
}

