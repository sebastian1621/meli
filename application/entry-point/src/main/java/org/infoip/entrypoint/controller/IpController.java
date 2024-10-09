package org.infoip.entrypoint.controller;

import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.entrypoint.controller.dto.IpInfoDto;
import org.infoip.entrypoint.service.IpInfoService;
import org.infoip.entrypoint.service.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1.0/ipInfo")
public class IpController {

    private final IpInfoService ipInfoService;
    private final StatsService statsService;

    public IpController(
            final IpInfoService ipInfoService,
            final StatsService statsService
    ) {
        this.ipInfoService = ipInfoService;
        this.statsService = statsService;
    }

    @GetMapping("/{ip}")
    public ResponseEntity<IpInfoDto> getIpInfo(final @PathVariable String ip) throws ExternalApiException {
        return ResponseEntity.ok(ipInfoService.getCountry(ip));
    }

    @GetMapping("/stats/average")
    public ResponseEntity<Double> getAverage() {
        return ResponseEntity.ok(statsService.getAverage());
    }

    @GetMapping("/stats/maxDistance")
    public ResponseEntity<Double> getMaxDistance() {
        return ResponseEntity.ok(statsService.getMaxDistance());
    }

    @GetMapping("/stats/minDistance")
    public ResponseEntity<Double> getMinDistance() {
        return ResponseEntity.ok(statsService.getMinDistance());
    }
}
