package mk.ukim.finki.lab1.lab1.service.impl;

import mk.ukim.finki.lab1.lab1.model.Balloon;
import mk.ukim.finki.lab1.lab1.repository.BalloonRepository;
import mk.ukim.finki.lab1.lab1.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return this.balloonRepository.findAllByNameOrDescription(text);
    }
}
