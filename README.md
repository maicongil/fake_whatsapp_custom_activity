# Custom Activity Spring Boot

### Steps
1. Clone this repo
2. Edit custom activity configuration
3. Customize configuration screen logic 
4. Customize endpoint logic
5. Deploy your app

### Files description

##### boot_custom_activity/src/main/resources/static
* **/images**: 
* **/js**: Contains all necessary libs
* **config.json**: Contains the configurations for the custom activity. These configurations may be overwriten in the configuration screen.
* **customActivity.js**: Contains the logic to interact with Journey Builder and configuration screen(index.html)
* **index.html**: This is the configuration screen to configure the custom activity in Journey Builder.
* **runnigHover.html**
* **runningModal.html**

##### /boot_custom_activity/src/main/java/com/boot/custom

* **ActivityController.java**: Contains all the endpoints that will be called by Marketing Cloud Journey.
* **ActivityResult.java**: A simple POJO to represent branchResult when building a custom split activity.
* **CustomActivityApplication.java**: Entry point of Spring Boot Application
* **ExecutePayload.java**: A POJO to represent the data sent by Jouney when the custom activity is triggered.
* **RequestLoggingFilterConfig.java**: Configuration to enable logging requests.

### Detailed Steps

1. Clone this repo

2. Edit custom activity configuration
    * Open config.js file
    * Replace all placeholders as follows:
        * YOUR APPLICATION EXTENSION KEY HERE
        * TYPE, FOR CUSTOM SPLIT ACTIVITY USE RESTDECISION
        * CUSTOM ACTIVITY NAME
        * CUSTOM ACTIVITY DESCRIPTION
        * URL OF THE SERVER RUNNING THE BACKEND
        * EXTERNAL KEY OF THE SALT KEY FOR THE JWT
    * If you aren't creating a custom aplit activity, remove the attribute "outcomes" else configure each path as you want.
    * If you want to know more about custom split activities, please check out [this link](https://developer.salesforce.com/docs/atlas.en-us.noversion.mc-app-development.meta/mc-app-development/extending-activities.htm)  
    * If you want to learn more about configuration, please check out 
 [this link](https://developer.salesforce.com/docs/atlas.en-us.noversion.mc-app-development.meta/mc-app-development/custom-activity-config.htm)

3. Customize configuration screen logic 
    * Open index.html and customActivity.js files
    * These files already have a working example which update the "inAttibutes" in config.js with the value of the selected event data column. You can edit these files to add your own logic.
    * If you want to add your own logic to configuration screen, you should check the [Postmonger events reference](https://developer.salesforce.com/docs/atlas.en-us.noversion.mc-app-development.meta/mc-app-development/using-postmonger.htm)

4. Customize endpoint logic

5. Deploy your app


### TODO

* Secure endpoints with JWT