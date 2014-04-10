#!/usr/bin/lein exec

(use 'clojure.java.io) 

(defn read-in [file]
  (line-seq (reader file)))

(defn write-to [file output]
  (with-open [the-writer (writer file :append true)]
    (.write the-writer output)))

(let [input-file (nth *command-line-args* 1)
      output-file (nth *command-line-args* 2)]
   (write-to output-file (str (read-in input-file))))
