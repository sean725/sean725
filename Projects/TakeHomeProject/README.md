# Welcome to sean725 - Yelp Clone!


**Overview:**

*This project is an Android mobile application, with the purpose of displaying data retrieved from the Yelp API. You can choose a city to explore the businesses in the area and the detail of the business.*

**Requirements:**

*Only compatible with Android - API 23 & Up*

*No adaptive layout for tablets.*

**Instructions:**

*To open the app, either download the project file and open the entire folder(SeanLee_TakeHomeProject) with Android studio or download the .apk file(yelp_clone.apk) and open in an Android Emulator or a physical Android device.*

***https://github.com/sean725/sean725/tree/master/Projects/TakeHomeProject***

**Features:**

1. Main Activity(1st screen): 

*User is able to choose between 5 cities to view business in the location.*

*Clicking on the row will navigate to BusinessesActivity.*

2. Businesses Activity(2nd screen):

*User is able to view 10 businesses in selected location.*

*Clicking on the white space(NOT the like button) of the row will navigate to BusinessDetailActivity.*

3. Business Detail Activity(3rd screen):

*User is able to view the detail of chosen business.
The detail consists of as follows.*

*- Business Name / Rating / Category / Address / 3 Reviews.*

**About Code:**

*App type: Android Mobile Application*

*- IDE: Android Studio*

*- Language: Java*

*- API: Yelp Public API*

*- Architecture Pattern: Model-View-ViewModel(MVVM)*

*- Database: SQLite*

*- HTTP Connection: Retrofit*

*- JSON Conversion: GSON converter*

*- Image Conversion: Picasso*


**Known errors and bugs:**

*None*

~~*1. BusinessesActivity(2nd screen): Like button does not indicate the proper like value.*~~
***Fixed on Jun 12, 2022***

~~*2. BusinessesActivity(2nd Screen): When the recyclerView is reloaded, saved value of the like button is refreshed. -> assuming there are some logic errors while implementing SQLiteOpenHelper*~~ ***Fixed on Jun 12, 2022***

