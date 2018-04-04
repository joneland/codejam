(ns codejam2016.qualification.A-test
  (:require [clojure.test :refer :all] 
            [codejam2016.qualification.A :as A]))

(deftest removes-from-numbers-left-to-find
  (is (=
       #{2 6}
       (A/numbers-left-to-find #{1 2 3 4 5 6} [1 3 4 5]))))

(deftest generates-series-for-given-number
  (is (=
       [[1] [2] [3] [4] [5]]
       (take 5 (A/series-as-digits 1))))
  (is (=
       [[2] [4] [6] [8] [1 0]]
       (take 5 (A/series-as-digits 2))))
  (is (=
       [[1 1] [2 2] [3 3] [4 4] [5 5]]
       (take 5 (A/series-as-digits 11))))
  (is (=
       [[1 6 9 2] [3 3 8 4] [5 0 7 6]]
       (take 3 (A/series-as-digits 1692)))))

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
