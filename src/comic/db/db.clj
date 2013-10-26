(ns comic.db.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:refer-clojure :exclude [sort find])
  (:use monger.query))
  
  (defn login [username password]
  (mg/connect!)
  (mg/set-db!(mg/get-db "comic"))
  (mc/find-maps "users" {:username username, :password password}))
  
  (defn register [firstname lastname username email password]
  (mg/connect!)
  (mg/set-db!(mg/get-db "comic"))
  (mc/insert "users" {:firstname firstname, :lastname lastname, :username username, :email email, :password password}))
  
  (defn get-home-data []
  (mg/connect!)
  (mg/set-db!(mg/get-db "comic"))
  (with-collection "edition"
    (find {})
    (fields [:name :publisher :desc :image])
    (sort (sorted-map :_id -1))
    (limit 3)))
  
  
  (defn initial-data []
  (mg/connect!)
  (mg/set-db!(mg/get-db "comic"))
  (mc/insert "edition" {:name "Dylan Dog", :publisher "Sergio Bonelli Comics", :desc "Dilan Dog (engl. Dylan Dog) je lik
  iz stripa koji je stvorio italijanski pisac i novinar Ticijano Sklavi za italijansku
  izdavacku kucu Serdo Boneli Editore, tj. Boneli Komiks. Prvi broj je izasao u Italiji
  1986. Dilan Dog je vec nakon nekoliko brojeva postigao veliku popularnost. Pocetkom 1990ih,
  Dilan je u celom svetu izlazio u mesecnom tirazu vecem od 1.000.000 primeraka. Dark Hors Komiks 
  je izdavao englesku verziju Dilana Doga, a u bivsoj Jugoslaviji objavljivao ga je novosadski Dnevnik. 
  Trenutno Ludens objavljuje stripove u Hrvatskoj i Bosni i Hercegovini. U Srbiji, od 14.02.2008. 
  Dilana objavljuje izdavacka kuca pod imenom Veseli cetvrtak.", :image "images/dylan.jpg"})
	(mc/insert "edition" {:name "Betman", :publisher "DC Comics", :desc "Betmen ili Covek-Sismis je lik iz stripova
	  i jedan od najpoznatijih izmisljenih likova danasnjice. Prvi put je objavljen u maju 1939. u Detektivskim 
	  stripovima. Njegov alter-ego je Brus Vejn, multimilioner-industrijalac i jedan od najuticajnijih ljudi Gotama. 
	  U ranim godinama serijal su crtali Bob Kejn i razni pomagaci, a jedan od glavnih scenarista bio je Bil Finger. 
	  Prica o Betmenu pocinje kada Brus Vejn, od majke Marte i oca Tomasa, kao osmogodisnji decak postaje siroce.", :image "images/betmen.png"})
	(mc/insert "edition" {:name "Talicni Tom", :publisher "Lucky Comics" :desc "Talicni Tom (u izvorniku Lucky Luke) 
	  jedan je od najpopularnijih stripova u Evropi, a pripada zanru komicnog vesterna.
Duhovni otac i crtac serijala je Belgijanac Moris de Bever. Posle prvih deset epizoda (od 1957. godine), 
pa do kraja svog zivota scenario je pisao Rene GoSini, a kasnije i Bob de Grot, Zan Leterzi i drugi.", :image "images/tom.jpg"})
  (mc/insert "users" {:firstname "Olivera", :lastname "Stanisic", :username "a", :email "olja@gmail.com", :password "a"}))