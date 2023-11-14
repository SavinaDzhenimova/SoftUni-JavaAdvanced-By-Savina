package p07_Google;

public class Children {
    String childName;
    String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String format(){
        return String.format("%s %s", childName, childBirthday);
    }
}