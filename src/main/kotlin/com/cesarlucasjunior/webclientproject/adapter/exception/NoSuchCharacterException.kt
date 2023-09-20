package com.cesarlucasjunior.webclientproject.adapter.exception

class NoSuchCharacterException: NoSuchElementException {

    constructor() : super() {
        println("Não encontramos os id na API")
    }

}