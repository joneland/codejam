(ns codejam2015.qualification.A-test
  (:use expectations)
  (:require [codejam2015.qualification.A :as A]))

(expect
  [[0 1] [1 1] [2 1] [3 1] [4 1]]
  (A/indexed-crowd "11111"))

(expect
  [[0 1]]
  (A/indexed-crowd "1"))


(expect
  9
  (A/crowd-total-before-adding-guests "09"))

(expect
  4
  (A/crowd-total-before-adding-guests "110011"))

(expect
  1
  (A/crowd-total-before-adding-guests "1"))

(expect
  3
  (A/crowd-total-after-adding-guests [[0 1] [1 0] [2 1]]))

(expect
  5
  (A/crowd-total-after-adding-guests [[0 1] [1 1] [2 1] [3 1] [4 1]]))

(expect
  10
  (A/crowd-total-after-adding-guests [[0 0] [1 9]]))

(expect
  1
  (A/crowd-total-after-adding-guests [[0 1]]))

;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/6224486/dashboard
(expect
  0
  (A/solve "11111"))

(expect
  1
  (A/solve "09"))

(expect
  2
  (A/solve "110011"))

(expect
  0
  (A/solve "1"))