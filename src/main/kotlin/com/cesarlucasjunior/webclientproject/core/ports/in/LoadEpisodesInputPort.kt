package com.cesarlucasjunior.webclientproject.core.ports.`in`

import com.cesarlucasjunior.webclientproject.core.domain.Episode
import com.cesarlucasjunior.webclientproject.core.domain.ListOfEpisodes
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface LoadEpisodesInputPort {

    fun loadEpisodeById(id: String): Mono<Episode>

    fun loadAllEpisodes(): Flux<ListOfEpisodes>
}