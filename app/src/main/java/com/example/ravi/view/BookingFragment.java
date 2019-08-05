package com.example.ravi.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.ravi.R;
import com.example.ravi.base.BaseContainerFragment;
import com.example.ravi.databinding.FragmentBookingBinding;
import com.example.ravi.utils.SharePrefUtil;
import com.example.ravi.utils.Util;
import com.example.ravi.viewmodel.TrainViewModel;

public class BookingFragment extends BaseContainerFragment {

    FragmentBookingBinding bookingBinding;
    private TrainViewModel trainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bookingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false);
        bookingBinding.setListener(this);
        return bookingBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        trainViewModel = ViewModelProviders.of(getActivity(), new TrainViewModel.Factory(getActivity())).get(TrainViewModel.class);
    }

    public void onBookClick() {
        int userId = Integer.parseInt(SharePrefUtil.getUserId(getActivity()));
        trainViewModel.createTrain(userId,
                bookingBinding.arrivalTime.getSelectedItem().toString(),
                bookingBinding.departureTime.getSelectedItem().toString(),
                bookingBinding.date.getSelectedItem().toString(),
                bookingBinding.availableTrains.getSelectedItem().toString(),
                bookingBinding.price.getSelectedItem().toString(),
                bookingBinding.trainName.getSelectedItem().toString(),
                bookingBinding.availableSeats.getSelectedItem().toString());
        Toast.makeText(getActivity(), "Successfully Booked a Train.", Toast.LENGTH_SHORT).show();
    }
}
