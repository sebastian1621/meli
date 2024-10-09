package org.infoip.core.provider;

import org.infoip.core.entity.IpInfo;
import org.infoip.core.exceptions.ExternalApiException;

public interface IpInfoProvider {
    IpInfo getIpInfo(String ip) throws ExternalApiException;
}
