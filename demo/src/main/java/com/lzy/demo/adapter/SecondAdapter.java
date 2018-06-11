package com.lzy.demo.adapter;

import android.content.Context;
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

public class SecondAdapter extends BaseAdapter {

    List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondchildsBeanXXList;
    Context context;

    public SecondAdapter(List<SmtModel.DataBean.ChildsBeanXX.ChildsBeanX> SecondchildsBeanXXList, Context context) {
        this.SecondchildsBeanXXList = SecondchildsBeanXXList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return SecondchildsBeanXXList.size();
    }

    @Override
    public Object getItem(int position) {
        return SecondchildsBeanXXList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SmtModel.DataBean.ChildsBeanXX.ChildsBeanX childsBeanXX = SecondchildsBeanXXList.get(position);
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.smt_menu_item, null);
            viewHold = new ViewHold();
            viewHold.item_name = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.item_name.setText(childsBeanXX.getDname());
//        switch (childsBeanXX.getDname()){
//            case "工厂":
//                viewHold.item_name.setText(R.string.factory);
//                break;
//            case "平台":
//                viewHold.item_name.setText(R.string.platform);
//                break;
//            case "工艺":
//                viewHold.item_name.setText(R.string.process);
//                break;
//            case "测试":
//                viewHold.item_name.setText(R.string.test);
//                break;
//            case "SN号段申请管理":
//                viewHold.item_name.setText(R.string.SN_section_application_management);
//                break;
//            case "属性基本信息":
//                viewHold.item_name.setText(R.string.Attribute_basic_information);
//                break;
//            case "产品属性信息管理":
//                viewHold.item_name.setText(R.string.Product_attribute_information_management);
//                break;
//            case "产品号码类型管理":
//                viewHold.item_name.setText(R.string.Product_number_type_management);
//                break;
//            case "生产记录查询":
//                viewHold.item_name.setText(R.string.Production_record_query);
//                break;
//            case "测试数据查询":
//                viewHold.item_name.setText(R.string.Test_data_query);
//                break;
//            case "包装数据查询":
//                viewHold.item_name.setText(R.string.Package_data_query);
//                break;
//            case "维修数据分析":
//                viewHold.item_name.setText(R.string.Maintenance_data_analysis);
//                break;
//            case "生产状况分析":
//                viewHold.item_name.setText(R.string.Production_status_analysis);
//                break;
//            case "生产报表":
//                viewHold.item_name.setText(R.string.Production_report);
//                break;
//            case "电子看板管理":
//                viewHold.item_name.setText(R.string.Electronic_kanban_management);
//                break;
//            case "质量业务查询":
//                viewHold.item_name.setText(R.string.Quality_business_enquiries);
//                break;
//            case "号码释放":
//                viewHold.item_name.setText(R.string.Number_to_release);
//                break;
//            case "PCBA维修管理":
//                viewHold.item_name.setText(R.string.PCBA_maintenance_management);
//                break;
//            case "整机维修管理":
//                viewHold.item_name.setText(R.string.Complete_machine_maintenance_management);
//                break;
//            case "密码修改":
//                viewHold.item_name.setText(R.string.Password_change);
//                break;
//        }



        return convertView;
    }
    private static class ViewHold {
        private TextView item_name;
    }
}
