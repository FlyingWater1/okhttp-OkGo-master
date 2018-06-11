package com.lzy.demo.model;

import java.util.List;

/**
 * Created by 54330 on 2018/3/29.
 */

public class SmtModel {

    /**
     * Code : Success
     * Data : [{"id":17,"dname":"MES","fid":0,"childs":[{"id":18,"dname":"基本数据管理","fid":17,"childs":[{"id":213,"dname":"工厂","fid":18,"childs":[{"id":26,"dname":"工厂管理","fid":213,"childs":[]},{"id":27,"dname":"线体管理","fid":213,"childs":[]},{"id":28,"dname":"工位管理","fid":213,"childs":[]}]},{"id":215,"dname":"平台","fid":18,"childs":[{"id":368,"dname":"国家管理","fid":215,"childs":[]},{"id":369,"dname":"运营商管理","fid":215,"childs":[]},{"id":73,"dname":"平台管理","fid":215,"childs":[]},{"id":24,"dname":"项目管理","fid":215,"childs":[]}]},{"id":214,"dname":"工艺","fid":18,"childs":[{"id":233,"dname":"工艺管理","fid":214,"childs":[]},{"id":113,"dname":"路由管理","fid":214,"childs":[]},{"id":615,"dname":"返工路由管理","fid":214,"childs":[]},{"id":353,"dname":"AAB管理","fid":214,"childs":[]},{"id":25,"dname":"工站查询","fid":214,"childs":[]}]},{"id":216,"dname":"测试","fid":18,"childs":[{"id":133,"dname":"测试项管理","fid":216,"childs":[]},{"id":193,"dname":"测试模板管理","fid":216,"childs":[]},{"id":273,"dname":"测试需求管理","fid":216,"childs":[]},{"id":114,"dname":"软件版本管理","fid":216,"childs":[]}]}]},{"id":656,"dname":"生产计划管理","fid":17,"childs":[{"id":880,"dname":"条码规则管理","fid":656,"childs":[]},{"id":900,"dname":"SN号段申请管理","fid":656,"childs":[]},{"id":901,"dname":"号码资源申请管理","fid":656,"childs":[]},{"id":924,"dname":"号码资源导入管理","fid":656,"childs":[]},{"id":973,"dname":"标贴模板管理","fid":656,"childs":[]}]},{"id":758,"dname":"产品属性配置","fid":17,"childs":[{"id":698,"dname":"属性基本信息","fid":758,"childs":[]},{"id":720,"dname":"产品属性信息管理","fid":758,"childs":[]},{"id":679,"dname":"产品号码类型管理","fid":758,"childs":[]},{"id":658,"dname":"号码库存管理","fid":758,"childs":[]},{"id":659,"dname":"号码安全库存管理","fid":758,"childs":[]},{"id":840,"dname":"TAC码校验信息维护","fid":758,"childs":[]}]},{"id":958,"dname":"仓储信息管理","fid":17,"childs":[{"id":971,"dname":"物料管理","fid":958,"childs":[{"id":972,"dname":"物料清单管理","fid":971,"childs":[]}]},{"id":949,"dname":"来料管理","fid":958,"childs":[{"id":950,"dname":"来料入库管理","fid":949,"childs":[]}]}]},{"id":19,"dname":"数据综合查询","fid":17,"childs":[{"id":960,"dname":"生产记录查询","fid":19,"childs":[{"id":77,"dname":"生产过程查询","fid":960,"childs":[]},{"id":505,"dname":"机台属性查询","fid":960,"childs":[]},{"id":588,"dname":"SN状态查询","fid":960,"childs":[]},{"id":424,"dname":"写号信息查询","fid":960,"childs":[]},{"id":547,"dname":"工站作业查询","fid":960,"childs":[]}]},{"id":961,"dname":"测试数据查询","fid":19,"childs":[{"id":30,"dname":"测试记录查询","fid":961,"childs":[]},{"id":381,"dname":"测试项查询","fid":961,"childs":[]}]},{"id":962,"dname":"包装数据查询","fid":19,"childs":[{"id":450,"dname":"包装明细查询","fid":962,"childs":[]},{"id":462,"dname":"包装记录查询","fid":962,"childs":[]},{"id":1045,"dname":"栈板数据导出","fid":962,"childs":[]},{"id":910,"dname":"ASN信息查询","fid":962,"childs":[]}]},{"id":596,"dname":"上料数据查询","fid":19,"childs":[]}]},{"id":20,"dname":"数据综合分析","fid":17,"childs":[{"id":313,"dname":"维修数据分析","fid":20,"childs":[{"id":314,"dname":"不良Top分析","fid":313,"childs":[]}]},{"id":355,"dname":"生产状况分析","fid":20,"childs":[{"id":356,"dname":"投入产出分析","fid":355,"childs":[]}]},{"id":604,"dname":"电子看板管理","fid":20,"childs":[{"id":955,"dname":"线体看板标配","fid":604,"childs":[]},{"id":956,"dname":"线体看板排程","fid":604,"childs":[]},{"id":957,"dname":"线体电子看板","fid":604,"childs":[]}]}]},{"id":21,"dname":"测试平台管理","fid":17,"childs":[{"id":333,"dname":"CheckSum","fid":21,"childs":[{"id":96,"dname":"CheckSum密码管理 ","fid":333,"childs":[]},{"id":97,"dname":"CheckSum用户管理","fid":333,"childs":[]}]}]},{"id":441,"dname":"质量业务管理","fid":17,"childs":[{"id":510,"dname":"SMTOQA管理","fid":441,"childs":[{"id":463,"dname":"SMT-OQA","fid":510,"childs":[]},{"id":461,"dname":"批次号替换","fid":510,"childs":[]},{"id":442,"dname":"批次号关闭 ","fid":510,"childs":[]},{"id":445,"dname":"批次号解除","fid":510,"childs":[]},{"id":612,"dname":"返工批次号解除","fid":510,"childs":[]},{"id":548,"dname":"批次整批释放","fid":510,"childs":[]}]},{"id":507,"dname":"质量业务查询","fid":441,"childs":[{"id":443,"dname":"抽检记录查询","fid":507,"childs":[]}]},{"id":616,"dname":"返工作业","fid":441,"childs":[{"id":617,"dname":"SMT返工扫描","fid":616,"childs":[]},{"id":618,"dname":"组装返工扫描","fid":616,"childs":[]}]}]},{"id":760,"dname":"生产作业管理","fid":17,"childs":[{"id":959,"dname":"贴片作业管理","fid":760,"childs":[{"id":564,"dname":"PCB连扳配置","fid":959,"childs":[]},{"id":592,"dname":"上料信息导入","fid":959,"childs":[]},{"id":965,"dname":"上料表信息查询","fid":959,"childs":[]},{"id":594,"dname":"PCBA物料追溯查询","fid":959,"childs":[]},{"id":595,"dname":"PCBA物料综合查询","fid":959,"childs":[]},{"id":1032,"dname":"质量对料数据查询","fid":959,"childs":[]},{"id":593,"dname":"连板绑定信息查询","fid":959,"childs":[]}]},{"id":968,"dname":"辅配件绑定管理","fid":760,"childs":[{"id":483,"dname":"绑定配置管理","fid":968,"childs":[]},{"id":537,"dname":"绑定关系解除","fid":968,"childs":[]},{"id":465,"dname":"绑定关系查询","fid":968,"childs":[]}]}]},{"id":22,"dname":"号码资源管理","fid":17,"childs":[{"id":388,"dname":"号码释放","fid":22,"childs":[{"id":360,"dname":"SN写号释放","fid":388,"childs":[]},{"id":362,"dname":"解除号码绑定","fid":388,"childs":[]},{"id":363,"dname":"串号打印释放","fid":388,"childs":[]}]},{"id":1027,"dname":"屏蔽解除产品","fid":22,"childs":[{"id":1028,"dname":"屏蔽产品","fid":1027,"childs":[]},{"id":1029,"dname":"解除屏蔽","fid":1027,"childs":[]}]}]},{"id":382,"dname":"系统配置管理","fid":17,"childs":[{"id":400,"dname":"路由重定向管理","fid":382,"childs":[]},{"id":440,"dname":"枚举类型管理","fid":382,"childs":[]},{"id":598,"dname":"常用枚举管理","fid":382,"childs":[{"id":602,"dname":"SFC区分管理","fid":598,"childs":[]}]}]},{"id":497,"dname":"维修管理","fid":17,"childs":[{"id":584,"dname":"PCBA维修管理","fid":497,"childs":[{"id":585,"dname":"PCBA不良提报","fid":584,"childs":[]},{"id":586,"dname":"PCBA维修销帐","fid":584,"childs":[]},{"id":587,"dname":"PCBA维修查询","fid":584,"childs":[]}]},{"id":951,"dname":"整机维修管理","fid":497,"childs":[{"id":952,"dname":"整机不良提报","fid":951,"childs":[]},{"id":953,"dname":"整机维修销账","fid":951,"childs":[]},{"id":954,"dname":"整机维修查询","fid":951,"childs":[]}]}]},{"id":1044,"dname":"设备耗材管理","fid":17,"childs":[{"id":1033,"dname":"FEEDER管理","fid":1044,"childs":[{"id":1034,"dname":"产品入库","fid":1033,"childs":[]},{"id":1035,"dname":"产品领出","fid":1033,"childs":[]},{"id":1036,"dname":"产品保养","fid":1033,"childs":[]},{"id":1037,"dname":"产品维修提报","fid":1033,"childs":[]},{"id":1039,"dname":"产品维修销账","fid":1033,"childs":[]},{"id":1040,"dname":"产品综合查询","fid":1033,"childs":[]},{"id":1041,"dname":"产品保养查询","fid":1033,"childs":[]},{"id":1042,"dname":"产品维修查询","fid":1033,"childs":[]},{"id":1043,"dname":"产品信息查询","fid":1033,"childs":[]}]},{"id":1047,"dname":"钢网管理","fid":1044,"childs":[{"id":1050,"dname":"钢网验收","fid":1047,"childs":[]},{"id":1049,"dname":"钢网入库","fid":1047,"childs":[]},{"id":1051,"dname":"钢网领出","fid":1047,"childs":[]},{"id":1052,"dname":"钢网上线","fid":1047,"childs":[]},{"id":1053,"dname":"钢网下线","fid":1047,"childs":[]},{"id":1054,"dname":"钢网清洗","fid":1047,"childs":[]},{"id":1055,"dname":"钢网清洗确认","fid":1047,"childs":[]},{"id":1056,"dname":"钢网异常处理","fid":1047,"childs":[]},{"id":1048,"dname":"钢网综合查询","fid":1047,"childs":[]},{"id":1059,"dname":"钢网信息查询","fid":1047,"childs":[]}]},{"id":1061,"dname":"锡膏管理","fid":1044,"childs":[{"id":1063,"dname":"锡膏入库","fid":1061,"childs":[]},{"id":1065,"dname":"锡膏领出","fid":1061,"childs":[]},{"id":1066,"dname":"锡膏上线","fid":1061,"childs":[]},{"id":1067,"dname":"锡膏下线","fid":1061,"childs":[]},{"id":1068,"dname":"锡膏归还","fid":1061,"childs":[]},{"id":1069,"dname":"锡膏回温","fid":1061,"childs":[]},{"id":1062,"dname":"锡膏综合查询","fid":1061,"childs":[]},{"id":1070,"dname":"锡膏信息查询","fid":1061,"childs":[]},{"id":1071,"dname":"将过期锡膏查询","fid":1061,"childs":[]}]},{"id":1073,"dname":"治具管理","fid":1044,"childs":[{"id":1075,"dname":"治具入库","fid":1073,"childs":[]},{"id":1076,"dname":"治具领出","fid":1073,"childs":[]},{"id":1077,"dname":"治具归还","fid":1073,"childs":[]},{"id":1082,"dname":"治具信息查询","fid":1073,"childs":[]},{"id":1074,"dname":"治具综合查询","fid":1073,"childs":[]},{"id":1079,"dname":"不良治具录入","fid":1073,"childs":[]},{"id":1080,"dname":"不良治具维修归还","fid":1073,"childs":[]},{"id":1083,"dname":"不良原因","fid":1073,"childs":[]},{"id":1081,"dname":"治具维修信息查询","fid":1073,"childs":[]},{"id":1078,"dname":"治具维修综合查询","fid":1073,"childs":[]}]}]},{"id":23,"dname":"系统管理","fid":17,"childs":[{"id":53,"dname":"模块管理","fid":23,"childs":[]},{"id":44,"dname":"权限管理","fid":23,"childs":[]},{"id":43,"dname":"角色管理","fid":23,"childs":[]},{"id":42,"dname":"用户管理","fid":23,"childs":[]},{"id":63,"dname":"部门管理","fid":23,"childs":[]},{"id":373,"dname":"任务管理","fid":23,"childs":[]},{"id":52,"dname":"日志管理","fid":23,"childs":[]},{"id":64,"dname":"系统配置","fid":23,"childs":[]},{"id":484,"dname":"应用程序管理","fid":23,"childs":[]}]},{"id":636,"dname":"个人设置","fid":17,"childs":[{"id":637,"dname":"密码修改","fid":636,"childs":[]}]}]}]
     */

