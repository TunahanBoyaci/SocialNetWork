package SocialNetWork;

import java.util.ArrayList;
import java.util.Iterator;

public class Database {
    private static ArrayList<User> users = new ArrayList();
    private static ArrayList<Friend> friends = new ArrayList();

    public Database() {
    }

    public static ArrayList<User> getAllUsers() {
        return users;
    }

    public static User getUserByEmailAndPassword(String email, String password) {
        Iterator var2 = users.iterator();

        User u;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            u = (User)var2.next();
        } while(!email.equals(u.getEmail()));

        return u;
    }

    public static User getUserByID(Long id) {
        Iterator var1 = users.iterator();

        User u;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            u = (User)var1.next();
        } while(!id.equals(u.getId()));

        return u;
    }

    public static ArrayList<Friend> getFriends() {
        return friends;
    }

    public static void updateUserFullName(User user, String fullname) {
        for(int i = 0; i < users.size(); ++i) {
            if (((User)users.get(i)).getId() == user.getId()) {
                ((User)users.get(i)).setFullName(fullname);
                break;
            }
        }

    }

    static {
        users.add(new User(1L, "john@gmail.com", "123", "John Smith"));
        users.add(new User(2L, "caroline@gmail.com", "123456", "Caroline Brian"));
        users.add(new User(3L, "luba@gmail.com", "123", "Luba Yaroslava"));
        users.add(new User(4L, "sam@gmail.com", "123456", "Sam Kevin"));
        users.add(new User(5L, "tom@gmail.com", "123", "Tom Allen"));
        friends.add(new Friend((User)users.get(0), (User)users.get(1)));
        friends.add(new Friend((User)users.get(1), (User)users.get(0)));
        friends.add(new Friend((User)users.get(1), (User)users.get(0)));
        friends.add(new Friend((User)users.get(0), (User)users.get(1)));
        friends.add(new Friend((User)users.get(3), (User)users.get(0)));
        friends.add(new Friend((User)users.get(0), (User)users.get(3)));
        friends.add(new Friend((User)users.get(4), (User)users.get(1)));
        friends.add(new Friend((User)users.get(1), (User)users.get(4)));
    }
}
