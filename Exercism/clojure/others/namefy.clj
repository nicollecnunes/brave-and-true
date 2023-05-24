(ns Exercism.clojure.others.namefy
  (:require [clojure.string]
            [clojure.string :as str]))

; threading
(defn get-name-by-mail-tf
  [mail]
  (-> mail
      (clojure.string/split ,,, #"@")
      first))

(defn get-name-by-mail
  [mail]
  (first (clojure.string/split mail #"@")))

(defn name-surname-tf
  [mail]
  (-> mail
      (clojure.string/split #"@")
      (first)
      (clojure.string/split #"\.|_|-")))

; #"\.|_|-" can also be witten as #"[.-_]"
(defn name-surname
  [mail]
  (clojure.string/split (first (clojure.string/split mail #"@")) #"\.|_|-"))

(defn letting
  [mail]
  (let [full-name (name-surname-tf mail)]
    {:firstname (first full-name)
      :lastname (last full-name)}))