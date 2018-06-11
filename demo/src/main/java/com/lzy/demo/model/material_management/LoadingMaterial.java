package com.lzy.demo.model.material_management;

import java.sql.Time;

/**
 * Created by 54330 on 2018/6/4.
 */

public class LoadingMaterial {
    public String SN;// 机台SN号
    public int PROJECT_ID;// 项目ID
    public String PROJECT_NAME;// 项目名称
    public int STATION_ID;// 工站ID
    public String STATION_NAME;// 工站名称
    public int LOCATION_ID;// 工位ID
    public String USER_ID;// 操作人ID
    public String RESULT;// 结果 Fail,Pass
    public String FAILURE_CODE;//不良描述
    public int MB_QTY;//主板连板数
    public int SUB_QTY;//小板连板数
    public int ENABLE_FLAG;// 0为启用，1为禁用 状态
    public String PanelSN;// 连板SN
    public String BoardTypeCode;// MB,大板;SUB,小板
    public String BoardTypeText;// MB,大板;SUB,小板
    public String REAL_QTY;// 剩余数量
    public String LINE_ID;//  线体ID
    public String LINE_NAME;;//  线体名称
    public String BoardSideCode;// 板子 Top面:T；BOT面:B
    public  String BoardSideText;// 板子 Top面:T；BOT面:B
    public String SubBomCode;// 子BOM编码
    public String MACHINE_CODE;// 机台号
    public String TRACK_NO;// 站位号
    public  String KEY_PART_NO;// 物料编码
    public String FEEDER_TYPE;// 飞达类型
    public int PICKUP_QTY;// 用量
    public  String LOT_NO;// 批次号
    public  String NEED_KEY_PART;// 需上料号
    public  String KP_LOT;// 批次号
    public Time CREATED_DATE;
    public String CREATED_BY;
    public String LAST_UPDATED_BY;
    public  boolean isAdd;

    public String getSN() {
        return SN == null ? "" : SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public int getPROJECT_ID() {
        return PROJECT_ID;
    }

    public void setPROJECT_ID(int PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID;
    }

    public String getPROJECT_NAME() {
        return PROJECT_NAME == null ? "" : PROJECT_NAME;
    }

    public void setPROJECT_NAME(String PROJECT_NAME) {
        this.PROJECT_NAME = PROJECT_NAME;
    }

    public int getSTATION_ID() {
        return STATION_ID;
    }

    public void setSTATION_ID(int STATION_ID) {
        this.STATION_ID = STATION_ID;
    }

    public String getSTATION_NAME() {
        return STATION_NAME == null ? "" : STATION_NAME;
    }

    public void setSTATION_NAME(String STATION_NAME) {
        this.STATION_NAME = STATION_NAME;
    }

    public int getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(int LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }

    public String getUSER_ID() {
        return USER_ID == null ? "" : USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getRESULT() {
        return RESULT == null ? "" : RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getFAILURE_CODE() {
        return FAILURE_CODE == null ? "" : FAILURE_CODE;
    }

    public void setFAILURE_CODE(String FAILURE_CODE) {
        this.FAILURE_CODE = FAILURE_CODE;
    }

    public int getMB_QTY() {
        return MB_QTY;
    }

    public void setMB_QTY(int MB_QTY) {
        this.MB_QTY = MB_QTY;
    }

    public int getSUB_QTY() {
        return SUB_QTY;
    }

    public void setSUB_QTY(int SUB_QTY) {
        this.SUB_QTY = SUB_QTY;
    }

    public int getENABLE_FLAG() {
        return ENABLE_FLAG;
    }

    public void setENABLE_FLAG(int ENABLE_FLAG) {
        this.ENABLE_FLAG = ENABLE_FLAG;
    }

    public String getPanelSN() {
        return PanelSN == null ? "" : PanelSN;
    }

    public void setPanelSN(String panelSN) {
        PanelSN = panelSN;
    }

    public String getBoardTypeCode() {
        return BoardTypeCode == null ? "" : BoardTypeCode;
    }

    public void setBoardTypeCode(String boardTypeCode) {
        BoardTypeCode = boardTypeCode;
    }

    public String getBoardTypeText() {
        return BoardTypeText == null ? "" : BoardTypeText;
    }

    public void setBoardTypeText(String boardTypeText) {
        BoardTypeText = boardTypeText;
    }

    public String getREAL_QTY() {
        return REAL_QTY == null ? "" : REAL_QTY;
    }

    public void setREAL_QTY(String REAL_QTY) {
        this.REAL_QTY = REAL_QTY;
    }

    public String getLINE_ID() {
        return LINE_ID == null ? "" : LINE_ID;
    }

    public void setLINE_ID(String LINE_ID) {
        this.LINE_ID = LINE_ID;
    }

    public String getLINE_NAME() {
        return LINE_NAME == null ? "" : LINE_NAME;
    }

    public void setLINE_NAME(String LINE_NAME) {
        this.LINE_NAME = LINE_NAME;
    }

    public String getBoardSideCode() {
        return BoardSideCode == null ? "" : BoardSideCode;
    }

    public void setBoardSideCode(String boardSideCode) {
        BoardSideCode = boardSideCode;
    }

    public String getBoardSideText() {
        return BoardSideText == null ? "" : BoardSideText;
    }

    public void setBoardSideText(String boardSideText) {
        BoardSideText = boardSideText;
    }

    public String getSubBomCode() {
        return SubBomCode == null ? "" : SubBomCode;
    }

    public void setSubBomCode(String subBomCode) {
        SubBomCode = subBomCode;
    }

    public String getMACHINE_CODE() {
        return MACHINE_CODE == null ? "" : MACHINE_CODE;
    }

    public void setMACHINE_CODE(String MACHINE_CODE) {
        this.MACHINE_CODE = MACHINE_CODE;
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

    public String getFEEDER_TYPE() {
        return FEEDER_TYPE == null ? "" : FEEDER_TYPE;
    }

    public void setFEEDER_TYPE(String FEEDER_TYPE) {
        this.FEEDER_TYPE = FEEDER_TYPE;
    }

    public int getPICKUP_QTY() {
        return PICKUP_QTY;
    }

    public void setPICKUP_QTY(int PICKUP_QTY) {
        this.PICKUP_QTY = PICKUP_QTY;
    }

    public String getLOT_NO() {
        return LOT_NO == null ? "" : LOT_NO;
    }

    public void setLOT_NO(String LOT_NO) {
        this.LOT_NO = LOT_NO;
    }

    public String getNEED_KEY_PART() {
        return NEED_KEY_PART == null ? "" : NEED_KEY_PART;
    }

    public void setNEED_KEY_PART(String NEED_KEY_PART) {
        this.NEED_KEY_PART = NEED_KEY_PART;
    }

    public String getKP_LOT() {
        return KP_LOT == null ? "" : KP_LOT;
    }

    public void setKP_LOT(String KP_LOT) {
        this.KP_LOT = KP_LOT;
    }

    public String getCREATED_BY() {
        return CREATED_BY == null ? "" : CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public String getLAST_UPDATED_BY() {
        return LAST_UPDATED_BY == null ? "" : LAST_UPDATED_BY;
    }

    public void setLAST_UPDATED_BY(String LAST_UPDATED_BY) {
        this.LAST_UPDATED_BY = LAST_UPDATED_BY;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }
}
