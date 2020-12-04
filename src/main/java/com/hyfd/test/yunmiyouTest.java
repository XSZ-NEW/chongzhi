package com.hyfd.test;

import com.qianmi.open.api.ApiException;
import com.qianmi.open.api.DefaultOpenClient;
import com.qianmi.open.api.OpenClient;
import com.qianmi.open.api.request.BmRechargeMobilePayBillRequest;
import com.qianmi.open.api.response.BmRechargeMobilePayBillResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class yunmiyouTest {
    public static void main(String[] args) {
        /*
        App Key：10002760
App Secret：TrT7Mo0HF5qkkV2yBef70XlqFPbMVFfs
Access Token:61a948a610b345279f8fa7a157d6d27a
         */
        //HTTPS请求地址
        String url = "https://apilf.bm001.com/api";

        //系统参数
        String method = "";
        String Access_Token = "61a948a610b345279f8fa7a157d6d27a"; //接入码
        String v = "1.1";
        String sign = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date()); //时间

        String App_Key = "10002760";
        String App_Secret = "TrT7Mo0HF5qkkV2yBef70XlqFPbMVFfs";

        //业务参数
        String mobileNo = "15564756682";//手机号
        String rechargeAmount = "50";//充值金额
        String outerTid = "O123456789";//外部订单编号
        String callback = "";//回调URL
        String itemId = "250052";//话费充值商品编号


        OpenClient client = new DefaultOpenClient(url, App_Secret);
        BmRechargeMobilePayBillRequest req = new BmRechargeMobilePayBillRequest();
        req.setMobileNo(mobileNo);
        req.setRechargeAmount(rechargeAmount);
        try {
            BmRechargeMobilePayBillResponse response = client.execute(req, Access_Token);
           System.out.println("response = " + response);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
