package com.example.ravi.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ravi.R;
import com.example.ravi.adapter.TrainListAdapter;
import com.example.ravi.base.BaseContainerFragment;
import com.example.ravi.databinding.FragmentHistoryBinding;
import com.example.ravi.entity.TrainEntity;
import com.example.ravi.utils.SharePrefUtil;
import com.example.ravi.viewmodel.TrainViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends BaseContainerFragment {

    FragmentHistoryBinding historyBinding;
    private TrainViewModel trainViewModel;
    private TrainListAdapter adapter;
    private List<TrainEntity> mtrainEntities = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        historyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);
        return historyBinding.getRoot();
    }

    private void initRecyclerview() {
        trainViewModel.getTrainDetails(SharePrefUtil.getUserId(getActivity()))
                .observe(this, new Observer<List<TrainEntity>>() {
                    @Override
                    public void onChanged(@Nullable final List<TrainEntity> trainEntities) {
                        // Update the cached copy of the words in the adapter.
                        //adapter.setmProducts(trainEntities);
                        if (mtrainEntities != null) {
                            mtrainEntities.clear();
                        }
                        mtrainEntities.addAll(trainEntities);
                        adapter = new TrainListAdapter(getActivity(), mtrainEntities);
                        historyBinding.recyclerview.setAdapter(adapter);
                        historyBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        //adapter.setmProducts(mtrainEntities);
                    }
                });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        trainViewModel = ViewModelProviders.of(getActivity(), new TrainViewModel.Factory(getActivity())).get(TrainViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerview();
    }
}
