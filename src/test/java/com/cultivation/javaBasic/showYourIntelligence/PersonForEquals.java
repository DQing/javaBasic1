package com.cultivation.javaBasic.showYourIntelligence;

@SuppressWarnings("unused")
public class PersonForEquals implements Comparable {
    private final String name;
    private final short yearOfBirth;

    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @SuppressWarnings("Contract")
    @Override
    public boolean equals(Object obj) {
        // TODO: please modify the following code to pass the test
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        PersonForEquals person = (PersonForEquals) obj;
        boolean nameSame = person.getName().equals(this.getName());
        boolean yearOfBirthSame = person.getYearOfBirth() == this.getYearOfBirth();
        return nameSame && yearOfBirthSame;
        // --end-->
    }

    @Override
    public int hashCode() {
        // TODO: please modify the following code to pass the test
        // <--start
        int result = 1;
        result = 31 * result + yearOfBirth;
        result = 31 * result + name.hashCode();
        return result;
//        return Objects.hash(name, yearOfBirth);
        // --end-->
    }


    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        PersonForEquals person = (PersonForEquals) o;
        int compare = getName().compareTo(person.getName());
        if (compare != 0) {
            return compare;
        }
        if (getYearOfBirth() == person.getYearOfBirth()) {
            return 0;
        }
        return yearOfBirth - person.yearOfBirth > 0 ? 1 : -1;
    }
}
