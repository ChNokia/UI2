package com.homework.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yushchenko on 26.09.2014.
 */


public class AdapterForNews extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List data;

    static class ViewHolder{
        TextView textCategory;
        TextView textTittle;
        TextView textDate;
        ImageView srcImage;
    }

    public AdapterForNews(Context context, List data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if ( data == null ) {
            return 0;
        }

        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View curentView = view;
        ViewHolder holder = null;

        if ( curentView == null ) {
            curentView = layoutInflater.inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder();

            holder.textCategory = (TextView) curentView.findViewById(R.id.newsCategory);
            holder.textTittle = (TextView) curentView.findViewById(R.id.newsTittle);
            holder.textDate = (TextView) curentView.findViewById(R.id.newsTime);
            holder.srcImage = (ImageView) curentView.findViewById(R.id.newsImg);

            curentView.setTag(holder);

        } else {
            holder = (ViewHolder) curentView.getTag();
        }

        ItemNews article = (ItemNews) getItem(position);

        holder.textCategory.setText(article.getCategory());
        holder.textTittle.setText(article.getTittle());
        holder.textDate.setText(article.getDate());
        holder.srcImage.setImageResource(article.getImg());

        return curentView;
    }
}