(ns codejam2008.round1A.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn solve
  "Problem A. Minimum Scalar Product"
  [vector1 vector2]
  (reduce + (map * (sort vector1) (reverse (sort vector2)))))

;; --- infrastructure ---
(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn read-ints []
  (let [line (read-line)]
    (vec (map #(Integer/parseInt %) (string/split line #"\s+")))))

(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn -main []
  (println "Paste input")
  (dotimes [x (read-int)]
    (let [unimportant-value (read-int)
          vector1 (read-ints)
          vector2 (read-ints)]
      (write-to "A_output.txt" (str "Case #" (inc x) ": " (solve vector1 vector2) "\n")))))