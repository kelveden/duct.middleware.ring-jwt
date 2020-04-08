(ns duct.middleware.ring-jwt
  (:require [integrant.core :as ig]
            [ring.middleware.jwt :refer [wrap-jwt]]))

(defmethod ig/init-key :duct.middleware/ring-jwt [_ opts]
  (fn [handler]
    (wrap-jwt handler opts)))