package com.example.practice.tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practice.R;
import com.example.practice.databinding.ActivityTabsBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabsActivity extends AppCompatActivity {

    private TabsViewPagersAdapter tabsViewPagersAdapter;
    private ActivityTabsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpAdapter();
        connectAdapter();
        connectTabsAndViewPager();
    }

    private void setUpAdapter() {
        tabsViewPagersAdapter = new TabsViewPagersAdapter(this);
    }

    private void connectAdapter() {
        binding.viewPagerVp.setAdapter(tabsViewPagersAdapter);
    }

    private void connectTabsAndViewPager() {
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabsTl, binding.viewPagerVp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 1:
                        tab.setText("Status");
                        break;
                    case 2:
                        tab.setText("Calls");
                        break;
                    case 3:
                        tab.setText("Camera");
                        break;
                    case 0:
                    default:
                        tab.setText("Chats");
                }
            }
        });
        mediator.attach();
    }
}