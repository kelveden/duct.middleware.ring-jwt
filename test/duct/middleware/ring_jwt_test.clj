(ns duct.middleware.ring-jwt-test
  (:require [clojure.test :refer :all]
            [duct.middleware.ring-jwt]
            [integrant.core :as ig]
            [ring.middleware.jwt-test-utils :as tu]))

(deftest integrant-key-wraps-wrap-jwt
  (let [handler    (fn [req] {:status 200
                              :body   (:claims req)})
        jwt-config {:alg    :HS256
                    :secret "whatever"}
        middleware (ig/init-key :duct.middleware/ring-jwt jwt-config)
        claims     {:key1 "val1"}
        token      (tu/encode-token claims jwt-config)]
    (let [resp ((middleware handler) {:headers {"Authorization" (str "Bearer " token)}})]
      (is (= claims (:body resp))))))

