package com.lzy.demo.ui.material_query.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.ui.material_query.entity.ProductiveProcessModel;

import java.util.List;

/**
 * Created by 54330 on 2018/3/29.
 */

public class ProductiveProcessAdapter extends BaseAdapter {

    List<ProductiveProcessModel> productiveProcessModels;
    Context context;

    public ProductiveProcessAdapter(List<ProductiveProcessModel> productiveProcessModels, Context context) {
        this.productiveProcessModels = productiveProcessModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productiveProcessModels.size();
    }

    @Override
    public Object getItem(int position) {
        return productiveProcessModels.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.connect_plate_item, null);
            viewHold = new ViewHold();
            viewHold.material_sn = (TextView) convertView.findViewById(R.id.material_sn);
            viewHold.material_test_result = (TextView) convertView.findViewById(R.id.material_test_result);
            viewHold.material_test_time = (TextView) convertView.findViewById(R.id.material_test_time);
            viewHold.material_software_version = (TextView) convertView.findViewById(R.id.material_software_version);
            viewHold.material_factory = (TextView) convertView.findViewById(R.id.material_factory);
            viewHold.material_workstation = (TextView) convertView.findViewById(R.id.material_workstation);
            viewHold.material_line_name = (TextView) convertView.findViewById(R.id.material_line_name);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
//        viewHold.connect_plate_sn.setText(productiveProcessModels.get(position).getPANEL_SN());
//        viewHold.material_sn.setText(productiveProcessModels.get(position).getSN());
//        viewHold.material_project.setText(productiveProcessModels.get(position).getPROJECT_NAME());
//        viewHold.material_production_order.setText(productiveProcessModels.get(position).getPRODUCT_INSTRUCTION());
//        viewHold.material_code.setText(productiveProcessModels.get(position).getBOM_NO());



        return convertView;
    }
    private static class ViewHold {
        private TextView material_sn;
        private TextView material_test_result;//测试结果
        private TextView material_test_time;//测试时间
        private TextView material_software_version;//软件版本
        private TextView material_factory;//工厂
        private TextView material_workstation;//工站
        private TextView material_line_name;//产线
    }
}
