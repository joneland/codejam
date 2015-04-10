(ns codejam2015.qualification.B-test
  (:use expectations)
  (:require [codejam2015.qualification.B :as B]))

(expect
  "test"
  (B/solve "test"))