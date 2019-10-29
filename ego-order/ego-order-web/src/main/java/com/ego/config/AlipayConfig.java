package com.ego.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101300677643";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNQcQhzu2xTRZp9MS15fnd0TdcogDBH1owglIHo61snT8n9eC34Mm84OZ30Egv8YwLo7/bp0aRReRTSoj74ZCpjgyIy10RkLYHLm3erS3IzjoAa2er4mT5w+T9t8SOqCoCgu57JVSzCN2hPVzxBBLRaemV8SOYznj3gypJhnmHYE1SsvT4XrvjrZmTSff3Ibbl95OWa3uEERmQsl8Kt8MneqN0n/DhWAkLxVywrgR6Bst+qN5X0Jtq/o9jAGZkxxeaByYCQajw5naj9+wdMYf4XZjjg6yoRclrMOhr7qcxBJeVzwJ0q5vUvgo+sbKG2ekSGFAkrASTgdVnhkDInhn7AgMBAAECggEAFYwbrACRt4MH0T/aJdkf5Vs9s66uqMbsjgvDEZFBKhlOgfz6u3HZtCsmXM5zxIR3FWt0H8CDfjOIIcBz5uBAneyiMte6qaxGaBAICHioTEJRDLFVjh2pw4PDUYSPwicayWlJkZVfNzQ6ApeGruktKa6bSBkRkgSk5TSn5bFSpniq333wC1CZmfCEXm9Y644kxc7nLFdy+oIYwpW2dQKf/AtYVydlPfWUqzTLlfePkKqjMjrtYUg/8rj4T5wc7Hw9bAwBw8Q+cKe3dzc2WP7pECHSCd1Z3s2xM6dgY9H3nJuuGa1cw4PMrGcBAMRwgk9ImGWYCKS4b4Qm3IQB/Wxr8QKBgQDS3az3K2c9OChIGDs2U6kiNQmsLWQKcQp5iPGMdD035bgyG6Snr0zEF7ZgYBD1+kyvP6PDR4J8I5izOvZkZMTBUOSm65TxF+bodzTKmZGbgTk0zUMAPDQ2pKEub1Npm7cebh2EYFZOD0XXeDsoWLxIw7fd9LBlj57ZJIt+wQwOswKBgQCrfeN1Yc7H3llXjQqf3VEwFGxoCAluT03vhlHjmTDlezBq++4We7I9r6yUoq6vy8BCe1k2GZw4P0G6CDk2943tSW5Z6XoWI0Gr2xuKMWrc8jCnFa3lpr8+mCU/p1/5K5y8i5pH2HKyU9tDmvhJbLtYqf8F/ShuvReMXVVLMunrmQKBgBFyAZNZZesssDh2uL9f4IhR9wDlqHcsrv8rE0DZhQ8Q1FJg8xhkamd2xsHmcMDI+nstOrE3Q1Zd445AfI4FwDl2JdShfOsNXS8yXY29csx4vnDd4oMsd+1lZWhgEXiVR2sfFRYUmk9O+CpBajOGU915Q8b7LXTZkvzIBzpvYj39AoGAd5V9e2kMzIrcOhT8B6ZI6wIS5ihUizt52UEM8Wztj9hrVu7+g2cWT7Wk3rDip2upUbK57uPE7+QMbTE21IGj0oeWD9SjcbR8It7TQXZcUl4AV0Li1HWGfpuRveV1I0eqMEAZAWiJ8phPGcGCyZCsw5MnZoG2JCJvvU2IILwMKmECgYBwVfXXPn9wUK/02qm/SqQrhccvUHLmRsKokkMFuouWZ7gHnzYL3o3+3jUqhlP+8DmPUkHMdHOsAcsyz+xEjKf30M50TeCXagfLqpAmOkYbKqlN7dckV4bYlXIkR6AKVa5CGCAv4klHow5v4JiqZUO5b91jRc5iPtna3dJb+qgF2A==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjUHEIc7tsU0WafTEteX53dE3XKIAwR9aMIJSB6OtbJ0/J/Xgt+DJvODmd9BIL/GMC6O/26dGkUXkU0qI++GQqY4MiMtdEZC2By5t3q0tyM46AGtnq+Jk+cPk/bfEjqgqAoLueyVUswjdoT1c8QQS0WnplfEjmM5494MqSYZ5h2BNUrL0+F67462Zk0n39yG25feTlmt7hBEZkLJfCrfDJ3qjdJ/w4VgJC8VcsK4EegbLfqjeV9Cbav6PYwBmZMcXmgcmAkGo8OZ2o/fsHTGH+F2Y44OsqEXJazDoa+6nMQSXlc8CdKub1L4KPrGyhtnpEhhQJKwEk4HVZ4ZAyJ4Z+wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9092/ego-order-web/order/myOrder";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径
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
