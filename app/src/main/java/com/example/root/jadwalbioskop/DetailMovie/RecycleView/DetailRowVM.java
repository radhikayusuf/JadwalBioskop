package com.example.root.jadwalbioskop.DetailMovie.RecycleView;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.root.jadwalbioskop.API.dao.JadwalDao;
import com.example.root.jadwalbioskop.databinding.CardDetailRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Varokah on 10/12/2016.
 */

public class DetailRowVM extends GitsRowVM<JadwalDao,CardDetailRowBinding>{
    public ObservableField<String> Bioskop = new ObservableField<>();
    public ObservableField<String> harga = new ObservableField<>();
    public ObservableField<String> time = new ObservableField<>();
    StringBuffer pukul = new StringBuffer();
    public DetailRowVM(Context context, CardDetailRowBinding binding, JadwalDao data) {
        super(context, binding, data);

        Bioskop.set(data.getBioskop());
        harga.set(data.getHarga());

        for(int i = 0;i < data.getJam().size() ; i++){
            pukul.append(data.getJam().get(i));
            if(i < data.getJam().size() - 1){
                pukul.append(", ");
            }
        }
        time.set(pukul.toString());
    }
}
