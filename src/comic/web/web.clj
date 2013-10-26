(ns comic.web.web
  (:require [clj-http.client :as client]))
  
  (def url "http://www.comicvine.com/api/search/?api_key=5111e85d4cd2f603d05fcdef0739b2d94876f431&format=json&resources=")
  
   (defn find-issue [name]
	(:results (:body (client/get (str url "issue&query=" name) {:as :json})))
	)

(defn find-publisher [name]
  (:results (:body (client/get (str url "publisher&query=" name) {:as :json})))
)

(defn find-character [name]
  (:results (:body (client/get (str url "character&query=" name) {:as :json})))
)