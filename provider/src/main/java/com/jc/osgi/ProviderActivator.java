package com.jc.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class ProviderActivator implements BundleActivator {

    private ServiceRegistration<HelloService> reg;

    @Override
    public void start(BundleContext context) throws Exception {
        reg = context.registerService(
                HelloService.class,
                new HelloServiceImpl(),
                new Hashtable<>()
        );
        System.out.println("[provider] HelloService registrado correctamente");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (reg != null) {
            reg.unregister();
        }
        System.out.println("[provider] HelloService desregistrado");
    }
}
