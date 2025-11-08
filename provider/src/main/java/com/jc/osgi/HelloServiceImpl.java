package com.jc.osgi;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hola " + name + " desde el servicio OSGi!";
    }
}
