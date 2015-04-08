(ns codejam2008.round1A.A-test
  (:use expectations)
  (:require [codejam2008.round1A.A :as A]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/32016/dashboard#s=p0

(expect
  -25
  (A/solve [1 3 -5] [-2 4 1]))

(expect
  6
  (A/solve [1 2 3 4 5] [1 0 1 0 1]))