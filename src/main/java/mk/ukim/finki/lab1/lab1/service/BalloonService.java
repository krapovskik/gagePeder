package mk.ukim.finki.lab1.lab1.service;


import mk.ukim.finki.lab1.lab1.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}

