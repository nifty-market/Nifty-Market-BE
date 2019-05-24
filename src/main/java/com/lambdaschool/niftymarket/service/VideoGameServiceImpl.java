package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.controller.VideoGameController;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.VideoGame;
import com.lambdaschool.niftymarket.repos.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class VideoGameServiceImpl implements VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    @Override
    public List<VideoGame> findAll(Pageable pageable)
    {
        ArrayList<VideoGame> list = new ArrayList<>();
        videoGameRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public VideoGame findByVidid(long cardid) {

        return videoGameRepository.findById(cardid).orElseThrow(() -> new EntityNotFoundException(Long.toString(cardid)));
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Card update(Card author, long id) {
        return null;
    }
}
