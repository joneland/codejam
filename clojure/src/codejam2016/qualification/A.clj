(ns codejam2016.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]
    [clojure.set :as cset]))

(def full-house #{1 2 3 4 5 6 7 8 9 0})

(defn digits [number]
  (map #(Integer/parseInt %) (map str (seq (str number)))))

(defn series-as-digits [number]
  (lazy-seq (map digits (map #(* number (inc %)) (range)))))

(defn numbers-left-to-find [outstanding digits]
  (cset/difference outstanding (into #{} digits)))

(defn final-number-before-sleep [x]
  (reduce
    (fn [outstanding number]
      (let [result (numbers-left-to-find outstanding number)]
        (if (empty? result)
          (reduced (apply str number))
          result)))
    (numbers-left-to-find full-house (digits x))
    (series-as-digits x)))

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
