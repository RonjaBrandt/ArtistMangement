/**
 * Created by Ronja on 2018-11-20.
 */
public class Artist {

    private int id;
    private String name;
    private String lastName;
    private int age;


    public Artist(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }



    public int getAge() {
        return age;
    }


}
