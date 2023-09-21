package com.cesarlucasjunior.webclientproject.core.ports.out

import com.cesarlucasjunior.webclientproject.core.domain.Character
import reactor.core.publisher.Mono

interface LoadCharactersOutputPort {

    fun getCharacterById(id: String): Mono<Character>
}