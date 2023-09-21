package com.cesarlucasjunior.webclientproject.adapter.web

import com.cesarlucasjunior.webclientproject.core.domain.Episode
import com.cesarlucasjunior.webclientproject.core.domain.ListOfEpisodes
import com.cesarlucasjunior.webclientproject.core.ports.`in`.LoadEpisodesInputPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/webclient")
class EpisodeController(private val loadEpisodesInputPort: LoadEpisodesInputPort) {

    @GetMapping("/episodes/{id}")
    fun getEpisodeById(@PathVariable id: String): Mono<Episode> {
        return loadEpisodesInputPort.loadEpisodeById(id)
    }

    @GetMapping("/episodes")
    fun getEpisodes(): Flux<ListOfEpisodes> {
        return loadEpisodesInputPort.loadAllEpisodes()
    }


}