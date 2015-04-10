(ns codejam2010.africa.qualification.A-test
  (:use expectations)
  (:require [codejam2010.africa.qualification.A :as A]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/351101/dashboard#s=p0

(expect
  [[[0 5][1 75]]  [[0 5][2 25]]  [[1 75][2 25]]]
  (A/combinations [[0 5] [1 75] [2 25]]))

(expect
  "2 3"
  (A/solve 100 3 [5 75 25]))

(expect
  "1 4"
  (A/solve 200 7 [150 24 79 50 88 345 3]))

(expect
  "4 5"
  (A/solve 8 8 [2 1 9 4 4 56 90 3]))