package serializable;

import java.io.Serializable;

/**
 * Created by hupo.wh on 2016/7/3.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(){

    }

    public Person(String str,int n){
        System.out.println("Inside Person's Constructor");
        name = str;
        age = n;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
