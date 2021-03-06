(ns codejam2015.qualification.B-test
  (:use expectations)
  (:require [codejam2015.qualification.B :as B]))


(expect
  [4 4]
  (B/split-pancakes 8))

(expect
  [5 4]
  (B/split-pancakes 9))

(expect
  6
  (B/time-to-eat [10]))

(expect
  10
  (B/time-to-eat [20]))

(expect
  9
  (B/time-to-eat [10 10]))

(expect
  3
  (B/solve 1 [3]))

(expect
  2
  (B/solve  4 [1 2 1 2]))

(expect
  3
  (B/solve  1 [4]))

(expect
  6
  (B/solve 4 [1 3 3 10]))

(expect
  9
  (B/solve 4 [1 3 3 10 10]))

(expect
  5
  (B/solve 5 [4 5 5 5 5]))



;; 5 (+1) --- 3x2 --- 4
;; 7 (+1) --- 3x4 (+1) --- 3 2x2 (+3) -> 5
;; 8 (+1) --- 4x4 (+1) (+1) --- 2x2 2x2 (+2) -> 5
;; 9 (+1) --- 4x5 (+1) (+1) --- 2x2 3x2 (+3) -> 6
;; 10 (+1) --- 5x5 (+1) (+1) --- 3x2 3x2 (+3) -> 6
;; 15 (+1) --- 8x7 (+1) (+1) --- 4x4 4x3 (+1) (+1) (+1) --- 2x2 2x2 2x2 3 (+3) --- 9
;; 16 (+1) --- 8x8 (+1) (+1) --- 4x4 4x4 (+1) (+1) (+1) (+1) --- 2x2 2x2 2x2 2x2 (+2) --- 9
;; 17 (+1) --- 9x8 (+1) (+1) --- 5x4 4x4 (+1) (+1) (+1) (+1) --- 3x2 2x2 2x2 2x2 (+3) --- 10
;; 18 (+1) --- 9x9 (+1) (+1) --- 5x4 5x4 (+1) (+1) (+1) (+1) --- 3x2 3x2 2x2 2x2 (+3) --- 10
;; 19 (+1) --- 10x9 (+1) (+1) --- 5x5 5x4 (+1) (+1) (+1) (+1) --- 3x2 3x2 3x2 2x2 (+3) --- 10
;; 20 (+1) --- 10x10 (+1) (+1) --- 5x5 5x5 (+1) (+1) (+1) (+1) --- 3x2 3x2 3x2 3x2 (+3) -> 10
;; 21 (+1) --- [11 10] (+1) (+1) --- [6 5] [5 5] (+1) (+1) (+1) (+1) --- [3 3] [3 2] [3 2] [3 2] (+3) -> 10