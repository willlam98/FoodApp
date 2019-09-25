package storage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> { // inner class

    private List<FoodInfo> foodInfoList;

    public class MyViewHolder extends RecyclerView.ViewHolder{ // why is the recyclerView holding eg textview, image view
        public TextView name, date;

        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.foodName);
            date = view.findViewById(R.id.expiryDate);
        }
    }

    public FoodAdapter(List<FoodInfo> foodInfoList){ // constructor
        this.foodInfoList = foodInfoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FoodInfo foodInfo = foodInfoList.get(position);
        holder.name.setText(foodInfo.getName());
        String expDate = "Expired on: " + foodInfo.getDate();

        holder.date.setText(expDate);
    }


    @Override
    public int getItemCount() {
        return foodInfoList.size();
    }
}
