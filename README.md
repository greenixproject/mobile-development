# Mobile Application Greenix

## TODO
- [x] Design the application using figma
- [x] Implementation the design to Application Layout (XML)
- [x] Importing the required libraries
- [x] Features users activity
- [x] Make a connection to REST API
- [x] Implementation of Machine Learning Model
- [x] Unit Testing

## Features
- get carbon footprint from activity
- Predict the approximate number of carbon footprints from user activity inputs

## Minimum Requirement
- Android Studio Electric Eel | 2022.1.1

## Installation Instructions
Fork and clone the forked repository:
```shell
git clone git://github.com/<your_fork>/mobile-development
```
Navigate into cloned repository:
```shell
cd mobile-development
```
Create file project.properties:
```shell
touch project.properties
```
Fill project.properties with your configuration
```
CLIENT_ID="YOUR CLIENT ID"
API_URL="YOUR API URL"
```
Add google-services.json to the folder app. You can get google-services.json from Firebase or Google Cloud. 

You can follow this instruction [Using API Keys](https://developers.google.com/maps/documentation/android-sdk/get-api-key?hl=id)
```
cd app && touch google-services.json && nano google-services.json
```
After everything is done, you can build the application using android studio and run this project.

## Common Issues
**Problem**: unable to maximize the use of CRUD.

**Solving**: Ensure our CRUD operations are in sync with our business logic. Each operation should serve a specific purpose within our business model.

### Plugins
- [Android Jetpack](https://developer.android.com/jetpack)
- [Retrofit2](https://square.github.io/retrofit/)
