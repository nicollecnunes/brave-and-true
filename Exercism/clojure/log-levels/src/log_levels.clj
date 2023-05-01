(ns log-levels
  (:require [clojure.string :as str]
            [clojure.string :as s]))

(defn message-standart
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/trim (get (str/split s #": ") 1))
  )

(defn message
  [s]
  (-> s 
      (str/split #": ")
      (get 1)
      (str/trim)))

(defn log-level-standart
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (str/lower-case (str/replace-first (get (str/split s #"]: ") 0) "[" ""))
  )

(defn log-level
  [s]
  (-> s
      (str/split #"]: ")
      (get 0)
      (str/replace-first "[" "")
      (str/lower-case)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")")
  )
