(ns codejam2016.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]
    [clojure.set :as cset]))

(def full-house #{1 2 3 4 5 6 7 8 9 0})

(defn digits [number]
  (map #(Integer/parseInt %) (map str (seq (str number)))))

(defn final-number-before-sleep [x]
  (let [x-series (lazy-seq (map digits (map #(* x (inc %)) (range))))
         outstanding-digits (cset/difference full-house (into #{} (digits x)))]
    (reduce
      (fn [outstanding number]
        (let [result (cset/difference outstanding (into #{} number))]
          (if (empty? result)
            (reduced (apply str number))
            result)))
      outstanding-digits
      x-series)))

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
