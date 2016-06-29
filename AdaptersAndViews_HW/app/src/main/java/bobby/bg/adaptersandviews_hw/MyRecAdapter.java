package bobby.bg.adaptersandviews_hw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        MyViewHolder vh;
        vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtDate.setText("dastard's");
    }



    @Override
    public int getItemCount() {
        return 16;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtPlace;
        TextView txtDate;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtPlace = (TextView) itemView.findViewById(R.id.txt_place);
            txtDate = (TextView) itemView.findViewById(R.id.txt_date);

        }
    }
}
