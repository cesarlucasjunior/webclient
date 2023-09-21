package com.cesarlucasjunior.webclientproject.adapter.web

import com.cesarlucasjunior.webclientproject.core.usecase.EpisodeService
import com.cesarlucasjunior.webclientproject.core.domain.Episode
import com.cesarlucasjunior.webclientproject.core.domain.ListOfEpisodes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/webclient")
class EpisodeController(private val episodeService: EpisodeService) {

    @GetMapping("/episodes/{id}")
    fun getEpisodeById(@PathVariable id: String): Mono<Episode> {
        return episodeService.getEpisodeById(id)
    }

    @GetMapping("/episodes")
    fun getEpisodes(): Flux<ListOfEpisodes> {
        return episodeService.getAllEpisodes()
    }


}