    private String Code;
    private List<DataBean> Data;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * id : 17
         * dname : MES
         * fid : 0
         * childs : [{"id":18,"dname":"基本数据管理","fid":17,"childs":[{"id":213,"dname":"工厂","fid":18,"childs":[{"id":26,"dname":"工厂管理","fid":213,"childs":[]},{"id":27,"dname":"线体管理","fid":213,"childs":[]},{"id":28,"dname":"工位管理","fid":213,"childs":[]}]},{"id":215,"dname":"平台","fid":18,"childs":[{"id":368,"dname":"国家管理","fid":215,"childs":[]},{"id":369,"dname":"运营商管理","fid":215,"childs":[]},{"id":73,"dname":"平台管理","fid":215,"childs":[]},{"id":24,"dname":"项目管理","fid":215,"childs":[]}]},{"id":214,"dname":"工艺","fid":18,"childs":[{"id":233,"dname":"工艺管理","fid":214,"childs":[]},{"id":113,"dname":"路由管理","fid":214,"childs":[]},{"id":615,"dname":"返工路由管理","fid":214,"childs":[]},{"id":353,"dname":"AAB管理","fid":214,"childs":[]},{"id":25,"dname":"工站查询","fid":214,"childs":[]}]},{"id":216,"dname":"测试","fid":18,"childs":[{"id":133,"dname":"测试项管理","fid":216,"childs":[]},{"id":193,"dname":"测试模板管理","fid":216,"childs":[]},{"id":273,"dname":"测试需求管理","fid":216,"childs":[]},{"id":114,"dname":"软件版本管理","fid":216,"childs":[]}]}]},{"id":656,"dname":"生产计划管理","fid":17,"childs":[{"id":880,"dname":"条码规则管理","fid":656,"childs":[]},{"id":900,"dname":"SN号段申请管理","fid":656,"childs":[]},{"id":901,"dname":"号码资源申请管理","fid":656,"childs":[]},{"id":924,"dname":"号码资源导入管理","fid":656,"childs":[]},{"id":973,"dname":"标贴模板管理","fid":656,"childs":[]}]},{"id":758,"dname":"产品属性配置","fid":17,"childs":[{"id":698,"dname":"属性基本信息","fid":758,"childs":[]},{"id":720,"dname":"产品属性信息管理","fid":758,"childs":[]},{"id":679,"dname":"产品号码类型管理","fid":758,"childs":[]},{"id":658,"dname":"号码库存管理","fid":758,"childs":[]},{"id":659,"dname":"号码安全库存管理","fid":758,"childs":[]},{"id":840,"dname":"TAC码校验信息维护","fid":758,"childs":[]}]},{"id":958,"dname":"仓储信息管理","fid":17,"childs":[{"id":971,"dname":"物料管理","fid":958,"childs":[{"id":972,"dname":"物料清单管理","fid":971,"childs":[]}]},{"id":949,"dname":"来料管理","fid":958,"childs":[{"id":950,"dname":"来料入库管理","fid":949,"childs":[]}]}]},{"id":19,"dname":"数据综合查询","fid":17,"childs":[{"id":960,"dname":"生产记录查询","fid":19,"childs":[{"id":77,"dname":"生产过程查询","fid":960,"childs":[]},{"id":505,"dname":"机台属性查询","fid":960,"childs":[]},{"id":588,"dname":"SN状态查询","fid":960,"childs":[]},{"id":424,"dname":"写号信息查询","fid":960,"childs":[]},{"id":547,"dname":"工站作业查询","fid":960,"childs":[]}]},{"id":961,"dname":"测试数据查询","fid":19,"childs":[{"id":30,"dname":"测试记录查询","fid":961,"childs":[]},{"id":381,"dname":"测试项查询","fid":961,"childs":[]}]},{"id":962,"dname":"包装数据查询","fid":19,"childs":[{"id":450,"dname":"包装明细查询","fid":962,"childs":[]},{"id":462,"dname":"包装记录查询","fid":962,"childs":[]},{"id":1045,"dname":"栈板数据导出","fid":962,"childs":[]},{"id":910,"dname":"ASN信息查询","fid":962,"childs":[]}]},{"id":596,"dname":"上料数据查询","fid":19,"childs":[]}]},{"id":20,"dname":"数据综合分析","fid":17,"childs":[{"id":313,"dname":"维修数据分析","fid":20,"childs":[{"id":314,"dname":"不良Top分析","fid":313,"childs":[]}]},{"id":355,"dname":"生产状况分析","fid":20,"childs":[{"id":356,"dname":"投入产出分析","fid":355,"childs":[]}]},{"id":604,"dname":"电子看板管理","fid":20,"childs":[{"id":955,"dname":"线体看板标配","fid":604,"childs":[]},{"id":956,"dname":"线体看板排程","fid":604,"childs":[]},{"id":957,"dname":"线体电子看板","fid":604,"childs":[]}]}]},{"id":21,"dname":"测试平台管理","fid":17,"childs":[{"id":333,"dname":"CheckSum","fid":21,"childs":[{"id":96,"dname":"CheckSum密码管理 ","fid":333,"childs":[]},{"id":97,"dname":"CheckSum用户管理","fid":333,"childs":[]}]}]},{"id":441,"dname":"质量业务管理","fid":17,"childs":[{"id":510,"dname":"SMTOQA管理","fid":441,"childs":[{"id":463,"dname":"SMT-OQA","fid":510,"childs":[]},{"id":461,"dname":"批次号替换","fid":510,"childs":[]},{"id":442,"dname":"批次号关闭 ","fid":510,"childs":[]},{"id":445,"dname":"批次号解除","fid":510,"childs":[]},{"id":612,"dname":"返工批次号解除","fid":510,"childs":[]},{"id":548,"dname":"批次整批释放","fid":510,"childs":[]}]},{"id":507,"dname":"质量业务查询","fid":441,"childs":[{"id":443,"dname":"抽检记录查询","fid":507,"childs":[]}]},{"id":616,"dname":"返工作业","fid":441,"childs":[{"id":617,"dname":"SMT返工扫描","fid":616,"childs":[]},{"id":618,"dname":"组装返工扫描","fid":616,"childs":[]}]}]},{"id":760,"dname":"生产作业管理","fid":17,"childs":[{"id":959,"dname":"贴片作业管理","fid":760,"childs":[{"id":564,"dname":"PCB连扳配置","fid":959,"childs":[]},{"id":592,"dname":"上料信息导入","fid":959,"childs":[]},{"id":965,"dname":"上料表信息查询","fid":959,"childs":[]},{"id":594,"dname":"PCBA物料追溯查询","fid":959,"childs":[]},{"id":595,"dname":"PCBA物料综合查询","fid":959,"childs":[]},{"id":1032,"dname":"质量对料数据查询","fid":959,"childs":[]},{"id":593,"dname":"连板绑定信息查询","fid":959,"childs":[]}]},{"id":968,"dname":"辅配件绑定管理","fid":760,"childs":[{"id":483,"dname":"绑定配置管理","fid":968,"childs":[]},{"id":537,"dname":"绑定关系解除","fid":968,"childs":[]},{"id":465,"dname":"绑定关系查询","fid":968,"childs":[]}]}]},{"id":22,"dname":"号码资源管理","fid":17,"childs":[{"id":388,"dname":"号码释放","fid":22,"childs":[{"id":360,"dname":"SN写号释放","fid":388,"childs":[]},{"id":362,"dname":"解除号码绑定","fid":388,"childs":[]},{"id":363,"dname":"串号打印释放","fid":388,"childs":[]}]},{"id":1027,"dname":"屏蔽解除产品","fid":22,"childs":[{"id":1028,"dname":"屏蔽产品","fid":1027,"childs":[]},{"id":1029,"dname":"解除屏蔽","fid":1027,"childs":[]}]}]},{"id":382,"dname":"系统配置管理","fid":17,"childs":[{"id":400,"dname":"路由重定向管理","fid":382,"childs":[]},{"id":440,"dname":"枚举类型管理","fid":382,"childs":[]},{"id":598,"dname":"常用枚举管理","fid":382,"childs":[{"id":602,"dname":"SFC区分管理","fid":598,"childs":[]}]}]},{"id":497,"dname":"维修管理","fid":17,"childs":[{"id":584,"dname":"PCBA维修管理","fid":497,"childs":[{"id":585,"dname":"PCBA不良提报","fid":584,"childs":[]},{"id":586,"dname":"PCBA维修销帐","fid":584,"childs":[]},{"id":587,"dname":"PCBA维修查询","fid":584,"childs":[]}]},{"id":951,"dname":"整机维修管理","fid":497,"childs":[{"id":952,"dname":"整机不良提报","fid":951,"childs":[]},{"id":953,"dname":"整机维修销账","fid":951,"childs":[]},{"id":954,"dname":"整机维修查询","fid":951,"childs":[]}]}]},{"id":1044,"dname":"设备耗材管理","fid":17,"childs":[{"id":1033,"dname":"FEEDER管理","fid":1044,"childs":[{"id":1034,"dname":"产品入库","fid":1033,"childs":[]},{"id":1035,"dname":"产品领出","fid":1033,"childs":[]},{"id":1036,"dname":"产品保养","fid":1033,"childs":[]},{"id":1037,"dname":"产品维修提报","fid":1033,"childs":[]},{"id":1039,"dname":"产品维修销账","fid":1033,"childs":[]},{"id":1040,"dname":"产品综合查询","fid":1033,"childs":[]},{"id":1041,"dname":"产品保养查询","fid":1033,"childs":[]},{"id":1042,"dname":"产品维修查询","fid":1033,"childs":[]},{"id":1043,"dname":"产品信息查询","fid":1033,"childs":[]}]},{"id":1047,"dname":"钢网管理","fid":1044,"childs":[{"id":1050,"dname":"钢网验收","fid":1047,"childs":[]},{"id":1049,"dname":"钢网入库","fid":1047,"childs":[]},{"id":1051,"dname":"钢网领出","fid":1047,"childs":[]},{"id":1052,"dname":"钢网上线","fid":1047,"childs":[]},{"id":1053,"dname":"钢网下线","fid":1047,"childs":[]},{"id":1054,"dname":"钢网清洗","fid":1047,"childs":[]},{"id":1055,"dname":"钢网清洗确认","fid":1047,"childs":[]},{"id":1056,"dname":"钢网异常处理","fid":1047,"childs":[]},{"id":1048,"dname":"钢网综合查询","fid":1047,"childs":[]},{"id":1059,"dname":"钢网信息查询","fid":1047,"childs":[]}]},{"id":1061,"dname":"锡膏管理","fid":1044,"childs":[{"id":1063,"dname":"锡膏入库","fid":1061,"childs":[]},{"id":1065,"dname":"锡膏领出","fid":1061,"childs":[]},{"id":1066,"dname":"锡膏上线","fid":1061,"childs":[]},{"id":1067,"dname":"锡膏下线","fid":1061,"childs":[]},{"id":1068,"dname":"锡膏归还","fid":1061,"childs":[]},{"id":1069,"dname":"锡膏回温","fid":1061,"childs":[]},{"id":1062,"dname":"锡膏综合查询","fid":1061,"childs":[]},{"id":1070,"dname":"锡膏信息查询","fid":1061,"childs":[]},{"id":1071,"dname":"将过期锡膏查询","fid":1061,"childs":[]}]},{"id":1073,"dname":"治具管理","fid":1044,"childs":[{"id":1075,"dname":"治具入库","fid":1073,"childs":[]},{"id":1076,"dname":"治具领出","fid":1073,"childs":[]},{"id":1077,"dname":"治具归还","fid":1073,"childs":[]},{"id":1082,"dname":"治具信息查询","fid":1073,"childs":[]},{"id":1074,"dname":"治具综合查询","fid":1073,"childs":[]},{"id":1079,"dname":"不良治具录入","fid":1073,"childs":[]},{"id":1080,"dname":"不良治具维修归还","fid":1073,"childs":[]},{"id":1083,"dname":"不良原因","fid":1073,"childs":[]},{"id":1081,"dname":"治具维修信息查询","fid":1073,"childs":[]},{"id":1078,"dname":"治具维修综合查询","fid":1073,"childs":[]}]}]},{"id":23,"dname":"系统管理","fid":17,"childs":[{"id":53,"dname":"模块管理","fid":23,"childs":[]},{"id":44,"dname":"权限管理","fid":23,"childs":[]},{"id":43,"dname":"角色管理","fid":23,"childs":[]},{"id":42,"dname":"用户管理","fid":23,"childs":[]},{"id":63,"dname":"部门管理","fid":23,"childs":[]},{"id":373,"dname":"任务管理","fid":23,"childs":[]},{"id":52,"dname":"日志管理","fid":23,"childs":[]},{"id":64,"dname":"系统配置","fid":23,"childs":[]},{"id":484,"dname":"应用程序管理","fid":23,"childs":[]}]},{"id":636,"dname":"个人设置","fid":17,"childs":[{"id":637,"dname":"密码修改","fid":636,"childs":[]}]}]
         */

