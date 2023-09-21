package com.cesarlucasjunior.webclientproject.core.usecase

import com.cesarlucasjunior.webclientproject.core.domain.Character
import com.cesarlucasjunior.webclientproject.core.ports.`in`.LoadCharactersInputPort
import com.cesarlucasjunior.webclientproject.core.ports.out.LoadCharactersOutputPort
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class LoadCharactersUseCase(private val loadCharactersOutputPort: LoadCharactersOutputPort): LoadCharactersInputPort {
    override fun loadCharacterById(id: String): Mono<Character> {
        return loadCharactersOutputPort.getCharacterById(id)
    }
}