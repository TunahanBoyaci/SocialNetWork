package SocialNetWork;


import java.util.ArrayList;
import java.util.Iterator;

public class SocialNetwork {
    private User currentAuthenticatedUser = null;

    public SocialNetwork() {
    }

    public User authenticate(String email, String password) {
        User foundUser = Database.getUserByEmailAndPassword(email, password);
        this.currentAuthenticatedUser = foundUser;
        return foundUser;
    }

    public String getMenu() {
        return "[1] - My Profile\n[2] - Edit Profile\n[3] - My Friends\n[0] - Logout";
    }

    public User getCurrentAuthenticatedUser() {
        return this.currentAuthenticatedUser;
    }

    public void logout() {
        this.currentAuthenticatedUser = null;
    }

    public ArrayList<User> getFriendList() {
        ArrayList<Friend> allFriends = Database.getFriends();
        ArrayList<User> userFriends = new ArrayList();
        Iterator var3 = allFriends.iterator();

        while(var3.hasNext()) {
            Friend f = (Friend)var3.next();
            if (f.getUser().getId() == this.currentAuthenticatedUser.getId()) {
                userFriends.add(f.getFriend());
            }
        }

        return userFriends;
    }

    public void updateUserFullName(String name, String surname) {
        Database.updateUserFullName(this.currentAuthenticatedUser, name + " " + surname);
        this.currentAuthenticatedUser.setFullName(name + " " + surname);
    }
}
