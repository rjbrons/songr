# Spring Basic Web App
Create a basic web app, can also communicate with database to display saved info.

# Functionality

## Routes
`/home` - this route will print Hello World to the browser.

`/capitalize/<phrase>` - this route will print the given phrase to the browser in all caps

`/reverse` - this route takes a phrase param and reverses it then prints it to the browser.
    when using the /reverse route add a parameter in this way: 
    `/reverse?sentence=<phrase you want to have reversed> `

`/album` Displays list of albums in the database.

# How to Use

- open app in intelliJ
    - build App
    - run App
- command line
    - from root - `./gradlew bootRun`
    - from root (to run tests) - `./gradlew test`
    
Server will run on localhost:8080




