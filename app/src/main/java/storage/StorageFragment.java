package storage;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.R;
import com.example.foodapp.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StorageFragment extends Fragment {

    static List<FoodInfo> foodInfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    static FoodAdapter mAdapter;
    DatePickerDialog datePickerDialog;
    String date;
    FoodInfo foodInfo;
    String selectedDate;

    FragmentManager fm;

    public static final int REQUEST_CODE = 11; // Used to identify the result

//    private OnFragmentInteractionListener mListener;

    public StorageFragment() {
        // Required empty public constructor
    }

    public static StorageFragment newInstance() {
        StorageFragment fragment = new StorageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_storage, container, false);


        //  dateOfBirthET = view.findViewById(R.id.dateOfBirthET);

        // get fragment manager so we can launch from fragment
        fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getView().findViewById(R.id.recycler_view);

        mAdapter = new FoodAdapter(foodInfoList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(getView().getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                foodInfo = foodInfoList.get(position);

                AppCompatDialogFragment newFragment = new DatePickerFragment();
                // set the targetFragment to receive the results, specifying the request code
                newFragment.setTargetFragment(StorageFragment.this, REQUEST_CODE);
                // show the datePicker
                newFragment.show(fm, "datePicker");

                Toast.makeText(view.getContext(), foodInfo.getName() + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        // prepareFoodDate();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check for the results
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // get date from string
            selectedDate = data.getStringExtra("selectedDate");
            // set the value of the editText
            foodInfo.setDate(selectedDate);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    public static void prepareFoodDate(){
        FoodInfo food = new FoodInfo("Tesco Chicken Thigh", "27-08-2019");
        foodInfoList.add(food);

        food = new FoodInfo("Waitrose pork sausage", "27-08-2019");
        foodInfoList.add(food);

        food = new FoodInfo("Chicken Breast", "28-08-2019");
        foodInfoList.add(food);

        food = new FoodInfo("Vegetables", "29-06-2019");
        foodInfoList.add(food);

    }
}