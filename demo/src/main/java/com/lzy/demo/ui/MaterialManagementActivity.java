package com.lzy.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.lzy.demo.R;
import com.lzy.demo.adapter.ColorItemsAdapter;
import com.lzy.demo.adapter.MaterialItemAdapter;
import com.lzy.demo.base.BaseActivity;
import com.lzy.demo.model.MenuItemModel;
import com.lzy.demo.ui.material_management.Material_scrapActivity;
import com.lzy.demo.ui.material_management.Store_adjustmentActivity;
import com.lzy.demo.ui.material_management.Store_bindActivity;
import com.lzy.demo.ui.material_management.Warehouse_allottingActivity;
import com.lzy.demo.widget.GridViewForScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 物料管理
 */
public class MaterialManagementActivity extends BaseActivity {

    GridViewForScrollView gridView;
    private RecyclerView recycler;
    ColorItemsAdapter colorItemsAdapter;
//    String images[] = new String[]{"http://img15.3lian.com/2015/h1/308/d/204.jpg","http://img15.3lian.com/2015/h1/308/d/204.jpg",
//            "http://img15.3lian.com/2015/h1/308/d/204.jpg","http://img15.3lian.com/2015/h1/308/d/204.jpg",
//            "http://img15.3lian.com/2015/h1/308/d/204.jpg","http://img15.3lian.com/2015/h1/308/d/204.jpg",
//            "http://img15.3lian.com/2015/h1/308/d/204.jpg","http://img15.3lian.com/2015/h1/308/d/204.jpg"};

    int images[] = new int[]{R.drawable.layout_gray_bg,R.drawable.layout_green_bg,
            R.drawable.layout_red_bg,R.drawable.layout_pink_bg,
            R.drawable.layout_yellow_bg,R.drawable.layout_purle_bg,
            R.drawable.layout_brown_bg,R.drawable.layout_cyan_bg,R.drawable.layout_blue_bg,
            R.drawable.layout_brown_bg,R.drawable.layout_cyan_bg,R.drawable.layout_blue_bg,R.drawable.layout_gray_bg};

    String titles[] = new String[]{"收料","在库拆分","杂发出库单","检验PDA取样","在库分拆",
            "试做单","新旧试做单","超领返库","杂发单出库","储位绑定","物料报废","储位调整","仓库调拨"};
    MaterialItemAdapter materialItemAdapter;
    List<MenuItemModel> menuItemModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_management);
//        recycler = (RecyclerView) findViewById(R.id.recycler);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
//        recycler.setLayoutManager(layoutManager);
//        colorItemsAdapter = new ColorItemsAdapter(this, 8,titles);
//        recycler.setAdapter(colorItemsAdapter);

        initView();
    }
    public void startResolution(View view) {
        startActivity(new Intent(this,ProductionMaterialReturnActivity.class));
    }
    private void initView() {
        ((TextView)findView(R.id.tv_title)).setText("物料管理");
        for (int i = 0; i < titles.length; i++) {
            menuItemModelList.add(new MenuItemModel(titles[i],images[i]));
        }
        gridView = (GridViewForScrollView) findViewById(R.id.gridView);
        materialItemAdapter = new MaterialItemAdapter(this,menuItemModelList);
        gridView.setAdapter(materialItemAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (menuItemModelList.get(position).getTitle()){
                        case "收料":
                        startActivity(new Intent(MaterialManagementActivity.this,ResolutionActivity.class));
                        break;
                        case "在库拆分":
                        startActivity(new Intent(MaterialManagementActivity.this,ProductionMaterialReturnActivity.class));
                        break;
                    case "杂发出库单":
                        break;
                    case "检验PDA取样":
                        break;
                    case "在库分拆":
                        break;
                    case "试做单":
                        break;
                    case "新旧试做单":
                        break;
                    case "超领返库":
                        break;
                    case "杂发单出库":
                        break;
                    case "储位绑定":
                        startActivity(new Intent(MaterialManagementActivity.this,Store_bindActivity.class));
                        break;
                    case "物料报废":
                        startActivity(new Intent(MaterialManagementActivity.this,Material_scrapActivity.class));
                        break;
                    case "储位调整":
                        startActivity(new Intent(MaterialManagementActivity.this,Store_adjustmentActivity.class));
                        break;
                    case "仓库调拨":
                        startActivity(new Intent(MaterialManagementActivity.this,Warehouse_allottingActivity.class));
                        break;
                }
            }
        });
    }
}
