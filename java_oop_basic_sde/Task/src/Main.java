class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    //constructor
    public Task(int id, String title, String des, boolean com) {
        this.id = id;
        this.title = title;
        this.description = des;
        this.completed = com;
    }

    //display function
    void display() {
        System.out.println("details:" + id + " " + title + " " + description + " " + completed);
    }

    //setter function
    void setter_id(int id) {
        this.id = id;
    }

    void setter_title(String title) {
        this.title = title;
    }

    void setter_des(String des) {
        this.description = des;
    }

    void setter_complete(boolean mark) {
        this.completed = mark;
    }

    //getter function
    int getter_id() {
        return id;
    }

    String getter_title() {
        return title;
    }

    String getter_des() {
        return description;
    }

    boolean getter_complete() {
        return completed;
    }

    //Main logic

    void MarkCompleted() {
        completed = true;
    }

    void reopen() {
        completed = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Task obj1 = new Task(1, "dbms", "do 1 question", false);
        //obj1.display();
        System.out.println(obj1.getter_title());
        obj1.MarkCompleted();
        System.out.println(obj1.getter_complete());
        obj1.reopen();
        System.out.println(obj1.getter_complete());
    }
}