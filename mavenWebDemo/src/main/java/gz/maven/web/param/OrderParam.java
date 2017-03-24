package gz.maven.web.param;

import java.util.Random;

/**
 * Created by sheqingling on 16/8/17.
 */
public class OrderParam {

    //order feature
    private int isPayed;// = 1; // 用户支付方式 1: 在线支付 0: 货到付款
    private int logisticsOfflinePayOrderRecord;// = 0;// 商家结算方式 0:非线下结算 1:线下结算
    private int pkgType;// = 1;//包裹类型处理: 如果是1变成2,如果是2变成1, 如果是其它默认为1 todo 注释什么鬼
    private int isPrebook;// = 0;// 0普通订单 1预订单
    private int prebookType;// = 0;// 预订单类别 0 普通预订单（或者非预订单）1 隔夜预订单
    private int deliveryType;// = 1003;// HTTP是通过传入的appId确认,这里需要明确传入: 2002=快送,1003=众包, 1002=自建, 1001=代理, 0=商家自配, 2=趣活美食送, 2001=角马配送  //todo bmWaybillView.getDeliveryWayType()  概念太容易混淆了 todo  type
    private int deliveryPriority;// = 0;// 0:普通订单 100:必胜客订单

    //order detail
    private int cityId;// = 110100;    //城市ID
    private int platformId;// = 1;//  平台id
    private long deliveryId;// = 10001;// 外卖投递ID ;;;;//todo System.currentTimeMillis()
    private String platformPoiId;// = "107092"; // 商家ID
    private String poiSeq;// = "1";// 商家接单序号 todo String.valueOf(System.currentTimeMillis()).substring(11)
    private String qrcode;// = "111";// 订单二维码
    private String invoiceTitle;// = "北京三快在线科技有限公司";// 包裹发票信息
    private String remark;// = "少辣";// 备注信息

    private double originTotal;// = 98; //订单原始价格
    private double total;// = 110.23;// 订单优惠后的价格
    private double totalSharedAmount;// = 23.2;// 分成总金额
    private double totalSharedDiscount;// = 13;// 分成总折扣
    private double lunchboxAmount;// = 5;// 餐盒费,对应HTTP参数中的box_price_total
    private double poiShippingFee;// = 3;// 商家的配送费用,这里传入商家在查询时得到的配送费用
    private double tipAmount;// = 3.00;//小费
    private double riderPayment;// = -1;// 骑手应付款

    //sender
    private String senderName;// = "驻点单";// 发件人名称
    private String senderAddress;// = "天朝望京研发园科创大厦";// 发件人地址
    private String senderPhone;// = "18601342868";// 发件人电话
    private int senderLng;// = 116494082;// 发件人坐标的经度
    private int senderLat;// = 400121103;// 发件人坐标的纬度

    //recipient
    private String recipientName;// = "大胃王"; // 收件人姓名
    private String recipientAddress;// = "牡丹一枝花"; // 收件人地址
    private String recipientPhone;// = "15010611617"; // 收件人电话
    private int recipientLng;// = 116487539;// 收件人坐标的经度
    private int recipientLat;// = 40036270; // 收件人坐标的纬度


    private int auditResult;// = 10;//10未审核、15待总部审核、20审核通过、30审核不通过、40关闭审核
    private int invoiceAuditResult;//  =0 ;//  发票审核 BUSINESS_PASS(0, "待财务审核"),BUSINESS_INIT(4, "待业务审核"), BUSINESS_REFUSE(5, "业务拒绝"), BUSINESS_STOP(6, "停止付款");

    public String getRiskSubtag() {
        return riskSubtag;
    }

    public void setRiskSubtag(String riskSubtag) {
        this.riskSubtag = riskSubtag;
    }

    //页面传过来需要处理的
    private int publicSettleStep;
    private int selfSettleStep;
    private int agentPrepaySettleStep;
    private int agentPostageSettleStep;
    private int settlementLifeCycle;//= 4;//结算单生命周期 1:待抢单订单 ； 2:待取餐订单； 3:待送达订单；4:已送达订单；


