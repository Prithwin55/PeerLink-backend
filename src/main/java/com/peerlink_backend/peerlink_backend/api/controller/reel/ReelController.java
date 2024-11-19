package com.peerlink_backend.peerlink_backend.api.controller.reel;

import com.peerlink_backend.peerlink_backend.api.dto.reel.ReelDto;
import com.peerlink_backend.peerlink_backend.data.service.reel.ReelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/peerlink/reel")
public class ReelController {
    ReelService reelService;

    @PostMapping("/create")
    public ResponseEntity<ReelDto> createReel(@RequestHeader("Authorization")String jwt, @RequestBody ReelDto reelDto){
        return new ResponseEntity<>(reelService.createReel(reelDto,jwt), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ReelDto>> findAllReel(){
        return new ResponseEntity<>(reelService.findAllReel(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReelDto>> findUsersReel(@PathVariable long id){
        return new ResponseEntity<>(reelService.findUserReel(id), HttpStatus.OK);
    }

}
