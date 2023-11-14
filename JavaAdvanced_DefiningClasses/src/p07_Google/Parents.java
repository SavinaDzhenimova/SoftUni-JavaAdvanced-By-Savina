package p07_Google;

public class Parents {
    String parentName;
    String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String format(){
        return String.format("%s %s", parentName, parentBirthday);
    }
}