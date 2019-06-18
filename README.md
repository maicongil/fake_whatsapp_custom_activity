# fake whatsapp custom activity

##Steps that I followed to make a new custom activity  

* cloned [this repo](https://github.com/maicongil/boot_custom_activity)
 
* Created a component Journey Builder Activity with key f1a9d930-f3ed-4312-b7d6-c501c2f7eda9

* Created a external key in Marketing Cloud (SALT)
This is a secret = 0x54686973206973206120736563726574 
[JWT Customer Key](https://developer.salesforce.com/docs/atlas.en-us.noversion.mc-app-development.meta/mc-app-development/encode-custom-activities-using-jwt-customer-key.htm)

* created new app "fake-whatsapp-custom-activity.herokuapp.com" on heroku to host the custom activity 

* Edit config.js file
    * replaced YOUR APPLICATION EXTENSION KEY HERE with f1a9d930-f3ed-4312-b7d6-c501c2f7eda9
    * replaced URL OF THE SERVER RUNNING THE BACKEND with fake-whatsapp-custom-activity.herokuapp.com
    * replaced TYPE, FOR CUSTOM ACTIVITY USE RESTDECISION with REST
    * replaced CUSTOM ACTIVITY NAME with Fake WhatsApp Sender
    * replaced CUSTOM ACTIVITY DESCRIPTION A custom activity to simulate a call to an API that sends WhatsApp messages
    * replaced EXTERNAL KEY OF THE SALT KEY FOR THE JWT with 3111a4d9-8e1d-49f9-b280-090c45e11ccf
    * removed "outcomes" attribute because the type isn't RESTDECISION

* changed the method save on customActivity.js to populate "mobileNumber" inArgument

* edited the logic of execute endpoint in ActivityController.java

* changed the icons

* deployed the app

* Verified if custom activity was working in Journey Builder