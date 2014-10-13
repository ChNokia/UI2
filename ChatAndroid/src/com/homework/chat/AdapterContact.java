package com.homework.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yushchenko on 02.10.2014.
 */
public class AdapterContact extends BaseAdapter {
    List data;
    private LayoutInflater inflater;

    static class ViewHolder{
        TextView nickNamme;
    }

    public AdapterContact(Context context, List data) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
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
            curentView = inflater.inflate(R.layout.contact_item_list, parent, false);
            holder = new ViewHolder();
            holder.nickNamme = (TextView) curentView.findViewById(R.id.nameContactId);

            curentView.setTag(holder);
        } else {
            holder = (ViewHolder) curentView.getTag();
        }

        ChatContact contact = (ChatContact) getItem(position);

        holder.nickNamme.setText(contact.getNickName());

        return curentView;
    }
}
