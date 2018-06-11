package com.lzy.demo.ui.material_management.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.model.material_management.SMTMaterial;

import java.util.List;

/**
 * Created by 54330 on 2018/3/29.
 */

public class TraceAdapter extends BaseAdapter {

    List<SMTMaterial> smtMaterialList;
    Context context;

    public TraceAdapter(List<SMTMaterial> smtMaterialList, Context context) {
        this.smtMaterialList = smtMaterialList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return smtMaterialList.size();
    }

    @Override
    public Object getItem(int position) {
        return smtMaterialList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.trace_item, null);
            viewHold = new ViewHold();
            viewHold.material_project = (TextView) convertView.findViewById(R.id.material_project);
            viewHold.material_sn = (TextView) convertView.findViewById(R.id.material_sn);
            viewHold.material_code = (TextView) convertView.findViewById(R.id.material_code);
            viewHold.material_line_name = (TextView) convertView.findViewById(R.id.material_line_name);
            viewHold.material_type = (TextView) convertView.findViewById(R.id.material_type);
            viewHold.material_noodles = (TextView) convertView.findViewById(R.id.material_noodles);
            viewHold.material_position = (TextView) convertView.findViewById(R.id.material_position);
            viewHold.material_no = (TextView) convertView.findViewById(R.id.material_no);
            viewHold.material_batch = (TextView) convertView.findViewById(R.id.material_batch);
            viewHold.material_factory = (TextView) convertView.findViewById(R.id.material_factory);
            viewHold.material_rack_time = (TextView) convertView.findViewById(R.id.material_rack_time);
            viewHold.material_rack_personnel = (TextView) convertView.findViewById(R.id.material_rack_personnel);
            viewHold.material_work_time = (TextView) convertView.findViewById(R.id.material_work_time);
            viewHold.material_work_personnel = (TextView) convertView.findViewById(R.id.material_work_personnel);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.material_project.setText(smtMaterialList.get(position).getPROJECT_NAME());
        viewHold.material_sn.setText(smtMaterialList.get(position).getSN());
        viewHold.material_code.setText(smtMaterialList.get(position).getBOM_NO());
        viewHold.material_line_name.setText(smtMaterialList.get(position).getLINE_NAME());
//        viewHold.material_type.setText(smtMaterialList.get(position).getBOARD_TYPE());
        viewHold.material_noodles.setText(smtMaterialList.get(position).getBOARD_SIDE());
//        viewHold.material_position.setText(smtMaterialList.get(position).getTRACK_NO());
        viewHold.material_no.setText(smtMaterialList.get(position).getKEY_PART_NO());
        viewHold.material_batch.setText(smtMaterialList.get(position).getKP_LOT());
//        viewHold.material_factory.setText(smtMaterialList.get(position).getFACTORY_NAME());
//        viewHold.material_rack_time.setText(smtMaterialList.get(position).getLOAD_DATE());
//        viewHold.material_rack_personnel.setText(smtMaterialList.get(position).getLOAD_BY());
//        viewHold.material_work_time.setText(smtMaterialList.get(position).getCREATED_DATE());
//        viewHold.material_work_personnel.setText(smtMaterialList.get(position).getCREATED_BY());



        return convertView;
    }
    private static class ViewHold {
        private TextView material_project;//项目
        private TextView material_sn;
        private TextView material_code;//物料编码
        private TextView material_line_name;//线别
        private TextView material_type;//类型
        private TextView material_noodles;//面别
        private TextView material_position;//站位号
        private TextView material_no;//料号
        private TextView material_batch;//批次号
        private TextView material_factory;//工厂
        private TextView material_rack_time;//上料时间
        private TextView material_rack_personnel;//上料人员
        private TextView material_work_time;//作业时间
        private TextView material_work_personnel;//作业人员
    }
}