        private int id;
        private String dname;
        private int fid;
        private List<ChildsBeanXX> childs;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDname() {
            return dname;
        }

        public void setDname(String dname) {
            this.dname = dname;
        }

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public List<ChildsBeanXX> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBeanXX> childs) {
            this.childs = childs;
        }

        public static class ChildsBeanXX {
            /**
             * id : 18
             * dname : 基本数据管理
             * fid : 17
             * childs : [{"id":213,"dname":"工厂","fid":18,"childs":[{"id":26,"dname":"工厂管理","fid":213,"childs":[]},{"id":27,"dname":"线体管理","fid":213,"childs":[]},{"id":28,"dname":"工位管理","fid":213,"childs":[]}]},{"id":215,"dname":"平台","fid":18,"childs":[{"id":368,"dname":"国家管理","fid":215,"childs":[]},{"id":369,"dname":"运营商管理","fid":215,"childs":[]},{"id":73,"dname":"平台管理","fid":215,"childs":[]},{"id":24,"dname":"项目管理","fid":215,"childs":[]}]},{"id":214,"dname":"工艺","fid":18,"childs":[{"id":233,"dname":"工艺管理","fid":214,"childs":[]},{"id":113,"dname":"路由管理","fid":214,"childs":[]},{"id":615,"dname":"返工路由管理","fid":214,"childs":[]},{"id":353,"dname":"AAB管理","fid":214,"childs":[]},{"id":25,"dname":"工站查询","fid":214,"childs":[]}]},{"id":216,"dname":"测试","fid":18,"childs":[{"id":133,"dname":"测试项管理","fid":216,"childs":[]},{"id":193,"dname":"测试模板管理","fid":216,"childs":[]},{"id":273,"dname":"测试需求管理","fid":216,"childs":[]},{"id":114,"dname":"软件版本管理","fid":216,"childs":[]}]}]
             */

            private int id;
            private String dname;
            private int fid;
            private List<ChildsBeanX> childs;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDname() {
                return dname;
            }

            public void setDname(String dname) {
                this.dname = dname;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public List<ChildsBeanX> getChilds() {
                return childs;
            }

            public void setChilds(List<ChildsBeanX> childs) {
                this.childs = childs;
            }

            public static class ChildsBeanX {
                /**
                 * id : 213
                 * dname : 工厂
                 * fid : 18
                 * childs : [{"id":26,"dname":"工厂管理","fid":213,"childs":[]},{"id":27,"dname":"线体管理","fid":213,"childs":[]},{"id":28,"dname":"工位管理","fid":213,"childs":[]}]
                 */

                private int id;
                private String dname;
                private int fid;
                private List<ChildsBean> childs;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDname() {
                    return dname;
                }

                public void setDname(String dname) {
                    this.dname = dname;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public List<ChildsBean> getChilds() {
                    return childs;
                }

                public void setChilds(List<ChildsBean> childs) {
                    this.childs = childs;
                }

                public static class ChildsBean {
                    /**
                     * id : 26
                     * dname : 工厂管理
                     * fid : 213
                     * childs : []
                     */

                    private int id;
                    private String dname;
                    private int fid;
                    private List<?> childs;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getDname() {
                        return dname;
                    }

                    public void setDname(String dname) {
                        this.dname = dname;
                    }

                    public int getFid() {
                        return fid;
                    }

                    public void setFid(int fid) {
                        this.fid = fid;
                    }

                    public List<?> getChilds() {
                        return childs;
                    }

                    public void setChilds(List<?> childs) {
                        this.childs = childs;
                    }
                }
            }
        }
    }
}
