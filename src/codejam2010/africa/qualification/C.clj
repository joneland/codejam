(ns codejam2010.africa.qualification.C
  (:gen-class)
  (:require
     [clojure.java.io :as io]))

(def mapped-values
  {\a 2, \b 22, \c 222, \d 3, \e 33, \f 333, \g 4 \h 44, \i 444,
   \j 5, \k 55, \l 555, \m 6, \n 66, \o 666, \p 7, \q 77,\r 777, \s 7777,
   \t 8, \u 88, \v 888, \w 9, \x 99, \y 999, \z 9999 \space 0})

(defn add-required-space [data]
  (let [x (seq (str (mapped-values (first data))))
        y (seq (str (mapped-values (second data))))]
    (if (= (first x) (first y))
      \space)))

(defn solve
  "Problem C. T9 Spelling"
  [text]
  (loop [data (seq text)
         result ""]
    (if (empty? data)
      result
      (recur (next data)
             (str result
                  (mapped-values (first data))
                  (add-required-space data))))))

;; --- infrastructure ---
(defn read-int []
  (let [line (read-line)]
    (Integer/parseInt line)))

(defn write-to [file output]
  (with-open [the-writer (io/writer file :append true)]
    (.write the-writer output)))

(defn -main []
  (println "Paste input")
  (dotimes [x (read-int)]
    (let [text (read-line)]
      (write-to "C_output.txt" (str "Case #" (inc x) ": " (solve text) "\n")))))