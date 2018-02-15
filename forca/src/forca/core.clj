(ns forca.core
  (:gen-class))

(def limite-vidas 6)

(def acertos #{})

(defn perdeu [] (print "Looooser\n"))

(defn ganhou [] (print "woo woo!! \\o/"))

(defn chuta [] (rand-nth ["A" "E" "I" "O" "U" "B" "C" "L" "R" "J"] ))


(defn acertou-tudo? [palavra acertos] 
  (if (= (set palavra) acertos)
    true
    (do(
        (def chute (str chuta))
        (if (contains? palavra chute)
          (def acertos (conj acertos chute))
          (dec limite-vidas)
        )
      )
    )
  ) 
)

(defn jogo [palavra] 
  (if  (= limite-vidas 0)
    (perdeu)
    (if (acertou-tudo? palavra chute acertos)
      (ganhou)
      (jogo palavra)
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print "Hello, World!")
  (jogo "ALURA")
)