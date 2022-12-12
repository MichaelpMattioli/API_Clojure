(ns projeto.main
  (:gen-class)
  (:require [clojure.data.json :as json]
            [clojure.java.jdbc :as jdbc]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(let [db-host "localhost"
      db-port 3306
      db-name "produtos"]

  (def db {:classname "com.mysql.cj.jdbc.Driver"
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name "?useTimezone=true&serverTimezone=UTC")
           :user "root"
           :password "Michael@28/04/98@"}))

(defn response-hello [req]
  {:status 200 :body "Projeto feito pelos integrantes:\n
                      Michael Pedroza Mattioli Leite 18.00688-4,\n
                      Gabriel Cardoso RA: 18.00477-6.\n
                      Felipe Felde Giusti, RA: 18.00402-4.\n
                      Guilherme Ballardini RA: 18.01353-8.\n
                      José Guilherme Martins dos Santos RA: 18.00135-0."})

(def queryGetAll (jdbc/query db ["SELECT * FROM items"]))

;; Tentei implementar a o INSERT, porem não foi possivel devido dificuldade de passar o parametro para o post
;; (defn queryInsert [nome, descricao] (jdbc/query db [str "insert into items (nome, descricao)
;; values (" nome ", " descricao ",)"]))

(defn getAll [req]
  {:status 200 :body (json/write-str queryGetAll)})

;; Tentei implementar porem não consegui passar o parametro para o routes
;; (defn Insert [nome & descricao]
;;   {:status 200 :body (json/write-str queryInsert[nome, descricao])})


(def routes
  (route/expand-routes
   #{["/alunos" :get response-hello :route-name :alunos]
     ["/allItems" :get getAll :route-name :allItems]}))

(defn server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port 9981}))

(defn start []
  (http/start (server)))
(defn stop []
  (http/stop (server)))

(start)

(stop)