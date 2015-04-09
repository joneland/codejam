(ns codejam2010.africa.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn drop-index [coll index]
  (remove #(= (nth coll index) %) coll))

(defn solve
  "Problem A. Store Credit"
  [credit number-of-items price-of-items]
  (let [indexed-items (map-indexed vector price-of-items)
        eligible-permutations (map (partial drop-index indexed-items) (range number-of-items))]
    eligible-permutations))

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