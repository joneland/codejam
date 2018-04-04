(ns codejam2010.africa.qualification.B-test
  (:use expectations)
  (:require [codejam2010.africa.qualification.B :as B]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/351101/dashboard#s=p1

(expect
  "test a is this"
  (B/solve "this is a test"))

(expect
  "foobar"
  (B/solve "foobar"))

(expect
  "base your all"
  (B/solve "all your base"))