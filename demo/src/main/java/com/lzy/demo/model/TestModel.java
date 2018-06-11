package com.lzy.demo.model;/*
 * Copyright (C) 2018 zhouyou(478319399@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.List;

/**
 * Created by 54330 on 2018/3/26.
 */

public class TestModel {

    /**
     * hander : Success
     * item : [{"START_TIME":"2018-03-01T00:00:00+08:00","END_TIME":"2018-03-26T23:59:59+08:00","TINSOLDER_NO":"ZJY2018031000006","PROJECT_ID":-1,"PROJECT_NAME":null,"TINSOLDER_SUPPLY":null,"TINSOLDER_TYPE":null,"BATCH_NO":null,"TINSOLDER_KP_NO":null,"SHELF_LIFE":null,"GETWARM_BEGINTIME":"2018-03-10T16:48:28","GETWARM_ENDTIME":null,"ALL_IN_TIMES":0,"MO_NUMBER":null,"TINSOLDER_STATUS":null,"TINSOLDER_STATUS_NAME":"回温","IF_EXPIRED":null,"LINE_ID":0,"LINE_NAME":null,"CREATED_BY":null,"CREATED_DATE":null,"LAST_UPDATED_BY":null,"LAST_UPDATED_DATE":null},{"START_TIME":"2018-03-01T00:00:00+08:00","END_TIME":"2018-03-26T23:59:59+08:00","TINSOLDER_NO":"ZJY2018031000003","PROJECT_ID":-1,"PROJECT_NAME":null,"TINSOLDER_SUPPLY":null,"TINSOLDER_TYPE":null,"BATCH_NO":null,"TINSOLDER_KP_NO":null,"SHELF_LIFE":null,"GETWARM_BEGINTIME":"2018-03-10T10:28:28","GETWARM_ENDTIME":null,"ALL_IN_TIMES":0,"MO_NUMBER":null,"TINSOLDER_STATUS":null,"TINSOLDER_STATUS_NAME":"回温","IF_EXPIRED":null,"LINE_ID":0,"LINE_NAME":null,"CREATED_BY":null,"CREATED_DATE":null,"LAST_UPDATED_BY":null,"LAST_UPDATED_DATE":null},{"START_TIME":"2018-03-01T00:00:00+08:00","END_TIME":"2018-03-26T23:59:59+08:00","TINSOLDER_NO":"ZJY2018031000002","PROJECT_ID":-1,"PROJECT_NAME":null,"TINSOLDER_SUPPLY":null,"TINSOLDER_TYPE":null,"BATCH_NO":null,"TINSOLDER_KP_NO":null,"SHELF_LIFE":null,"GETWARM_BEGINTIME":"2018-03-10T10:28:24","GETWARM_ENDTIME":null,"ALL_IN_TIMES":0,"MO_NUMBER":null,"TINSOLDER_STATUS":null,"TINSOLDER_STATUS_NAME":"回温","IF_EXPIRED":null,"LINE_ID":0,"LINE_NAME":null,"CREATED_BY":null,"CREATED_DATE":null,"LAST_UPDATED_BY":null,"LAST_UPDATED_DATE":null},{"START_TIME":"2018-03-01T00:00:00+08:00","END_TIME":"2018-03-26T23:59:59+08:00","TINSOLDER_NO":"ZJY201803080004","PROJECT_ID":-1,"PROJECT_NAME":null,"TINSOLDER_SUPPLY":null,"TINSOLDER_TYPE":null,"BATCH_NO":null,"TINSOLDER_KP_NO":null,"SHELF_LIFE":null,"GETWARM_BEGINTIME":"2018-03-08T11:19:22","GETWARM_ENDTIME":null,"ALL_IN_TIMES":0,"MO_NUMBER":null,"TINSOLDER_STATUS":null,"TINSOLDER_STATUS_NAME":"回温","IF_EXPIRED":null,"LINE_ID":0,"LINE_NAME":null,"CREATED_BY":null,"CREATED_DATE":null,"LAST_UPDATED_BY":null,"LAST_UPDATED_DATE":null},{"START_TIME":"2018-03-01T00:00:00+08:00","END_TIME":"2018-03-26T23:59:59+08:00","TINSOLDER_NO":"ZJY201803070001","PROJECT_ID":-1,"PROJECT_NAME":null,"TINSOLDER_SUPPLY":null,"TINSOLDER_TYPE":null,"BATCH_NO":null,"TINSOLDER_KP_NO":null,"SHELF_LIFE":null,"GETWARM_BEGINTIME":"2018-03-07T16:08:49","GETWARM_ENDTIME":null,"ALL_IN_TIMES":0,"MO_NUMBER":null,"TINSOLDER_STATUS":null,"TINSOLDER_STATUS_NAME":"回温","IF_EXPIRED":null,"LINE_ID":0,"LINE_NAME":null,"CREATED_BY":null,"CREATED_DATE":null,"LAST_UPDATED_BY":null,"LAST_UPDATED_DATE":null}]
     */

