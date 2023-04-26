(ns brave-and-true.namefy
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


(defn name-surname
  [mail]
  (clojure.string/split (first (clojure.string/split mail #"@")) #"\.|_|-"))