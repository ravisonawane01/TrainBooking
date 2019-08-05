package com.example.ravi.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.example.ravi.databinding.FragmentEditProfileBinding;
import com.example.ravi.entity.UserEntity;
import com.example.ravi.utils.SharePrefUtil;
import com.example.ravi.utils.Util;
import com.example.ravi.viewmodel.UserViewModel;
import com.squareup.picasso.Picasso;

import java.io.File;

public class EditProfileFragment extends BaseContainerFragment {

    private static final int IMAGE_CODE = 102;
    FragmentEditProfileBinding editProfileBinding;
    private UserViewModel userViewModel;
    private UserEntity userEntity;
    private Uri selectedImageUri;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        editProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false);
        editProfileBinding.setListener(this);
        return editProfileBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getActivity().getApplicationContext())).get(UserViewModel.class);
        userEntity = userViewModel.getUserDetails(SharePrefUtil.getUserId(getActivity()));
        editProfileBinding.etAddress.setText(userEntity.getAddress() != null ? userEntity.getAddress() : "");
        editProfileBinding.etEmail.setText(userEntity.getEmail() != null ? userEntity.getEmail() : "");

        Uri uri = Uri.parse(userEntity.getPhoto() != null ? userEntity.getPhoto() : "");
        Picasso.with(getActivity())
                .load(new File(uri.getPath()))
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(editProfileBinding.ivEditPic);
    }

    public void onClickEvents(View view) {
        switch (view.getId()) {
            case R.id.iv_edit_pic:
                /*Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select a picture"), IMAGE_CODE);*/


                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, IMAGE_CODE);
                break;

            case R.id.btn_edit:
                String photo = null;
                if (selectedImageUri != null) {
                    photo = selectedImageUri.getPath();
                }
                userViewModel.editUser(SharePrefUtil.getUserId(getActivity()),
                        editProfileBinding.etAddress.getText().toString(),
                        editProfileBinding.etEmail.getText().toString(),
                        photo);
                Toast.makeText(getActivity(), "Successfully Updated Profile.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE_CODE
                && resultCode == Activity.RESULT_OK) {
            String path = Util.getPathFromCameraData(data, this.getActivity());
            if (path != null) {
                Picasso.with(getActivity())
                        .load(path)
                        .placeholder(R.mipmap.ic_launcher_round)
                        .error(R.mipmap.ic_launcher_round)
                        .into(editProfileBinding.ivEditPic);
            }
        }
    }
}
