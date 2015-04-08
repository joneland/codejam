(ns codejam2010.africa.qualification.C-test
  (:use expectations)
  (:require [codejam2010.africa.qualification.C :as C]))
;; Based on sample input vs output at
;; https://code.google.com/codejam/contest/351101/dashboard#s=p2

(expect
  "44 444"
  (C/solve "hi"))

(expect
  "999337777"
  (C/solve "yes"))

(expect
  "333666 6660 022 2777"
  (C/solve "foo  bar"))

(expect
  "4433555 555666096667775553"
  (C/solve "hello world"))