(ns codejam2016.qualification.A-test
  (:require [clojure.test :refer :all] 
            [codejam2016.qualification.A :as A]))

(deftest number-when-full-house-reached-whilst-counting-sheep
  (is (=
        "INSOMNIA" 
        (A/solve 0)))
  (is (=
        "10"
        (A/solve 1)))
  (is (=
        "90"
        (A/solve 2)))
  (is (=
        "110"
        (A/solve 11)))
  (is (=
        "5076" 
        (A/solve 1692))))
