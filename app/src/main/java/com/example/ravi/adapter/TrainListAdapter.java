package com.example.ravi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ravi.R;
import com.example.ravi.databinding.AdapterListBinding;
import com.example.ravi.entity.TrainEntity;

import java.util.ArrayList;
import java.util.List;

public class TrainListAdapter extends RecyclerView.Adapter<TrainListAdapter.ProductViewHolder> {
    private final LayoutInflater mInflater;
    private List<TrainEntity> mtrainEntities = new ArrayList<>();

    public TrainListAdapter(Context context, List<TrainEntity> trainEntities) {
        mInflater = LayoutInflater.from(context);
        this.mtrainEntities = trainEntities;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        AdapterListBinding adapterListBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.adapter_list, viewGroup, false);
        return new ProductViewHolder(adapterListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        if (mtrainEntities != null) {
            TrainEntity trainEntity = mtrainEntities.get(position);
            holder.adapterListBinding.setTrainvm(trainEntity);
        }
    }

    public void setmProducts(List<TrainEntity> trainEntities) {
        if (mtrainEntities != null) {
            mtrainEntities.clear();
        }
        mtrainEntities.addAll(trainEntities);
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mtrainEntities != null)
            return mtrainEntities.size();
        else return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private AdapterListBinding adapterListBinding;

        public ProductViewHolder(@NonNull AdapterListBinding adapterListBinding) {
            super(adapterListBinding.getRoot());
            this.adapterListBinding = adapterListBinding;
        }
    }
}
