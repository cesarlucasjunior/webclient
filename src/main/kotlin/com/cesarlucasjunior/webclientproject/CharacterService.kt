package com.cesarlucasjunior.webclientproject

import com.cesarlucasjunior.webclientproject.core.domain.Character
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CharacterService(private val webConfig: WebConfig) {

    fun findAndCharacterById(id: String): Mono<Character> {
        return webConfig.webClient()
            .get()
            .uri("/character/$id")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { Mono.error(NoSuchCharacterException()) }
            .bodyToMono(Character::class.java)
    }
}