    //页面没传的
    private String detail;// ="{\"goods\":[{\"goodCount\":4,\"goodName\":\"胡萝卜\",\"goodPrice\":12,\"goodUnit\":\"根\"},{\"goodCount\":1,\"goodName\":\"配送费\",\"goodPrice\":5.03,\"goodUnit\":\"共\"},{\"goodCount\":1,\"goodName\":\"基础配送费\",\"goodPrice\":2.22,\"goodUnit\":\"共\"},{\"goodCount\":1,\"goodName\":\"增量费\",\"goodPrice\":2.22,\"goodUnit\":\"共\"}]}";
    private String wmOrderViewId;// = "20150609004";// 外卖订单ID todo "test"+ System.currentTimeMillis()

    //so many times
    private int deliveredTime =(int)(System.currentTimeMillis()/1000+5700);// 预计送达时间

    public String getGoods() {
        return goods;
    }

    public void setGifts(String gifts) {

        this.gifts = gifts;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }


//    public List<OpenGoodsParam> goods; // optional
//    public List<OpenGiftParam> gifts; // optional
    private String gifts = "[{\"giftName\":\"apple\", \"giftType\":1}]";
    private String goods = "[{\"detailId\":9266551163,\"foodId\":170713748,\"goodName\":\"库存测试g\",\"goodPrice\":6.0,\"goodCount\":1,\"goodUnit\":\"份\",\"cartId\":0,\"goodSpec\":\"3个\",\"arrtValues\":[],\"boxCount\":1.0,\"boxPrice\":0.0,\"refundStatus\":0,\"refundCount\":0,\"refundAmount\":0.0,\"refundTime\":0}]";
    public double deliveryFee; // optional
    public double deliveryFeeBase; // optional
    public double deliveryFeeExtra; // optional
    public int partialRefundStatus; // optional



    //rider
//    private String riderPhone;// = "18515061085";//接单骑手电话； 18515061085
    private Long riderId;// = "18515061085";//接单骑手电话； 18515061085

    //settle
    private int riskLevel;// = 0; //众包风控标签
    private String riskTag;//= 104; //众包风控等级
    private String riskSubtag ;


//    public List<OpenGoodsParam> getGoods() {
//        return goods;
//    }

    public String getGifts() {
        return gifts;
    }


//    public List<OpenGiftParam> getGifts() {
//        return gifts;
//    }

    @Override
    public String toString() {
        return "OrderParam{" +
                "isPayed=" + isPayed +
                ", logisticsOfflinePayOrderRecord=" + logisticsOfflinePayOrderRecord +
                ", pkgType=" + pkgType +
                ", isPrebook=" + isPrebook +
                ", prebookType=" + prebookType +
                ", deliveryType=" + deliveryType +
                ", deliveryPriority=" + deliveryPriority +
                ", cityId=" + cityId +
                ", platformId=" + platformId +
                ", deliveryId=" + deliveryId +
                ", platformPoiId='" + platformPoiId + '\'' +
                ", poiSeq='" + poiSeq + '\'' +
                ", qrcode='" + qrcode + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", remark='" + remark + '\'' +
                ", originTotal=" + originTotal +
                ", total=" + total +
                ", totalSharedAmount=" + totalSharedAmount +
                ", totalSharedDiscount=" + totalSharedDiscount +
                ", lunchboxAmount=" + lunchboxAmount +
                ", poiShippingFee=" + poiShippingFee +
                ", tipAmount=" + tipAmount +
                ", riderPayment=" + riderPayment +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderPhone='" + senderPhone + '\'' +
                ", senderLng=" + senderLng +
                ", senderLat=" + senderLat +
                ", recipientName='" + recipientName + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", recipientLng=" + recipientLng +
                ", recipientLat=" + recipientLat +
                ", auditResult=" + auditResult +
                ", invoiceAuditResult=" + invoiceAuditResult +
                ", publicSettleStep=" + publicSettleStep +
                ", selfSettleStep=" + selfSettleStep +
                ", agentPrepaySettleStep=" + agentPrepaySettleStep +
                ", agentPostageSettleStep=" + agentPostageSettleStep +
                ", settlementLifeCycle=" + settlementLifeCycle +
                ", detail='" + detail + '\'' +
                ", wmOrderViewId='" + wmOrderViewId + '\'' +
                ", deliveredTime=" + deliveredTime +
                ", gifts='" + gifts + '\'' +
                ", goods='" + goods + '\'' +
                ", deliveryFee=" + deliveryFee +
                ", deliveryFeeBase=" + deliveryFeeBase +
                ", deliveryFeeExtra=" + deliveryFeeExtra +
                ", partialRefundStatus=" + partialRefundStatus +
                ", riderId=" + riderId +
                ", riskLevel=" + riskLevel +
                ", riskTag='" + riskTag + '\'' +
                ", riskSubtag='" + riskSubtag + '\'' +
                '}';
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public double getDeliveryFeeBase() {
        return deliveryFeeBase;
    }

    public double getDeliveryFeeExtra() {
        return deliveryFeeExtra;
    }

    public int getPartialRefundStatus() {
        return partialRefundStatus;
    }


//    public void setGoods(List<OpenGoodsParam> goods) {
//        this.goods = goods;
//    }

//    public void setGifts(List<OpenGiftParam> gifts) {
//        this.gifts = gifts;
//    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void setDeliveryFeeBase(double deliveryFeeBase) {
        this.deliveryFeeBase = deliveryFeeBase;
    }

