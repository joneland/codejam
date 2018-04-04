(ns codejam2015.qualification.B
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn split-pancakes [amount]
  (condp = (rem amount 2)
    0 [(quot amount 2) (quot amount 2)]
    1 [(inc (quot amount 2)) (quot amount 2)]))

(defn time-to-eat [pancakes]
  (loop [p pancakes]
    (if (empty? (filter #(<= 4 %) p))
      (do
        (+ (- (count p) (count pancakes)) (apply max p)))
      (recur (flatten (keep #(if (<= 4 %) (split-pancakes %) %) p))))))

(defn solve
  "Problem B. Infinite House of Pancakes"
  [non-empty-plates pancakes]
  (let [max-minutes (apply max pancakes)]
    (if (> 4 max-minutes)
      max-minutes
      (let [over-time (time-to-eat (filter #(<= 4 %) pancakes))]
        (if (< over-time max-minutes)
          over-time
          max-minutes)))))

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