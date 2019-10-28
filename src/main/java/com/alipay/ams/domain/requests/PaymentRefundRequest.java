/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.ams.domain.requests;

import java.util.Map;

import com.alipay.ams.cfg.AMSSettings;
import com.alipay.ams.domain.Amount;
import com.alipay.ams.domain.Body;
import com.alipay.ams.domain.Request;
import com.alipay.ams.util.StringUtil;

/**
 * 
 * @author guangling.zgl
 * @version $Id: PaymentRefundRequest.java, v 0.1 2019年10月18日 下午5:58:58 guangling.zgl Exp $
 */
public class PaymentRefundRequest extends Request {

    private String  paymentId;
    private String  refundRequestId;
    private String  referenceRefundId;
    private Amount  refundAmount;
    private String  refundReason;
    private String  refundRequestTime;
    private boolean isAsyncRefund;
    private String  agentToken;

    /**
     * @param requestURI
     * @param settings
     */
    public PaymentRefundRequest(AMSSettings settings, String paymentId, String refundRequestId,
                                Amount refundAmount, String refundRequestTime) {
        this(settings, paymentId, refundRequestId, refundAmount, refundRequestTime, null);
    }

    /**
     * @param requestURI
     * @param settings
     */
    public PaymentRefundRequest(AMSSettings settings, String paymentId, String refundRequestId,
                                Amount refundAmount, String refundRequestTime, String agentToken) {

        super("/ams/api/v1/payments/refund", settings);
        this.paymentId = paymentId;
        this.refundRequestId = refundRequestId;
        this.refundAmount = refundAmount;
        this.refundRequestTime = refundRequestTime;
        this.agentToken = agentToken;

    }

    /** 
     * @see com.alipay.ams.domain.Request#getExtraHeaders()
     */
    @Override
    protected Map<String, String> getExtraHeaders() {

        Map<String, String> extraHeaders = super.getExtraHeaders();

        if (StringUtil.isNotBlank(this.agentToken)) {
            extraHeaders.put("Agent-Token", this.agentToken);
        }

        return extraHeaders;
    }

    /** 
     * @see com.alipay.ams.domain.Request#buildBody()
     */
    @Override
    public Body buildBody() {

        Body body = new Body();
        body.put("paymentId", paymentId);
        body.put("refundRequestId", refundRequestId);
        body.put("refundAmount", refundAmount);
        body.put("refundRequestTime", refundRequestTime);
        return body;

    }

    /** 
     * @see com.alipay.ams.domain.AMSMessage#getBizIdentifier()
     */
    @Override
    public String getBizIdentifier() {
        return refundRequestId;
    }

    /** 
     * @see com.alipay.ams.domain.Request#extValidate()
     */
    @Override
    protected boolean extValidate() {
        return true;
    }

    /** 
     * @see com.alipay.ams.domain.Request#getExt()
     */
    @Override
    protected String getExt() {
        return null;
    }

    /**
     * Getter method for property <tt>paymentId</tt>.
     * 
     * @return property value of paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Setter method for property <tt>paymentId</tt>.
     * 
     * @param paymentId value to be assigned to property paymentId
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Getter method for property <tt>refundRequestId</tt>.
     * 
     * @return property value of refundRequestId
     */
    public String getRefundRequestId() {
        return refundRequestId;
    }

    /**
     * Setter method for property <tt>refundRequestId</tt>.
     * 
     * @param refundRequestId value to be assigned to property refundRequestId
     */
    public void setRefundRequestId(String refundRequestId) {
        this.refundRequestId = refundRequestId;
    }

    /**
     * Getter method for property <tt>referenceRefundId</tt>.
     * 
     * @return property value of referenceRefundId
     */
    public String getReferenceRefundId() {
        return referenceRefundId;
    }

    /**
     * Setter method for property <tt>referenceRefundId</tt>.
     * 
     * @param referenceRefundId value to be assigned to property referenceRefundId
     */
    public void setReferenceRefundId(String referenceRefundId) {
        this.referenceRefundId = referenceRefundId;
    }

    /**
     * Getter method for property <tt>refundAmount</tt>.
     * 
     * @return property value of refundAmount
     */
    public Amount getRefundAmount() {
        return refundAmount;
    }

    /**
     * Setter method for property <tt>refundAmount</tt>.
     * 
     * @param refundAmount value to be assigned to property refundAmount
     */
    public void setRefundAmount(Amount refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * Getter method for property <tt>refundReason</tt>.
     * 
     * @return property value of refundReason
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * Setter method for property <tt>refundReason</tt>.
     * 
     * @param refundReason value to be assigned to property refundReason
     */
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    /**
     * Getter method for property <tt>refundRequestTime</tt>.
     * 
     * @return property value of refundRequestTime
     */
    public String getRefundRequestTime() {
        return refundRequestTime;
    }

    /**
     * Setter method for property <tt>refundRequestTime</tt>.
     * 
     * @param refundRequestTime value to be assigned to property refundRequestTime
     */
    public void setRefundRequestTime(String refundRequestTime) {
        this.refundRequestTime = refundRequestTime;
    }

    /**
     * Getter method for property <tt>isAsyncRefund</tt>.
     * 
     * @return property value of isAsyncRefund
     */
    public boolean isAsyncRefund() {
        return isAsyncRefund;
    }

    /**
     * Setter method for property <tt>isAsyncRefund</tt>.
     * 
     * @param isAsyncRefund value to be assigned to property isAsyncRefund
     */
    public void setAsyncRefund(boolean isAsyncRefund) {
        this.isAsyncRefund = isAsyncRefund;
    }

    /**
     * Getter method for property <tt>agentToken</tt>.
     * 
     * @return property value of agentToken
     */
    public String getAgentToken() {
        return agentToken;
    }

    /**
     * Setter method for property <tt>agentToken</tt>.
     * 
     * @param agentToken value to be assigned to property agentToken
     */
    public void setAgentToken(String agentToken) {
        this.agentToken = agentToken;
    }

}