package com.example.week3_homework.Service;
import com.example.week3_homework.domain.Hm;
import com.example.week3_homework.domain.HmRepository;
import com.example.week3_homework.model.HmRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class HmService {

    private final HmRepository homeworkRepository;

    @Transactional
    public Long update(Long id, HmRequestDto boardRequestDto) {

        Hm homework = HmRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        homework.update(boardRequestDto);
        return homework.getId();
    }


}
