(ns duct.middleware.ring-jwt-test
  (:require [clojure.test :refer :all]
            [duct.middleware.ring-jwt]
            [integrant.core :as ig]
            [ring.middleware.jwt-test-utils :as tu])
  (:import (java.util UUID)))

(deftest integrant-key-wraps-wrap-jwt
  (let [handler    (fn [req] {:status 200
                              :body   (:claims req)})
        issuer     (str (UUID/randomUUID))
        alg-opts   {:alg    :HS256
                    :secret "whatever"}
        jwt-config {:issuers {issuer alg-opts}}
        middleware (ig/init-key :duct.middleware/ring-jwt jwt-config)
        claims     {:key1 "val1" :iss issuer}
        token      (tu/encode-token claims alg-opts)]
    (let [resp ((middleware handler) {:headers {"Authorization" (str "Bearer " token)}})]
      (is (= claims (:body resp))))))

