package com.example.laura.pruebaandroid_estebanposada2;

/**
 * Created by Laura on 28/08/2016.
 */
public class Movie {
    private String name, dura, gend, age, hora, url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDura() {
        return dura;
    }

    public void setDura(String dura) {
        this.dura = dura;
    }

    public String getGend() {
        return gend;
    }

    public void setGend(String gend) {
        this.gend = gend;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Movie(String name, String dura, String gend, String age, String hora, String url) {

        this.name = name;
        this.dura = dura;
        this.gend = gend;
        this.age = age;
        this.hora = hora;
        this.url = url;
    }
}
