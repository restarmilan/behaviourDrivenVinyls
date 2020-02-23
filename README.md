Behaviour Driven Development project for get acquainted with this testing approach's special features, rules and possibilities.

* This is a practice only learning project it's main goal is to discover quite deeply the BDD method and the Cucumber and Gherkin syntax with Java.
* Maven is used for build and dependency configuration, initial project structure is created by the maven cucumber template.
* For generating test results maven's surefire plugin is used.
* For browser automation Selenium WebDriver (ChromeDriver) is used.
* This project is also establishing the page object model pattern for easy maintainability and re-usability.
* All user credentials are stored as environmental variables.
* Apart from discover new technologies it is also important to do not distract with SOLID and basic OOP principles during the whole project.


The System Under Test (SUT) is [Discogs](https://www.discogs.com/), the scenarios focuses on the page's different features, like:
* user access (login / logout) 
* user profile settings and validating settings changes
* search for artists and items
* wish list functions
* dynamically generated elements (tables based on a query, etc)