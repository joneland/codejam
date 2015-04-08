(ns codejam2010.africa.qualification.B
  (:gen-class)
  (:require
    [clojure.string :as string]
    [clojure.java.io :as io]))

(defn solve
  "Problem B. Reverse Words"
  [words]
  (string/join \space (reverse (string/split words #"\s+"))))

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
    (let [words (read-line)]
      (write-to "B_output.txt" (str "Case #" (inc x) ": " (solve words) "\n")))))