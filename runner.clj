#!/usr/bin/env lein-exec

(defn read-int[]
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn main[]
  (dotimes [x (read-int)]
    (print (str "Case #" (inc x) ": "))
    (println "ANSWER")))

(main)
