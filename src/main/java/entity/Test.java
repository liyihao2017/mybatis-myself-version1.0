package entity;

import lombok.Data;

@Data
public class Test {
    private Integer id;
    private int age;
    private String name;

    
    public int getAge() {
        return age;
    }

    
    public void setAge(int age) {
        this.age = age;
    }

    public Test(Integer id, Integer age, String name) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Test() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}