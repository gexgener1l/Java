package com.webblog.blog.dto_classes;

public class ResponseDTO {
    private String status;
    private String message;
    private String pageTitle;
    private int statusCode;
    private String lastModified;
    private String metaDescription;
    private String metaKeywords;

    private String errorDetails;

    // Геттеры
    public String getStatus() {
        return status;
    }
    public String getErrorDetails(){
        return errorDetails;
    }

    public String getMessage() {
        return message;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    // Сеттеры
    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public void setErrorDetails(String message) {
        this.errorDetails = message;
    }
}

