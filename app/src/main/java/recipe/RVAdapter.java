package recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        ImageView foodPhoto;
        ImageView greyBlock;
        TextView foodName;
        TextView time;
        TextView mainIngredient;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            foodPhoto = itemView.findViewById(R.id.foodPhoto);
            greyBlock = itemView.findViewById(R.id.greyBlock);
            foodName = itemView.findViewById(R.id.foodname);
            time = itemView.findViewById(R.id.cooking_time);
            mainIngredient = itemView.findViewById(R.id.main_ingredient);


        }
    }

    List<Recipe> recipes;
    Context context;

    public RVAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
       // this.context = context;
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_cardview, parent, false );
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.foodName.setText(recipes.get(position).name);
        String cocat = "Time: " + recipes.get(position).cookingTime + " minutes";
        holder.time.setText(cocat);
        // API 26 cocat = "Main Ingredients: " + String.join(", ", recipes.get(position).mainIngredients);
        cocat = "Main Ingredients: " + recipes.get(position).mainIngredients.toString();
        holder.mainIngredient.setText(cocat);

        holder.foodPhoto.setImageResource(recipes.get(position).photoId);

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
