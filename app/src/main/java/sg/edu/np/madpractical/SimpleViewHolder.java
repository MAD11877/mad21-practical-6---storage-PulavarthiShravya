package sg.edu.np.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    TextView txt1;
    ImageView image;
    public SimpleViewHolder(View itemView){
        super(itemView); //call back up the very top parent
        image = itemView.findViewById(R.id.imageView);
        txt = itemView.findViewById(R.id.textView3); //Name
        txt1 = itemView.findViewById(R.id.textView4); //Description
    }
}
