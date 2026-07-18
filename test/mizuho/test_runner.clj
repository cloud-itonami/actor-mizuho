(ns mizuho.test-runner
  (:require [clojure.test :as t]
            [mizuho.murakumo-test]
            [mizuho.cells.test-state-machines]
            [mizuho.methods.test-charter-gates]
            [mizuho.methods.test-chlorination]
            [mizuho.methods.test-pid-parity]
            [mizuho.methods.test-water-supply]))

(def suites
  '[mizuho.murakumo-test
    mizuho.cells.test-state-machines
    mizuho.methods.test-charter-gates
    mizuho.methods.test-chlorination
    mizuho.methods.test-pid-parity
    mizuho.methods.test-water-supply])

(defn -main [& _]
  (let [{:keys [fail error]} (apply t/run-tests suites)]
    (when (pos? (+ fail error))
      (System/exit 1))))
