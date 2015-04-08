(ns codejam2010.africa.qualification.A-test
  (:use expectations)
  (:require [codejam2010.africa.qualification.A :as A]))

(expect
  "2 3"
  (A/solve 100 3 [5 75 25]))