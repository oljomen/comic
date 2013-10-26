(ns comic.core
 (:require [comic.db.db :as db]
            [comic.web.web :as web]
			[comic.views.views :as views]
            [noir.session :as session]
            [noir.server :as server]
            [noir.core :as noir]
            [noir.response :as response]
            [clojure.java.io :as io]))

			
			(def not-nil? (complement nil?))
			
(defn process-login [username]
 (session/put! :username username) 
 (views/home))
 
(defn check-login [username password]
  (if (nil? (first (db/login username password))) 
    (str "ERROR") 
    (process-login username) 
))  


(noir/defpage [:post "/register"] {:keys [firstname lastname username email password]}
  (db/register firstname lastname username email password)
  (response/redirect "/"))

(noir/defpage [:post "/"] {:keys [username password]}
  (check-login username password))


			
(noir/defpage "/" {}
(session/clear!)
(if (not-nil?  (session/get :username))
	(response/redirect "/home")
  (views/index)))
  
  (noir/defpage "/home.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/home)))
  
  (noir/defpage "/stripovi.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/stripovi "dylan"))) 
  
  (noir/defpage [:post "/search-comic"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/stripovi search)))
  
  (noir/defpage "/izdavaci.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/izdavaci "marvel")) )
  
  (noir/defpage [:post "/search-publisher"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/izdavaci search)))
  
  (noir/defpage "/junaci.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/junaci "groucho")))
  
  (noir/defpage [:post "/search-character"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/junaci search)))
  
(defn -main []
  ;;(print (web/find-issue "dylan"))
  (db/initial-data)
  (server/start 5949)
  
)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
