(ns forca.core
  (:gen-class))

(defn perdeu [] (print "Looooser\n"))

(defn ganhou [] (print "woo woo!! \\o/"))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn le-letra! [] (read-line))

(defn avalia-chute [chute vidas palavra acertos]
  (if (acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)
  )
)

(defn acertou-todas? [palavra acertos]
  (empty? (letras-faltantes palavra acertos))
)

(defn jogo [vidas palavra acertos] 
  (if  (= vidas 0)
    (perdeu)
    (if (acertou-todas? palavra acertos)
      (ganhou)
      (avalia-chute (le-letra!) vidas palavra acertos)
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print "Hello, World!")
  (jogo 5 "ALURA" #{})
)