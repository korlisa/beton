package ru.sfedu.vetClinicH.constants;

import java.util.List;

public class Result<T> {

    private List<T> bean;
    private Status status;
    private String answer;
    private Object object;
    private Long id;

    public Result(Result bean) {

    }

    public Result(Status status, String answer) {
        this.status = status;
        this.answer = answer;
    }

    public Result(Status status) {this.status = status;}

    public Result(List<T> bean){
        this.bean = bean;
    }

    public Result(List<T> bean, Status status) {
        this.bean = bean;
        this.status = status;
    }


    public Result(Status status, Long id) {
        this.status = status;
        this.id = id;
    }

    public List<T> getBean() {
        return bean;
    }

    public void setBean(List<T> bean) {
        this.bean = bean;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Result{" +
                "bean=" + bean +
                ", status=" + status +
                ", answer='" + answer + '\'' +
                ", object=" + object +
                ", id=" + id +
                '}';
    }
}
