package com.cesarlucasjunior.webclientproject

class NoSuchEpisodeException: NoSuchElementException {

    constructor() : super() {
        println("Não encontramos os id na API")
    }
}