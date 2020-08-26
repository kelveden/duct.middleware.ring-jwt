(ns duct.module.ring-jwt-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [duct.module.ring-jwt]))

(deftest module-wires-ring-jwt-middleware-into-handler-root
  (let [opts        {:issuers {"someissuer" {:alg    :HS256
                                             :secret "whatever"}}}
        module      (ig/init-key :duct.module/ring-jwt opts)
        duct-config {:duct.core/environment :development}
        result      (module duct-config)]

    (is (contains? result :duct.middleware/ring-jwt))
    (is (= (:duct.middleware/ring-jwt result) opts))
    (is (some #{(ig/ref :duct.middleware/ring-jwt)}
              (get-in result [:duct.handler/root :middleware])))))