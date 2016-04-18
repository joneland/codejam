(ns codejam2016.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(def full-house #{1 2 3 4 5 6 7 8 9 0})

(defn digits [number]
  (map #(Integer/parseInt %) (map str (seq (str number)))))

(defn final-number-before-sleep [x]
  (loop [x-series (lazy-seq (map #(* x (inc %)) (range)))
         tally (into #{} (digits x))]
    (let [current-x (first x-series)
          updated-series (into tally (digits current-x))]
      (if (= full-house updated-series)
        current-x
        (recur (rest x-series) updated-series)))))

(defn solve
  "Problem A. Counting Sheep"
  [x]
  (cond
    (= x 0) "INSOMNIA"
    :else (final-number-before-sleep x)))

;; --- infrastructure ---
(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn -main []
  (println "Paste input")
  (dotimes [n (read-int)]
    (let [x (Integer/parseInt (read-line))]
      (write-to "A_output.txt" (str "Case #" (inc n) ": " (solve x) "\n")))))
