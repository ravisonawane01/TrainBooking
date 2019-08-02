package com.example.ravi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.ravi.R;
import com.example.ravi.base.BaseContainerFragment;
import com.example.ravi.databinding.FragmentEditProfileBinding;

public class EditProfileFragment extends BaseContainerFragment {

    FragmentEditProfileBinding editProfileBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        editProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false);
        return editProfileBinding.getRoot();
    }
}
