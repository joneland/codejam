(ns codejam2015.qualification.A
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn indexed-crowd [crowd]
  (->> (string/split crowd #"")
       (map #(Integer/parseInt %))
       (vec)
       (map-indexed vector)))

(defn crowd-total-before-adding-guests [crowd]
  (->> (string/split crowd #"")
       (map #(Integer/parseInt %))
       (vec)
       (reduce +)))

(defn crowd-total-after-adding-guests [crowd]
  (if (= 1 (count crowd))
    (second (first crowd))
    (reduce
      (fn [total shyness-level]
        (if (< total (first shyness-level))
          (-> (first shyness-level)
            (+ (second shyness-level)))
          (-> (second shyness-level)
            (+ total))))
      (first (second crowd))
      (rest crowd))))

(defn solve
  "Problem A. Standing Ovation"
  [crowd]
  (let [target (crowd-total-after-adding-guests (indexed-crowd crowd))
        current (crowd-total-before-adding-guests crowd)]
    (- target current)))

;; --- infrastructure ---
(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn -main []
  (println "Paste input")
  (dotimes [x (read-int)]
    (let [line (read-line)
          crowd (second (string/split line #"\s+"))]
      (write-to "A_output.txt" (str "Case #" (inc x) ": " (solve crowd) "\n")))))