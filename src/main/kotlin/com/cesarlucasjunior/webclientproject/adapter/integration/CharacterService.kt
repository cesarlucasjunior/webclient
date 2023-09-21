package com.cesarlucasjunior.webclientproject.adapter.integration

import com.cesarlucasjunior.webclientproject.adapter.exception.NoSuchCharacterException
import com.cesarlucasjunior.webclientproject.adapter.conf.WebConfig
import com.cesarlucasjunior.webclientproject.core.domain.Character
import com.cesarlucasjunior.webclientproject.core.ports.out.LoadCharactersOutputPort
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CharacterService(private val webConfig: WebConfig): LoadCharactersOutputPort {

    override fun getCharacterById(id: String): Mono<Character> {
        return webConfig.webClient()
            .get()
            .uri("/character/$id")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { Mono.error(NoSuchCharacterException()) }
            .bodyToMono(Character::class.java)
    }
}