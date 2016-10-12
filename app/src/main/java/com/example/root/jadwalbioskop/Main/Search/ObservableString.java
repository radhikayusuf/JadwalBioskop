package com.example.root.jadwalbioskop.Main.Search;

import android.databinding.BaseObservable;

/**
 * Created by Varokah on 10/12/2016.
 */

public class ObservableString extends BaseObservable{
    private String value;

    public String get()
    {
        return value != null ? value : "";
    }

    public void set(String value)
    {
        if (equals(this.value, value) == false)
        {
            this.value = value;
            notifyChange();
        }
    }

    public static boolean equals(Object a, Object b)
    {
        return (a == null) ? (b == null) : a.equals(b);
    }
}
