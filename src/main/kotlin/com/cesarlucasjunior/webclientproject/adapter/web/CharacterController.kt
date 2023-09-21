package com.cesarlucasjunior.webclientproject.adapter.web

import com.cesarlucasjunior.webclientproject.adapter.integration.CharacterService
import com.cesarlucasjunior.webclientproject.core.domain.Character
import com.cesarlucasjunior.webclientproject.core.ports.`in`.LoadCharactersInputPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/webclient")
class CharacterController(private val loadCharactersInputPort: LoadCharactersInputPort) {

    @GetMapping("/character/{id}")
    fun getCharacters(@PathVariable id:String): Mono<Character> {
        return loadCharactersInputPort.loadCharacterById(id)
    }
}