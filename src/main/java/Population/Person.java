package Population;

import java.util.ArrayList;

public class Person {
  public String fName, lName="", occupation;
  public ArrayList<Integer> childId = new ArrayList<>();
  public int age, spouseId, numbOfChildren = 0, id;
  public boolean isMale, isMarried = false;

  public Person(String fName, String occupation, int age,
                int id, boolean isMale) {
    this.fName = fName;
    this.occupation = occupation;
    this.age = age;
    this.id = id;
    this.isMale = isMale;
  }

  public String toString() {
    return "id: " + id +
            ", fName: " + fName +
            ", lName: " + lName +
            ", occupation: " + occupation +
            ", childId: " + childId +
            ", age: " + age +
            ", spouseId: " + spouseId +
            ", numbOfChildren: " + numbOfChildren +
            ", gender: " + (isMale?"male":"female") +
            ", marital status: " + (isMarried?"married":"single");
  }
}
