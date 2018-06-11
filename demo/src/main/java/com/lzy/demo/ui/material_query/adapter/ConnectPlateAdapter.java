package com.lzy.demo.ui.material_query.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.ui.material_query.entity.ConnectPlateModel;

import java.util.List;

/**
 * Created by 54330 on 2018/3/29.
 */

public class ConnectPlateAdapter extends BaseAdapter {

    List<ConnectPlateModel> connectPlateModelList;
    Context context;

    public ConnectPlateAdapter(List<ConnectPlateModel> connectPlateModelList, Context context) {
        this.connectPlateModelList = connectPlateModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return connectPlateModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return connectPlateModelList.size();
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
            viewHold.connect_plate_sn = (TextView) convertView.findViewById(R.id.connect_plate_sn);
            viewHold.material_project = (TextView) convertView.findViewById(R.id.material_project);
            viewHold.material_sn = (TextView) convertView.findViewById(R.id.material_sn);
            viewHold.material_code = (TextView) convertView.findViewById(R.id.material_code);
            viewHold.material_production_order = (TextView) convertView.findViewById(R.id.material_production_order);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.connect_plate_sn.setText(connectPlateModelList.get(position).getPANEL_SN());
        viewHold.material_sn.setText(connectPlateModelList.get(position).getSN());
        viewHold.material_project.setText(connectPlateModelList.get(position).getPROJECT_NAME());
        viewHold.material_production_order.setText(connectPlateModelList.get(position).getPRODUCT_INSTRUCTION());
        viewHold.material_code.setText(connectPlateModelList.get(position).getBOM_NO());



        return convertView;
    }
    private static class ViewHold {
        private TextView connect_plate_sn;//连板SN
        private TextView material_sn;
        private TextView material_project;//项目
        private TextView material_production_order;//生产指令
        private TextView material_code;//物料编码
    }
}
