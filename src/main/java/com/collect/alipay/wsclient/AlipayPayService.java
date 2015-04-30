
package com.collect.alipay.wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AlipayPayService", targetNamespace = "http://service.alipay.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AlipayPayService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.PrecreateResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayPrecreatePic", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreatePic")
    @ResponseWrapper(localName = "alipayPrecreatePicResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreatePicResponse")
    public PrecreateResponse alipayPrecreatePic(
        @WebParam(name = "arg0", targetNamespace = "")
        PrecreateRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.CancelResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayCancel", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayCancel")
    @ResponseWrapper(localName = "alipayCancelResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayCancelResponse")
    public CancelResponse alipayCancel(
        @WebParam(name = "arg0", targetNamespace = "")
        CancelRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.RefundResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayRefund", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayRefund")
    @ResponseWrapper(localName = "alipayRefundResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayRefundResponse")
    public RefundResponse alipayRefund(
        @WebParam(name = "arg0", targetNamespace = "")
        RefundRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.QueryResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayQuery", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayQuery")
    @ResponseWrapper(localName = "alipayQueryResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayQueryResponse")
    public QueryResponse alipayQuery(
        @WebParam(name = "arg0", targetNamespace = "")
        QueryRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.PrecreateResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayPrecreate", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreate")
    @ResponseWrapper(localName = "alipayPrecreateResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreateResponse")
    public PrecreateResponse alipayPrecreate(
        @WebParam(name = "arg0", targetNamespace = "")
        PrecreateRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.PrecreateResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayPrecreatePicArray", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreatePicArray")
    @ResponseWrapper(localName = "alipayPrecreatePicArrayResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayPrecreatePicArrayResponse")
    public PrecreateResponse alipayPrecreatePicArray(
        @WebParam(name = "arg0", targetNamespace = "")
        PrecreateRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.CloseResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayClose", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayClose")
    @ResponseWrapper(localName = "alipayCloseResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayCloseResponse")
    public CloseResponse alipayClose(
        @WebParam(name = "arg0", targetNamespace = "")
        CloseRequest arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.collect.alipay.wsclient.CreateandpayResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alipayCreateandPay", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayCreateandPay")
    @ResponseWrapper(localName = "alipayCreateandPayResponse", targetNamespace = "http://service.alipay.com/", className = "com.collect.alipay.wsclient.AlipayCreateandPayResponse")
    public CreateandpayResponse alipayCreateandPay(
        @WebParam(name = "arg0", targetNamespace = "")
        CreateandpayRequest arg0);

}