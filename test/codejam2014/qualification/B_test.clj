(ns codejam2014.qualification.B-test
  (:use expectations)
  (:require [codejam2014.qualification.B :as B]))
;; Based on sample input vs output
;; https://code.google.com/codejam/contest/2974486/dashboard#s=p1

(expect
  "1.0000000"
  (B/solve [30.0 1.0 2.0]))

(expect
  "39.1666667"
  (B/solve [30.0 2.0 100.0]))

(expect
  "63.9680013"
  (B/solve [30.50000 3.14159 1999.19990]))

(expect
  "526.1904762"
  (B/solve [500.0 4.0 2000.0]))
