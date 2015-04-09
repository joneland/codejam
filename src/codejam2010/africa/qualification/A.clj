(ns codejam2010.africa.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn indicies [pred coll]
  (keep-indexed #(when (pred %2) %1) coll))

;; map-indexed, repeat, remove nth, for + x y, return when equal to credit
(defn solve
  "Problem A. Store Credit"
  [credit number-of-items price-of-items]
  "2 3")

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