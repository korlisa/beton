package ru.sfedu.betonZavod.Constants;

public class Result {

    private Status status;
    private String answer;

    Result(){

    }

    public Result(Status status){
        this.status = status;
    }

    public Result(Status status, String answer) {
        this.status = status;
        this.answer = answer;
    }

    public Result(String answer) {
        this.answer = answer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", answer='" + answer + '\'' +
                '}';
    }
}
