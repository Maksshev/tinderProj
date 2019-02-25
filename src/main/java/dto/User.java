package dto;

public class User implements Identifiable {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String img;

    public User(int id, String login, String name, String surname, String img){
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.img = img;
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(String login, String password, String name, String surname, String img) {
        this(login, password, name, surname);
        this.img = img;
    }

    public User(int id, String login, String password, String name, String surname, String img) {
        this(login, password, name, surname);
        this.id = id;
        this.img = img;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
