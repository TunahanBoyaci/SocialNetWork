package SocialNetWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            label24:
            while(true) {
                System.out.println("Insert email: ");
                String email = scanner.next();
                System.out.println("Insert password: ");
                String password = scanner.next();
                User user = socialNetwork.authenticate(email, password);
                if (user != null) {
                    System.out.println("Successfully logged in");
                    scanner.nextLine();

                    while(true) {
                        while(true) {
                            System.out.println("Welcome " + socialNetwork.getCurrentAuthenticatedUser().getFullName() + "!");
                            System.out.println(socialNetwork.getMenu());
                            String option = scanner.nextLine();
                            if (option.equals("1")) {
                                System.out.println("##### My Profile #####");
                                System.out.println(socialNetwork.getCurrentAuthenticatedUser());
                            } else if (option.equals("2")) {
                                System.out.println("Insert new name: ");
                                String name = scanner.nextLine();
                                System.out.println("Insert new surname: ");
                                String surname = scanner.nextLine();
                                socialNetwork.updateUserFullName(name, surname);
                                System.out.println("User name has been updated.");
                            } else if (option.equals("3")) {
                                System.out.println("##### My Friends #####");
                                ArrayList<User> friends = socialNetwork.getFriendList();
                                Iterator var8 = friends.iterator();

                                while(var8.hasNext()) {
                                    User u = (User)var8.next();
                                    System.out.println(u);
                                }
                            } else {
                                if (option.equals("0")) {
                                    System.out.println("Exiting...");
                                    socialNetwork.logout();
                                    continue label24;
                                }

                                System.out.println("Invalid entry");
                            }
                        }
                    }
                } else {
                    System.out.println("Incorrect email or password");
                }
            }
        }
    }
}
