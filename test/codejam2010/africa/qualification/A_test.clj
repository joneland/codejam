(ns codejam2010.africa.qualification.A-test
  (:use expectations)
  (:require [codejam2010.africa.qualification.A :as A]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/351101/dashboard#s=p0

(expect
  "2 3"
  (A/solve 100 3 [5 75 25]))