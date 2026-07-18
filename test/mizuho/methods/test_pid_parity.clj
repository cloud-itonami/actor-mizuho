(ns mizuho.methods.test-pid-parity
  "Regression tests for the canonical CLJC PID loops. The deprecated Python parity
  oracle was removed with the Python implementation; these assertions retain the
  physical and safety invariants that the oracle established."
  (:require [mizuho.methods.chlorination :as cl]
            [mizuho.methods.water-supply :as ws]
            [clojure.test :refer [deftest is]]))

(def ^:private chlor-targets [0.5 0.8 1.2])
(def ^:private supply-demands [50.0 120.0 300.0])
(defn- close? [a b] (< (Math/abs (- (double a) (double b))) 1e-6))

(deftest cljc-loops-are-self-consistent
  (doseq [target chlor-targets]
    (let [result (cl/commission-dosing {:target-residual-mgl target})]
      (is (<= (:max-residual-mgl result) (+ cl/max-residual-mgl 1e-9)))
      (is (pos? (:settling-seconds result)))))
  (doseq [demand supply-demands]
    (let [result (ws/commission-water-supply {:demand-step-lps demand})]
      (is (close? (:final-level-m result) 3.0))
      (is (pos? (:settling-seconds result))))))
