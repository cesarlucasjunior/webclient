package com.cesarlucasjunior.webclientproject.core.ports.out

import com.cesarlucasjunior.webclientproject.core.domain.Episode
import com.cesarlucasjunior.webclientproject.core.domain.ListOfEpisodes
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface LoadEpisodesOutputPort {
    fun getEpisodeById(id: String): Mono<Episode>

    fun getAllEpisodes(): Flux<ListOfEpisodes>
}