    public void setDeliveryFeeExtra(double deliveryFeeExtra) {
        this.deliveryFeeExtra = deliveryFeeExtra;
    }

    public void setPartialRefundStatus(int partialRefundStatus) {
        this.partialRefundStatus = partialRefundStatus;
    }


    public int getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(int isPayed) {
        this.isPayed = isPayed;
    }

    public int getLogisticsOfflinePayOrderRecord() {
        return logisticsOfflinePayOrderRecord;
    }

    public void setLogisticsOfflinePayOrderRecord(int logisticsOfflinePayOrderRecord) {
        this.logisticsOfflinePayOrderRecord = logisticsOfflinePayOrderRecord;
    }

    public int getPkgType() {
        return pkgType;
    }

    public void setPkgType(int pkgType) {
        this.pkgType = pkgType;
    }

    public int getIsPrebook() {
        return isPrebook;
    }

    public void setIsPrebook(int isPrebook) {
        this.isPrebook = isPrebook;
    }

    public int getPrebookType() {
        return prebookType;
    }

    public void setPrebookType(int prebookType) {
        this.prebookType = prebookType;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getDeliveryPriority() {
        return deliveryPriority;
    }

    public void setDeliveryPriority(int deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getPlatformPoiId() {
        return platformPoiId;
    }

    public void setPlatformPoiId(String platformPoiId) {
        this.platformPoiId = platformPoiId;
    }

    public String getPoiSeq() {
        return poiSeq;
    }

    public void setPoiSeq(String poiSeq) {
        this.poiSeq = poiSeq;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getOriginTotal() {
        return originTotal;
    }

    public void setOriginTotal(double originTotal) {
        this.originTotal = originTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalSharedAmount() {
        return totalSharedAmount;
    }

    public void setTotalSharedAmount(double totalSharedAmount) {
        this.totalSharedAmount = totalSharedAmount;
    }

    public double getTotalSharedDiscount() {
        return totalSharedDiscount;
    }

    public void setTotalSharedDiscount(double totalSharedDiscount) {
        this.totalSharedDiscount = totalSharedDiscount;
    }

    public double getLunchboxAmount() {
        return lunchboxAmount;
    }

    public void setLunchboxAmount(double lunchboxAmount) {
        this.lunchboxAmount = lunchboxAmount;
    }

    public double getPoiShippingFee() {
        return poiShippingFee;
    }

    public void setPoiShippingFee(double poiShippingFee) {
        this.poiShippingFee = poiShippingFee;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public double getRiderPayment() {
        return riderPayment;
    }

    public void setRiderPayment(double riderPayment) {
        this.riderPayment = riderPayment;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public int getSenderLng() {
        return senderLng;
    }

    public void setSenderLng(int senderLng) {
        this.senderLng = senderLng;
    }

    public int getSenderLat() {
        return senderLat;
    }

    public void setSenderLat(int senderLat) {
        this.senderLat = senderLat;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public int getRecipientLng() {
        return recipientLng;
    }

    public void setRecipientLng(int recipientLng) {
        this.recipientLng = recipientLng;
    }

    public int getRecipientLat() {
        return recipientLat;
    }

    public void setRecipientLat(int recipientLat) {
        this.recipientLat = recipientLat;
    }


    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskTag() {
        return riskTag;
    }

    public void setRiskTag(String riskTag) {
        this.riskTag = riskTag;
    }

    public int getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(int auditResult) {
        this.auditResult = auditResult;
    }

    public int getInvoiceAuditResult() {
        return invoiceAuditResult;
    }

    public void setInvoiceAuditResult(int invoiceAuditResult) {
        this.invoiceAuditResult = invoiceAuditResult;
    }

    public int getPublicSettleStep() {
        return publicSettleStep;
    }

    public void setPublicSettleStep(int publicSettleStep) {
        this.publicSettleStep = publicSettleStep;
    }

    public int getSelfSettleStep() {
        return selfSettleStep;
    }

    public void setSelfSettleStep(int selfSettleStep) {
        this.selfSettleStep = selfSettleStep;
    }

    public int getAgentPrepaySettleStep() {
        return agentPrepaySettleStep;
    }

    public void setAgentPrepaySettleStep(int agentPrepaySettleStep) {
        this.agentPrepaySettleStep = agentPrepaySettleStep;
    }

    public int getAgentPostageSettleStep() {
        return agentPostageSettleStep;
    }

    public void setAgentPostageSettleStep(int agentPostageSettleStep) {
        this.agentPostageSettleStep = agentPostageSettleStep;
    }

    public int getSettlementLifeCycle() {
        return settlementLifeCycle;
    }

    public void setSettlementLifeCycle(int settlementLifeCycle) {
        this.settlementLifeCycle = settlementLifeCycle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWmOrderViewId() {
        return wmOrderViewId;
    }

    public void setWmOrderViewId(String wmOrderViewId) {
        this.wmOrderViewId = wmOrderViewId;
    }

    public Long getRiderId() {
        return riderId;
    }

    public void setRiderId(Long riderId) {
        if(riderId == null) {
            this.riderId = 0l;
        } else {
            this.riderId = riderId;
        }
    }

    public void fixParam() {    //todo
        long random = System.currentTimeMillis();
        String wmOrderViewId = Long.toString(-random) + String.valueOf(Math.abs(new Random().nextInt(1000)));
        String poiSeq=String.valueOf(System.currentTimeMillis()).substring(11);
        long random1 = System.currentTimeMillis();
        this.setDeliveryId(-((int)random1));//todo 页面有传，这里要复写？
        this.setPoiSeq(poiSeq); //todo 页面有传，这里要复写？
        this.setWmOrderViewId(wmOrderViewId);
        //goods
//        OpenGoodsParam good = new OpenGoodsParam();
//        good.setDetailId(123456l);
//        good.setFoodId(99991l);
//        good.setGoodName("极品胡萝卜王");
//        good.setGoodPrice(22.22);
//        good.setGoodUnit("根");
//        good.setCartId(1);
//        good.setGoodSpec("spec");
//        ArrayList<String> arrtValues = new ArrayList<String>();
//        arrtValues.add("好吃啊");
//        good.setArrtValues(arrtValues);
//        //good1.setBoxNum(1);
//        good.setBoxPrice(1.0);
//
//        ArrayList<OpenGoodsParam> goods = new ArrayList<OpenGoodsParam>();
//        goods.add(good);
//        this.setGoods(goods);
//        //gift
//        OpenGiftParam gift = new OpenGiftParam();
//        gift.setGiftName("apple");
//        gift.setGiftType(4);
//        ArrayList<OpenGiftParam> gifts = new ArrayList<OpenGiftParam>();
//        gifts.add(gift);
        this.setGifts(gifts);
        this.setGoods(goods);
    }

}


