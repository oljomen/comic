# comic

Comic application can be used to search comic books, characters and publishers of comic books. 
To use this searh, user hac to be logged in with his own comic account. Therefore this application also enables registration.

Application is written in clojure. For search functionality it uses database and REST service of https://www.comicvine.com

Available pages are:
* login and registration - initial page where users log in with their account, or submit registration form and then loggin. Data is saved in local DB
* home page - where users have basic information of some of the comics, retrieved from DB
* comic search page - where users get first 6 comic search results based on their input
* character search page - where users get first 2 search results of maching characters based on the search input
* publisher search page - where users get maching publisher result based on the searh input

/access to all pages, except login and registration, is restricted if user is not authenticated.

## Usage

It's necessary to start MongoDB before running the application. Database used in this project is MongoDB 2.2.3 (to download, visit http://www.mongodb.org/downloads). To start database open command line, navigate to mongodb/bin folder, and then execute mongod.exe (on windows). For more detailed instructions on how to start MongoDB, see http://docs.mongodb.org/manual/installation/.

The application automaticaly inserts dummy data in database. If you would like to prevent this comment out the first line in the main method.

To start the application navigate to the root folder and enter: lein run

## License

Distributed under the Eclipse Public License, the same as Clojure
