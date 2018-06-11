package com.lzy.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.model.APPMemuModel;

import java.util.List;

/**
 * author：wangzihang
 * date： 2017/8/8 19:15
 * desctiption：
 * e-mail：wangzihang@xiaohongchun.com
 */

public class MenuItemAdapter extends BaseAdapter {

    private Context context;
    private List<APPMemuModel> items;

    public MenuItemAdapter(Context context, List<APPMemuModel> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        if (items != null) {
            return items.size();
        } else {
            return 10;
        }
    }

    @Override
    public Object getItem(int position) {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.home_menu_item, null);
            viewHold = new ViewHold();
            viewHold.menu_item_title = (TextView) convertView.findViewById(R.id.menu_item_title);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.menu_item_title.setText(items.get(position).getName());
//        Glide.with(context).load(subcategory.getImgURL()).into(viewHold.iv_icon);
//        viewHold.iv_icon.setImageURI(uri);
        return convertView;


    }

    private static class ViewHold {
        private TextView menu_item_title;
    }

}
