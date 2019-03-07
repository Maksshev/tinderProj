package dto;

public class User implements Identifiable {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String imgUrl;
    private String regUid;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String regUid) {
        this.regUid = regUid;
    }

    public User(int id, String login, String name, String surname, String imgUrl){
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.imgUrl = imgUrl;
    }

    public User(String login, String password, String name, String surname) {
        this(login, password);
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!imgUrl.equals(user.imgUrl)) return false;
        return regUid.equals(user.regUid);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + imgUrl.hashCode();
        result = 31 * result + regUid.hashCode();
        return result;
    }

    public User(String login, String password, String name, String surname, String imgUrl, String regUid) {
        this(login, password, name, surname);
        this.imgUrl = imgUrl;
        this.regUid = regUid;

    }

    public User(int id, String login, String password, String name, String surname, String imgUrl) {
        this(login, password, name, surname);
        this.id = id;
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", regUid='" + regUid + '\'' +
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRegUid() {
        return regUid;
    }

    public void setRegUid(String regUid) {
        this.regUid = regUid;
    }
}
