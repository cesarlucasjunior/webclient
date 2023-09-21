package com.cesarlucasjunior.webclientproject.core.ports.`in`

import com.cesarlucasjunior.webclientproject.core.domain.Character
import reactor.core.publisher.Mono

interface LoadCharactersInputPort {
    fun loadCharacterById(id: String): Mono<Character>
}