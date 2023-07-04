package com.example.practice.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsViewPagersAdapter extends FragmentStateAdapter {

    public TabsViewPagersAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1 :
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            case 3:
                return new CameraFragment();
            case 0:
            default:
                return new ChatsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
