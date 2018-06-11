package com.lzy.demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.model.SmtModel;

import java.util.List;

/**
 * Created by 54330 on 2018/3/29.
 */

public class FirstAdapter extends BaseAdapter {

    List<SmtModel.DataBean.ChildsBeanXX> FirstchildsBeanXXList;
    private int selectItem = 0;
    Context context;

    public FirstAdapter(List<SmtModel.DataBean.ChildsBeanXX> FirstchildsBeanXXList,Context context) {
        this.FirstchildsBeanXXList = FirstchildsBeanXXList;
        this.context = context;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getCount() {
        return FirstchildsBeanXXList.size();
    }

    @Override
    public Object getItem(int position) {
        return FirstchildsBeanXXList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SmtModel.DataBean.ChildsBeanXX childsBeanXX = FirstchildsBeanXXList.get(position);
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.smt_menu_item, null);
            viewHold = new ViewHold();
            viewHold.item_name = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }

        if (position == selectItem) {
            viewHold.item_name.setBackgroundColor(Color.WHITE);
            viewHold.item_name.setTextColor(context.getResources().getColor(R.color.green_400));
        } else {
            viewHold.item_name.setBackgroundColor(context.getResources().getColor(R.color.background));
            viewHold.item_name.setTextColor(context.getResources().getColor(R.color.black));
        }
        viewHold.item_name.setText(childsBeanXX.getDname());
//        switch (childsBeanXX.getDname()){
//            case "基本数据管理":
//                viewHold.item_name.setText(R.string.basic_data_management);
//                break;
//            case "生产计划管理":
//                viewHold.item_name.setText(R.string.production_planning_management);
//                break;
//            case "产品属性配置":
//                viewHold.item_name.setText(R.string.Product_attribute_configuration);
//                break;
//            case "数据综合查询":
//                viewHold.item_name.setText(R.string.Data_integrated_query);
//                break;
//            case "数据综合分析":
//                viewHold.item_name.setText(R.string.data_comprehensive_analysis);
//                break;
//            case "质量业务管理":
//                viewHold.item_name.setText(R.string.Quality_business_management);
//                break;
//            case "号码资源管理":
//                viewHold.item_name.setText(R.string.Number_resource_management);
//                break;
//            case "维修管理":
//                viewHold.item_name.setText(R.string.maintenance_management);
//                break;
//            case "个人设置":
//                viewHold.item_name.setText(R.string.personal_setting);
//                break;
//        }

        List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondChildsBeanXXList = FirstchildsBeanXXList.get(position).getChilds();


        return convertView;
    }
    private static class ViewHold {
        private TextView item_name;
    }
}
