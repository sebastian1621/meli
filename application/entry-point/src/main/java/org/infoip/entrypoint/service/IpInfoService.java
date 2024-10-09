package org.infoip.entrypoint.service;

import org.infoip.core.exceptions.ExternalApiException;
import org.infoip.entrypoint.controller.dto.IpInfoDto;

public interface IpInfoService {
    IpInfoDto getCountry(String ip) throws ExternalApiException;
}
