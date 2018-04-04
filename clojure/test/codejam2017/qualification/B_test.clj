(ns codejam2017.qualification.B-test
  (:require [clojure.test :refer :all]
            [codejam2017.qualification.B :as B]))

(deftest converts-number-to-digits
  (is (=
        (vector 1 2 3)
        (B/digits 123)))
  (is (=
        (vector 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0)
        (B/digits 111111111111111110))))

(deftest finds-best-number-to-start-at
  (is (=
        7
        (B/starting-number 7)))
  (is (=
        132
        (B/starting-number 132)))
  (is (=
        1000
        (B/starting-number 1000)))
  (is (=
        100000000000000000
        (B/starting-number 111111111111111110))))

(deftest identifies-tidy-numbers
  (is (=
        true
        (B/tidy-number? 7)))
  (is (=
        true
        (B/tidy-number? 123)))
  (is (=
        false
        (B/tidy-number? 132)))
  (is (=
        true
        (B/tidy-number? 99999999999999999)))
  (is (=
        false
        (B/tidy-number? 111111111111111110))))

(deftest finds-largest-tidy-number-from-1-to-N
  (is (=
        129
        (B/largest-tidy-number 132)))
  (is (=
        999
        (B/largest-tidy-number 1000)))
  (is (=
        7
        (B/largest-tidy-number 7)))
  (is (=
        99999999999999999
        (B/largest-tidy-number 111111111111111110))))