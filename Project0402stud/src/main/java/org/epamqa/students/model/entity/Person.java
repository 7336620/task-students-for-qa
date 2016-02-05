package org.epamqa.students.model.entity;

/**
 * Created by Администратор on 04.02.2016.
 */
public class Person {
    private int id;
    private String lastName;
    private String name;
    private char professionCode;
    private float weightPerson;

    public Person(int id, String lastName, String name, char professionCode, float weightPerson) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.professionCode = professionCode;
        this.weightPerson = weightPerson;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public char getProfessionCode() {
        return professionCode;
    }

    public float getWeightPerson() {
        return weightPerson;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessionCode(char professionCode) {
        this.professionCode = professionCode;
    }

    public void setWeightPerson(float weightPerson) {
        this.weightPerson = weightPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (professionCode != person.professionCode) return false;
        if (Double.compare(person.weightPerson, weightPerson) != 0) return false;
        if (!lastName.equals(person.lastName)) return false;
        return name.equals(person.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + lastName.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) professionCode;
        temp = Double.doubleToLongBits(weightPerson);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", professionCode=" + professionCode +
                ", weightPerson=" + weightPerson +
                '}';
    }
}
