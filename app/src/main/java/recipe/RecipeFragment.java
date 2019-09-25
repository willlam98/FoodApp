package recipe;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;


public class RecipeFragment extends Fragment {


    static List<Recipe> recipes = new ArrayList<>();
    static RVAdapter adapter;
    RecyclerView rv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final int REQUEST_CODE = 12; // Used to identify the result


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RecipeFragment() {
        // Required empty public constructor
    }


    public static RecipeFragment newInstance() {
        RecipeFragment fragment = new RecipeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = getView().findViewById(R.id.recycler_view_recipe);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getView().getContext());
        rv.setLayoutManager(llm);

        adapter = new RVAdapter(recipes);
        rv.setAdapter(adapter);

    }

    public static void initializeFoodRecipeData(){
        recipes.add(new Recipe("Chicken Pesto Pasta", "20", R.drawable.chickenpesto, new String[]{"Chicken", "Pasta", "Pesto Sauce"}));
        recipes.add(new Recipe("Lasagna", "30", R.drawable.lasagna, new String[]{"Lasagna noodle", "ground beef", "mozzarella"}));
        recipes.add(new Recipe("Thai Salmon Parcels", "25", R.drawable.salmon, new String[]{"Salmon", "Spring onion", "Coriander", "Rice", "Fish Sauce"}));

    }

}
