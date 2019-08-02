package com.example.ravi;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.ravi.databinding.ActivityDashboardBinding;
import com.example.ravi.fragment.BookingFragment;
import com.example.ravi.fragment.EditProfileFragment;
import com.example.ravi.fragment.HistoryFragment;
import com.example.ravi.viewmodel.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding dashboardBinding;
    private MainViewModel mainViewModel;
    private Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_edit_profile:
                    mainViewModel.setToolbarTitle("Edit Profile");
                    fragment = new EditProfileFragment();
                    break;

                case R.id.action_book:
                    mainViewModel.setToolbarTitle("Booking");
                    fragment = new BookingFragment();
                    break;

                case R.id.action_history:
                    mainViewModel.setToolbarTitle("History");
                    fragment = new HistoryFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        setViewModel();
        setInitialScreen();
        dashboardBinding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setInitialScreen() {
        loadFragment(new EditProfileFragment());
    }

    //switching fragment
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void setViewModel() {
        mainViewModel = new MainViewModel();
        dashboardBinding.toolbar.setToolbarVm(mainViewModel);
    }

}
