package com.personal.expenses.domain.model;

public class ErrorResponse {
    private String hourDate;
    private Integer status;
    private String title;
    private String message;

    public ErrorResponse(String hourDate, Integer status, String title, String message) {
        this.hourDate = hourDate;
        this.status = status;
        this.title = title;
        this.message = message;
    }

    public String getHourDate() {
        return hourDate;
    }

    public void setHourDate(String hourDate) {
        this.hourDate = hourDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
