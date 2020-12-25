package com.example.nideshop.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.nideshop.R;

public class HomeFragment extends Fragment {

    private Button et_search;
    private RecyclerView rv_home;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        et_search = (Button) inflate.findViewById(R.id.et_search);
        rv_home = (RecyclerView) inflate.findViewById(R.id.rv_home);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        rv_home.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        rv_home.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        linearLayoutHelper.setItemCount(2);
        linearLayoutHelper.setMarginTop(5);
        linearLayoutHelper.setMarginBottom(5);
        linearLayoutHelper.setBgColor(Color.WHITE);
    }
}