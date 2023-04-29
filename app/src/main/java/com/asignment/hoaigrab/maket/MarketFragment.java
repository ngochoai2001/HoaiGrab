package com.asignment.hoaigrab.maket;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RatingBar;

import com.asignment.hoaigrab.Oder.ListOderFragment;
import com.asignment.hoaigrab.base.BaseFragment;
import com.asignment.hoaigrab.databinding.DialogEvaluateBinding;
import com.asignment.hoaigrab.databinding.FragmentMaketBinding;
import com.asignment.hoaigrab.model.Table;
import com.asignment.hoaigrab.table.DetailTableFragment;

public class MarketFragment extends BaseFragment {
    private FragmentMaketBinding binding = null;
    private Table table;
    public MarketFragment() {
        // Required empty public constructor
    }

    public static MarketFragment newInstance() {
        MarketFragment fragment = new MarketFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMaketBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
        initObSever();
    }

    @Override
    public void loadData() {

    }

    @Override
    public void listening() {
        binding.icCloseLayoutStar.setOnClickListener(ic ->{
            binding.layoutStart.setVisibility(View.GONE);
        });

        binding.layoutEvaluate.setOnClickListener(layout ->{
            dialogEvaluate(getContext());
        });

        binding.tvListTableEmpty.setOnClickListener(tv ->{
            replaceFragment(FragmentListTablesToOder.newInstance());
        });
        binding.tvListOder.setOnClickListener(ic->{
            replaceFragment(ListOderFragment.newInstance());
        });

        binding.btnAddOder.setOnClickListener(v -> {
            replaceFragment(DetailTableFragment.newInstance(table));
        });

    }

    @Override
    public void initObSever() {

    }

    @Override
    public void initView() {


    }

    public void dialogEvaluate(Context context){
        final Dialog dialog = new Dialog(context);
        DialogEvaluateBinding binding = DialogEvaluateBinding.inflate(LayoutInflater.from(context));
        dialog.setContentView(binding.getRoot());

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(ratingBar.getRating() == 1){
                    binding.tvEvaluate.setText("Kém");
                }else if(ratingBar.getRating() == 2){
                    binding.tvEvaluate.setText("Trung bình");
                } else if(ratingBar.getRating() == 3){
                    binding.tvEvaluate.setText("Khá");
                } else if(ratingBar.getRating() == 4){
                    binding.tvEvaluate.setText("Tốt");
                } else if(ratingBar.getRating() == 5){
                    binding.tvEvaluate.setText("Rất tốt");
                }
            }
        });

        binding.btnCancel.setOnClickListener(button ->{
            dialog.dismiss();
        });
        binding.btnSend.setOnClickListener(button ->{


        });

        dialog.show();
    }



}