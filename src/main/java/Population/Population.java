package Population;

import java.util.Random;

public class Population {

  public static Random r = new Random();

  public static Person[] createPopulation(int n) {
    // ======= Creating People database ===========
    Person[] peopleArr = new Person[n];
    // Creating data feed for random algorithm
    String[] occupationFeed = {"teacher", "software engineer", "cook", "artist", "doctor", "sales person", "driver"};
    String[] fMaleNameFeed = {"Alex", "Mickael", "David", "Bob", "Tom", "Jhon", "Christian", "Cruse", "Bruise", "Edy",
            "Leo"};
    String[] fFemaleNameFeed = {"Nancy", "Barbara", "Audry", "Vicky", "Lisa", "Sofie", "Katy", "Diane", "Lilly",
            "Stephanie", "Jill"};
    String[] lNameFeed = {"Smith", "Jefferson", "Shaffer", "Turner", "Walker", "Kennedy", "Johnson", "Fischer", "Red",
            "Claus", "Swarovski"};
    // Creating random people without any family connections
    for (int i = 0; i < n; i++) {
      int id = i + 1;
      int age = r.nextInt(81);
      String occupation = age < 1 ? "infant"
              : age < 6 ? "toddler"
              : age < 23 ? "student"
              : age < 65 ? occupationFeed[r.nextInt(occupationFeed.length)]
              : "senior citizen";
      boolean isMale = r.nextInt(2) > 0;
      String fName = isMale ? fMaleNameFeed[r.nextInt(fMaleNameFeed.length)]
              : fFemaleNameFeed[r.nextInt(fFemaleNameFeed.length)];
      peopleArr[i] = new Person(fName, occupation, age, id, isMale);
    }
    // Creating family connections based on age, sex and marital status
    // Getting people married
    for (Person male : peopleArr) {
      if (male.age > 21 && !male.isMarried && male.isMale) {
        for (Person female : peopleArr) {
          if (female.age > 21 && !female.isMarried && !female.isMale
                  && male.age >= (female.age - 3) && male.age <= (female.age + 3)) {
            male.isMarried = true;
            female.isMarried = true;
            male.spouseId = female.id;
            female.spouseId = male.id;
            male.lName = lNameFeed[r.nextInt(lNameFeed.length)];
            female.lName = male.lName;
            break;
          }
        }
      }
    }
    // Getting kids to their parents
    for(Person kid : peopleArr) {
      if (kid.age <= 21) {
        for (Person male : peopleArr) {
          if (male.age > 21 && male.isMarried && male.isMale
                  && male.age < kid.age + 40 && male.age > kid.age + 20
                  && male.numbOfChildren < 2) {
            male.numbOfChildren++;
            male.childId.add(kid.id);
            for (Person female : peopleArr) {
              if (female.spouseId == male.id ) {
                female.childId.add(kid.id);
                female.numbOfChildren++;
                break;
              }
            }
            kid.lName = male.lName;
            break;
          }
        }
      }
    }

    // Giving last names to single people
    for (Person single : peopleArr) {
      if (single.lName.equals("")) {
        single.lName = lNameFeed[r.nextInt(lNameFeed.length)];
      }
    }
    return peopleArr;
  }
}

