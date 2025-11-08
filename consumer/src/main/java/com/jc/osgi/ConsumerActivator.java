package com.jc.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class ConsumerActivator implements BundleActivator {

    private ServiceTracker<HelloService, HelloService> tracker;

    @Override
    public void start(BundleContext context) {
        System.out.println("[consumer] starting...");

        tracker = new ServiceTracker<>(context, HelloService.class, null) {
            @Override
            public HelloService addingService(ServiceReference<HelloService> ref) {
                HelloService svc = context.getService(ref);
                System.out.println("[consumer] Servicio encontrado: " + svc.getClass().getName());
                System.out.println("[consumer] Llamada: " + svc.sayHello("Josue"));
                return svc;
            }

            @Override
            public void removedService(ServiceReference<HelloService> ref, HelloService svc) {
                System.out.println("[consumer] Servicio removido");
                context.ungetService(ref);
            }
        };

        tracker.open(); // empieza a escuchar el registro del servicio
    }

    @Override
    public void stop(BundleContext context) {
        if (tracker != null) tracker.close();
        System.out.println("[consumer] stop");
    }
}
