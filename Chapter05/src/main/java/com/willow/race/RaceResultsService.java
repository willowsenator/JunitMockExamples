package com.willow.race;

import java.util.*;

public class RaceResultsService {
    private Map<Client, Set<Category>> clients= new HashMap<>();

    public void addSubscriber(Client client, Set<Category> categories) {
        clients.put(client, categories);
    }

    public void send(Message message) {
        clients.forEach(
                (client, categories) -> {
                    if(categories.contains(message.getCategory())){
                        client.receive(message);
                    }
                }
        );

    }

    public Set<Category> removeSubscriber(Client client) {
        return clients.remove(client);
    }
}
