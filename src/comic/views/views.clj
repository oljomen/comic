(ns comic.views.views
  (:require [net.cgrand.enlive-html :as html]
    		[noir.session :as session]
			[comic.db.db :as db]
			[comic.web.web :as web]
    ))
	
	
	(html/deftemplate index "comic/views/index.html"
	[]
	)
	
	(html/deftemplate home "comic/views/home.html"
	[]
	[:#slika1] (html/set-attr :src (:image (nth (db/get-home-data) 0)))
    [:#slika2] (html/set-attr :src (:image (nth (db/get-home-data) 1)))
    [:#slika3] (html/set-attr :src (:image (nth (db/get-home-data) 2)))
	
	[:#tekst1] (html/content (:desc (nth (db/get-home-data) 0)))
    [:#tekst2] (html/content (:desc (nth (db/get-home-data) 1)))
    [:#tekst3] (html/content (:desc (nth (db/get-home-data) 2)))
	
	[:#izdavac1] (html/content (:publisher (nth (db/get-home-data) 0)))
    [:#izdavac2] (html/content (:publisher (nth (db/get-home-data) 1)))
    [:#izdavac3] (html/content (:publisher (nth (db/get-home-data) 2)))
	
	[:#naziv1] (html/content (:name (nth (db/get-home-data) 0)))
    [:#naziv2] (html/content (:name (nth (db/get-home-data) 1)))
    [:#naziv3] (html/content (:name (nth (db/get-home-data) 2)))
  )
  (html/deftemplate stripovi "comic/views/stripovi.html" [])
  
   (html/deftemplate izdavaci "comic/views/izdavaci.html" [search]
   []
   (def publisher (get (web/find-publisher search) 0))
    [:#slika1] (html/set-attr :src (:medium_url (:image publisher)))
  [:#link1] (html/set-attr :href (:site_detail_url publisher))
  [:#naziv1] (html/content (:name publisher))
  [:#tekst1] (html/content (:deck publisher))
  [:#izdavac1] (html/content (:aliases publisher))
  
   
   )
   
   (html/deftemplate junaci "comic/views/junaci.html" [search]
   []
   (def character (web/find-character search))
    [:#slika1] (html/set-attr :src (:medium_url (:image (get character 0))))
    [:#link1] (html/set-attr :href (:site_detail_url (get character 0)))
    [:#naziv1] (html/content (:name (get character 0)))
    [:#tekst1] (html/content (:deck (get character 0)))
    [:#izdavac1] (html/content (:aliases (get character 0)))
	
	[:#slika2] (html/set-attr :src (:medium_url (:image (get character 1))))
    [:#link2] (html/set-attr :href (:site_detail_url (get character 1)))
    [:#naziv2] (html/content (:name (get character 1)))
    [:#tekst2] (html/content (:deck (get character 1)))
    [:#izdavac2] (html/content (:aliases (get character 1)))
    
   )
   
  (html/deftemplate stripovi "comic/views/stripovi.html" [search]
  []
  (def comic (web/find-issue search))
  
  [:#slika1] (html/set-attr :src (:medium_url (:image (get comic 0))))
  [:#link1] (html/set-attr :href (:site_detail_url (get comic 0)))
  [:#naziv1] (html/content (:name (:volume (get comic 0))))
  [:#tekst1] (html/content (:name (get comic 0)))
  [:#izdavac1] (html/content (:cover_date (get comic 0)))
  
  [:#slika2] (html/set-attr :src (:medium_url (:image (get comic 1))))
  [:#link2] (html/set-attr :href (:site_detail_url (get comic 1)))
  [:#naziv2] (html/content (:name (:volume (get comic 1))))
  [:#tekst2] (html/content (:name (get comic 1)))
  [:#izdavac2] (html/content (:cover_date (get comic 1)))
  
  [:#slika3] (html/set-attr :src (:medium_url (:image (get comic 2))))
  [:#link3] (html/set-attr :href (:site_detail_url (get comic 2)))
  [:#naziv3] (html/content (:name (:volume (get comic 2))))
  [:#tekst3] (html/content (:name (get comic 2)))
  [:#izdavac3] (html/content (:cover_date (get comic 2)))
  
  [:#slika4] (html/set-attr :src (:medium_url (:image (get comic 3))))
  [:#link4] (html/set-attr :href (:site_detail_url (get comic 3)))
  [:#naziv4] (html/content (:name (:volume (get comic 3))))
  [:#tekst4] (html/content (:name (get comic 3)))
  [:#izdavac4] (html/content (:cover_date (get comic 3)))
  
  [:#slika5] (html/set-attr :src (:medium_url (:image (get comic 4))))
  [:#link5] (html/set-attr :href (:site_detail_url (get comic 4)))
  [:#naziv5] (html/content (:name (:volume (get comic 4))))
  [:#tekst5] (html/content (:name (get comic 4)))
  [:#izdavac5] (html/content (:cover_date (get comic 4)))
  
  [:#slika6] (html/set-attr :src (:medium_url (:image (get comic 5))))
  [:#link6] (html/set-attr :href (:site_detail_url (get comic 5)))
  [:#naziv6] (html/content (:name (:volume (get comic 5))))
  [:#tekst6] (html/content (:name (get comic 5)))
  [:#izdavac6] (html/content (:cover_date (get comic 5)))
  
  
  
  
  
  
  
  
  
  
  
  
  )