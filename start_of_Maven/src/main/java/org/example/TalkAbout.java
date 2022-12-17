package org.example;

public class TalkAbout {
    private int id;
    private String Tsingle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTsingle() {
        return Tsingle;
    }

    public void setTsingle(String tsingle) {
        Tsingle = tsingle;
    }

    @Override
    public String toString() {
        return "TalkInformation{" +
                "id=" + id +
                ", Tsingle='" + Tsingle + '\'' +
                '}';
    }
}
