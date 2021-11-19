package com.loveyj.config;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117681496";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2rlDumDQidwpLdQWfGGLVjV7Ez56UY/tsrHMjSQTRpkJ+kFByRbd71tLKodX1/87lgWcdmb0GiA58rZ5facRymP4zAt13XrBq5ZUbHKKTJPBaRMIxA8SUnSNdnT+jrV7sV7jL7IChmdEN8noNXSJanZpOzZNvmFn2WkYtc603nqcooIkwGjXZz8AHAjJnJbYggdK1yigQdIicIdFTQ23AlHgJkeuoqAeZW+lEwn23FoLbnCHtjDg+WlrNJfHqo4JkUgdAyCeqNRy6sGeqd2S5XBHG6dOgkitx6xQ5mL8G9G+niDYzq760eZsQ+yesPRQkQpxntYyftUY3ON0dfsDbAgMBAAECggEAEwKo4WttYXjJ1XhkEV5USqzfg9OnSQHulCyN/soGelq26LzT4lBm+7grT3Lv9R2dxjxlIqtxBFD8UPUwWfWDv/kz2tMdgOKVsUoa7itYr79UU9B79OXTezOvDnriuIG+MxId5PrDmA2Nt8nX8bQTcyKbgD/ca+yK0Bws2WYETJlEa34uWtypkIE31FVj6DInIMEFlBT5ZatCJ0xRI6XwShtXUqGYC5DEZTpoXakUUmc6Qmooq0LbMBXFjwmsQzPGdlqxzfOqBHNtQN8ulRqCYZpndJDimSkc0h62Hs6tBnuETrjCwbPBiENhCP99iwc5724I8IYeAy5gNcGfNsxTwQKBgQD+F640Gi9h2v5iv7FoPbNXJQ5FHFRgaQrB6QMCVVUSQKjIqkblr1MUhzfWfxxHsuMHsLcvI00D6xRmU6/6GfOxBl9nhmXe4DmDGeowfQA5v1dvlA26zo9XuUME2lG60HGZze3kzYAq5T6xkyiClstQSHjBtKOGhIRjJf+Y4cgH8wKBgQC4DWVGe3QLzl29Kf2/5HO/atrENh4J62euR6w68trXOAOnpAabLRoX7png67t1GPAwyIhXoqBB4NNU1pSfy+F0MjYvGAUxz+85X3G0FsCb4fcUpijabsZkyrEPUK7smK/GTQaEqCPy2gGoUE8FYiPz9LbFlToEjla/LWHrexfFeQKBgQCjssHqk0wfcSUenX1AOTAHXro40C2UB1iE4QetQyiRn9KdpQYUB8YwnYTdzfp8PsWBONprpgSCF7uGyTfAm2OikwZ3/eA3nKGw0stL/dxdV+aO3gWSam1zCMoioDyzbIMjocY3+CUwfYzMfpBEwb2utWIG+ce4bDuWXO60ohFq/QKBgFFZomTn1iANw8MDl2PEryBxM2a8YMSTpw0SIt8fTnkICh2D02OtKLZhQOR4bS/RqQB28kSB3gGgROhfu+txayI3u1lPbaRZuuwJ8rDdyZ5c3x/iXXZGtiwApwgU6mwrBK5Kh1IFG3aQw2DItlSzzx5aEJr+XVl8LH1tqrUxgA1JAoGBAIALAWtRFH4bZOF0DSiSo7PUdUwZXgbF/RDABTdkJQipX9ZF2fSEKMNzx7fqfpYODExVqcalQqasxyvFIxAZrCOuYxK8y2j5yhBdB8mK7IcqNP1XDG3kvUIQZLa2gb1wJgk0xGx+MnZnc5dcgPQ7R6pb2m7+Dq94Mvih2g1M7HSU";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoM/uQ+6rmljkPuuUzBi54yEc2A0lG3VaNuwpl57+/n1LtdnZf+YtGm2rPqsluBasCEWKfcwK2hO7y69/m8BA5RtJaOy+vIll68Mw81sHk9wktlag5Bpi1umviEp9P1MXBYGHmP3IUm4PDfyT1pQJq2Gkd/lnchZhg7cCxCUS3blu39TW+fCwvVEATUuQUF4LLkaeYMMBlPy5of14KarLiAtcY2cWyEwjVZ0XalBX9BnkGIBKUOEpWADFzstx1pWW85iSu5jahfrMhgMUJhh1R1zZnMfR+LWRblV+rNP8z74lCszLZpCS5PTM40iLFGwnRHraGDGCdL51DDBloalw6wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:1314//alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:1314/buy/finishOrder";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
