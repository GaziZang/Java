
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>结算自动化工具</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

    <link href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" /><!-- bootstrap 3.0.2 -->
    <link href="<c:url value='/static/bootstrap/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" /><!-- font Awesome -->
    <link href="<c:url value='/static/bootstrap/css/ionicons.min.css'/>" rel="stylesheet" type="text/css" /><!-- Ionicons -->
    <link href="<c:url value='/static/bootstrap/css/AdminLTE.css'/>" rel="stylesheet" type="text/css" /><!-- Theme style -->

    <style>
        .iCheck-helper{display:none!important}
        .iCheck-helper{display:none!important}
        #ZBBillCycle,#JMYZBillCycle,#JMDFBillCycle,#riskTagWrap,#riskSubtagWrap,#waybillRiskLevelWrap,#selfAuditWrap,#invoiceAuditWrap{display:none}
    </style>

</head>

<body class="skin-blue">

<header class="header">
    <a href="index" class="logo">
        banmatest
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
    </nav>
</header>

<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu active">
                <li class="treeview"><a href="#"> <i
                        class="fa fa-laptop"></i> <span>数据构造</span> <i
                        class="fa fa-angle-left pull-right"></i>
                </a>
                    <ul class="treeview-menu">
                        <li><a href="order"><i class="fa fa-angle-double-right"></i> 发单</a></li>
                        <li><a href="order_detail"><i class="fa fa-angle-double-right"></i> 订单信息查询</a></li>
                        <li><a href="datamake.jsp"><i class="fa fa-angle-double-right"></i> 发单2</a></li>
                        <li><a href="getdata.jsp"><i class="fa fa-angle-double-right"></i> 骑手模拟</a></li>
                        <li><a href="poi.jsp"><i class="fa fa-angle-double-right"></i> 商家模拟</a></li>
                        <li><a href="jiesuanAuto.jsp"><i class="fa fa-angle-double-right"></i> 结算自动化测试工具</a></li>

                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Right side column. Contains the navbar and content of the page -->
    <aside class="right-side">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                配送测试工具
                <small>集合</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-laptop"></i> Banmatest</a></li>
                <li><a href="#">数据构造</a></li>
                <li class="active">结算自动化测试工具</li>
            </ol>
        </section>

        <section class="content">
            <div class="row">
                <!-- left column -->
                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">运单——结算单——账单——打款/提现</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <label><font color="red">&nbsp;发单骑手,商家,组织信息请查询:http://wiki.sankuai.com/pages/viewpage.action?pageId=508013887</font></label>
                        <a href="http://wiki.sankuai.com/pages/viewpage.action?pageId=508013887"></a>
                        <form role="form" id="orderForm" name="orderParam">
                            <div class="box-body">
                                <div class="form-group">
                                    <label>组织类型(deliveryType)</label>
                                    <div class="radio" id="divDeliveryType">
                                        <label> <input type="radio" name="deliveryType" id="self" value="1002" checked/> 自建</label>
                                        <label> <input type="radio" name="deliveryType" id="agent" value="1001" /> 代理</label>
                                        <label> <input type="radio" name="deliveryType" id="people" value="1003"/> 众包</label>
                                        <label> <input type="radio" name="deliveryType" id="fast" value="2002" /> 快送</label>
                                        <label> <input type="radio" name="deliveryType" id="poi_managed" value="10031" /> 全托管</label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>订单是否是在线支付(isPayed)</label>
                                    <div class="radio">
                                        <label> <input type="radio" name="isPayed" id="optionsRadios1" value="1" checked/> yes</label>
                                        <label> <input type="radio" name="isPayed" id="optionsRadios2" value="0"/> no </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>是否为线下(logisticsOfflinePayOrderRecord)<font color="red">&nbsp;垫付款=订单已经付款&&线下商家</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="logisticsOfflinePayOrderRecord" id="off_pay1" value="1" > yes </label>
                                        <label> <input type="radio" name="logisticsOfflinePayOrderRecord" id="off_pay2" value="0" checked> no
                                    </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>是否代购(pkgType)</label>
                                    <div class="radio">
                                        <label> <input type="radio" name="pkgType" id="poi_confirm2" value="2" > yes </label>
                                        <label> <input type="radio" name="pkgType" id="poi_confirm1" value="1" checked> no </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>是否为预订单(isPrebook)</label>
                                    <div class="radio">
                                        <label> <input type="radio" name="isPrebook" id="Prebook1" value="1" > yes </label>
                                        <label> <input type="radio" name="isPrebook" id="Prebook2" value="0" checked> no </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>预约单类别(prebookType)</label>
                                    <div class="radio">
                                        <label> <input type="radio" name="prebookType" id="pre_book1" value="0" checked> 普通预约单 </label>
                                        <label> <input type="radio" name="prebookType" id="pre_book2" value="1"> 隔夜预约单</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>是否为必胜客订单(deliveryPriority)</label>
                                    <div class="radio">
                                        <label> <input type="radio" name="deliveryPriority"  id="deliveryPriority1" value="100" > yes </label>
                                        <label> <input type="radio" name="deliveryPriority" id="deliveryPriority2" value="0" checked> no </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>城市ID(cityId)<font color="red">&nbsp;必填*</font></label>
                                    <input type="text" class="form-control" name="cityId" id="cityId" value="110100" />
                                </div>
                                <div class="form-group">
                                    <label>平台ID(platformId)</label>
                                    <input type="text" class="form-control" name="platformId" id="platformId" value="1" />
                                </div>
                                <div class="form-group">
                                    <label>外卖投递ID(deliveryId)</label>
                                    <input type="text" class="form-control" name="deliveryId" id="deliveryId" value="10001" />
                                </div>
                                <div class="form-group">
                                    <label>商家ID(platformPoiId)<font color="red">&nbsp;必填*</font></label>
                                    <input type="text" class="form-control" name="platformPoiId" id="platformPoiId" value="123" />
                                </div>

                                <div class="form-group">
                                    <label>商家接单序号(poiSeq)</label>
                                    <input type="text" class="form-control" name="poiSeq" id="poiSeq" value="1-1" />
                                </div>
                                <div class="form-group">
                                    <label>商家配送费用(poiShippingFee)</label>
                                    <input type="text" class="form-control" name="poiShippingFee" id="poiShippingFee" value= "20" />
                                </div>

                                <div class="form-group">
                                     <label>订单详情(detail)</label>
                                     <input type="text" class="form-control" name="detail" id="detail" value= '{"goods":[{"goodCount":4,"goodName":"胡萝卜","goodPrice":12,"goodUnit":"根"},{"goodCount":1,"goodName":"配送费","goodPrice":5.03,"goodUnit":"共"},{"goodCount":1,"goodName":"基础配送费","goodPrice":2.22,"goodUnit":"共"},{"goodCount":1,"goodName":"增量费","goodPrice":2.22,"goodUnit":"共"}]}'/>
                                </div>

                                 <div class="form-group">
                                      <label>菜品详情列表	(goods)</label>
                                      <input type="text" class="form-control" name="goods" id="goods" value= '[{"detailId":9266551163,"foodId":170713748,"goodName":"库存测试g","goodPrice":6.0,"goodCount":1,"goodUnit":"份","cartId":0,"goodSpec":"3个","arrtValues":[],"boxCount":1.0,"boxPrice":0.0,"refundStatus":0,"refundCount":0,"refundAmount":0.0,"refundTime":0}]'/>
                                 </div>


                                  <div class="form-group">
                                       <label>赠品列表(gifts)</label>
                                       <input type="text" class="form-control" name="gifts" id="gifts" value= '[{"giftName":"apple", "giftType":1}]'/>
                                  </div>

                                    <div class="form-group">
                                         <label>配送费(deliveryFee)</label>
                                         <input type="text" class="form-control" name="deliveryFee" id="deliveryFee" value= '1.0'/>
                                    </div>
                                 <div class="form-group">
                                     <label>基础配送费   (deliveryFeeBase)</label>
                                     <input type="text" class="form-control" name="deliveryFeeBase" id="deliveryFeeBase" value= "1.0" />
                                 </div>
                                 <div class="form-group">
                                     <label>增量费(deliveryFeeExtra)</label>
                                     <input type="text" class="form-control" name="deliveryFeeExtra" id="deliveryFeeExtra" value= "0" />
                                 </div>
                                <div class="form-group">
                                    <label>发件人名称(senderName)</label>
                                    <input type="text" class="form-control" name="senderName" id="senderName" value= "Lucy" />
                                </div>
                                <div class="form-group">
                                    <label>发件人地址(senderAddress)</label>
                                    <input type="text" class="form-control" name="senderAddress" id="senderAddress" value= "望京西" />
                                </div>
                                <div class="form-group">
                                    <label>发件人电话(senderPhone)</label>
                                    <input type="text" class="form-control" name="senderPhone" id="senderPhone" value= "18888888888" />
                                </div>
                                <div class="form-group">
                                    <label>发件人经度(senderLng)</label>
                                    <input type="text" class="form-control" name="senderLng" id="senderLng" value= "116483969" />
                                </div>
                                <div class="form-group">
                                    <label>发件人纬度(senderLat)</label>
                                    <input type="text" class="form-control" name="senderLat" id="senderLat" value= "40007333" />
                                </div>
                                <div class="form-group">
                                    <label>收件人姓名(recipientName)</label>
                                    <input type="text" class="form-control" name="recipientName" id="recipientName" value="Lily" />
                                </div>
                                <div class="form-group">
                                    <label>收件人地址(recipientAddress)</label>
                                    <input type="text" class="form-control" name="recipientAddress" id="recipientAddress" value="西二旗" />
                                </div>
                                <div class="form-group">
                                    <label>收件人电话(recipientPhone)</label>
                                    <input type="text" class="form-control" name="recipientPhone" id="recipientPhone" value="19999999999" />
                                </div>
                                <div class="form-group">
                                    <label>收件人经度(recipientLng)</label>
                                    <input type="text" class="form-control" name="recipientLng" id="recipientLng" value="116483969" />
                                </div>
                                <div class="form-group">
                                    <label>收件人纬度(recipientLat)</label>
                                    <input type="text" class="form-control" name="recipientLat" id="recipientLat" value="40006333" />
                                </div>
                                <div class="form-group">
                                    <label>订单原始价格(originTotal)</label>
                                    <input type="text" class="form-control" name="originTotal" id="originTotal" value="22.4" />
                                </div>
                                <div class="form-group">
                                    <label>订单优惠后的价格(total)</label>
                                    <input type="text" class="form-control" name="total" id="total" value="26.5" />
                                </div>
                                <div class="form-group">
                                    <label>分成总金额(totalSharedAmount)</label>
                                    <input type="text" class="form-control" name="totalSharedAmount" id="totalSharedAmount" value="23.2" />
                                </div>
                                <div class="form-group">
                                    <label>分成总折扣(totalSharedDiscount)</label>
                                    <input type="text" class="form-control" name="totalSharedDiscount" id="totalSharedDiscount" value="13" />
                                </div>
                                <div class="form-group">
                                    <label>餐盒费(lunchboxAmount)</label>
                                    <input type="text" class="form-control" name="lunchboxAmount" id="lunchboxAmount" value="5" />
                                </div>
                                <div class="form-group">
                                    <label>骑手应付款(riderPayment)</label>
                                    <input type="text" class="form-control" name="riderPayment" id="riderPayment" value="-1"/>
                                </div>
                                <div class="form-group">
                                    <label>配送费(deliveryFee)</label>
                                    <input type="text" class="form-control" name="deliveryFee" id="deliveryFee" value="5" />
                                </div>
                                <div class="form-group">
                                    <label>基础配送费(deliveryFeeBase)</label>
                                    <input type="text" class="form-control" name="deliveryFeeBase" id="deliveryFeeBase" value="2" />
                                </div>
                                <div class="form-group">
                                     <label>增量配送费(deliveryFeeExtra)</label>
                                     <input type="text" class="form-control" name="deliveryFeeExtra" id="deliveryFeeExtra" value="2" />
                                </div>
                                <div class="form-group">
                                    <label>小费(tipAmount)</label>
                                    <input type="text" class="form-control" name="tipAmount" id="tipAmount" value="1" />
                                </div>
                                <div class="form-group">
                                    <label>订单二维码(qrcode)</label>
                                    <input type="text" class="form-control" name="qrcode" id="qrcode" value="111" />
                                </div>
                                <div class="form-group">
                                    <label>包裹发票信息(invoiceTitle)</label>
                                    <input type="text" class="form-control" name="invoiceTitle" id="invoiceTitle" value="meituan" />
                                </div>

                                <div class="form-group">
                                    <label>备注(remark)</label>
                                    <input type="text" class="form-control" name="remark" id="remark" value="备注信息" />
                                </div>

                                <%--<div class="form-group">--%>
                                    <%--<label>骑手电话<font color="red">&nbsp;必填*</font></label>--%>
                                    <%--<input type="text" class="form-control" name="riderPhone" id="riderPhone" value="骑手电话" />--%>
                                <%--</div>--%>

                                <div class="form-group">
                                    <label>骑手Id<font color="red">&nbsp;必填*</font></label>
                                    <input type="text" class="form-control" name="riderId" id="riderId" placeholder="骑手ID"/>
                                </div>

                                <div class="form-group" id ='settlementLifeCycleWrap'>
                                    <label>结算单生命周期<font color="red">&nbsp;必填* R端限制短时间内不能送达,若要直接送达,需要将骑手ID添加到配置中心pos节点的key:test.rider.id 下</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="settlementLifeCycle" id="waitingForGrab" value="1" checked>待抢单订单 </label>
                                        <label> <input type="radio" name="settlementLifeCycle" id="waitingForFetch" value="2">待取餐订单</label>
                                        <label> <input type="radio" name="settlementLifeCycle" id="waitingForDelivery" value="3" />待送达订单</label>
                                        <label> <input type="radio" name="settlementLifeCycle" id="Delivered" value="4" />已送达订单</label>
                                    </div>
                                </div>


                                <div class="form-group" id = "ZBBillCycle" >
                                    <label>众包-帐单生命周期<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="publicSettleStep" id="publicWaitRcAudit" value="4101" checked>众包-待风控审核 </label>
                                        <label> <input type="radio" name="publicSettleStep" id="publicDoneRcAudit" value="4102">众包-风控审核完毕</label>
                                        <label> <input type="radio" name="publicSettleStep" id="publicRiderWithDrow" value="4103" />众包-骑手提现</label>
                                    </div>
                                </div>


                                <div class="form-group" id = "ZJBillCycle">
                                    <label>自建-帐单生命周期<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="selfSettleStep" id="selfWaitAudit" value="1101" checked>自建-待审核</label>
                                        <label> <input type="radio" name="selfSettleStep" id="selfWaitSalarySettle" value="1103">自建-薪酬待结算</label>
                                        <label> <input type="radio" name="selfSettleStep" id="selfSalarySettled" value="1104" />自建-薪酬已经结算</label>
                                    </div>
                                </div>



                                <div class="form-group" id = "JMDFBillCycle">
                                    <label>加盟-垫付款帐单生命周期<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="agentPrepaySettleStep" id="agentPrePayWaitAudit" value="2101" checked>加盟垫付款待审核</label>
                                        <label> <input type="radio" name="agentPrepaySettleStep" id="agentPrepayWaitBill" value="2102">加盟垫付款待生成账单</label>
                                        <label> <input type="radio" name="agentPrepaySettleStep" id="agentPrepayWaitBillAudit" value="2103" />加盟垫付款待财务审核</label>
                                        <label> <input type="radio" name="agentPrepaySettleStep" id="agentPrepayDoneSettle" value="2104" />加盟垫付款结算完成</label>
                                    </div>
                                </div>

                                <div class="form-group" id = "JMYZBillCycle">
                                    <label>加盟-邮资账单生命周期<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="agentPostageSettleStep" id="agentPostageWaitBill" value="2201" checked>加盟邮资待生成账单</label>
                                        <label> <input type="radio" name="agentPostageSettleStep" id="agentPostageWaitInvoiceAudit" value="2202">加盟邮资待发票审核</label>
                                        <label> <input type="radio" name="agentPostageSettleStep" id="agentPostageWaitBillAudit" value="2203" />加盟邮资待财务审核</label>
                                        <label> <input type="radio" name="agentPostageSettleStep" id="agentPostageDoneSettle" value="2204" />加盟邮资结算完成</label>
                                    </div>
                                </div>

                                <div class="form-group" id="riskTagWrap" >
                                    <label>风控标签(riskTag)<font color="red">&nbsp;必填*</font></label> <input type="text" class="form-control" name="riskTag" id="riskTag" value="1,2" />
                                </div>

                                <div class="form-group" id="riskSubtagWrap" >
                                    <label>风控子标签(riskSubtag)<font color="red">&nbsp;必填*</font></label> <input type="text" class="form-control" name="riskSubtag" id="riskSubtag" value="1,5,3" />
                                </div>

                                <div class="form-group" id = "waybillRiskLevelWrap">
                                    <label>风控等级<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="riskLevel" id="notPass" value="1" checked>不通过</label>
                                        <label> <input type="radio" name="riskLevel" id="manualAudit" value="2">人工审核</label>
                                        <label> <input type="radio" name="riskLevel" id="pass" value="3" />通过</label>
                                        <label> <input type="radio" name="riskLevel" id="partialSettle" value="4" />部分结算</label>
                                    </div>
                                </div>

                                <div class="form-group" id = "selfAuditWrap">
                                    <label>自建审核<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="auditResult" id="selfAuditNotPass" value="30" checked>驳回</label>
                                        <label> <input type="radio" name="auditResult" id="selfAuditPass" value="20">通过</label>
                                    </div>
                                </div>


                                <div class="form-group" id = "invoiceAuditWrap">
                                    <label>加盟发票审核(invoiceAudit)<font color="red">&nbsp;必填*</font></label>
                                    <div class="radio">
                                        <label> <input type="radio" name="invoiceAuditResult" id="invoiceAuditPass" value="0" checked>通过</label>
                                        <label> <input type="radio" name="invoiceAuditResult" id="invoiceAuditNotPass" value="5">驳回</label>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div><!-- /.box -->
                </div><!--/.col (right) -->
                <div class="col-md-6">
                    <div class="box-footer">
                        <button type="button" class="btn btn-primary" id="orderStart">Start</button>
                    </div></br>
                    <!-- general form elements disabled -->
                    <div class="box box-warning">
                        <div class="box-header" >
                            <h3 class="box-title">运行结果如下</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div id= "myDiv"></div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!--/.col (right) -->
            </div>   <!-- /.row -->
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->
<script src="<c:url value='/static/bootstrap/js/jquery-2.1.4.js'/>" type="text/javascript" ></script>
<!-- Bootstrap -->
<script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>" type="text/javascript" ></script>
<!-- AdminLTE App -->
<script src="<c:url value='/static/bootstrap/js/AdminLTE/app.js'/>" type="text/javascript" ></script>

