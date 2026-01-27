package com.edutech.progressive.controller;
 
import com.edutech.progressive.entity.Vote;
import com.edutech.progressive.service.impl.VoteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/vote")
public class VoteController {
 
    private final VoteServiceImpl voteService;
 
    public VoteController(VoteServiceImpl voteService) {
        this.voteService = voteService;
    }
 
    
    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        return voteService.getAllVotes();
    }
 
    
    @PostMapping
    public ResponseEntity<Integer> createVote(@RequestBody Vote vote) {
        return voteService.createVote(vote);
    }
 
   
    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getVotesCountOfAllCategories() {
        return voteService.getVotesCountOfAllCategories();
    }
}
