package com.tomitribe.tomee.monitoring;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.Path;

@Singleton
@Lock(LockType.READ)
@Path("/invocations")
public class InvocationsService {
}
