package com.crop.jirawatpoo.bitcointickerrealtime.view.Pricenotchart;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crop.jirawatpoo.bitcointickerrealtime.R;
import com.crop.jirawatpoo.bitcointickerrealtime.dao.Pricecheck.pricerespone;
import com.crop.jirawatpoo.bitcointickerrealtime.http.HttpProvider;
import com.crop.jirawatpoo.bitcointickerrealtime.http.service.ServicecallPrice;
import com.crop.jirawatpoo.bitcointickerrealtime.interfaceclass.IAllView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartFragment extends Fragment implements IAllView{
    private final Handler mHandler = new Handler();
    private Runnable mTimer1;
    private Runnable mTimer2;
    private LineGraphSeries<DataPoint> mSeries1;
    private LineGraphSeries<DataPoint> mSeries2;
    private double graph2LastXValue = 5d;
    private static final String TAG = "ChartFragment";
    int count = 300;
    DataPoint[] values = new DataPoint[10];
    int i = 0;
    GraphView graph;

    public ChartFragment() {
    }
    public static ChartFragment newInstance() {
        ChartFragment fragment = new ChartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        graph = (GraphView) view.findViewById(R.id.graph);
        generateData();
    }

    private void generateData() {
        ServicecallPrice servicecallPrice = HttpProvider.get().servicecallPrice();
        servicecallPrice.getpair("1").enqueue(new Callback<pricerespone>() {
            @Override
            public void onResponse(Call<pricerespone> call, Response<pricerespone> response) {
                int save = i;
                i = 9;
                for(pricerespone.TradesBean tradesBean : response.body().getTrades()){
                    double x = i;
                    double y = Double.parseDouble(tradesBean.getRate());
                    DataPoint v = new DataPoint(x, y);
                    values[i--] = v;

                }
                if(save == 0){
                    mSeries1 = new LineGraphSeries<>(values);
                    graph.addSeries(mSeries1);
                }else{
                    mSeries1.resetData(values);
                }
                mHandler.removeCallbacks(mTimer1);
                mHandler.postDelayed(mTimer1, 1000);

            }

            @Override
            public void onFailure(Call<pricerespone> call, Throwable t) {
                call.cancel();
                call.clone().enqueue(this);
            }
        });
    }

    private void sentdata(boolean b) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void apicallsuccess(pricerespone pricerespone) {

    }

    @Override
    public void apicallfail(Throwable throwable) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    double mLastRandom = 2;
    Random mRand = new Random();

    @Override
    public void onResume() {
        super.onResume();
        mTimer1 = new Runnable() {
            @Override
            public void run() {
                generateData();
            }
        };
//        mHandler.removeCallbacks(mTimer1);
//        mHandler.postDelayed(mTimer1, 1000);
    }

    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer1);
        super.onPause();
    }
}
