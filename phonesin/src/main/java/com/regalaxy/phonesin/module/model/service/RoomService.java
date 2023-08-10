package com.regalaxy.phonesin.module.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Service
public class RoomService {
    private final Map<String, Set<String>> rooms;

    @Autowired
    public RoomService(Map<String, Set<String>> rooms) {
        this.rooms = rooms;
    }

    public void createRoom(String roomId) {
        Set<String> set = new ConcurrentSkipListSet<>();
        rooms.put(roomId, set);
    }

    public void joinRoom(String roomId, String member) {
        Set<String> set = rooms.get(roomId);
        if (set != null) {
            set.add(member);
        }
    }

    public void leaveRoom(String roomId, String subscriber) {
        Set<String> set = rooms.get(roomId);
        if (set != null) {
            set.remove(subscriber);
            if (set.isEmpty()) {
                rooms.remove(roomId);
            }
        }
    }

    public Set<String> getRoom(String roomId) {
        return rooms.get(roomId);
    }
}
