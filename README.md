# Group 28 assignments

please create Exs1 class inside your package and copy past code below:

```java
import AsignmentUtils.Population.Person;
import AsignmentUtils.Population.Population;

import java.util.ArrayList;
import java.util.Arrays;

public class Exs1 {
  public static void main(String[] args) {
    ArrayList<Person> allPeople = new ArrayList<>(Arrays.asList(Population.createPopulation(200)));

    /*
    1)  a - Create ArrayList of Person type and name it singlePeople
        b - Add all single people from allPeople to singlePeople (hint: isMarried = false)

    2)  a - Create ArrayList of Person type and name it parents
        b - Add all people that have kids from allPeople to parents (hint: numbOfChildren > 0)

    3)  a - Create ArrayList of Person type and name it noEngineers
        b - Add all people from allPeople to noEngineers
        c - remove all people that are "software engineer" (hint: occupation.equals("software engineer"))
        Very optional:
        d - if any relatives associated remove them too. (hint: look out for spouseId and childId)

    4)  a - change occupation from "doctor" to "Artist" in allPeople
     */
  }
}
```