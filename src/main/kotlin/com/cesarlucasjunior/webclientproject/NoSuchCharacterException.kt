package com.cesarlucasjunior.webclientproject

class NoSuchCharacterException: NoSuchElementException {

    constructor() : super() {
        println("Não encontramos os id na API")
    }

}