package ru.iad.response;

public class ResponseUserAuth {
    private int answerCode;
    private String reason;
    private long userID;

    public ResponseUserAuth(int answerCode, String reason, long userID) {
        this.answerCode = answerCode;
        this.reason = reason;
        this.userID = userID;
    }
}
