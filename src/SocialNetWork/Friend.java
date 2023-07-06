package SocialNetWork;

public class Friend {
    private User user;
    private User friend;

    public Friend(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    public Friend() {
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return this.friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
