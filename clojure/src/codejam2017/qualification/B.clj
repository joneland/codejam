(ns codejam2017.qualification.B
  (:gen-class)
  (:require
    [clojure.java.io :as io]))

(defn digits [n]
  (->> n
    (iterate #(quot % 10))
    (take-while pos?)
    (mapv #(mod % 10))
    rseq))

(defn tidy-number? [n]
  (let [the-digits (digits n)]
    (= the-digits (sort the-digits))))

(defn starting-number [n]
  (let [the-digits (digits n)]
    (if (some #(< % (first the-digits)) (rest the-digits))
      (->>
        (conj
          (repeat (count (rest the-digits)) 0)
          (first the-digits))
        (apply str)
        read-string)
      n)))

(defn largest-tidy-number [n]
  (->>
    (range (starting-number n) 0 -1)
    (filter tidy-number?)
    first))

;; infra

(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn -main []
  (println "Paste input")
  (dotimes [n (read-int)]
    (let [x (Long/parseLong (read-line))]
      (write-to "B_output.txt" (str "Case #" (inc n) ": " (largest-tidy-number x) "\n")))))