package src.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import src.main.service.CountService;

@RestController
@RequestMapping("/counter")
@Slf4j
@RequiredArgsConstructor
public class CountController {
    private final CountService countService;

    @GetMapping("/{inputStr}")
    public String getCountOfSymbols(@PathVariable String inputStr) {
        log.info("Получить количество использований разных символов в строке");
        return countService.getCountOfSymbols(inputStr);
    }
}
