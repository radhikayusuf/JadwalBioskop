package com.example.root.jadwalbioskop.Main.Fragment.ViewModel;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 11/10/16.
 */

public class SettingFragmentVM extends GitsVM{
    public Button.OnClickListener onclick;
    public SettingFragmentVM(Context context) {
        super(context);
        onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Hello Fragment", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
