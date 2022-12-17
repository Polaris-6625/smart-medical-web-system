package example;

public class MainInformation {
    private int id;
    private String place;
    private String time;
    private String name;
    private String score;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MainInformation{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }
}
