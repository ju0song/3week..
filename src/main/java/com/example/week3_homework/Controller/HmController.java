package com.example.week3_homework.Controller;

import com.example.week3_homework.Service.HmService;
import com.example.week3_homework.domain.Hm;
import com.example.week3_homework.domain.HmRepository;
import com.example.week3_homework.model.HmRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class HmController {
    private final HmRepository hmRepository;
    private final HmService hmService;

    @PostMapping("/api/homework")
    public Hm createHm(@RequestBody HmRequestDto requestDto) {
        Hm homework = new Hm(requestDto); //Memo클래스에서 requestDto의 데이터를 가져온다
        return hmRepository.save(homework); //Repositpry에서 저장하니까
    }
    //read
    @GetMapping("/api/homework")
    public List<Hm> getHm() {
        return hmRepository.findAllByOrderByModifiedAtDesc(); //리포지토리에서 찾아와라
    }

    @GetMapping("/api/homework/{id}")
    public Optional<Hm> getOneHm(@PathVariable Long id) {
        return HmRepository.findById(id);
    }


    //put
    @PutMapping("/api/homework/{id}")
    public Long updateHm(@PathVariable Long id, @RequestBody HmRequestDto requestDto) {
        Optional<Hm> homework = HmRepository.findById(id);
        if (requestDto.getPassword().equals(homework.get().getPassword())) {
            HmService.update(id, requestDto);
        } else {
            System.out.println("오류");
        } return id;
    }

    @DeleteMapping("/api/homework/{id}")
    public Long DeleteHm(@PathVariable Long id,@RequestBody HmRequestDto requestDto) {

        Optional<Hm> homework = HmRepository.findById(id);
        if (requestDto.getPassword().equals(homework.get().getPassword())) {
            HmRepository.deleteById(id);
        } else {
            System.out.println("비밀번호 오류");
        }
        return id;
    }





}
