# Group 28 assignments

please create Exs2 class inside your package and copy past code below:

```java
public class Exs2 {
  //TC#1: filter movies by rating
  //1. Open Chrome browser
  //2. Go to https://www.imdb.com/list/ls026253657/
  //3. Verify  title
  //Expected: "Movies 2020 - IMDb"
  // ****************************************
  //4. collect all similar WebElements containing movie info on to List named movies
  // They should be <div> tags that include all movie info
  // Image, movie name, raitind etc.
  //5. remove WebElement with movie rating less than 6
  //6. collect target WebElements from inside <head></head> to List named stylings:
  // target: <link rel="stylesheet" type="text/css">
  // 7. Create your HTML file inside same package as your current class
  // place all different <link> elements from you sylings List inside <head></head> of your HTML file
  // These stylesheets are used to aply styles to your movie elements that found inside <body></body>
  //8. Setup the target elements (look below) inside <body></body> of your HTML file
  // target: 
  // <div class="lister list detail sub-list">
  //    <div class="lister-list"></div>
  // </div>
  //9. Now let's put all the movies from movies List to your HTML file
  //place all WebElemens with movie info inside this div tag:
  // <div class="lister-list"></div>
  //10. open your HTML file with driver
  //11. Additional task:
  //Test your HTML using Assert methods that all raitings are >=6
  //this time decide yourself how you would get raitings from your HTML file
  //and how would you check the condition
}
```

##Second exercise (optional, a bit more advanced)

####Task:

Based on user stories and acceptance criterias create:
*Optional, you can create all or one of them* 
1. Test plan that includes test and execution tickets
2. Automation framework (smoke test) on Selenium to run all scenarios

Environment: "https://sobirjon001.github.io/todo_list/"

User stories and scenarios:

1. User is able to add new task to To-Do list
  a. User is able to type characters inside input box (task text)
  b. When user clicks plus button new task appeared in list below input box
  C. New task has exactly the same text that was typed by user in input box
2. User is not able to add new task with blank/empty input box
  a. While input box is empty or has space character user clicks plus button
  b. New task didn't appeared in list below input box
  c. Window alerts the user about invalid input
3. User is not able to add new duplicate task
  a. User types exactly same text as previously created task inside input box
  b. When user clicks plus button new (duplicate) task didn't appeared in list
  c. Window alerts the user about invalid input
4. User is able to toggle check mark task in list 
  a. Given user created some tasks user clicks green cheek mark button on task
  b. This task's text becomes outlined
  c. This task styling becomes under shadow
  d. User clicks green cheek mark button of same task again
  e. This task's text returns back to not outlined
  f. This task's styling return back to regular
5. User is able to filter tasks based on check mark condition
    *Given that user added some tasks and marked some of them*
  a. Drop down input default selection is "All"
  b. User clicks drop down input
  c. Drop down input shows all possible selections
  d. User clicks on "Completed" selection
  e. All marked task are displayed on list
  f. All not marked tasks are not displayed on list
  g. *Do same for "Uncompleted" selection
  e. *Select back to "All" to return to default condition for next tests*
6. User is able to delete task for list
  a. Given user created some tasks
  b. User clicks on red delete button on the task
  c. That exactly task is gone, doesn't exist on page
  d. *That task is not in not displayed state - it's not exist \
  so you have to handle noSuchElementExeption and use it in Assert report*
  e. *Tester has to remove tasks in different order to make sure \
  only particular task is removed not the other one*