    private String hander;
    private List<ItemBean> item;

    public String getHander() {
        return hander;
    }

    public void setHander(String hander) {
        this.hander = hander;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean {
        /**
         * START_TIME : 2018-03-01T00:00:00+08:00
         * END_TIME : 2018-03-26T23:59:59+08:00
         * TINSOLDER_NO : ZJY2018031000006
         * PROJECT_ID : -1
         * PROJECT_NAME : null
         * TINSOLDER_SUPPLY : null
         * TINSOLDER_TYPE : null
         * BATCH_NO : null
         * TINSOLDER_KP_NO : null
         * SHELF_LIFE : null
         * GETWARM_BEGINTIME : 2018-03-10T16:48:28
         * GETWARM_ENDTIME : null
         * ALL_IN_TIMES : 0
         * MO_NUMBER : null
         * TINSOLDER_STATUS : null
         * TINSOLDER_STATUS_NAME : 回温
         * IF_EXPIRED : null
         * LINE_ID : 0
         * LINE_NAME : null
         * CREATED_BY : null
         * CREATED_DATE : null
         * LAST_UPDATED_BY : null
         * LAST_UPDATED_DATE : null
         */

        private String START_TIME;
        private String END_TIME;
        private String TINSOLDER_NO;
        private int PROJECT_ID;
        private String PROJECT_NAME;
        private String TINSOLDER_SUPPLY;
        private String TINSOLDER_TYPE;
        private String BATCH_NO;
        private String TINSOLDER_KP_NO;
        private String SHELF_LIFE;
        private String GETWARM_BEGINTIME;
        private String GETWARM_ENDTIME;
        private int ALL_IN_TIMES;
        private String MO_NUMBER;
        private String TINSOLDER_STATUS;
        private String TINSOLDER_STATUS_NAME;
        private String IF_EXPIRED;
        private int LINE_ID;
        private String LINE_NAME;
        private String CREATED_BY;
        private String CREATED_DATE;
        private String LAST_UPDATED_BY;
        private String LAST_UPDATED_DATE;

        public String getSTART_TIME() {
            return START_TIME;
        }

        public void setSTART_TIME(String START_TIME) {
            this.START_TIME = START_TIME;
        }

        public String getEND_TIME() {
            return END_TIME;
        }

        public void setEND_TIME(String END_TIME) {
            this.END_TIME = END_TIME;
        }

        public String getTINSOLDER_NO() {
            return TINSOLDER_NO;
        }

        public void setTINSOLDER_NO(String TINSOLDER_NO) {
            this.TINSOLDER_NO = TINSOLDER_NO;
        }

        public int getPROJECT_ID() {
            return PROJECT_ID;
        }

        public void setPROJECT_ID(int PROJECT_ID) {
            this.PROJECT_ID = PROJECT_ID;
        }

        public String getPROJECT_NAME() {
            return PROJECT_NAME;
        }

        public void setPROJECT_NAME(String PROJECT_NAME) {
            this.PROJECT_NAME = PROJECT_NAME;
        }

        public String getTINSOLDER_SUPPLY() {
            return TINSOLDER_SUPPLY;
        }

        public void setTINSOLDER_SUPPLY(String TINSOLDER_SUPPLY) {
            this.TINSOLDER_SUPPLY = TINSOLDER_SUPPLY;
        }

        public String getTINSOLDER_TYPE() {
            return TINSOLDER_TYPE;
        }

        public void setTINSOLDER_TYPE(String TINSOLDER_TYPE) {
            this.TINSOLDER_TYPE = TINSOLDER_TYPE;
        }

        public String getBATCH_NO() {
            return BATCH_NO;
        }

        public void setBATCH_NO(String BATCH_NO) {
            this.BATCH_NO = BATCH_NO;
        }

        public String getTINSOLDER_KP_NO() {
            return TINSOLDER_KP_NO;
        }

        public void setTINSOLDER_KP_NO(String TINSOLDER_KP_NO) {
            this.TINSOLDER_KP_NO = TINSOLDER_KP_NO;
        }

        public String getSHELF_LIFE() {
            return SHELF_LIFE;
        }

        public void setSHELF_LIFE(String SHELF_LIFE) {
            this.SHELF_LIFE = SHELF_LIFE;
        }

        public String getGETWARM_BEGINTIME() {
            return GETWARM_BEGINTIME;
        }

        public void setGETWARM_BEGINTIME(String GETWARM_BEGINTIME) {
            this.GETWARM_BEGINTIME = GETWARM_BEGINTIME;
        }

        public String getGETWARM_ENDTIME() {
            return GETWARM_ENDTIME;
        }

        public void setGETWARM_ENDTIME(String GETWARM_ENDTIME) {
            this.GETWARM_ENDTIME = GETWARM_ENDTIME;
        }

        public int getALL_IN_TIMES() {
            return ALL_IN_TIMES;
        }

        public void setALL_IN_TIMES(int ALL_IN_TIMES) {
            this.ALL_IN_TIMES = ALL_IN_TIMES;
        }

        public String getMO_NUMBER() {
            return MO_NUMBER;
        }

        public void setMO_NUMBER(String MO_NUMBER) {
            this.MO_NUMBER = MO_NUMBER;
        }

        public String getTINSOLDER_STATUS() {
            return TINSOLDER_STATUS;
        }

        public void setTINSOLDER_STATUS(String TINSOLDER_STATUS) {
            this.TINSOLDER_STATUS = TINSOLDER_STATUS;
        }

        public String getTINSOLDER_STATUS_NAME() {
            return TINSOLDER_STATUS_NAME;
        }

        public void setTINSOLDER_STATUS_NAME(String TINSOLDER_STATUS_NAME) {
            this.TINSOLDER_STATUS_NAME = TINSOLDER_STATUS_NAME;
        }

        public String getIF_EXPIRED() {
            return IF_EXPIRED;
        }

        public void setIF_EXPIRED(String IF_EXPIRED) {
            this.IF_EXPIRED = IF_EXPIRED;
        }

        public int getLINE_ID() {
            return LINE_ID;
        }

        public void setLINE_ID(int LINE_ID) {
            this.LINE_ID = LINE_ID;
        }

        public String getLINE_NAME() {
            return LINE_NAME;
        }

        public void setLINE_NAME(String LINE_NAME) {
            this.LINE_NAME = LINE_NAME;
        }

        public String getCREATED_BY() {
            return CREATED_BY;
        }

        public void setCREATED_BY(String CREATED_BY) {
            this.CREATED_BY = CREATED_BY;
        }

        public String getCREATED_DATE() {
            return CREATED_DATE;
        }

        public void setCREATED_DATE(String CREATED_DATE) {
            this.CREATED_DATE = CREATED_DATE;
        }

        public String getLAST_UPDATED_BY() {
            return LAST_UPDATED_BY;
        }

        public void setLAST_UPDATED_BY(String LAST_UPDATED_BY) {
            this.LAST_UPDATED_BY = LAST_UPDATED_BY;
        }

        public String getLAST_UPDATED_DATE() {
            return LAST_UPDATED_DATE;
        }

        public void setLAST_UPDATED_DATE(String LAST_UPDATED_DATE) {
            this.LAST_UPDATED_DATE = LAST_UPDATED_DATE;
        }
    }
}
