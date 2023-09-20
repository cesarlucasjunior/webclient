package com.cesarlucasjunior.webclientproject

import com.cesarlucasjunior.webclientproject.core.domain.Episode
import com.cesarlucasjunior.webclientproject.core.domain.ListOfEpisodes
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class EpisodeService(private val webConfig: WebConfig) {

    fun getEpisodeById(id: String): Mono<Episode> {
        return webConfig.webClient()
            .get()
            .uri("/episode/$id")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { Mono.error(NoSuchEpisodeException()) }
            .bodyToMono(Episode::class.java)
    }

    fun getAllEpisodes(): Flux<ListOfEpisodes> {
        return webConfig.webClient()
            .get()
            .uri("/episode/")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { Mono.error(NoSuchEpisodeException()) }
            .bodyToFlux(ListOfEpisodes::class.java)
    }
}