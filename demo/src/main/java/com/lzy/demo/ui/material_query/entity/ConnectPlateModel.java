package com.lzy.demo.ui.material_query.entity;

/**
 * Created by 54330 on 2018/6/11.
 */

public class ConnectPlateModel {
    String PANEL_SN;//连板SN
    String SN;
    String PROJECT_NAME;
    String PRODUCT_INSTRUCTION;
    String BOM_NO;

    public String getPANEL_SN() {
        return PANEL_SN == null ? "" : PANEL_SN;
    }

    public void setPANEL_SN(String PANEL_SN) {
        this.PANEL_SN = PANEL_SN;
    }

    public String getSN() {
        return SN == null ? "" : SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getPROJECT_NAME() {
        return PROJECT_NAME == null ? "" : PROJECT_NAME;
    }

    public void setPROJECT_NAME(String PROJECT_NAME) {
        this.PROJECT_NAME = PROJECT_NAME;
    }

    public String getPRODUCT_INSTRUCTION() {
        return PRODUCT_INSTRUCTION == null ? "" : PRODUCT_INSTRUCTION;
    }

    public void setPRODUCT_INSTRUCTION(String PRODUCT_INSTRUCTION) {
        this.PRODUCT_INSTRUCTION = PRODUCT_INSTRUCTION;
    }

    public String getBOM_NO() {
        return BOM_NO == null ? "" : BOM_NO;
    }

    public void setBOM_NO(String BOM_NO) {
        this.BOM_NO = BOM_NO;
    }
}
