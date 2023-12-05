package io.risf.galaxion.exemple.subscriptionmanagement.application.service;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;

public class GraphBuilder {

    public static Node buildAccountGraph() {
        Account account = Account.withoutId();

        account.setFirstName("Bob");
        account.setLastName("Sponge");

        Service service = Service.withoutId();
        service.setNumber("696969696969");

        Equipment equipment = Equipment.withoutId();
        equipment.setPartNumber("myPartNumber");
        equipment.setSerialNumber("mySerialNumber");

        Usage usage = Usage.withoutId();

        service.include(equipment);
        service.addAddon(usage);

        Feature feature = Feature.withoutId();

        account.subscribe(service);
        account.addAddon(feature);

        return account;
    }

    public static Node buildAccountGraphWithDoubleRelation(String firstName, String lastName) {
        Account account =  Account.withoutId();
        account.setFirstName(firstName);
        account.setLastName(lastName);

        Service service = Service.withoutId();
        service.setNumber("696969696969");

        Equipment equipment = Equipment.withoutId();
        equipment.setPartNumber("myPartNumber");
        equipment.setSerialNumber("mySerialNumber");

        Usage usage = Usage.withoutId();

        service.include(equipment);
        service.addAddon(usage);

        Feature feature = Feature.withoutId();
        feature.include(equipment);

        account.subscribe(service);
        account.addAddon(feature);

        return account;
    }

    public static Node buildAccountGraphWithDoubleRelation() {
        return buildAccountGraphWithDoubleRelation("Bob", "Sponge");
    }

}
