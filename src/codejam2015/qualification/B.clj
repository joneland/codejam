(ns codejam2015.qualification.B
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn solve
  "Problem B. Infinite House of Pancakes"
  [non-empty-plates pancakes]
  (println non-empty-plates pancakes))

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
    (let [non-empty-plates (read-int)
          pancakes (read-ints)]
      (write-to "B_output.txt" (str "Case #" (inc x) ": " (solve non-empty-plates pancakes) "\n")))))