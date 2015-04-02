#!/usr/bin/lein exec

(use '[clojure.string :only (split)])
(use 'clojure.java.io)

(defn write-to [file output]
  (with-open [the-writer (writer file :append true)]
    (.write the-writer output)))

(defn read-int[]
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn read-doubles[]
  (let [line (read-line)]
    (vec (map #(Double/parseDouble %) (split line #"\s+")))))

(defn solve[input]
  (let [[c f x] input
        no-farms (/ x 2)]
   (loop [current-time no-farms
          cps 2
          farm-penalties 0]

     (let [next-farm-penalty (/ c cps)
           time-to-reach-x (/ x (+ cps f)) 
           next-time (+ farm-penalties next-farm-penalty time-to-reach-x)]

        (if (< current-time next-time)
         (format "%.7f" current-time)
        (recur next-time
               (+ cps f)
               (+ farm-penalties next-farm-penalty)))))))


(defn main[]
  (dotimes [x (read-int)]
    (let [input (read-doubles)]
    (write-to "B_output.txt" (str "Case #" (inc x) ": " (solve input) "\n")))))

(main)