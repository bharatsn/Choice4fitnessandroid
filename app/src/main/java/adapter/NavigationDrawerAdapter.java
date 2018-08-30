package adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.kaopo.choice4fitnessandroid.R;

import java.util.Collections;
import java.util.List;

import model.NavDrawerItem;


/**
 * Created by Ravi Tamada on 12-03-2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;

        Log.d("context",context.toString());
        Log.d("data", data.toString());
//        if(data  "Type Strain"){
//            itemView.setBackgroundColor(Color.parseColor("#000000"));
//        }

    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType ) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder;
        holder = new MyViewHolder(view);

//        if(holder.getPosition() == 0) {
//            view.setBackgroundColor(Color.parseColor("#000000"));
//            holder = new MyViewHolder(view);
//        }
//        Log.d("holdersetview", viewType+"");
//        Log.d("holdersetview", parent+"");
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());

//        if(position == 0||position == 5||position == 10) {
//            holder.itemView.setBackgroundColor(Color.parseColor("#20000000"));
//        }
//        else{
//            holder.title.setText("   "+current.getTitle());
//        }



        Log.d("holder", holder.toString());
        Log.d("current.getTitle()", current.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            Log.d("title", title.toString());

        }
    }
}
