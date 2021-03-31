package Utils;

public enum LoginUsers {
    DemoDriver("asaf.demo6", "qqqqqqq4");

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    LoginUsers(String userName, String password){
        this.userName = userName;
        this.password = password;


    }
}
