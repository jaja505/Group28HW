# Group 28 assignments

please create Exs2 class inside your package and copy past code below:

```java
public class Exs2 {
  //TC#1: filter movies by rating
  //1. Open Chrome browser
  //2. Go to https://www.imdb.com/list/ls026253657/
  //3. Verify  title
  //Expected: "Movies 2020 - IMDb"
  //4. collect all similar WebElements containing movie info on to List named movies
  // They should be <div> tags that include all movie info
  // Image, movie name, raitind etc.
  //5. remove WebElement with movie rating less than 6
  //6. collect target WebElements from inside <head></head> to List named stylings:
  // target: <link rel="stylesheet" type="text/css">
  // 7. Create your HTML file inside same package as your current class
  // place all <link> elements from you sylings List inside <head></head> of your HTML file
  // These stylesheets are needed to aply styles to your movie elements
  //8. create next element inside <body></body> of your HTML file
  // target: 
  // <div class="lister list detail sub-list">
  //    <div class="lister-list"></div>
  // </div>
  //9. place all WebElemens with movie info inside:
  // <div class="lister-list"></div>
  //10. open your HTML file with driver
  //11. Test your HTML using Assert methods that all raitings are >=6
  //tis time deside your self how you would get raitings from your HTML file
  //and how would you check the condition
}
```
