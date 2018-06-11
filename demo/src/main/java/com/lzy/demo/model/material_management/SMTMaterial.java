package com.lzy.demo.model.material_management;

import java.io.Serializable;

/**
 * Created by 54330 on 2018/6/4.
 */

public class SMTMaterial implements Serializable {
    public String SN;//连板SN-
    public String PROJECT_NAME;//项目名称
    public String BOM_NO;//物料编码(PCBA)
    public String ITEM_NAME;//物料名称
    public  String MO_NUMBER;//生产工单
    public  String LINE_NAME;//线别
    public String BOARD_TYPE;//MB.主板，SUB.小板
    public  String BOARD_SIDE;//BOT. BOT面，TOP. TOP面-
    public  String TRACK_NO;//站位号
    public   String KEY_PART_NO;//料号
    public  String KP_LOT;//批次号
    public String FACTORY_NAME;//工厂名称
    public  String LOAD_DATE;//物料上料时间
    public String LOAD_BY;//物料上料作业人员
    public  String CREATED_DATE;//作业时间
    public  String CREATED_BY;//作业人员

    public String getKP_LOT() {
        return KP_LOT == null ? "" : KP_LOT;
    }

    public void setKP_LOT(String KP_LOT) {
        this.KP_LOT = KP_LOT;
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

    public String getBOM_NO() {
        return BOM_NO == null ? "" : BOM_NO;
    }

    public void setBOM_NO(String BOM_NO) {
        this.BOM_NO = BOM_NO;
    }

    public String getITEM_NAME() {
        return ITEM_NAME == null ? "" : ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public String getMO_NUMBER() {
        return MO_NUMBER == null ? "" : MO_NUMBER;
    }

    public void setMO_NUMBER(String MO_NUMBER) {
        this.MO_NUMBER = MO_NUMBER;
    }

    public String getLINE_NAME() {
        return LINE_NAME == null ? "" : LINE_NAME;
    }

    public void setLINE_NAME(String LINE_NAME) {
        this.LINE_NAME = LINE_NAME;
    }

    public String getBOARD_TYPE() {
        return BOARD_TYPE == null ? "" : BOARD_TYPE;
    }

    public void setBOARD_TYPE(String BOARD_TYPE) {
        this.BOARD_TYPE = BOARD_TYPE;
    }

    public String getBOARD_SIDE() {
        return BOARD_SIDE == null ? "" : BOARD_SIDE;
    }

    public void setBOARD_SIDE(String BOARD_SIDE) {
        this.BOARD_SIDE = BOARD_SIDE;
    }

    public String getTRACK_NO() {
        return TRACK_NO == null ? "" : TRACK_NO;
    }

    public void setTRACK_NO(String TRACK_NO) {
        this.TRACK_NO = TRACK_NO;
    }

    public String getKEY_PART_NO() {
        return KEY_PART_NO == null ? "" : KEY_PART_NO;
    }

    public void setKEY_PART_NO(String KEY_PART_NO) {
        this.KEY_PART_NO = KEY_PART_NO;
    }

    public String getFACTORY_NAME() {
        return FACTORY_NAME == null ? "" : FACTORY_NAME;
    }

    public void setFACTORY_NAME(String FACTORY_NAME) {
        this.FACTORY_NAME = FACTORY_NAME;
    }

    public String getLOAD_DATE() {
        return LOAD_DATE;
    }

    public void setLOAD_DATE(String LOAD_DATE) {
        this.LOAD_DATE = LOAD_DATE;
    }

    public String getLOAD_BY() {
        return LOAD_BY == null ? "" : LOAD_BY;
    }

    public void setLOAD_BY(String LOAD_BY) {
        this.LOAD_BY = LOAD_BY;
    }

    public String getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(String CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    public String getCREATED_BY() {
        return CREATED_BY == null ? "" : CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }
}
