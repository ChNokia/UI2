package com.homework.news;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Yushchenko on 26.09.2014.
 */
public class ListFragment extends Fragment {
    ArrayList<ItemNews> newsList = new ArrayList<ItemNews>();
    AdapterForNews boxAdapter;

    int[] images = { R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5, R.drawable.ic_6, R.drawable.ic_7,
            R.drawable.ic_8, R.drawable.ic_9, R.drawable.ic_10, R.drawable.ic_11, R.drawable.ic_12, R.drawable.ic_13, R.drawable.ic_14,
            R.drawable.ic_15, R.drawable.ic_16, R.drawable.ic_17, R.drawable.ic_18, R.drawable.ic_19, R.drawable.ic_20};
    String[] category = { "Політика", "Неймовірне", "Калейдоскоп", "Економіка", "Спорт", "Життя",
            "Калейдоскоп", "Економіка", "Спорт", "Політика", "Неймовірне", "Калейдоскоп", "Економіка",
            "Спорт", "Життя","Економіка", "Спорт", "Політика", "Неймовірне", "Калейдоскоп"};

    String[] tittles = { "В Раду проходять партії Порошенка, Ляшка і Тимошенко", "\"Курс молодого бійця\" можуть зробити обов'язковим для всіх", "Кинопремьеры недели: Владимир П… должен умереть",
            "Співочий друг Ющенка-молодшого отримав посаду у Київраді", "Яценюк заощаджує на перельоті, але тринькає гроші на готелі?", "Кака може повернутися в збірну Бразилії", "Marca: Ройс погодився перейти в Реал",
            "Китай. Світоліна не змогла пробитися у фінал", "Гладир відновився від травми", "Маркевич: Думками ми вже у Франції", "Охранник", "Директор", "Программер", "Охранник",
            "Директор", "Программер", "Охранник", "Директор", "Программер", "Охранник"};

    void fillData() {
        for (int i = 0; i < category.length; i++) {
            newsList.add(new ItemNews(category[i], tittles[i],images[i]));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View list_root = inflater.inflate(R.layout.fragment_list, null);

        return list_root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        fillData();

        boxAdapter = new AdapterForNews(getActivity(), newsList);
        ListView listView = (ListView) getActivity().findViewById(R.id.lvData);

        listView.setAdapter(boxAdapter);
        listView.setSelector(R.drawable.bg_key);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String text = parent.getItemAtPosition(position).toString();

                if ( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Fragment fragmentDetail = getFragmentManager().findFragmentById(R.id.fragment_detail);

                    WebView webView = (WebView) fragmentDetail.getView().findViewById(R.id.webViewDetail);

                    webView.loadUrl("file:///android_asset/html/NewsTemplate.html");

                    webView.getSettings().setJavaScriptEnabled(true);

                    return;
                }

                Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);



                startActivity(intent);
            }
        });

    }
}

