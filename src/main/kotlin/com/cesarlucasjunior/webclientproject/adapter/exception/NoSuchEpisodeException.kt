package com.cesarlucasjunior.webclientproject.adapter.exception

class NoSuchEpisodeException: NoSuchElementException {

    constructor() : super() {
        println("Não encontramos os id na API")
    }
}