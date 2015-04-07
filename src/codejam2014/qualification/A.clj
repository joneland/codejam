#!/usr/bin/env lein-exec
(ns codejam2014.qualification.A)

(use '[clojure.string :only [split]])
(use 'clojure.java.io)

(defn write-to [file output]
  (with-open [the-writer (writer file :append true)]
    (.write the-writer output)))

(defn read-int[]
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn read-ints[]
  (let [line (read-line)]
    (vec (map #(Integer/parseInt %) (split line #"\s+")))))

(defn solve[row1 row2]
  (let [candidates (filter #(< 1 (val %)) (frequencies (flatten [row1 row2])))
        occurances (count candidates)]
    (cond
      (= 1 occurances) (ffirst  candidates)
      (< 1 occurances) "Bad magician!"
      :else "Volunteer cheated!")))

(defn main[]
  (println "Ready for input")
  (dotimes [x (read-int)]
    (let [first-answer (read-int)
          a1 (read-ints)
          b1 (read-ints)
          c1 (read-ints)
          d1 (read-ints)
          row1 (nth [a1 b1 c1 d1] (dec first-answer))
          second-answer (read-int)
          a2 (read-ints)
          b2 (read-ints)
          c2 (read-ints)
          d2 (read-ints)
          row2 (nth [a2 b2 c2 d2] (dec second-answer))]
    (write-to "A_output.txt" (str "Case #" (inc x) ": " (solve row1 row2) "\n")))))

(main)