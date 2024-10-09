package org.infoip.core.usecase;

import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;

public interface ReadIpInfoUseCase {
    IpInfo getIpInfo(String ip) throws ExternalApiException;
}
