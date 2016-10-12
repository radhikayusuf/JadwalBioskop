package com.example.root.jadwalbioskop.Main.Fragment.ViewModel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.EditText;

import com.example.root.jadwalbioskop.API.Kota.KotaResponse;

import com.example.root.jadwalbioskop.API.dao.DetailKotaDao;
import com.example.root.jadwalbioskop.API.dao.KotaDao;
import com.example.root.jadwalbioskop.Dagger.Injector;
import com.example.root.jadwalbioskop.Main.Fragment.RecyclerViewSetting.ContentAdapter;
import com.example.root.jadwalbioskop.Main.KotaRequest;
import com.example.root.jadwalbioskop.Main.Search.ObservableString;
import com.example.root.jadwalbioskop.Main.Search.TextWatcherAdapter;
import com.example.root.jadwalbioskop.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 11/10/16.
 */

public class ContentFragmentVM extends GitsVM {


    public ObservableString observableString = new ObservableString();
    public static ContentAdapter rcAppAdapter;
    List<KotaRequest.KotaViewResponse> mDataKota;
    public static List<DetailKotaDao> detailKotaDaos = new ArrayList<>();
    public static List<DetailKotaDao> detailKotabackup = new ArrayList<>();
    public LinearLayoutManager bGridLayoutManager;

    @Inject
    KotaRequest kotaRequest;

    public ContentFragmentVM(Context context) {
        super(context);
        Injector.component.Inject(this);

        rcAppAdapter = new ContentAdapter(detailKotaDaos);
        bGridLayoutManager = new LinearLayoutManager(mContext);

        kotaRequest.requestKota()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<KotaRequest.KotaViewResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e( "onCompleted: ","complete" );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e( "onError: ",e.toString() );

                    }

                    @Override
                    public void onNext(KotaRequest.KotaViewResponse kotaViewResponse) {
                        detailKotabackup.clear();
                        detailKotabackup.addAll(kotaViewResponse.datas);
                        detailKotaDaos.clear();
                        detailKotaDaos.addAll(kotaViewResponse.datas);
                        //mDataKota.add(kotaViewResponse);
                        rcAppAdapter.notifyDataSetChanged();
                    }
                });
    }

    @BindingAdapter({"binding"})
    public static void bindEditText(EditText view, final ObservableString observableString)
    {
        if (view.getTag(R.id.binded) == null)
        {
            view.setTag(R.id.binded, true);
            view.addTextChangedListener(new TextWatcherAdapter()
            {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    //detailKotabackup.addAll(detailKotaDaos);
                    detailKotaDaos.clear();
                    observableString.set(s.toString());
                    detailKotaDaos.addAll(onSearch(observableString.get().toUpperCase(),detailKotabackup));
                    rcAppAdapter.notifyDataSetChanged();
                }
            });
        }
        String newValue = observableString.get();
        if (!view.getText().toString().equals(newValue))
        {
            view.setText(newValue);
        }
    }

    @BindingConversion
    public static String convertObservableStringToString(ObservableString observableString)
    {
        return observableString.get();
    }




    public static List<DetailKotaDao> onSearch(String search , List<DetailKotaDao> detailTemporary){
        List<DetailKotaDao> detailKotaSearch = new ArrayList<>();

        if(!search.isEmpty() && detailTemporary.size() != 0){
            detailKotaDaos.clear();
            detailKotaSearch.clear();
            for(int x=0; x < detailTemporary.size(); x++){
                if(detailTemporary.get(x).getKota().contains(search)){
                    detailKotaSearch.add(detailTemporary.get(x));
                }
            }
            return detailKotaSearch;
        }else{
            return detailTemporary;
        }
//        if(!search.equalsIgnoreCase("") || search != null){
//            for (int i = 0;i < detailTemporary.size();i++){
//                for (int j = 0;j < detailTemporary.get(i).getKota().length()- 1;j++){
//                    String chardata = String.valueOf(detailTemporary.get(i).getKota().charAt(j));
//                    if(chardata.equalsIgnoreCase(search)){
//                        detailKotaSearch.add(detailTemporary.get(i));
//                        break;
//                        }
//                }
//            }
//            return detailKotaSearch;
//        }else {
//            return detailTemporary;
//
//        }
    }

}
