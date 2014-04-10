#!/usr/bin/lein exec

(let [input-file (nth *command-line-args* 1)
      output-file (nth *command-line-args* 2)]
  (println input-file)
  (println output-file))
