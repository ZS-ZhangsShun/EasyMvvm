package com.zs.home.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.zs.home.mine.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment mHomeFragment = new MineFragment();
    private MineFragment mAccountFragment = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

}
