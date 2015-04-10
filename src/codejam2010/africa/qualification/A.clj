(ns codejam2010.africa.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn combinations
  "Creates all permutations of collection"
  [coll]
  (let [tails (take-while next (iterate rest coll))]
    (mapcat
      (fn [[first-item & rest-items]]
        (map #(vector first-item %) rest-items)) tails)))

(defn filter-eligible [credit items]
  (filter #(> credit (second %)) items))

(defn filter-matching-combination [credit eligible-combinations]
  (flatten (keep #(if (= credit (+ (second (first %)) (second (second %)))) (map first %)) eligible-combinations)))

(defn format-result [indicies]
  (format "%d %d" (first indicies) (second indicies)))

(defn solve
  "Problem A. Store Credit"
  [credit number-of-items price-of-items]
  (->>
    (map-indexed vector price-of-items)
    (filter-eligible credit)
    (combinations)
    (filter-matching-combination credit)
    (map inc)
    (format-result)))

;; --- infrastructure ---
(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn read-ints []
  (let [line (read-line)]
    (vec (map #(Integer/parseInt %) (string/split line #"\s+")))))

(defn -main []
  (println "Paste input")
  (dotimes [x (read-int)]
    (let [credit (read-int)
          number-of-items (read-int)
          cost-of-items (read-ints)]
      (write-to "A_output.txt" (str "Case #" (inc x) ": " (solve credit number-of-items cost-of-items) "\n")))))