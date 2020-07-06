package com.ufostudio.crm.common.client.sms.model;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:24
 * @Package: com.ufostudio.crm.common.client.sms.model
 */

public class Content {
    private String title;
    private String summary;
    private String body;

    /**
     * 可选参数
     */
    private String androidOpenType;
    private String androidActivity;

    public Content() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAndroidOpenType() {
        return androidOpenType;
    }

    public void setAndroidOpenType(String androidOpenType) {
        this.androidOpenType = androidOpenType;
    }

    public String getAndroidActivity() {
        return androidActivity;
    }

    public void setAndroidActivity(String androidActivity) {
        this.androidActivity = androidActivity;
    }
}
