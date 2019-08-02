package com.example.ravi.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.ravi.DashboardActivity;
import com.example.ravi.R;
import com.example.ravi.databinding.ActivitySignInBinding;
import com.example.ravi.utils.Util;
import com.example.ravi.utils.validator.EmptyValidator;
import com.example.ravi.utils.validator.SimpleValidator;
import com.example.ravi.utils.validator.Validator;
import com.example.ravi.viewmodel.UserViewModel;


public class SignInActivity extends AppCompatActivity {

    UserViewModel userViewModel;
    ActivitySignInBinding signInBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        userViewModel = ViewModelProviders.of(this, new UserViewModel.Factory(getApplicationContext())).get(UserViewModel.class);

        signInBinding.setListener(this);

        /*binding.setLifecycleOwner(this);

        binding.setLoginViewModel(signInViewModel);

        signInViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable LoginUser loginUser) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (!loginUser.isEmailValid()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password");
                    binding.txtPassword.requestFocus();
                }
                else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.txtPassword.setError("Enter at least 6 Digit password");
                    binding.txtPassword.requestFocus();
                }
                else {
                    binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress());
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                }

            }
        });*/

    }

    public void onSignInClick() {
        String username = signInBinding.etEmail.getText().toString();
        String password = signInBinding.etPass.getText().toString();

        if (isSignInValid(username, password)) {
            boolean isValid = userViewModel.checkValidLogin(username, password);

            if (isValid) {
                Util.displayAlertDialog(this, "Login Success", "Successfully Logged In.");
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                this.finish();
            } else {
                Util.displayAlertDialog(this, "Invalid Login", "Your login credentials are invalid.");
            }
        }
    }

    public void onSignUpClick() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private boolean isSignInValid(String username, String password) {
        Validator emptyValidator = new EmptyValidator(new SimpleValidator());
        if (!emptyValidator.validate(username)) {
            signInBinding.etEmail.setError("Please enter Username.");
            signInBinding.etEmail.requestFocus();
            return false;

        } else if (!emptyValidator.validate(password)) {
            signInBinding.etPass.setError("Please enter Password.");
            signInBinding.etPass.requestFocus();
            return false;
        }
        return true;
    }
}
