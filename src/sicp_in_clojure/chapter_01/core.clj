(ns sicp-in-clojure.chapter-01.core)

(+ 137 349)
;; => 486

(- 1000 334)
;; => 666

(* 5 99)
;; => 495

(/ 10 5)
;; => 2

(+ 2.7 10)
;; => 12.7

(+ 21 35 12 7)
;; => 75

(* 25 4 12)
;; => 1200

(+ (* 3 5) (- 10 6))
;; => 19

(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))
;; => 57

(+ (* 3 
      (+ (* 2 4) 
           (+ 3 5))) 
   (+ (- 10 7) 
      6))
;; => 57

(def size 2)
;; => #'sicp-in-clojure.chapter-01.core/size

size
;; => 2

(def pi 3.14159)

(def radius 10)

(* pi (* radius radius))
;; => 314.159

(def circumference (* 2 pi radius))

circumference
;; => 62.8318

(defn square [x] (* x x))

(square 21)
;; => 441

(square (+ 2 5))
;; => 49

(square (square 3))
;; => 81

(defn sum-of-squares
  [x y]
  (+ (square x) (square y)))

(sum-of-squares 3 4)
;; => 25

(defn abs'
  [x]
  (cond
    (> x 0) x
    (= x 0) 0
    (< x 0) (- x)))

(abs' 5)
;; => 5

(abs' (- 5))
;; => 5

(abs' 0)
;; => 0

(defn abs''
  [x]
  (if (< x 0)
    (- x)
    x))

(abs'' -5)
;; => 5

(defn >='
  [x y]
  (or (> x y) (= x y)))

(>=' 3 2)
;; => true

;; ----------------------------------------------
;; 1.1.7 Example: Square Roots by Newton’s Method
;; ----------------------------------------------

(defn average
  [& args]
  (/ (reduce + args) (count args)))

(defn good-enough?
  [guess x]
  (< (abs (- (square guess) x)) 0.0001))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn sqrt
  ([x]
   (sqrt 1.0 x))
  ([guess x]
   (if (good-enough? guess x)
     guess
     (sqrt (improve guess x) x))))

(sqrt 9)
;; => 3.000000001396984

(sqrt (+ 100 37))
;; => 11.704699917758145

(sqrt (+ (sqrt 2) (sqrt 3)))
;; => 1.7737718323432423

(square (sqrt 1000))
;; => 1000.0000000000343

