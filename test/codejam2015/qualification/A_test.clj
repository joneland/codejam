(ns codejam2015.qualification.A-test
  (:use expectations)
  (:require [codejam2015.qualification.A :as A]))

(expect
  "test"
  (A/solve "test"))