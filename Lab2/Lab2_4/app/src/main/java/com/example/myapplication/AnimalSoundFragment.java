package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

import kotlin.io.LineReader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalSoundFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalSoundFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalSoundFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalSoundFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalSoundFragment newInstance(String param1, String param2) {
        AnimalSoundFragment fragment = new AnimalSoundFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_animal_sound, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Integer> color_src = new ArrayList<Integer>();
        color_src.add(R.color.teal_200);
        color_src.add(R.color.teal_700);
        color_src.add(R.color.purple_200);
        color_src.add(R.color.purple_500);
        color_src.add(R.color.purple_700);

        Random random = new Random();
        int i = random.nextInt(color_src.size());
        View rootView = getView();
        if(rootView != null){
            rootView.setBackgroundColor(getResources().getColor(color_src.get(i)));
        }
    }
}