<script type= "text/javascript">
    $('#orderStart').click(function() {
        var options = {
            url: 'settle',
            type: 'post',
            dataType: 'json',
            data: $("#orderForm").serialize(),
            success : function(msg) {
                console.dir(msg);
                if(null != msg.resultCode) {
                    document.getElementById("myDiv").innerHTML = "<div>"
                    + msg.msg
                    + "</div>"
                    + "<div>"
                    + "isSuccess"
                    + " : "
                    + msg.success
                    + "</div>"
                    + "<div>"
                    + "resultCode"
                    + " : "
                    + msg.resultCode
                    + "</div>"
                    + "<div>"
                    + "resultMsg"
                    + " : "
                    + msg.msg
                    + "</div>"
                    + "<div>"
                    + "data"
                    + " : "
                    + msg.data
                    + "</div>"
                    + "<div>"
                    + "e"
                    + " : "
                    + msg.e
                    + "</div>"
                } else {
                    document.getElementById("myDiv").innerHTML = "<div>"
                    + msg.msg
                    + "</div>"
                }
            }
        };
        $.ajax(options);
    });


    $('#divDeliveryType label').click(
            function(){
                $('#ZBBillCycle').hide();
                $('#JMYZBillCycle').hide();
                $('#JMDFBillCycle').hide();
                $('#ZJBillCycle').hide();

                if($(this).find('input').attr('value')=='1002'){
                    $('#ZJBillCycle').show();
                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                    $('#invoiceAuditWrap').hide();

                }else if(($(this).find('input').attr('value')=='1003')||($(this).find('input').attr('value')=='2002')){
                    $('#ZBBillCycle').show();
                    $('#invoiceAuditWrap').hide();
                    $('#selfAuditWrap').hide();

                }else if ($(this).find('input').attr('value')=='1001'){
                    $('#JMYZBillCycle').show();
                    $('#JMDFBillCycle').show();

                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                    $('#selfAuditWrap').hide();
                }
            }
    )



    $('#divDeliveryType').on('click', '.iCheck-gz.maven.web.helper',
            function(){
                $('#ZBBillCycle').hide();
                $('#JMYZBillCycle').hide();
                $('#JMDFBillCycle').hide();
                $('#ZJBillCycle').hide();

                if($(this).prev().attr('value')=='1002'){
                    $('#ZJBillCycle').show();
                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                    $('#invoiceAuditWrap').hide();
                }else if(($(this).prev().attr('value')=='1003')||($(this).prev().attr('value')=='2002')) {
                    $('#ZBBillCycle').show();
                    $('#invoiceAuditWrap').hide();
                }else if($(this).prev().attr('value')=='1001'){
                    $('#JMYZBillCycle').show();
                    $('#JMDFBillCycle').show();
                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                }

            }
    )

    $('#ZBBillCycle .radio label').click(
            function(){
                if($(this).find('input').attr('value')=='4102'||$(this).find('input').attr('value')=='4103'){
                    $('#riskTagWrap').show();
                    $('#riskSubtagWrap').show();
                    $('#waybillRiskLevelWrap').show();

                }else {
                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                }

            }
    )

    $('#ZBBillCycle .radio label').on('click', '.iCheck-gz.maven.web.helper',
            function(){
                if($(this).prev().attr('value')=='1103'||$(this).prev().attr('value')=='1104'){
                    $('#riskTagWrap').show();
                    $('#riskSubtagWrap').show();
                    $('#waybillRiskLevelWrap').show();

                }else {
                    $('#riskTagWrap').hide();
                    $('#riskSubtagWrap').hide();
                    $('#waybillRiskLevelWrap').hide();
                }
            }
    )

    $('#ZJBillCycle .radio label').click(
            function(){
                if($(this).find('input').attr('value')=='1103'||$(this).find('input').attr('value')=='1104'){
                    $('#selfAuditWrap').show();

                }else {
                    $('#selfAuditWrap').hide();
                }

            }
    )

    $('#ZJBillCycle .radio label').on('click', '.iCheck-gz.maven.web.helper',
            function(){
                if($(this).prev().attr('value')=='1103'||$(this).prev().attr('value')=='1104'){
                    $('#selfAuditWrap').show();

                }else {
                    $('#selfAuditWrap').hide();

                }
            }
    )


    $('#JMYZBillCycle .radio label').click(
            function(){
                if($(this).find('input').attr('value')=='2202'){
                    $('#invoiceAuditWrap').show();

                }else {
                    $('#invoiceAuditWrap').hide();

                }

            }
    )

    $('#JMYZBillCycle .radio label').on('click', '.iCheck-gz.maven.web.helper',
            function(){
                if($(this).prev().attr('value')=='2202'){
                    $('#invoiceAuditWrap').show();

                }else {
                    $('#invoiceAuditWrap').hide();

                }
            }
    )

</script>

</body>

</html>