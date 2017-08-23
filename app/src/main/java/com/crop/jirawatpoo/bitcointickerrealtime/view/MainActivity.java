package com.crop.jirawatpoo.bitcointickerrealtime.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crop.jirawatpoo.bitcointickerrealtime.R;
import com.crop.jirawatpoo.bitcointickerrealtime.view.Pricenotchart.ChartFragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {
    public static String TAG_CHART = "CHERT_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container_graph, ChartFragment.newInstance(), TAG_CHART)
                .addToBackStack(null)
                .commit();



    }
}
