package com.example.ravi.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.ravi.DashboardActivity;
import com.example.ravi.R;
import com.example.ravi.databinding.ActivitySignUpBinding;
import com.example.ravi.utils.Util;
import com.example.ravi.utils.validator.EmailValidator;
import com.example.ravi.utils.validator.EmptyValidator;
import com.example.ravi.utils.validator.PasswordValidator;
import com.example.ravi.utils.validator.SimpleValidator;
import com.example.ravi.utils.validator.Validator;
import com.example.ravi.viewmodel.UserViewModel;

public class SignUpActivity extends AppCompatActivity {

    private static final int IMAGE_CODE = 101;
    ActivitySignUpBinding signUpBinding;
    private UserViewModel userViewModel;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        userViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getApplicationContext())).get(UserViewModel.class);
        signUpBinding.setListener(this);
    }

    public void onSignUpClick() {
        String etName = signUpBinding.etName.getText().toString();
        String etAddress = signUpBinding.etAddress.getText().toString();
        String etPincode = signUpBinding.etPincode.getText().toString();
        String etMobile = signUpBinding.etMobile.getText().toString();
        String etEmail = signUpBinding.etEmail.getText().toString();
        String etUser = signUpBinding.etUser.getText().toString();
        String etPass = signUpBinding.etPass.getText().toString();

        String photo = null;
        if (selectedImageUri != null) {
            photo = selectedImageUri.getPath();
        }

        if (isSignUpInValid(etName, etAddress, etPincode, etMobile, etEmail, etUser, etPass, photo)) {
            userViewModel.createUser(etName,
                    etAddress,
                    etPincode, etMobile,
                    etEmail, etUser,
                    etPass, photo);
            Util.displayAlertDialog(this, "Success", "Successfully Created An Account.");
        }
    }

    public void onPhotoClick() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select a picture"), IMAGE_CODE);
    }

    public void onSignInBackClick() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CODE) {
            if (resultCode == RESULT_OK) {
                selectedImageUri = data.getData();
                signUpBinding.ivProfile.setImageURI(selectedImageUri);
            }
        }
    }

    private boolean isSignUpInValid(String etName, String etAddress, String etPincode,
                                    String etMobile, String etEmail, String etUser, String etPass, String photo) {
        Validator emptyValidator = new EmptyValidator(new SimpleValidator());
        Validator emailValidator = new EmptyValidator(new EmailValidator(new SimpleValidator()));
        Validator passValidator = new EmptyValidator(new PasswordValidator(new SimpleValidator()));

        if (!emptyValidator.validate(etName)) {
            signUpBinding.etName.setError("Please enter Name.");
            signUpBinding.etName.requestFocus();
            return false;

        } else if (!emptyValidator.validate(etAddress)) {
            signUpBinding.etAddress.setError("Please enter Address.");
            signUpBinding.etAddress.requestFocus();
            return false;
        }
        if (!emptyValidator.validate(etPincode)) {
            signUpBinding.etPincode.setError("Please enter PinCode.");
            signUpBinding.etPincode.requestFocus();
            return false;

        } else if (!emptyValidator.validate(etMobile)) {
            signUpBinding.etMobile.setError("Please enter Mobile.");
            signUpBinding.etMobile.requestFocus();
            return false;
        }
        if (!emailValidator.validate(etEmail)) {
            signUpBinding.etEmail.setError("Please enter Valid Email Id.");
            signUpBinding.etEmail.requestFocus();
            return false;

        } else if (!emptyValidator.validate(etUser)) {
            signUpBinding.etUser.setError("Please enter Username.");
            signUpBinding.etUser.requestFocus();
            return false;
        }
        if (!passValidator.validate(etPass)) {
            signUpBinding.etPass.setError("Please enter Valid Password.");
            signUpBinding.etPass.requestFocus();
            return false;

        } else if (!emptyValidator.validate(photo)) {
            Util.displayAlertDialog(this, "Error", "Please select Profile Picture.");
            return false;
        }
        return true;
    }
}
