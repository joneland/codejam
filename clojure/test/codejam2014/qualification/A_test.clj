(ns codejam2014.qualification.A-test
  (:use expectations)
  (:require [codejam2014.qualification.A :as A]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/2974486/dashboard#s=p0

;; Single matching number from row 1 and 2
(expect
  4
  (A/solve [1 2 3 4] [4 5 6 7]))

;; Bad magician when more than 1 matching number in row 1 and 2
(expect
  "Bad magician!"
  (A/solve [1 2 3 4] [3 4 5 6]))

(expect
  "Bad magician!"
  (A/solve [1 2 3 4] [2 3 4 5]))

(expect
  "Bad magician!"
  (A/solve [1 2 3 4] [1 2 3 4]))

;; Volunteer cheated when no matching number in row 1 and 2
(expect
  "Volunteer cheated!"
  (A/solve [1 2 3 4] [5 6 7 8]))