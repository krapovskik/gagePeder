package mk.ukim.finki.lab1.lab1.repository;

import mk.ukim.finki.lab1.lab1.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    public List<Balloon> balloons;

    public BalloonRepository(){
        this.balloons = new ArrayList<>();
        for(int i = 0; i<10; i++) balloons.add(new Balloon(""+i,"Balloon: "+i));
    }

    public List<Balloon> findAllBalloons(){
        return this.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return this.balloons.stream()
                .filter(balloon -> balloon.getName().contains(text) || balloon.getDescription().contains(text))
                .collect(Collectors.toList());
    }

}
