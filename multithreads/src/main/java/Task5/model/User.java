package Task5.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    String name;
    String lastName;

    private static Pattern usrNamePtrn = Pattern.compile("[a-zA-Z]*");

    public User(String name, String lastName) throws Exception {
       validateUserName(name);
       validateUserName(lastName);

        this.name = name;
        this.lastName=lastName;
    }


    public static void validateUserName(String userName) throws Exception {

        Matcher mtch = usrNamePtrn.matcher(userName);
        if(mtch.matches()){
        } else {
            throw new Exception ("Sorry. Inncorrect user name or lastname");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
