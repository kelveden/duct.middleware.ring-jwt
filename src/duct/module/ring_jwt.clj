(ns duct.module.ring-jwt
  (:require [integrant.core :as ig]
            [duct.core :as duct]))

(defmethod ig/init-key :duct.module/ring-jwt [_ opts]
  (fn [config]
    (duct/merge-configs
      config

      {:duct.middleware/ring-jwt
       opts

       :duct.handler/root
       {:middleware [(ig/ref :duct.middleware/ring-jwt)]}})))